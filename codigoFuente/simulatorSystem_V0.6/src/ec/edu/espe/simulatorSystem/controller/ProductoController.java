/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorSystem.controller;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import ec.edu.espe.simulatorSystem.model.Producto;
import ec.edu.espe.simulatorSystem.utils.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author luist
 */
public class ProductoController {
    
         MongoDBManager dataB = new MongoDBManager();
           BasicDBObject document = new BasicDBObject();
           BasicDBObject documento_nuevo = new BasicDBObject();
           DBCollection collection;  
       
       
        
      
         
public ProductoController(){};
                   
public BasicDBObject registroProducto(Producto producto) {

        
        document.put("ID", producto.getID());
        document.put("Nombres", producto.getNombre());
        document.put("Cantidad", producto.getCantidad());
        document.put("Categoria", producto.getCategoria());        
        document.put("Precio", producto.getPrecio());
        document.put("Fecha Inicial",producto.getFechaInicial());
        document.put("Fecha Final",producto.getFechaFinal());
        document.put("Venta",producto.getPrecioFinal());

  
        return document;
    }

public void ValidarID(JTable tabla,JTextField igual){
     DefaultTableModel model = new DefaultTableModel();
for(int i=0;i<tabla.getRowCount();i++){
if(tabla.getValueAt(i, 0).equals(igual.getText())){
    JOptionPane.showMessageDialog(null, "N° de  producto ya registrado");
    model.removeRow(i);    
}
}
dataB.verProducto(tabla);

} 
public BasicDBObject RegistroMateriaP(Producto producto) {
     
      document.put("Producto",producto.getNombre());  
      document.put("Cantidad",producto.getCantidad());
      document.put("ID",producto.getID());
      document.put("Stock",producto.getStock());
            

        return document;
    }

public BasicDBObject ActualizarMateriaP(Producto producto) {
     
      documento_nuevo.put("Producto",producto.getNombre());  
      documento_nuevo.put("Cantidad",producto.getCantidad());
      documento_nuevo.put("ID",producto.getID());
      documento_nuevo.put("Stock",producto.getStock());
            

        return documento_nuevo;
    }

}
