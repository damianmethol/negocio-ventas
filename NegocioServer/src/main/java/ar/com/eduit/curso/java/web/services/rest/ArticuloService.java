package ar.com.eduit.curso.java.web.services.rest;

import ar.com.eduit.curso.java.web.connectors.Connector;
import ar.com.eduit.curso.java.web.entities.Articulo;
import ar.com.eduit.curso.java.web.repositories.interfaces.I_ArticuloRepository;
import ar.com.eduit.curso.java.web.repositories.jdbc.ArticuloRepository;
import com.google.gson.Gson;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/articulos/v1")
public class ArticuloService {
    
    private I_ArticuloRepository ar=new ArticuloRepository(new Connector().getConnection());
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String info(){
        return "Servicio articulos V1 activo!";
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("alta")
    public int alta(
            @QueryParam("descripcion") String descripcion, 
            @QueryParam("precio") double precio, 
            @QueryParam("stock") int stock
    ){
        descripcion = descripcion.replaceAll("_", " ");
        Articulo articulo=new Articulo(descripcion, precio, stock);
        ar.save(articulo);
        return articulo.getId();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public String getAll(){
        return new Gson().toJson(ar.getAll());
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("likeDescripcion")
    public String getLikeDescripcion(@QueryParam("descripcion") String descripcion){
        return new Gson().toJson(ar.getLikeDescripcion(descripcion));
    }
    
}
