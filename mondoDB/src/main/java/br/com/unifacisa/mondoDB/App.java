package br.com.unifacisa.mondoDB;
import  br.com.unifacisa.mondoDB.model.*;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.codecs.configuration.CodecRegistries;

public class App {
	public static void main(String[] args) {
		CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(),
				CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));

		MongoClientOptions options = MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build();

		MongoClient mongoClient = new MongoClient("localhost:27017", options);
		MongoDatabase database = mongoClient.getDatabase("exemplo").withCodecRegistry(pojoCodecRegistry);
		MongoCollection<Produto> collection = database.getCollection("Produto", Produto.class);
		
		//collection.insertOne(new Produto("arroz",1,5 ));
		/*collection.deleteOne(new Document("description", "arroz"));*/

	}
}
