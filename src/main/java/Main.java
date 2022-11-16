import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;

public class Main {
    public static void main(String[] args)
    {
        String uri = "mongodb://172.31.77.252:27020";
        MongoClient mongoClient = MongoClients.create(uri);
        MongoDatabase database = mongoClient.getDatabase("admin");

        try
        {
            Bson command = new BsonDocument("ping", new BsonInt64(1));
            Document commandResult = database.runCommand(command);
            System.out.println("Connected succesfully to server.");
        } catch (MongoException me) {
            System.err.println("An error occurred while attempting to run a command: " + me);
        }
    }
}