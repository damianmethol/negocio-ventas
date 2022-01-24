package ar.com.eduit.curso.java.web.repositories.rest;

import ar.com.eduit.curso.java.web.entities.Cliente;
import ar.com.eduit.curso.java.web.http.ClienteHttp;
import ar.com.eduit.curso.java.web.repositories.interfaces.I_ClienteRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;


public class ClienteRepository implements I_ClienteRepository{
    private String urlServer;

    public ClienteRepository(String urlServer) {
        this.urlServer = urlServer;
    }

    @Override
    public void save(Cliente cliente) {
        if(cliente==null) return;
        String url=urlServer+"/clientes/v1/alta?nombre="+cliente.getNombre()
                +"&apellido="+cliente.getApellido()
                +"&edad="+cliente.getEdad()
                +"&idArticulo="+cliente.getIdArticulo();
        try{
            //String resp=responseBody(url);
            //int id=Integer.parseInt(resp);
            //cliente.setId(id);
            cliente.setId(Integer.parseInt(ClienteHttp.responseBody(url)));
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void remove(Cliente cliente) { }

    @Override
    public List<Cliente> getAll() {
        Type listType=new TypeToken<List<Cliente>>(){}.getType();
        try{
            List<Cliente>list=new Gson().fromJson(ClienteHttp.responseBody(urlServer+"/clientes/v1/all"), listType);
            return list;
        }catch(Exception e){
            System.out.println(e);
            return new ArrayList();
        }
    }

    @Override
    public List<Cliente> getLikeApellido(String apellido) {
       Type listType=new TypeToken<List<Cliente>>(){}.getType();
        try{
            List<Cliente>list=new Gson()
                    .fromJson(
                            ClienteHttp
                                    .responseBody(urlServer+"/clientes/v1/likeApellido?apellido="+apellido), listType);
            return list;
        }catch(Exception e){
            System.out.println(e);
            return new ArrayList();
        }
    }

    @Override
    public Cliente getById(int id) {
        Type listType=new TypeToken<Cliente>(){}.getType();
        try{
            Cliente cliente=new Gson()
                    .fromJson(ClienteHttp
                            .responseBody(urlServer+"/clientes/v1/byId?id="+id), listType);
            return cliente;
        }catch(Exception e){
            System.out.println(e);
            return new Cliente();
        }    
    }

}
