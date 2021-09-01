/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorSystem.model;

/**
 *
 * @author luist
 */
public class Producto {
    
    private String nombre;
    private String cantidad;
    private String categoria;
    private String fechaInicial;
    private String fechaFinal;
    private String precio;

   
    
    //CONSTRUCTOR
  public Producto(String nombre, String cantidad, String categoria, String fechaInicial, String fechaFinal, String precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.precio = precio;
    }

     //SETTER AND GEETTER

  
     public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(String fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
  
    
    
}
