package ar.com.eduit.curso.java.web.repositories.list;


import ar.com.eduit.curso.java.web.entities.Factura;
import ar.com.eduit.curso.java.web.repositories.interfaces.I_FacturaRepository;
import java.util.ArrayList;
import java.util.List;

public class FacturaRepository implements I_FacturaRepository {
    private List<Factura>list=new ArrayList();

    @Override
    public void save(Factura factura) {
       list.add(factura);
    }

    @Override
    public void remove(Factura factura) {
        list.remove(factura);
    }

    @Override
    public List<Factura> getAll() {
       return list;
    }
    

}
