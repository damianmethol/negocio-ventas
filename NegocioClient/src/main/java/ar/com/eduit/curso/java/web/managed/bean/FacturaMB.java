package ar.com.eduit.curso.java.web.managed.bean;

import ar.com.eduit.curso.java.web.entities.Factura;
import ar.com.eduit.curso.java.web.repositories.interfaces.I_FacturaRepository;
import ar.com.eduit.curso.java.web.repositories.rest.FacturaRepository;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class FacturaMB implements Serializable {
    private Factura factura=new Factura();
    private String mensaje="";
    private String buscarApellido="";
    private I_FacturaRepository fr=new FacturaRepository("http://localhost:8084/NegocioServer/webresources");
    
    public void save(){
        fr.save(factura);
        if(factura.getId()==0){
            mensaje="Error no se pudo guardar la factura!";
            addMessage(FacesMessage.SEVERITY_ERROR, "Info Message", mensaje);
        }else{
            mensaje="Se guardó la factura id: "+factura.getId()+"!";
            factura=new Factura();
            addMessage(FacesMessage.SEVERITY_INFO, "Info Message", mensaje);
        }
        
    }
    
    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }
    
    public List<Factura>getAll(){
        return fr.getAll();
    }
    
    public List<Factura>getLikeApellido(){
        return fr.getLikeApellido(buscarApellido);
    }
    
    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getBuscarApellido() {
        return buscarApellido;
    }

    public void setBuscarApellido(String buscarApellido) {
        this.buscarApellido = buscarApellido;
    }
    
    
}
