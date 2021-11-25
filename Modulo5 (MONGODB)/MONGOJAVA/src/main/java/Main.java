import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Filter;

public class Main {
    public static void main (String[ ] args ){
        MongoCredential credential = MongoCredential.createCredential( "root", "admin", "root".toCharArray());
        MongoClient cliente = new MongoClient(new ServerAddress("localhost", 27017) , Arrays.asList(credential));
        MongoDatabase db = cliente.getDatabase("vemserdbc");
        MongoCollection<Document> alunos = db.getCollection("alunos_java");


        //create
        Document novoAluno = new Document("nome", "bia")
                .append("data_nascimento", new Date(2000, 10, 10))
                .append("curso", new Document("nome", "historia"))
                .append("notas", Arrays.asList(8,7,9))
                .append("habilidades", Arrays.asList( new Document()
                                .append("nome", "Português")
                                .append("nível", "Fluente"),
                        new Document()
                                .append("nome", "Inglês")
                                .append("nível", "Intermediário")))
                .append("_id",  5);

        alunos.insertOne(novoAluno);

    //find:
     FindIterable<Document> result = alunos.find();
       result.forEach((Block<? super Document>) d -> System.out.println(d.toJson()));

      //update
       alunos.updateOne(Filters.eq("nome", "bia"), Updates.set("nome", "Adriele"));

        //delete:
        alunos.deleteOne(Filters.eq("_id", 3));
    }
    }


