package ar.com.eduit.curso.java.web.test;

import ar.com.eduit.curso.java.web.connectors.Connector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.time.Duration;
import java.time.LocalDateTime;

public class TestConnector {
    public static void main(String[] args) {
        LocalDateTime ldtInicio=LocalDateTime.now();
        try (Connection connection = new Connector().getConnection()){
            ResultSet rs=connection
                    .createStatement()
                    .executeQuery("select version()");
            if (rs.next()) System.out.println(rs.getString(1));
        } catch (Exception e) {
            System.out.println(e);
        }
        LocalDateTime ldtFin=LocalDateTime.now();
        Duration duration = Duration.between(ldtInicio, ldtFin);
        System.out.println("Tiempo: "+duration.getSeconds()+" segundos.");
    }
}
