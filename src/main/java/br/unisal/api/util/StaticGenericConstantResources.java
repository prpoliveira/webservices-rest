package br.unisal.api.util;

public class StaticGenericConstantResources {
	/**
	 * The Name of Application
	 */
	public static final String APP_OWNER = "unisal-api";

	/**
	 * TecWebEnergia
	 */
	public static final String CONSUMER_KEY = "";

	/**
	 * TecWebEnergia API
	 */
	public static final String CONSUMER_SECRET = "";

	/**
	 * ContextPath WebService /rest/requestToken /rest/accessToken
	 * /rest/authorize
	 */
	public static final String CONTEXT_PATH = "http://localhost:8080/api";
	public static final String REQUEST_TOKEN = CONTEXT_PATH + "/rest/requestToken";
	public static final String ACCESS_TOKEN = CONTEXT_PATH + "/rest/accessToken";
	public static final String AUTHORIZE = CONTEXT_PATH + "/rest/authorize";

	/**
	 * Constante para o hashcode do usuário que está no header
	 */
	public static final String HEADER_TOKEN = "x-token";
	
	/**
	 * Ações do usuário
	 */
	public static final String DELETE = "OBJETO EXCLUÍDO";
	public static final String INSERT = "OBJETO CADASTRADO";
	public static final String UPDATE = "OBJETO ATUALIZADO";
	public static final String REENVIO_LOGIN_SENHA_USUARIO = "REENVIO LOGIN SENHA USUARIO";
	
}
