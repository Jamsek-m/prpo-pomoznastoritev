package si.pomozna.v1.napaka;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NeNajdem implements ExceptionMapper<NotFoundException>{
	
	@Override
	public Response toResponse(NotFoundException exception) {
		Objekt obj = new Objekt(Response.Status.NOT_FOUND.getStatusCode(), "Napaka! Ne najdem zahtevane storitve!");
		return Response.status(Response.Status.NOT_FOUND).entity(obj).build();
	}
}

