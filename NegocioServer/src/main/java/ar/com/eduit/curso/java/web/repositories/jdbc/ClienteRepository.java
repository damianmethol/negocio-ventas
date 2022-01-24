package ar.com.eduit.curso.java.web.repositories.jdbc;

import ar.com.eduit.curso.java.web.entities.Articulo;
import ar.com.eduit.curso.java.web.entities.Cliente;
import ar.com.eduit.curso.java.web.repositories.interfaces.I_ClienteRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository implements I_ClienteRepository{
    private Connection conn;

    public ClienteRepository(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public void save(Cliente cliente) {
        if(cliente==null) return;
        try (PreparedStatement ps=conn.prepareStatement(
                "insert into clientes (nombre,apellido,edad,idArticulo) values (?,?,?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS)){
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getEdad());
            ps.setInt(4, cliente.getIdArticulo());
            ps.execute();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()) cliente.setId(rs.getInt(1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void remove(Cliente cliente) {
        if(cliente==null) return;
        try (PreparedStatement ps=conn.prepareStatement("delete from clientes where id=?")){
            ps.setInt(1, cliente.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Cliente> getAll() {
        List<Cliente>list=new ArrayList();
        try (ResultSet rs=conn.createStatement().executeQuery("select * from clientes")){
            while(rs.next()){
                list.add(new Cliente(
                        rs.getInt("id"), 
                        rs.getString("nombre"), 
                        rs.getString("apellido"), 
                        rs.getInt("edad"),
                        rs.getInt("idArticulo")
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
}
