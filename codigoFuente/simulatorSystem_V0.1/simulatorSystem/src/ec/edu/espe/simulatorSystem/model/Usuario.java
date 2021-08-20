/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorSystem.model;

import java.util.logging.Logger;

/**
 *
 * @author luist
 */
public class Usuario extends PersonalEmpresarial {
    
      private String usuario;
      private String contraseña;
      private String IDEmpresarial;
      
      //CONSTRUCTOR
    
    public Usuario(String nombres, String apellidos, String ID, String dateOfBirth, String numeroCelular, String direccion, String correo, boolean option) {
        super(nombres, apellidos, ID, dateOfBirth, numeroCelular, direccion, correo, option);
      
    }

    public Usuario(String usuario, String contraseña,  boolean option) {
        super(option);
        this.usuario = usuario;
        this.contraseña = contraseña;
      
    }

    
    // SETTER AND GETTER
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

    public String getIDEmpresarial() {
        return IDEmpresarial;
    }

    public void setIDEmpresarial(String IDEmpresarial) {
        this.IDEmpresarial = IDEmpresarial;
    }
    
    
}
