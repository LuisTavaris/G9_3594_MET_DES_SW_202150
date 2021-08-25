/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorSystem.controller;

import com.mongodb.BasicDBObject;
import ec.edu.espe.simulatorSystem.model.Producto;
import ec.edu.espe.simulatorSystem.utils.*;


/**
 *
 * @author luist
 */
public class ProductoController {
    
         noSqlDBManager dataBase = new MongoDBManager();
         
         public ProductoController(){};
         
          public BasicDBObject register(Producto producto) {
        BasicDBObject document = new BasicDBObject();
 
        document.put("Nombres", producto.getNombre());
        document.put("Cantidad", producto.getCantidad());
        document.put("Categoria", producto.getCategoria());        
        document.put("Precio", producto.getPrecio());
        document.put("Fecha Inicial",producto.getFechaInicial());
        document.put("Fecha Final",producto.getFechaFinal());

  
        return document;
    }

    
}
