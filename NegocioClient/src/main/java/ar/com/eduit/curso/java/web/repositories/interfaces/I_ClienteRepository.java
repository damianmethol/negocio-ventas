package ar.com.eduit.curso.java.web.repositories.interfaces;

import ar.com.eduit.curso.java.web.entities.Articulo;
import ar.com.eduit.curso.java.web.entities.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface I_ClienteRepository {
    void save(Cliente cliente);
    void remove(Cliente cliente);
    List<Cliente>getAll();
    default Cliente getById(int id){
        return getAll()
                .stream()
                .filter(a->a.getId()==id)
                .findFirst()
                .orElse(new Cliente());
    }
    default List<Cliente>getLikeApellido(String apellido){
        if(apellido==null) return new ArrayList();
        return getAll()
                .stream()
                .filter(c->c.getApellido().toLowerCase().contains(apellido.toLowerCase()))
                .collect(Collectors.toList());
    }
    default List<Cliente>getLikeArticulo(Articulo articulo){
        if(articulo==null) return new ArrayList();
        return getAll()
                .stream()
                .filter(c->c.getIdArticulo()==articulo.getId())
                .collect(Collectors.toList());
    }
}
