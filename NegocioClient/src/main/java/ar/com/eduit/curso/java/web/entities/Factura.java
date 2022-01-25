package ar.com.eduit.curso.java.web.entities;

import ar.com.eduit.curso.java.web.enums.Tipo;
import java.io.Serializable;

public class Factura implements Serializable {
    
    int id;
    String nombre;
    String apellido;
    Tipo tipo;
    double monto;
    int idArticulo;

    public Factura() {
    }

    public Factura(String nombre, String apellido, Tipo tipo, double monto, int idArticulo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo = tipo;
        this.monto = monto;
        this.idArticulo = idArticulo;
    }

    public Factura(int id, String nombre, String apellido, Tipo tipo, double monto, int idArticulo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo = tipo;
        this.monto = monto;
        this.idArticulo = idArticulo;
    }

    @Override
    public String toString() {
        return "Factura{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", tipo=" + tipo + ", monto=" + monto + ", idArticulo=" + idArticulo + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }
    
    
}
