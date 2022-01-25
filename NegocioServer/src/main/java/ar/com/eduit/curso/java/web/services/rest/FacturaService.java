package ar.com.eduit.curso.java.web.services.rest;

import ar.com.eduit.curso.java.web.connectors.Connector;
import ar.com.eduit.curso.java.web.entities.Factura;
import ar.com.eduit.curso.java.web.enums.Tipo;
import ar.com.eduit.curso.java.web.repositories.interfaces.I_FacturaRepository;
import ar.com.eduit.curso.java.web.repositories.jdbc.FacturaRepository;
import com.google.gson.Gson;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/facturas/v1")
public class FacturaService {
    private I_FacturaRepository fr=new FacturaRepository(new Connector().getConnection());
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String info(){
        return "Servicio facturas V1 activo!";
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("alta")
    public int alta(
            @QueryParam("nombre") String nombre, 
            @QueryParam("apellido") String apellido, 
            @QueryParam("tipo") Tipo tipo,
            @QueryParam("monto") double monto,
            @QueryParam("idArticulo") int idArticulo
    ){
        nombre = nombre.replaceAll("_", " ");
        apellido = apellido.replaceAll("_", " ");
        Factura factura=new Factura(nombre, apellido, tipo, monto, idArticulo);
        fr.save(factura);
        return factura.getId();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public String getAll(){
        return new Gson().toJson(fr.getAll());
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("likeTipo")
    public String getLikeTipo(@QueryParam("tipo") Tipo tipo){
        return new Gson().toJson(fr.getLikeTipo(tipo));
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("likeApellido")
    public String getLikeApellido(@QueryParam("apellido") String apellido){
        return new Gson().toJson(fr.getLikeApellido(apellido));
    }
}
