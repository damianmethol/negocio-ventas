package ar.com.eduit.curso.java.web.repositories.rest;

import ar.com.eduit.curso.java.web.entities.Articulo;
import ar.com.eduit.curso.java.web.entities.Cliente;
import ar.com.eduit.curso.java.web.http.ClienteHttp;
import ar.com.eduit.curso.java.web.repositories.interfaces.I_ArticuloRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ArticuloRepository implements I_ArticuloRepository{
    private String urlServer;

    public ArticuloRepository(String urlServer) {
        this.urlServer = urlServer;
    }

    @Override
    public void save(Articulo articulo) {
        if(articulo==null) return;
        String url=urlServer+"/articulos/v1/alta?descripcion="+articulo.getDescripcion()
                +"&precio="+articulo.getPrecio()
                +"&stock="+articulo.getStock();
        try{
            articulo.setId(Integer.parseInt(ClienteHttp.responseBody(url)));
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void remove(Articulo articulo) { }

    @Override
    public List<Articulo> getAll() {
        Type listType=new TypeToken<List<Articulo>>(){}.getType();
        try{
            List<Articulo>list=new Gson().fromJson(ClienteHttp.responseBody(urlServer+"/articulos/v1/all"), listType);
            return list;
        }catch(Exception e){
            System.out.println(e);
            return new ArrayList();
        }
    }

    @Override
    public List<Articulo> getLikeDescripcion(String descripcion) {
        Type listType=new TypeToken<List<Articulo>>(){}.getType();
        try{
            List<Articulo>list=new Gson()
                    .fromJson(
                            ClienteHttp
                                    .responseBody(urlServer+"/articulos/v1/likeDescripcion?descripcion="+descripcion), listType);
            return list;
        }catch(Exception e){
            System.out.println(e);
            return new ArrayList();
        }
    }

    @Override
    public Articulo getById(int id) {
        Type listType=new TypeToken<Articulo>(){}.getType();
        try{
            Articulo articulo=new Gson()
                    .fromJson(
                            ClienteHttp
                                    .responseBody(urlServer+"/articulos/v1/byId?id="+id), listType);
            return articulo;
        }catch(Exception e){
            System.out.println(e);
            return new Articulo();
        }    
    }
    
}
