package com.web.gearz.services;

import java.net.UnknownHostException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

@Service
public class FilingService {
	public static String getHost() {
		return host;
	}

	@Value("${host}")
	public static void setHost(String host) {
		FilingService.host = host;
	}

	public static String getDb() {
		return db;
	}

	@Value("${mongodb}")
	public static void setDb(String db) {
		FilingService.db = db;
	}

	private static String host;
	private static String db;
	
	private static DBCollection coll = null;
	private static final String COLLECTION_NAME = "divContents";
	
	private static Mongo _mongo = null;
	private static Log logger = LogFactory.getLog(FilingService.class);
    private static Mongo getMongo() throws  MongoException, UnknownHostException{
        if ( _mongo == null )
            _mongo = new Mongo( host );
        return _mongo;
    }
    
    public static DBCollection getCollection() throws MongoException, UnknownHostException{
    	if(coll== null){
    		Mongo mongo = getMongo();
    	 coll = mongo.getDB(db).getCollection(COLLECTION_NAME);
    	}
    	return coll;
    }

	public void storeContent(int userId,String divId,String content) throws MongoException, UnknownHostException{
		DBCollection dbCollection = getCollection();
		DBCursor cursor = getDBObject(dbCollection,userId,divId);
		BasicDBObject mongoDBObject;
		if(cursor.count()>0){
			 mongoDBObject = (BasicDBObject)cursor.next();
		}
		else{
			mongoDBObject = new BasicDBObject();
			mongoDBObject.append("userId", userId);
			mongoDBObject.append("divId", divId);
		}
		mongoDBObject.put("content", content);
		//dbCollection.find(ref, keys);
		
		dbCollection.insert(mongoDBObject);
	}
	

	public String getContent(int userId,String divId) throws MongoException, UnknownHostException{
		String response = "Default Text";
		DBCollection dbCollection = getCollection();
		DBCursor cursor = getDBObject(dbCollection,userId,divId); 
		if(cursor.count()>0){
			BasicDBObject dbObj = (BasicDBObject)cursor.next();
			return (String)dbObj.get("content");
		}
		return response;
	}

	
	private DBCursor getDBObject(DBCollection dbCollection,int userId,String divId) throws MongoException, UnknownHostException{
		
		assert dbCollection != null;
		BasicDBObject searchKey = new BasicDBObject();
		searchKey.append("userId", userId);
		searchKey.append("divId",divId);
		searchKey.markAsPartialObject();
		DBCursor cursor = dbCollection.find(searchKey);
		return cursor;
	}

}
