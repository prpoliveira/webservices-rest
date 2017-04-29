package br.unisal.api.util;

/* Example implementation of password hasher similar on Django's PasswordHasher
 * Requires Java8 (but should be easy to port to older JREs)
 * Currently it would work only for pbkdf2_sha256 algorithm
 *
 * Django code: https://github.com/django/django/blob/1.6.5/django/contrib/auth/hashers.py#L221
 */
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.logging.Logger;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import org.apache.commons.codec.binary.Base64;


public class Hasher {
    private final Integer DEFAULT_ITERATIONS = 20000;
    private final String algorithm = "pbkdf2_sha1";

    public Hasher() {}

    private String getEncodedHash(String password, String salt, int iterations) {
        // Returns only the last part of whole encoded password
        SecretKeyFactory keyFactory = null;
        try {
            keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Could NOT retrieve PBKDF2WithHmacSHA1 algorithm");
        }
        KeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt.getBytes(Charset.forName("UTF-8")), iterations, 256);
        SecretKey secret = null;
        try {
            secret = keyFactory.generateSecret(keySpec);
        } catch (InvalidKeySpecException e) {
            System.out.println("Could NOT generate secret key");
        }

        byte[] rawHash = secret.getEncoded();
        byte[] hashBase64 = Base64.encodeBase64(rawHash);

        return new String(hashBase64);
    }

    private String encode(String password, String salt, int iterations) {
        // returns hashed password, along with algorithm, number of iterations and salt
        String hash = getEncodedHash(password, salt, iterations);
        return String.format("%s$%d$%s$%s", algorithm, iterations, salt, hash);
    }

	public String encode(String password) {
        return this.encode(password, getSalt(), this.DEFAULT_ITERATIONS);
    }

    public boolean checkPassword(String password, String hashedPassword) {
        // hashedPassword consist of: ALGORITHM, ITERATIONS_NUMBER, SALT and
        // HASH; parts are joined with dollar character ("$")
        String[] parts = hashedPassword.split("\\$");
        if (parts.length != 4) {
            // wrong hash format
            return false;
        }
        Integer iterations = Integer.parseInt(parts[1]);
        String salt = parts[2];
        String hash = encode(password, salt, iterations);

        return hash.equals(hashedPassword);
    }
    
    private static String getSalt() {
    	SecureRandom sr;
    	byte[] algorithm = new byte[16];
		try {
			sr = SecureRandom.getInstance("SHA1PRNG");
			sr.nextBytes(algorithm);
			return algorithm.toString();
		} catch (NoSuchAlgorithmException e) {
			Logger.getLogger(e.getMessage());
			return null;
		}   	
    }
    
    public String getHashCode(String toDoHashcode) {
    	String hashcode = null;
    	try {
    		MessageDigest md = MessageDigest.getInstance("SHA-256");
    		byte[] bytes = md.digest(toDoHashcode.getBytes());
    		StringBuilder builder = new StringBuilder();
    		for (int i = 0; i < bytes.length; i++) {
				byte b = bytes[i];
				builder.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
			}
    		hashcode = builder.toString();
    	} catch (Exception e) {
    		hashcode = null;
			Logger.getLogger(e.getMessage());
		}
    	return hashcode;
    }

}