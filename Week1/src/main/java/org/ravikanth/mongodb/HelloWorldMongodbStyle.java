package org.ravikanth.mongodb;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class HelloWorldMongodbStyle {

	public static void main(String [] args) throws UnknownHostException{
		MongoClient client=new MongoClient("localhost", 27017);
		
		DB db=client.getDB("test");
		DBCollection collection=db.getCollection("hello");
		
		DBObject object=(DBObject) collection.findOne();
		
		System.out.println(object);
	}
}
