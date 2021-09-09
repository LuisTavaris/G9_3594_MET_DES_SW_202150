/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorSystem.controller;

import com.mongodb.*;
import ec.edu.espe.simulatorSystem.model.*;
import ec.edu.espe.simulatorSystem.utils.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author luist
 */
public class ProveedorController {
    
     MongoDBManager dataBase = new MongoDBManager();
     
     public ProveedorController(){};
     
      public BasicDBObject register(Proveedor user) {
        BasicDBObject document = new BasicDBObject();
    

        document.put("Nombres", user.getNombres());
        document.put("Apellidos", user.getApellidos());
        document.put("Fecha de Nacimiento", user.getDateOfBirth());
        document.put("Numero celular", user.getNumeroCelular());
        document.put("Correo Electronico", user.getCorreo());
        document.put("Cedula de Identidad", user.getID());
        document.put("Direccion Domiciliaria", user.getDireccion());

  
        return document;
    }
            
  
}
