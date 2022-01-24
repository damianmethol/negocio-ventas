package ar.com.eduit.curso.java.web.repositories.jdbc;

import ar.com.eduit.curso.java.web.entities.Articulo;
import ar.com.eduit.curso.java.web.repositories.interfaces.I_ArticuloRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ArticuloRepository implements I_ArticuloRepository {

    private Connection conn;

    public ArticuloRepository(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void save(Articulo articulo) {
        if(articulo==null) return;
        try (PreparedStatement ps=conn.prepareStatement(
                "insert into articulos (descripcion,precio,stock) values (?,?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS)){
            ps.setString(1, articulo.getDescripcion());
            ps.setDouble(2, articulo.getPrecio());
            ps.setInt(3, articulo.getStock());
            ps.execute();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()) articulo.setId(rs.getInt(1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void remove(Articulo articulo) {
        if(articulo==null) return;
        try (PreparedStatement ps=conn.prepareStatement("delete from articulos where id=?")){
            ps.setInt(1, articulo.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Articulo> getAll() {
        List<Articulo>list=new ArrayList();
        try (ResultSet rs=conn.createStatement().executeQuery("select * from articulos")){
            while(rs.next()){
                list.add(new Articulo(
                        rs.getInt("id"), 
                        rs.getString("descripcion"), 
                        rs.getDouble("precio"),
                        rs.getInt("stock")
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
}
