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

/**
 *
 * @author FailOverflow
 */
public class MongoDBManager extends noSqlDBManager {

    public MongoDBManager() {

    }

    

    /*public void id(String id) {
        mainDocument.put("id", id);
    }*/
    @Override
    /*public void save(String option, BasicDBObject basicObject, String dBCollection) {
        openConnection();
        collection = dataBase.getCollection(dBCollection);

        if ("Register".equals(option)) {
            collection.insert(basicObject);
        } else if ("Clinic History".equals(option)) {
            collection.insert(basicObject);
        }
    }*/
    public void save(BasicDBObject basicObject, String dBCollection) {
        openConnection();
        collection = dataBase.getCollection(dBCollection);
        collection.insert(basicObject);
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

}
