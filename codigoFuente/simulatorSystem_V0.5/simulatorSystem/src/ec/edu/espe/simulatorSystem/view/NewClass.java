/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorSystem.view;

import ec.edu.espe.simulatorSystem.utils.MongoDBManager;

/**
 *
 * @author luist
 */
public class NewClass {
    
      public static void main(String[] args) {
        
        MongoDBManager beach = new  MongoDBManager();
        beach.openConnection();
        beach.readF();
        
    }
    
    
}
