package ar.com.eduit.curso.java.web.repositories.interfaces;

import ar.com.eduit.curso.java.web.entities.Factura;
import ar.com.eduit.curso.java.web.enums.Tipo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface I_FacturaRepository {
    void save(Factura factura);
    void remove(Factura factura);
    List<Factura>getAll();
    default Factura getById(int id){
        return getAll()
                .stream()
                .filter(f->f.getId()==id)
                .findFirst()
                .orElse(new Factura());
    }
    default List<Factura>getLikeApellido(String apellido){
        if(apellido==null) return new ArrayList();
        return getAll()
                .stream()
                .filter(f->f.getApellido().toLowerCase().contains(apellido.toLowerCase()))
                .collect(Collectors.toList());
    }
    default List<Factura>getLikeTipo(Tipo tipo){
        if(tipo==null) return new ArrayList();
        return getAll()
                .stream()
                .filter(f->f.getTipo().toString().toLowerCase().contains(tipo.toString().toLowerCase()))
                .collect(Collectors.toList());
    }
}
