package ar.com.eduit.curso.java.web.repositories.rest;

import ar.com.eduit.curso.java.web.entities.Factura;
import ar.com.eduit.curso.java.web.http.ClienteHttp;
import ar.com.eduit.curso.java.web.repositories.interfaces.I_FacturaRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FacturaRepository implements I_FacturaRepository {
    
    private String urlServer;

    public FacturaRepository(String urlServer) {
        this.urlServer = urlServer;
    }

    @Override
    public void save(Factura factura) {
        if(factura==null) return;
        factura.setNombre(factura.getNombre().replaceAll(" ", "_"));
        factura.setApellido(factura.getApellido().replaceAll(" ", "_"));
        String url=urlServer+"/facturas/v1/alta?nombre="+factura.getNombre()
                +"&apellido="+factura.getApellido()
                +"&tipo="+factura.getTipo()
                +"&monto="+factura.getMonto()
                +"&idArticulo="+factura.getIdArticulo();
        try{
            factura.setId(Integer.parseInt(ClienteHttp.responseBody(url)));
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void remove(Factura factura) { }

    @Override
    public List<Factura> getAll() {
        Type listType=new TypeToken<List<Factura>>(){}.getType();
        try{
            List<Factura>list=new Gson().fromJson(ClienteHttp.responseBody(urlServer+"/facturas/v1/all"), listType);
            return list;
        }catch(Exception e){
            System.out.println(e);
            return new ArrayList();
        }
    }

    @Override
    public List<Factura> getLikeTipo(String tipo) {
       Type listType=new TypeToken<List<Factura>>(){}.getType();
        try{
            List<Factura>list=new Gson()
                    .fromJson(
                            ClienteHttp
                                    .responseBody(urlServer+"/clientes/v1/likeTipo?tipo="+tipo), listType);
            return list;
        }catch(Exception e){
            System.out.println(e);
            return new ArrayList();
        }
    }

    @Override
    public Factura getById(int id) {
        Type listType=new TypeToken<Factura>(){}.getType();
        try{
            Factura factura=new Gson()
                    .fromJson(ClienteHttp
                            .responseBody(urlServer+"/facturas/v1/byId?id="+id), listType);
            return factura;
        }catch(Exception e){
            System.out.println(e);
            return new Factura();
        }    
    }
}
