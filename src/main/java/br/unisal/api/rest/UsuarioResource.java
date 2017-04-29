package br.unisal.api.rest;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unisal.api.model.Usuario;
import br.unisal.api.service.UsuarioService;
import br.unisal.api.util.Hasher;
import br.unisal.api.util.MessageCodeHTTP;
import br.unisal.api.util.StaticGenericConstantResources;

@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Component
public class UsuarioResource {

	@Context
	HttpServletRequest request;

	@Autowired
	private UsuarioService usuarioService;
	
	// @RolesAllowed({"user", "admin"})
	@GET
	public Response get() {
		String xtoken = request.getHeader(StaticGenericConstantResources.HEADER_TOKEN);
		if (xtoken == null) {
			return Response.ok(MessageCodeHTTP.NAO_AUTORIZADO_RSP).build();
		}

		if (!usuarioService.isExistUsuarioByHashcodeAndActive(xtoken)) {
			return Response.ok(MessageCodeHTTP.NAO_AUTORIZADO_RSP).build();
		}
		
		return Response.ok(usuarioService.getUsuario()).build();
	}

	// @RolesAllowed({"user", "admin"})
	@GET
	@Path("{id}")
	public Response getById(@PathParam("id") long id) {
		String xtoken = request.getHeader(StaticGenericConstantResources.HEADER_TOKEN);
		if (xtoken == null) {
			return Response.ok(MessageCodeHTTP.NAO_AUTORIZADO_RSP).build();
		}

		if (!usuarioService.isExistUsuarioByHashcodeAndActive(xtoken)) {
			return Response.ok(MessageCodeHTTP.NAO_AUTORIZADO_RSP).build();
		}
		
		return Response.ok(usuarioService.getUsuarioById(id)).build();
	}

	// @RolesAllowed({"user", "admin"})
	@GET
	@Path("/username/{username}")
	public Response getByUsername(@PathParam("username") String username) {
		String xtoken = request.getHeader(StaticGenericConstantResources.HEADER_TOKEN);
		if (xtoken == null) {
			return Response.ok(MessageCodeHTTP.NAO_AUTORIZADO_RSP).build();
		}

		if (!usuarioService.isExistUsuarioByHashcodeAndActive(xtoken)) {
			return Response.ok(MessageCodeHTTP.NAO_AUTORIZADO_RSP).build();
		}
		
		return Response.ok(usuarioService.getUsuarioByUsername(username)).build();
	}
	
	@GET
	@Path("/reenvio-email/{idUsuario}")
	public Response sendEmailAgain(@PathParam("idUsuario") Long idUsuario) {
		String xtoken = request.getHeader(StaticGenericConstantResources.HEADER_TOKEN);
		if (xtoken == null) {
			return Response.ok(MessageCodeHTTP.NAO_AUTORIZADO_RSP).build();
		}

		if (!usuarioService.isExistUsuarioByHashcodeAndActive(xtoken)) {
			return Response.ok(MessageCodeHTTP.NAO_AUTORIZADO_RSP).build();
		}
		
		Usuario usuario = usuarioService.getUsuarioById(idUsuario);
		if (usuario == null) {
			return Response.ok(MessageCodeHTTP.NAO_EXISTE_RSP).build();
		}
		
		String newPasswordToReSend = usuario.getNewGeneratedPassword();
		
		Hasher hasher = new Hasher();
		usuario.setPassword(hasher.encode(newPasswordToReSend));
		usuario.setHashcode(hasher.getHashCode(usuario.getNome() + usuario.getUsername()));
		usuario.setDtUpdate(new Date());
		
		usuarioService.update(usuario);
		
		return Response.ok(MessageCodeHTTP.ACEITO_RSP).build();
	}

	// @RolesAllowed({"admin"})
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") long id) {
		String xtoken = request.getHeader(StaticGenericConstantResources.HEADER_TOKEN);
		if (xtoken == null) {
			return Response.ok(MessageCodeHTTP.NAO_AUTORIZADO_RSP).build();
		}

		if (!usuarioService.isExistUsuarioByHashcodeAndActive(xtoken)) {
			return Response.ok(MessageCodeHTTP.NAO_AUTORIZADO_RSP).build();
		}

		Usuario u = usuarioService.getUsuarioById(id);
		u.setDtUpdate(new Date());
		u.setEnable(false);
		usuarioService.save(u);
				
		return Response.ok(MessageCodeHTTP.OK_RSP).build();
	}

	// @RolesAllowed({"admin"})
	@POST
	public Response post(Usuario u) {
		String xtoken = request.getHeader(StaticGenericConstantResources.HEADER_TOKEN);
		if (xtoken == null) {
			return Response.ok(MessageCodeHTTP.NAO_AUTORIZADO_RSP).build();
		}

		if (!usuarioService.isExistUsuarioByHashcodeAndActive(xtoken)) {
			return Response.ok(MessageCodeHTTP.NAO_AUTORIZADO_RSP).build();
		}

		//enviaEmailService.inicializaConfiguracoesNecessarias(u.getUsername(), u.getPassword(), u.getEmail(), u.getNome());

		Hasher hasher = new Hasher();
		u.setPassword(hasher.encode(u.getPassword()));
		u.setHashcode(hasher.getHashCode(u.getNome() + u.getUsername()));
		u.setEmailEnviado(true);
		u.setEnable(true);
		u.setDtCadastro(new Date());

		try {
			usuarioService.save(u);
						
		} catch (ConstraintViolationException e) {
			return Response.ok(MessageCodeHTTP.CONSTRAINT_VIOLATION_RSP).build();
		}

		return Response.ok(MessageCodeHTTP.CRIADO_RSP).build();
	}

	// @RolesAllowed({"admin"})
	@POST
	@Path("/usuarios")
	public Response postList(List<Usuario> list) {
		String xtoken = request.getHeader(StaticGenericConstantResources.HEADER_TOKEN);
		if (xtoken == null) {
			return Response.ok(MessageCodeHTTP.NAO_AUTORIZADO_RSP).build();
		}

		if (!usuarioService.isExistUsuarioByHashcodeAndActive(xtoken)) {
			return Response.ok(MessageCodeHTTP.NAO_AUTORIZADO_RSP).build();
		}
		Hasher hasher = new Hasher();
		for (Usuario u : list) {
			u.setPassword(hasher.encode(u.getPassword()));
			u.setHashcode(hasher.getHashCode(u.getNome() + u.getUsername()));
			u.setEmailEnviado(true);
			u.setEnable(true);
			u.setDtCadastro(new Date());

			try {
				usuarioService.save(u);
				
			} catch (ConstraintViolationException e) {
				return Response.ok(MessageCodeHTTP.CONSTRAINT_VIOLATION_RSP).build();
			}
		}
		return Response.ok(MessageCodeHTTP.CRIADO_RSP).build();
	}

	// @RolesAllowed({"admin"})
	@PUT
	public Response put(Usuario u) {
		String xtoken = request.getHeader(StaticGenericConstantResources.HEADER_TOKEN);
		if (xtoken == null) {
			return Response.ok(MessageCodeHTTP.NAO_AUTORIZADO_RSP).build();
		}

		if (!usuarioService.isExistUsuarioByHashcodeAndActive(xtoken)) {
			return Response.ok(MessageCodeHTTP.NAO_AUTORIZADO_RSP).build();
		}

		Hasher hasher = new Hasher();
		u.setPassword(hasher.encode(u.getPassword()));
		u.setHashcode(hasher.getHashCode(u.getNome() + u.getUsername()));
		u.setDtUpdate(new Date());

		try {
			usuarioService.save(u);
			
		} catch (ConstraintViolationException e) {
			return Response.ok(MessageCodeHTTP.CONSTRAINT_VIOLATION_RSP).build();
		}

		return Response.ok(MessageCodeHTTP.ACEITO_RSP).build();
	}

}
