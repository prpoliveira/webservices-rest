package br.unisal.api.util;

import br.unisal.api.vo.ResponseMessageVO;

public class MessageCodeHTTP {
	
	/**
	 *  Protocolos 1xx
	 */
	private static final String CONTINUE_MSG = "Continue";
	private static final String PROTOCOLOS_DE_COMUTACAO_MSG = "Protocolos de comutação";
	
	/**
	 *  Protocolos 2xx
	 */
	private static final String OK_MSG = "Ok";
	private static final String CRIADO_MSG = "Criado";
	private static final String ACEITO_MSG = "Aceito";
	private static final String INFORMACOES_NAO_AUTORIZADAS_MSG = "Informações não autorizadas";
	private static final String NENHUM_CONTEUDO_MSG = "Nenhum conteúdo";
	private static final String REDEFINIR_CONTEUDO_MSG = "Redefinir conteúdo";
	private static final String CONTEUDO_PARCIAL_MSG = "Conteúdo parcial";
	
	/**
	 *  Protocolos 3xx
	 */
	private static final String MULTIPLAS_ESCOLHAR_MSG = "Multiplas escolhas";
	private static final String MOVIDO_PERMANENTEMENTE_MSG = "Movido permanentemente";
	private static final String ENCONTRADO_MSG = "Encontrado";
	private static final String VEJA_OUTROS_MSG = "Veja outros";
	private static final String NAO_MODIFICADO_MSG = "Não modificado";
	private static final String USAR_O_PROXY_MSG = "Usar o proxy";
	private static final String NAO_USADO_MSG = "Não usado";
	private static final String REDIRECIONAMENTO_TEMPORARIO_MSG = "Redirecionamento temporário";
	
	/**
	 *  Protocolos 4xx
	 */
	private static final String PEDIDO_RUIM_MSG = "Pedido ruim";
	private static final String NAO_AUTORIZADO_MSG = "Não autorizado";
	private static final String PAGAMENTO_REQUERIDO_MSG = "Pagamento requerido";
	private static final String PROIBIDO_MSG = "Proibido";
	private static final String NAO_EXISTE_MSG = "Não existe";
	private static final String METODO_NAO_PERMITIDO_MSG = "Método não permitido";
	private static final String NAO_ACEITAVEL_MSG = "Não aceitável";
	private static final String AUTENTICACAO_DE_PROXY_REQUERIDA_MSG = "Autenticação de proxy requerida";
	private static final String TEMPO_LIMITE_DE_REQUISICAO_MSG = "Tempo limite de requisição";
	private static final String CONFLITO_MSG = "Conflito";
	private static final String CONSTRAINT_VIOLATION_MSG = "O username escolhido já está cadastrado, favor escolher outro.";
	private static final String DESAPARECIMENTO_MSG = "Desaparecimento";
	private static final String COMPRIMENTO_REQUERIDO_MSG = "Comprimento requerido";
	private static final String PRE_CONDICAO_FALHOU_MSG = "Pré condição falhou";
	private static final String ENTIDADE_SOLICITADA_MUITO_GRANDE_MSG = "Entidade solicitada muito grande";
	private static final String SOLICITACAO_DE_URI_MUITO_LONGA_MSG = "Solicitação de URI muito longa";
	private static final String TIPO_DE_MIDIA_NAO_SUPORTADO_MSG = "Tipo de mídia não suportado";
	private static final String INTERVALO_SOLICITADO_NAO_SATISFATORIO_MSG = "Intervalo solicitado não satisfatório";
	private static final String EXPECTATIVA_DE_FALHA_MSG = "Expectativa de falha";
	
	/**
	 *  Protocolos 5xx
	 */
	private static final String ERRO_INTERNO_NO_SERVIDOR_MSG = "Erro interno no servidor";
	private static final String NAO_IMPLEMENTADO_MSG = "Não implementado";
	private static final String PORTA_DE_SAIDA_RUIM_MSG = "Porta de saída ruim";
	private static final String SERVICO_NAO_AVALIADO_MSG = "Serviço não avaliado";
	private static final String TEMPO_DE_LIMITE_PARA_PORTA_DE_SAIDA_MSG = "Tempo de limite para porta de saída";
	private static final String VERSAO_DE_PROTOCOLO_HTTP_NAO_SUPORTADO_MSG = "Versão de protocolo HTTP não surpotado";
	
	/**
	 *  Respostas
	 */
	public static ResponseMessageVO CONTINUE_RSP = new ResponseMessageVO(100, MessageCodeHTTP.CONTINUE_MSG);
	public static ResponseMessageVO PROTOCOLOS_DE_COMUTACAO_RSP = new ResponseMessageVO(101, MessageCodeHTTP.PROTOCOLOS_DE_COMUTACAO_MSG);
	
	public static ResponseMessageVO OK_RSP = new ResponseMessageVO(200, MessageCodeHTTP.OK_MSG);
	public static ResponseMessageVO CRIADO_RSP = new ResponseMessageVO(201, MessageCodeHTTP.CRIADO_MSG);
	public static ResponseMessageVO ACEITO_RSP = new ResponseMessageVO(202, MessageCodeHTTP.ACEITO_MSG);
	public static ResponseMessageVO INFORMACOES_NAO_AUTORIZADAS_RSP = new ResponseMessageVO(203, MessageCodeHTTP.INFORMACOES_NAO_AUTORIZADAS_MSG);
	public static ResponseMessageVO NENHUM_CONTEUDO_RSP = new ResponseMessageVO(204, MessageCodeHTTP.NENHUM_CONTEUDO_MSG);
	public static ResponseMessageVO REDEFINIR_CONTEUDO_RSP = new ResponseMessageVO(205, MessageCodeHTTP.REDEFINIR_CONTEUDO_MSG);
	public static ResponseMessageVO CONTEUDO_PARCIAL_RSP = new ResponseMessageVO(206, MessageCodeHTTP.CONTEUDO_PARCIAL_MSG);
	
	public static ResponseMessageVO MULTIPLAS_ESCOLHAR_RSP = new ResponseMessageVO(300, MessageCodeHTTP.MULTIPLAS_ESCOLHAR_MSG);
	public static ResponseMessageVO MOVIDO_PERMANENTEMENTE_RSP = new ResponseMessageVO(301, MessageCodeHTTP.MOVIDO_PERMANENTEMENTE_MSG);
	public static ResponseMessageVO ENCONTRADO_RSP = new ResponseMessageVO(302, MessageCodeHTTP.ENCONTRADO_MSG);
	public static ResponseMessageVO VEJA_OUTROS_RSP = new ResponseMessageVO(303, MessageCodeHTTP.VEJA_OUTROS_MSG);
	public static ResponseMessageVO NAO_MODIFICADO_RSP = new ResponseMessageVO(304, MessageCodeHTTP.NAO_MODIFICADO_MSG);
	public static ResponseMessageVO USAR_O_PROXY_RSP = new ResponseMessageVO(305, MessageCodeHTTP.USAR_O_PROXY_MSG);
	public static ResponseMessageVO NAO_USADO_RSP = new ResponseMessageVO(306, MessageCodeHTTP.NAO_USADO_MSG);
	public static ResponseMessageVO REDIRECIONAMENTO_TEMPORARIO_RSP = new ResponseMessageVO(307, MessageCodeHTTP.REDIRECIONAMENTO_TEMPORARIO_MSG);
	
	public static ResponseMessageVO PEDIDO_RUIM_RSP = new ResponseMessageVO(400, MessageCodeHTTP.PEDIDO_RUIM_MSG);
	public static ResponseMessageVO NAO_AUTORIZADO_RSP = new ResponseMessageVO(401, MessageCodeHTTP.NAO_AUTORIZADO_MSG);
	public static ResponseMessageVO PAGAMENTO_REQUERIDO_RSP = new ResponseMessageVO(402, MessageCodeHTTP.PAGAMENTO_REQUERIDO_MSG);
	public static ResponseMessageVO PROIBIDO_RSP = new ResponseMessageVO(403, MessageCodeHTTP.PROIBIDO_MSG);
	public static ResponseMessageVO NAO_EXISTE_RSP = new ResponseMessageVO(404, MessageCodeHTTP.NAO_EXISTE_MSG);
	public static ResponseMessageVO METODO_NAO_PERMITIDO_RSP = new ResponseMessageVO(405, MessageCodeHTTP.METODO_NAO_PERMITIDO_MSG);
	public static ResponseMessageVO NAO_ACEITAVEL_RSP = new ResponseMessageVO(406, MessageCodeHTTP.NAO_ACEITAVEL_MSG);
	public static ResponseMessageVO AUTENTICACAO_DE_PROXY_REQUERIDA_RSP = new ResponseMessageVO(407, MessageCodeHTTP.AUTENTICACAO_DE_PROXY_REQUERIDA_MSG);
	public static ResponseMessageVO TEMPO_LIMITE_DE_REQUISICAO_RSP = new ResponseMessageVO(408, MessageCodeHTTP.TEMPO_LIMITE_DE_REQUISICAO_MSG);
	public static ResponseMessageVO CONFLITO_RSP = new ResponseMessageVO(409, MessageCodeHTTP.CONFLITO_MSG);
	public static ResponseMessageVO CONSTRAINT_VIOLATION_RSP = new ResponseMessageVO(409, MessageCodeHTTP.CONSTRAINT_VIOLATION_MSG);
	public static ResponseMessageVO DESAPARECIMENTO_RSP = new ResponseMessageVO(410, MessageCodeHTTP.DESAPARECIMENTO_MSG);
	public static ResponseMessageVO COMPRIMENTO_REQUERIDO_RSP = new ResponseMessageVO(411, MessageCodeHTTP.COMPRIMENTO_REQUERIDO_MSG);
	public static ResponseMessageVO PRE_CONDICAO_FALHOU_RSP = new ResponseMessageVO(412, MessageCodeHTTP.PRE_CONDICAO_FALHOU_MSG);
	public static ResponseMessageVO ENTIDADE_SOLICITADA_MUITO_GRANDE_RSP = new ResponseMessageVO(413, MessageCodeHTTP.ENTIDADE_SOLICITADA_MUITO_GRANDE_MSG);
	public static ResponseMessageVO SOLICITACAO_DE_URI_MUITO_LONGA_RSP = new ResponseMessageVO(414, MessageCodeHTTP.SOLICITACAO_DE_URI_MUITO_LONGA_MSG);
	public static ResponseMessageVO TIPO_DE_MIDIA_NAO_SUPORTADO_RSP = new ResponseMessageVO(415, MessageCodeHTTP.TIPO_DE_MIDIA_NAO_SUPORTADO_MSG);
	public static ResponseMessageVO INTERVALO_SOLICITADO_NAO_SATISFATORIO_RSP = new ResponseMessageVO(416, MessageCodeHTTP.INTERVALO_SOLICITADO_NAO_SATISFATORIO_MSG);
	public static ResponseMessageVO EXPECTATIVA_DE_FALHA_RSP = new ResponseMessageVO(417, MessageCodeHTTP.EXPECTATIVA_DE_FALHA_MSG);
	
	public static ResponseMessageVO ERRO_INTERNO_NO_SERVIDOR_MSG_RSP = new ResponseMessageVO(500, MessageCodeHTTP.ERRO_INTERNO_NO_SERVIDOR_MSG);
	public static ResponseMessageVO NAO_IMPLEMENTADO_RSP = new ResponseMessageVO(501, MessageCodeHTTP.NAO_IMPLEMENTADO_MSG);
	public static ResponseMessageVO PORTA_DE_SAIDA_RUIM_RSP = new ResponseMessageVO(502, MessageCodeHTTP.PORTA_DE_SAIDA_RUIM_MSG);
	public static ResponseMessageVO SERVICO_NAO_AVALIADO_RSP = new ResponseMessageVO(503, MessageCodeHTTP.SERVICO_NAO_AVALIADO_MSG);
	public static ResponseMessageVO TEMPO_DE_LIMITE_PARA_PORTA_DE_SAIDA_RSP = new ResponseMessageVO(504, MessageCodeHTTP.TEMPO_DE_LIMITE_PARA_PORTA_DE_SAIDA_MSG);
	public static ResponseMessageVO VERSAO_DE_PROTOCOLO_HTTP_NAO_SUPORTADO_RSP = new ResponseMessageVO(505, MessageCodeHTTP.VERSAO_DE_PROTOCOLO_HTTP_NAO_SUPORTADO_MSG);
}
