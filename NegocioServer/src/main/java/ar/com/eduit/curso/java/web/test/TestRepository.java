package ar.com.eduit.curso.java.web.test;

import ar.com.eduit.curso.java.web.connectors.Connector;
import ar.com.eduit.curso.java.web.entities.Articulo;
import ar.com.eduit.curso.java.web.entities.Cliente;
import ar.com.eduit.curso.java.web.entities.Factura;
import ar.com.eduit.curso.java.web.enums.Tipo;
import ar.com.eduit.curso.java.web.repositories.interfaces.I_ArticuloRepository;
import ar.com.eduit.curso.java.web.repositories.interfaces.I_ClienteRepository;
import ar.com.eduit.curso.java.web.repositories.interfaces.I_FacturaRepository;
import ar.com.eduit.curso.java.web.repositories.jdbc.ArticuloRepository;
import ar.com.eduit.curso.java.web.repositories.jdbc.ClienteRepository;
import ar.com.eduit.curso.java.web.repositories.jdbc.FacturaRepository;
import ar.com.eduit.curso.java.web.repositories.list.ArticuloRepositoryFactory;

public class TestRepository {
    public static void main(String[] args) {
        //I_ArticuloRepository ar=ArticuloRepositoryFactory.getArticuloRepository();
        I_ArticuloRepository ar=new ArticuloRepository(new Connector().getConnection());
//        ar.save(new Articulo("Carpa",35000,10));
//        ar.save(new Articulo("Termo",2300,20));
//        ar.save(new Articulo("Silla",5000,10));
//        ar.save(new Articulo("Cocina",5000,30));
        
//        ar.getAll().forEach(System.out::println);
        System.out.println(ar.getById(3));
        
//        I_ClienteRepository cr=new ClienteRepository(new Connector().getConnection());
//        cr.save(new Cliente("Juan", "Perez", 50, 1));
//        cr.save(new Cliente("Diego", "Gomez", 45, 2));
//        cr.save(new Cliente("Andrea", "Moro", 30, 3));
//        cr.save(new Cliente("Laura", "Salas", 25, 4));
//        
//        cr.getAll().forEach(System.out::println);

        I_FacturaRepository fr=new FacturaRepository(new Connector().getConnection());
        fr.save(new Factura("Damian", "Methol", Tipo.B, 3500, 2));
        fr.getAll().forEach(System.out::println);
        
    }
}
