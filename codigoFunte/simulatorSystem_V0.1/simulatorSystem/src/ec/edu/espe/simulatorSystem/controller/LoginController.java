/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorSystem.controller;

import ec.edu.espe.simulatorSystem.utils.MongoDBManager;

/**
 *
 * @author luist
 */
public class LoginController {
    
        public boolean system(String pass, String admin) {
        boolean validate = false;
        if (pass.equalsIgnoreCase("rootpass") && admin.equalsIgnoreCase("admin")) {
            validate = true;
        }
        return validate;
    }
    
     public boolean historyUpdater(String user, String pass) {
        boolean validate = false;
        MongoDBManager database = new MongoDBManager();

        String[] validation = database.readPassword(user, "Contraseña de Usuarios");

        if (validation[0] != null) {
            if (validation[0].equalsIgnoreCase(user)) {
                if (validation[0].equalsIgnoreCase(user) && validation[1].equalsIgnoreCase(pass)) {
                    validate = true;
                }
            }
        }
        return validate;
    }
    
}
