package br.unisal.api.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import br.unisal.api.util.GeradorSenhaAleatoria;
import br.unisal.api.util.GsonSingleton;

/**
 * The persistent class for the auth_user database table.
 * 
 */
@Entity
@Table(name="usuario")
@XmlRootElement
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4124364649619748033L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario", unique = true, nullable = false)
	private Long id;

	@Column(name="email")
	private String email;

	@Column(name="nome")
	private String nome;
	
	@Column(name="sobrenome")
	private String sobrenome;

	@Column(name="password")
	private String password;

	@Column(name="username", unique=true)
	private String username;
		
	@Column(name="enable")
	private Boolean enable;

	@Column(name="hashcode", length=400)
	private String hashcode;
	
	@Column(name="email_enviado")
	private Boolean emailEnviado;
	
	@Column(name="dt_cadastro")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date dtCadastro;
	
	@Column(name="dt_update")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date dtUpdate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tipo_usuario")
	private TipoUsuario tipoUsuario;
	
	public Usuario() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public String getHashcode() {
		return hashcode;
	}

	public void setHashcode(String hashcode) {
		this.hashcode = hashcode;
	}

	public Boolean getEmailEnviado() {
		return emailEnviado;
	}

	public void setEmailEnviado(Boolean emailEnviado) {
		this.emailEnviado = emailEnviado;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public Date getDtUpdate() {
		return dtUpdate;
	}

	public void setDtUpdate(Date dtUpdate) {
		this.dtUpdate = dtUpdate;
	}
	
	public String recuperaRole(){
		return this.getTipoUsuario().getSigla();
	}
	
	public String getNewGeneratedPassword() {
		return GeradorSenhaAleatoria.gerarSenhaAleatoria(12);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getTipoUsuario(), getUsername());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof Usuario) {
			Usuario other = (Usuario) obj;
			return Objects.equals(id, other.id)
					&& Objects.equals(tipoUsuario, other.tipoUsuario)
					&& Objects.equals(username, other.username);
		}
		return false;
	}

	@Override
	public String toString() {
		return GsonSingleton.getInstance().toJson(this);
	}

}