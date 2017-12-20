package si.pomozna.v1.vir;

import si.pomozna.model.Storitev;
import si.pomozna.zrna.UpravljalecVrste;
import si.pomozna.zrna.Zrno;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("storitve")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class Vir {
	
	@Inject
	private Zrno zrno;
	
	@Inject
	private UpravljalecVrste qManager;
	
	@GET
	public Response vrniVse(){
		return Response.status(Response.Status.OK).entity(zrno.vrniVse()).build();
	}
	
	@Path("{id}")
	@GET
	public Response vrniEnega(@PathParam("id") long id){
		Storitev st = zrno.vrniEno(id);
		if(st == null){
			throw new NotFoundException();
		} else {
			return Response.status(Response.Status.OK).entity(st).build();
		}
	}
	
	@POST
	public Response dodajEntiteto(Storitev storitev){
		System.out.println("==============> Dodajam entiteto!");
		long id = zrno.dodajStoritev(storitev);
		qManager.posljiObvestiloODodanemPonudniku(id);
		
		return Response.status(Response.Status.CREATED).entity(storitev).build();
	}
	
}
