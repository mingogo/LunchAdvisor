package com.mteng.dao.mongo.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mteng.dao.PushArticleToMagnoliaDAO;
import com.mteng.dao.mongo.manager.MongodbConnectionManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class PushArticleToMagnoliaDAOImpl implements PushArticleToMagnoliaDAO {

	MongodbConnectionManager mongodbConnectionManager;
	public void setMongodbConnectionManager(MongodbConnectionManager mongodbConnectionManager){
		this.mongodbConnectionManager = mongodbConnectionManager;
	}
	DBCollection coll = null; 

	@Override
	public HashMap<String, String> getContentBasedonDocID(String articleID) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MongodbConnectionManager mongodbConnectionManager = (MongodbConnectionManager) context.getBean("mongodbConnectionManager");

		this.coll = mongodbConnectionManager.getDbConn();
		HashMap<String, String> resultingHashMap = new HashMap<String, String>();

		BasicDBObject query = new BasicDBObject("docID",articleID);
		BasicDBObject doc = (BasicDBObject) coll.findOne(query);

		resultingHashMap.put("title", doc.getString("title"));
		resultingHashMap.put("abstract", doc.getString("Abstract"));

		return resultingHashMap;
	}
}
