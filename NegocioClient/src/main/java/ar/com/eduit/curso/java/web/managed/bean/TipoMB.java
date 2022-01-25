package ar.com.eduit.curso.java.web.managed.bean;

import ar.com.eduit.curso.java.web.enums.Tipo;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class TipoMB {
    
    public Tipo[] getTipos() {
        return Tipo.values();
    }
    
}