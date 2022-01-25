package ar.com.eduit.curso.java.web.repositories.jdbc;

import ar.com.eduit.curso.java.web.entities.Articulo;
import ar.com.eduit.curso.java.web.entities.Cliente;
import ar.com.eduit.curso.java.web.entities.Factura;
import ar.com.eduit.curso.java.web.enums.Tipo;
import ar.com.eduit.curso.java.web.repositories.interfaces.I_FacturaRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FacturaRepository implements I_FacturaRepository {

    private Connection conn;

    public FacturaRepository(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public void save(Factura factura) {
        if(factura==null) return;
        try (PreparedStatement ps=conn.prepareStatement(
                "insert into facturas (nombre,apellido,tipo,monto,idArticulo) values (?,?,?,?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS)){
            ps.setString(1, factura.getNombre());
            ps.setString(2, factura.getApellido());
            ps.setString(3, factura.getTipo().toString());
            ps.setDouble(4, factura.getMonto());
            ps.setInt(5, factura.getIdArticulo());
            ps.execute();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()) factura.setId(rs.getInt(1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void remove(Factura factura) {
        if(factura==null) return;
        try (PreparedStatement ps=conn.prepareStatement("delete from facturas where id=?")){
            ps.setInt(1, factura.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
        }

    @Override
    public List<Factura> getAll() {
        List<Factura>list=new ArrayList();
        try (ResultSet rs=conn.createStatement().executeQuery("select * from facturas")){
            while(rs.next()){
                list.add(new Factura(
                        rs.getInt("id"), 
                        rs.getString("nombre"), 
                        rs.getString("apellido"), 
                        Tipo.valueOf(rs.getString("tipo").toUpperCase()),
                        rs.getDouble("monto"),
                        rs.getInt("idArticulo")
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    @Override
    public List<Factura> getLikeTipo(Tipo tipo) {
        if(tipo==null) return new ArrayList();
        List<Factura>list=new ArrayList();
        try (PreparedStatement ps = conn.prepareStatement(
                "select * from facturas where tipo like ?")){
            ps.setString(1, "%"+tipo.toString().toLowerCase()+"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Factura(
                        rs.getInt("id"), 
                        rs.getString("nombre"), 
                        rs.getString("apellido"),
                        Tipo.valueOf(rs.getString("tipo").toUpperCase()),
                        rs.getDouble("monto"),
                        rs.getInt("idArticulo")
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;}


    @Override
    public Factura getById(int id) {
        Factura factura = new Factura();
        try (PreparedStatement ps = conn.prepareStatement(
                "select * from facturas where id=?")){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                factura = new Factura(
                        rs.getInt("id"), 
                        rs.getString("nombre"), 
                        rs.getString("apellido"),
                        Tipo.valueOf(rs.getString("tipo").toUpperCase()),
                        rs.getDouble("monto"),
                        rs.getInt("idArticulo")
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return factura;
    }
    
    
}
