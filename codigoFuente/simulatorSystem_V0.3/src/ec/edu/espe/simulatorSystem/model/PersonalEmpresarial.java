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
public abstract class PersonalEmpresarial {
        
    private String nombres;
    private String apellidos;
    private String ID;
    private String dateOfBirth;
    private String numeroCelular;
    private String direccion;
    private String correo;
    private boolean option;

    //CONTRUCTOR 
    public PersonalEmpresarial(String nombres, String apellidos, String ID, String dateOfBirth, String numeroCelular, String direccion, String correo, boolean option) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.ID = ID;
        this.dateOfBirth = dateOfBirth;
        this.numeroCelular = numeroCelular;
        this.direccion = direccion;
        this.correo = correo;
        this.option = option;
    }

    public PersonalEmpresarial(boolean option){
        this.option = option;
    }
    
    
    //SETTER AND GETTER
    
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isOption() {
        return option;
    }

    public void setOption(boolean option) {
        this.option = option;
    }

    
    
    
    
 
    
}
