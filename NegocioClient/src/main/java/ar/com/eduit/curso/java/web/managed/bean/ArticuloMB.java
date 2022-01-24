package ar.com.eduit.curso.java.web.managed.bean;

import ar.com.eduit.curso.java.web.entities.Articulo;
import ar.com.eduit.curso.java.web.repositories.interfaces.I_ArticuloRepository;
import ar.com.eduit.curso.java.web.repositories.rest.ArticuloRepository;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class ArticuloMB implements Serializable {
    private Articulo articulo=new Articulo();
    private String mensaje="";
    private String buscarDescripcion="";
    private I_ArticuloRepository ar=new ArticuloRepository("http://localhost:8082/NegocioServer/webresources");

    public void save(){
        ar.save(articulo);
        if(articulo.getId()==0){
            mensaje="Error no se pudo guardar el artículo!";
            addMessage(FacesMessage.SEVERITY_ERROR, "Info Message", mensaje);
        }else{
            mensaje="Se guardo el artículo id: "+articulo.getId()+"!";
            articulo=new Articulo();
            addMessage(FacesMessage.SEVERITY_INFO, "Info Message", mensaje);
        }
        
    }
    
    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }
    
    public List<Articulo>getAll(){
        return ar.getAll();
    }
    
    public List<Articulo>getLikeDescripcion(){
        return ar.getLikeDescripcion(buscarDescripcion);
    }
    
    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getBuscarDescripcion() {
        return buscarDescripcion;
    }

    public void setBuscarDescripcion(String buscarDescripcion) {
        this.buscarDescripcion = buscarDescripcion;
    }

}
