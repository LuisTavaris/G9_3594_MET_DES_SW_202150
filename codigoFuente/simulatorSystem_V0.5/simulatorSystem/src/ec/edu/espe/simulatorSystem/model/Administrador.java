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
public class Administrador extends PersonalEmpresarial {
    
    private String usuario;
    private String contraseña;
    
    
    //CONSTRUCTOR

    public Administrador(String nombres, String apellidos, String ID, String dateOfBirth, String numeroCelular, String direccion, String correo, boolean option) {
        super(nombres, apellidos, ID, dateOfBirth, numeroCelular, direccion, correo, option);
        this.contraseña = contraseña;
        this.usuario = usuario;
    }

    
    
    //SETTER AND GEETTER
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }


    
   
    
}
