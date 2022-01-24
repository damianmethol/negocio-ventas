package ar.com.eduit.curso.java.web.services.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("testRest")
public class TestRest {
    
    @GET
    //@Produces("text/plain")
    @Produces(MediaType.TEXT_PLAIN)
    public String info(){
        return "<h1>Hola mundo JaxRS</h1>";
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("info2")
    public String info2(){
        return "Método info2";
    }
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("saludo")
    public String saludar(@QueryParam("nombre")String nombre){
        if(nombre==null || nombre.isEmpty()){
            return "<h2>Debe ingresar su nombre.</h2>";
        }else{
            return "<h2>Hola "+nombre+"</h2>";
        }
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("suma")
    public int sumar(@QueryParam("nro1")int nro1, @QueryParam("nro2")int nro2){
        int resultado=nro1+nro2;
        return resultado;
    }
    
}
