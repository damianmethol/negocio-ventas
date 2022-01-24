package ar.com.eduit.curso.java.web.services.rest;

import ar.com.eduit.curso.java.web.connectors.Connector;
import ar.com.eduit.curso.java.web.entities.Cliente;
import ar.com.eduit.curso.java.web.repositories.interfaces.I_ClienteRepository;
import ar.com.eduit.curso.java.web.repositories.jdbc.ClienteRepository;
import com.google.gson.Gson;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/clientes/v1")
public class ClienteService {
    private I_ClienteRepository cr=new ClienteRepository(new Connector().getConnection());
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String info(){
        return "Servicio Clientes V1 activo!";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public String getAll(){
        return new Gson().toJson(cr.getAll());
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/byId")
    public String getById(@QueryParam("id")int id){
        return new Gson().toJson(cr.getById(id));
    }
        
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("likeApellido")
    public String getLikeApellido(@QueryParam("apellido") String apellido){
        return new Gson().toJson(cr.getLikeApellido(apellido));
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("alta")
    public int alta(
            @QueryParam("nombre") String nombre, 
            @QueryParam("apellido") String apellido, 
            @QueryParam("edad") int edad,
            @QueryParam("idArticulo") int idArticulo
    ){
        Cliente cliente=new Cliente(nombre, apellido, edad, idArticulo);
        cr.save(cliente);
        return cliente.getId();
    }
    
}
