package ar.com.eduit.curso.java.web.servlets.services;

import ar.com.eduit.curso.java.web.connectors.Connector;
import ar.com.eduit.curso.java.web.entities.Factura;
import ar.com.eduit.curso.java.web.enums.Tipo;
import ar.com.eduit.curso.java.web.repositories.interfaces.I_FacturaRepository;
import ar.com.eduit.curso.java.web.repositories.jdbc.FacturaRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FacturaAlta extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        I_FacturaRepository fr=new FacturaRepository(new Connector().getConnection());
        response.setContentType("text/plain;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try{
               String nombre=request.getParameter("nombre");
               String apellido=request.getParameter("apellido");
               Tipo tipo = Tipo.valueOf(request.getParameter("tipo"));
               double monto=Double.parseDouble(request.getParameter("monto"));
               int idArticulo=Integer.parseInt(request.getParameter("idArticulo"));
               Factura factura=new Factura(nombre, apellido, tipo, monto, idArticulo);
               fr.save(factura);
               out.println(factura.getId());
            } catch (Exception e) {
                System.out.println(e);
                out.println("0");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
