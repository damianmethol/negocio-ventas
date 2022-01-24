package ar.com.eduit.curso.java.web.services.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("")
public class Service {
        @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String info(){
        return "Servidor Activo!";
    }
}
