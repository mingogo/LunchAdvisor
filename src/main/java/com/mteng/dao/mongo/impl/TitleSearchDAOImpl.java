package com.mteng.dao.mongo.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mteng.dao.TitleSearchDAO;
import com.mteng.dao.mongo.manager.MongodbConnectionManager;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.regex.Pattern;

@Component
public class TitleSearchDAOImpl implements TitleSearchDAO {

	MongodbConnectionManager mongodbConnectionManager;
	public void setMongodbConnectionManager(MongodbConnectionManager mongodbConnectionManager){
		this.mongodbConnectionManager = mongodbConnectionManager;
	}


	DBCollection coll = null; 

	@Override
	public HashMap<String,String> resultingHashMap(String inputKeyword) {
		HashMap<String, String> resultingHashMap = new HashMap<String, String>();
		this.coll = mongodbConnectionManager.getDbConn();
		String output = "";
		Pattern pattern = Pattern.compile(inputKeyword,Pattern.CASE_INSENSITIVE);
		BasicDBObject query = new BasicDBObject("title",pattern);
		DBCursor cursorDoc =  coll.find(query).limit(15);

		while(cursorDoc.hasNext()){
			DBObject doc = cursorDoc.next();
			resultingHashMap.put((String) doc.get("docID"),(String) doc.get("title"));
		}
		return resultingHashMap;
	}
}
