package ar.com.eduit.curso.java.web.entities;

import java.io.Serializable;

public class Cliente implements Serializable{
        
    /**
	 * 
	 */
    private static final long serialVersionUID = 8768571648817043118L;
    int id;
    String nombre;
    String apellido;
    int edad;
    int idArticulo;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, int edad, int idArticulo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.idArticulo = idArticulo;
    }

    public Cliente(int id, String nombre, String apellido, int edad, int idArticulo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.idArticulo = idArticulo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", idArticulo=" + idArticulo + '}';
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

}
