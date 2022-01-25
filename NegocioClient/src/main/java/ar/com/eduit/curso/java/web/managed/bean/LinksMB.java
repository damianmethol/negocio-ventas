package ar.com.eduit.curso.java.web.managed.bean;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named
@SessionScoped
public class LinksMB implements Serializable {
    private String urlServer = "http://localhost:8080/NegocioClient/faces";
    private String index = urlServer + "/index.xhtml";
    private String clientes = urlServer + "/ClientesPrimefaces.xhtml";
    private String articulos = urlServer + "/ArticulosPrimefaces.xhtml";
    private String facturas = urlServer + "/FacturasPrimefaces.xhtml";

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getClientes() {
        return clientes;
    }

    public void setClientes(String clientes) {
        this.clientes = clientes;
    }

    public String getArticulos() {
        return articulos;
    }

    public void setArticulos(String articulos) {
        this.articulos = articulos;
    }

    public String getFacturas() {
        return facturas;
    }

    public void setFacturas(String facturas) {
        this.facturas = facturas;
    }
    
}
