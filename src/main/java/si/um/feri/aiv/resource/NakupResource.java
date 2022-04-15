package si.um.feri.aiv.resource;

import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import si.um.feri.aiv.dao.NakupDao;
import si.um.feri.aiv.dto.NakupDTO;

import java.util.logging.Logger;

@Path("/nakup")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NakupResource {

    Logger log = Logger.getLogger(NakupResource.class.toString());

    @Context
    private UriInfo context;

    @EJB
    NakupDao nakupPostgresDao;

    @GET
    public Response returnAllNakup() throws Exception{
        log.info("GET: " + context.getPath());
        return Response.ok(nakupPostgresDao.getAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response returnNakup(@PathParam("id") Integer id) throws Exception {
        log.info("GET: " + context.getPath());
        return Response.ok(nakupPostgresDao.find(id)).build();
    }

    @POST
    public Response addNakup(NakupDTO nakupDTO) throws Exception {
        log.info("POST: " + context.getPath());
        System.out.println(nakupDTO.toString());
        nakupPostgresDao.save(nakupDTO.nakupDTOtoNakup());
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateNakup(@PathParam("id") Integer id, NakupDTO nakupDTO) throws Exception {
        log.info("POST: " + context.getPath());
        System.out.println(nakupDTO.toString());
        if (nakupPostgresDao.find(id) == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        nakupPostgresDao.save(nakupDTO.nakupDTOtoNakup());
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/checkForVinjeta/{registrskaOznakaVozila}")
    public Response checkForVinjeta(@PathParam("registrskaOznakaVozila") String registrskaOznakaVozila) throws Exception {
        log.info("GET: " + context.getPath());
        try {
            boolean valid = nakupPostgresDao.checkForVinjeta(registrskaOznakaVozila);
            return Response.ok(valid).build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).build();
        }
    }

}
