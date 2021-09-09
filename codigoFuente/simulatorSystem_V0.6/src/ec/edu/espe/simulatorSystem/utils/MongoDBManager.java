/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorSystem.utils;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FailOverflow
 */
public class MongoDBManager extends noSqlDBManager {
    
    private static DBCollection collections;
    private static DB BaseData;
    private DBCursor cursor;
    private static MongoClient mongoC;

    public MongoDBManager() {

    }
      @Override
    public void openConnection() {
         try {
            MongoClientURI uri = new MongoClientURI(
                    "mongodb+srv://tentacle:atlas1234@cluster0.pq2gf.mongodb.net/microEmpresa?retryWrites=true&w=majority");

            MongoClient mongoClient = new MongoClient(uri);
             MongoDatabase database = mongoClient.getDatabase("microEmpresa");
            MongoCollection<org.bson.Document> collections = database.getCollection("microEmpresa");
            dataBase = mongoClient.getDB("microEmpresa");
            collection = dataBase.getCollection("microEmpresa");

        } catch (Exception ex) {
            System.out.println("The connection was unsuccesfull");
        }
    }
        public boolean DatabaseConection(String nameCollection) {
        MongoClientURI mongoCUri
                = new MongoClientURI("mongodb+srv://tentacle:atlas1234@cluster0.pq2gf.mongodb.net/microEmpresa?retryWrites=true&w=majority");
        setMongoC(new MongoClient(mongoCUri));
        setBaseData(getMongoC().getDB("microEmpresa"));
        setCollections(getBaseData().getCollection(nameCollection));
        return true;

    }

    @Override
    public void save(BasicDBObject basicObject, String dBCollection) {
        openConnection();
        collection = dataBase.getCollection(dBCollection);
        collection.insert(basicObject);
    }
     
    public void actualizar(String dBCollection,String producto,int stock){
        openConnection();
        collection = dataBase.getCollection(dBCollection);
        
        BasicDBObject actualizarStock = new BasicDBObject();
        actualizarStock.append("$set", new BasicDBObject().append("Stock", stock));
        
        BasicDBObject buscarProducto = new BasicDBObject();
         buscarProducto.append("Producto",producto);
        
    }
    

    @Override
    public String read(String dBCollection) {
        openConnection();
        collection = dataBase.getCollection(dBCollection);

        DBCursor cursor = collection.find();
        String name = "";

        while (cursor.hasNext()) {
            name = "Name: " + cursor.next().get("Name") + "\n";
            return name;
        }
        return null;
    }

    @Override
    public void deleteObject(String search, String basicObject, String dBCollection, boolean decision) {
        openConnection();
        collection = dataBase.getCollection(dBCollection);
        if (decision) {
            collection.remove(new BasicDBObject().append(basicObject, search));
        }
    }

    @Override
    public String[] readPassword(String search, String dBCollection) {
        openConnection();
        collection = dataBase.getCollection(dBCollection);

        String[] user = new String[2];

        BasicDBObject consultation = new BasicDBObject();
        consultation.put("Usuario", search);

        DBCursor cursor = collection.find(consultation);

        while (cursor.hasNext()) {
            user[0] = (String) cursor.next().get("Usuario");
            user[1] = (String) cursor.curr().get("Contraseña");
        }
        return user;
    }
   public void verProveedor(JTable tabla){

    
     DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombres");
        model.addColumn("Apellidos");
        model.addColumn("Fecha de Nacimiento");
        model.addColumn("Numero Celular");
        model.addColumn("Correo Electrónico");
        model.addColumn("Cedula");
        model.addColumn("Dirección");

        tabla.setModel(model);

        String[] date = new String[7];
        try {

            collection = dataBase.getCollection("Proveedores");
            DBCursor cursor = collection.find();
            while (cursor.hasNext()) {
                date[0] = cursor.next().get("Nombres").toString();
                date[1] = cursor.curr().get("Apellidos").toString();
                date[2] = cursor.curr().get("Fecha de Nacimiento").toString();
                date[3] = cursor.curr().get("Numero celular").toString();
                date[4] = cursor.curr().get("Correo Electronico").toString();
                date[5] = cursor.curr().get("Cedula de Identidad").toString();
                date[6] = cursor.curr().get("Direccion Domiciliaria").toString();
                model.addRow(date);
            }

           tabla.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
        }
    
    }
  
    public void verProducto(JTable tabla){
        openConnection();
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Cantidad");
        model.addColumn("Categoria");
        model.addColumn("Precio");
        model.addColumn("Fecha Inicial");
        model.addColumn("Fecha Final");
        model.addColumn("Venta");
        

        tabla.setModel(model);

        String[] date = new String[8];
        try {

            collection = dataBase.getCollection("Producto");
            DBCursor cursor = collection.find();
            while (cursor.hasNext()) {
                date[0]= cursor.next().get("ID").toString();
                date[1] = cursor.curr().get("Nombres").toString();
                date[2] = cursor.curr().get("Cantidad").toString();
                date[3] = cursor.curr().get("Categoria").toString();
                date[4] = cursor.curr().get("Precio").toString();
                date[5] = cursor.curr().get("Fecha Inicial").toString();
                date[6] = cursor.curr().get("Fecha Final").toString();
                date[7] = cursor.curr().get("Venta").toString();

                model.addRow(date);
 
            }
            

            tabla.setModel(model);
           

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
        } 
      

}
      public void verContrasñas(JTable tabla){
        openConnection();
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("Usuario");
        model.addColumn("Contraseña");
      
        

        tabla.setModel(model);

        String[] date = new String[2];
        try {

            collection = dataBase.getCollection("Contraseña de Usuarios");
            DBCursor cursor = collection.find();
            while (cursor.hasNext()) {
                date[0]= cursor.next().get("Usuario").toString();
                date[1] = cursor.curr().get("Contraseña").toString();
          

                model.addRow(date);
 
            }
            

            tabla.setModel(model);
           

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
        } 
      

}
    
    public void verUsuario(JTable tabla){
    
     DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombres");
        model.addColumn("Apellidos");
        model.addColumn("Fecha de Nacimiento");
        model.addColumn("Numero Celular");
        model.addColumn("Correo Electrónico");
        model.addColumn("Cedula");
        model.addColumn("Dirección");

        tabla.setModel(model);

        String[] date = new String[7];
        try {

            collection = dataBase.getCollection("Usuarios");
            DBCursor cursor = collection.find();
            while (cursor.hasNext()) {
                date[0] = cursor.next().get("Nombres").toString();
                date[1] = cursor.curr().get("Apellidos").toString();
                date[2] = cursor.curr().get("Fecha de Nacimiento").toString();
                date[3] = cursor.curr().get("Numero celular").toString();
                date[4] = cursor.curr().get("Correo Electronico").toString();
                date[5] = cursor.curr().get("Cedula de Identidad").toString();
                date[6] = cursor.curr().get("Direccion Domiciliaria").toString();
                model.addRow(date);
            }

           tabla.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
        }
    
    }
    public void VerMateriaPrima(JTable tabla){
      openConnection();
        DefaultTableModel model = new DefaultTableModel();
    
        model.addColumn("Producto");
        model.addColumn("Cantidad");
        model.addColumn("ID");
        model.addColumn("Total Stock");

       tabla.setModel(model);
      
        
      

        String[] date = new String[4];
        try {

            collection = dataBase.getCollection("ListaMateriaPrima");
             DBCursor cursor = collection.find();
            while (cursor.hasNext()) {
                date[0] = cursor.next().get("Producto").toString();
                date[1] = cursor.curr().get("Cantidad").toString();
                date[2] = cursor.curr().get("ID").toString();
                date[3] = cursor.curr().get("Stock").toString();
                model.addRow(date);
            }

            tabla.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
        }
    
    }
    public void borrarProducto(JTable tabla){
        collection = dataBase.getCollection("Producto");
        BasicDBObject erraser = new BasicDBObject();
        int fila =  tabla.getSelectedRow();   
        int value =  Integer.parseInt(tabla.getValueAt(fila,0).toString());
        erraser.put("ID", value);
        try {
            collection.remove(erraser);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Escoja una fila");
        }
    
    }
    public void borrarUsuario(JTable tabla){
     collection = dataBase.getCollection("Usuarios");
        BasicDBObject erraser = new BasicDBObject();
        int fila =  tabla.getSelectedRow();
        String value =  tabla.getValueAt(fila, 5).toString();
        erraser.put("Cedula de Identidad", value);
        try {
            collection.remove(erraser);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
        }
    }
    
      public void borrarProveedor(JTable tabla){
     collection = dataBase.getCollection("Proveedores");
        BasicDBObject erraser = new BasicDBObject();
        int fila =  tabla.getSelectedRow();
        String value =  tabla.getValueAt(fila, 5).toString();
        erraser.put("Cedula de Identidad", value);
        try {
            collection.remove(erraser);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
        }
    }
    
    
   public boolean update(String colecccion, String filtro, int oldData, int newData) {
        BasicDBObject query = new BasicDBObject();
        query.put(filtro, oldData);
        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put(filtro, newData);
        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", newDocument);
        setCollections(getBaseData().getCollection(colecccion));
        getCollections().update(query, updateObject);
        return true;
    }
    public boolean update(String colecccion, String filtro, String oldData, String newData) {
        BasicDBObject query = new BasicDBObject();
        query.put(filtro, oldData);
        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put(filtro, newData);
        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", newDocument);
        setCollections(getBaseData().getCollection(colecccion));
        getCollections().update(query, updateObject);
        return true;
    }
   
   
   ////////////////////////////////////////////////////////////////////

    public static DBCollection getCollections() {
        return collections;
    }

    public static void setCollections(DBCollection collections) {
        MongoDBManager.collections = collections;
    }

    public static DB getBaseData() {
        return BaseData;
    }

    public static void setBaseData(DB BaseData) {
        MongoDBManager.BaseData = BaseData;
    }

    public DBCursor getCursor() {
        return cursor;
    }

    public void setCursor(DBCursor cursor) {
        this.cursor = cursor;
    }

    public static MongoClient getMongoC() {
        return mongoC;
    }

    public static void setMongoC(MongoClient mongoC) {
        MongoDBManager.mongoC = mongoC;
    }


}
