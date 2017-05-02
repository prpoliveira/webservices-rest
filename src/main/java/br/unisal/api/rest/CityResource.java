package br.unisal.api.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unisal.api.model.City;
import br.unisal.api.service.CityService;
import br.unisal.api.util.MessageCodeHTTP;

@Path("/city")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Component
public class CityResource {

	@Context
	HttpServletRequest request;

	@Autowired
	private CityService cityService;
	
	/*@GET
	public Response get() {
				
		return Response.ok(usuarioService.getUsuario()).build();
	}*/

	@GET
	@Path("{id}")
	public Response getById(@PathParam("id") long id) {
		
		return Response.ok(cityService.getCityById(id)).build();
	}


	@POST
	public Response post(City c) {
	
		try {
			cityService.save(c);
						
		} catch (ConstraintViolationException e) {
			return Response.ok(MessageCodeHTTP.CONSTRAINT_VIOLATION_RSP).build();
		}

		return Response.ok(MessageCodeHTTP.CRIADO_RSP).build();
	}

	@POST
	@Path("/cities")
	public Response postList(List<City> list) {
	
		City city = new City();
	
		for (City c : list) {
			city.setNome(c.getNome());
			city.setGeocodigo(c.getGeocodigo());
			city.setLatitude(c.getLatitude());
			city.setLongitude(c.getLongitude());

			try {
				cityService.save(city);
				
			} catch (ConstraintViolationException e) {
				return Response.ok(MessageCodeHTTP.CONSTRAINT_VIOLATION_RSP).build();
			}
		}
		return Response.ok(MessageCodeHTTP.CRIADO_RSP).build();
	}


}
