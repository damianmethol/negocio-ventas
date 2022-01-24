package ar.com.eduit.curso.java.web.connectors;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {

    private String driver = "org.mariadb.jdbc.Driver";
    private String url = "jdbc:mariadb://localhost:3306/javaWebNoviembre";
    private String user = "root";
    private String pass = "";
    
//    private String driver="org.mariadb.jdbc.Driver";
//    private String url="jdbc:mariadb://db4free.net:3306/java_web";
//    private String user="java_web";
//    private String pass="java_web";
    
//    private String driver="org.postgresql.Driver";
//    private String url="jdbc:postgresql://kesavan.db.elephantsql.com:5432/nqaprvqs";
//    private String user="nqaprvqs";
//    private String pass="o1ekXT1OD6YSOCVrTyJ6BvNW0POiiL-y";
    
    public Connector() {
    }

    public Connector(String driver, String url, String user, String pass) {
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    public Connection getConnection(){
        try {
            Class.forName(driver);      //registra el driver
            return DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            return null;
        }
    }
    
}
