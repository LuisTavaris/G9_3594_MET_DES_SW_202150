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
    
    private int ID;
    private String nombre;
    private int cantidad;
    private String categoria;
    private String fechaInicial;
    private String fechaFinal;
    private float  precio;
    private double precioFinal;
    private int Stock;

   
    
    //CONSTRUCTOR
  
  

    public Producto(int ID, String nombre, int cantidad, String categoria, String fechaInicial, String fechaFinal, float precio,double precioFinal) {
        this.ID = ID;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.precio = precio;
       this.precioFinal = precioFinal;
    }

    public Producto(String nombre, int cantidad,int ID, int Stock) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.ID = ID;
        this.Stock = Stock;
    }

    

  

    public Producto() {
        
    }


  

   
       

    //SETTER AND GEETTER
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }
  
    
    
}
