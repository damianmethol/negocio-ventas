package ar.com.eduit.curso.java.web.test;

import ar.com.eduit.curso.java.web.entities.Articulo;
import ar.com.eduit.curso.java.web.entities.Cliente;
import ar.com.eduit.curso.java.web.repositories.interfaces.I_ArticuloRepository;
import ar.com.eduit.curso.java.web.repositories.interfaces.I_ClienteRepository;
import ar.com.eduit.curso.java.web.repositories.rest.ArticuloRepository;
import ar.com.eduit.curso.java.web.repositories.rest.ClienteRepository;


public class TestRepository {
    public static void main(String[] args) {
        //I_ArticuloRepository ar=ArticuloRepositoryFactory.getArticuloRepository();
        //I_ArticuloRepository ar=new ArticuloRepository(new Connector().getConnection());
        I_ArticuloRepository ar=new ArticuloRepository("http://localhost:8082/NegocioServer/webresources");
        ar.save(new Articulo("Carpa",35000,10));
        ar.save(new Articulo("Termo",2300,20));
        ar.save(new Articulo("Silla",5000,10));
        ar.save(new Articulo("Cocina",5000,30));
        
        System.out.println("****************************************************");
        Articulo articulo=new Articulo("mesa", 82000, 50);
        ar.save(articulo);
        System.out.println(articulo);
        System.out.println("****************************************************");
        ar.getAll().forEach(System.out::println);
        System.out.println("****************************************************");
        ar.getLikeDescripcion("me").forEach(System.out::println);
        System.out.println("****************************************************");
        
        I_ClienteRepository cr=new ClienteRepository("http://localhost:8082/NegocioServer/webresources");
        
        cr.save(new Cliente("Juan", "Perez", 50, 1));
        cr.save(new Cliente("Diego", "Gomez", 45, 2));
        cr.save(new Cliente("Andrea", "Moro", 30, 3));
        cr.save(new Cliente("Laura", "Salas", 25, 4));
        
        Cliente cliente=new Cliente("Marina", "Tedesco", 26, 2);
        cr.save(cliente);
        System.out.println(cliente);
        System.out.println("****************************************************");
        cr.getAll().forEach(System.out::println);
        System.out.println("****************************************************");
        cr.getLikeApellido("ez").forEach(System.out::println);
        
    }
}
