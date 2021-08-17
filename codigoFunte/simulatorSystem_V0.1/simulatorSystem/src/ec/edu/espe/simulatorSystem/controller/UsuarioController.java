/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorSystem.controller;

import com.mongodb.*;
import ec.edu.espe.simulatorSystem.model.Usuario;
import ec.edu.espe.simulatorSystem.utils.*;


/**
 *
 * @author luist
 */
public class UsuarioController {
    
     noSqlDBManager dataBase = new MongoDBManager();
     
     public UsuarioController(){};
     
      public BasicDBObject register(Usuario user) {
        BasicDBObject document = new BasicDBObject();
        BasicDBObject mainDocument = new BasicDBObject();

        document.put("Nombres", user.getNombres());
        document.put("Apellidos", user.getApellidos());
        document.put("Fecha de Nacimiento", user.getDateOfBirth());
        document.put("Numero celular", user.getNumeroCelular());
        document.put("Correo Electronico", user.getCorreo());
        document.put("Cedula de Identidad", user.getID());
        document.put("Direccion Domiciliaria", user.getDireccion());

  
        return document;
    }
      
       public BasicDBObject registerLoggin(Usuario user) {
        BasicDBObject document = new BasicDBObject();
        BasicDBObject mainDocument = new BasicDBObject();

        document.put("Usuario", user.getUsuario());
        document.put("Contraseña", user.getContraseña());
       
    
       
        return document;
    }
    
}
