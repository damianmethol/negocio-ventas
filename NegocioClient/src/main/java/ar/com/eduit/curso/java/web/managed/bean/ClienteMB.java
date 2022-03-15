package ar.com.eduit.curso.java.web.managed.bean;



import ar.com.eduit.curso.java.web.entities.Cliente;
import ar.com.eduit.curso.java.web.repositories.interfaces.I_ClienteRepository;
import ar.com.eduit.curso.java.web.repositories.rest.ClienteRepository;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class ClienteMB implements Serializable{
    private Cliente cliente=new Cliente();
    private String mensaje="";
    private String buscarApellido="";
    private I_ClienteRepository cr=new ClienteRepository("http://localhost:8084/NegocioServer/webresources");

    public Cliente getCliente() {
        return cliente;
    }

    public void save(){
        cr.save(cliente);
        if(cliente.getId()==0){
            mensaje="Error no se pudo guardar el cliente!";
            addMessage(FacesMessage.SEVERITY_ERROR, "Info Message", mensaje);
        }else{
            mensaje="Se guardo el cliente id: "+cliente.getId()+"!";
            cliente=new Cliente();
            addMessage(FacesMessage.SEVERITY_INFO, "Info Message", mensaje);
        }
        
    }
    
    public List<Cliente>getAll(){
        return cr.getAll();
    }
    
    public List<Cliente>getLikeApellido(){
        return cr.getLikeApellido(buscarApellido);
    }
    
    public int getSize(){
        return cr.getLikeApellido(buscarApellido).size();
    }
    
    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
