/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorSystem.utils;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;

/**
 *
 * @author luist
 */
public abstract class noSqlDBManager {

    DB dataBase;
    DBCollection collection;
    BasicDBObject mainDocument = new BasicDBObject();

    public abstract void openConnection();

    public abstract void save(BasicDBObject basicObject, String dBCollection);

    public abstract String read(String dBCollection);

    public abstract void deleteObject(String search, String basicObject, String dBCollection, boolean decision);

    public abstract String[] readPassword(String search, String dBCollection);
    
    

    public DB getDataBase() {
        return dataBase;
    }

    public void setDataBase(DB dataBase) {
        this.dataBase = dataBase;
    }

    public DBCollection getCollection() {
        return collection;
    }

    public void setCollection(DBCollection collection) {
        this.collection = collection;
    }

    public BasicDBObject getMainDocument() {
        return mainDocument;
    }

    public void setMainDocument(BasicDBObject mainDocument) {
        this.mainDocument = mainDocument;
    }
    
    

}
