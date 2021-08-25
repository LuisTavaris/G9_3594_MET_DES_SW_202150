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
public class Proveedor extends PersonalEmpresarial {
    
    
    //CONSTRUCTOR
    public Proveedor(String nombres, String apellidos, String ID, String dateOfBirth, String numeroCelular, String direccion, String correo, boolean option) {
        super(nombres, apellidos, ID, dateOfBirth, numeroCelular, direccion, correo, option);
    }
        
    
}
