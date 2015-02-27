package com.mteng.dao.mongo.impl;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mteng.dao.DataCountDAO;
import com.mteng.dao.mongo.manager.MongodbConnectionManager;
import org.springframework.stereotype.Component;

@Component
public class DataCountDAOImpl implements DataCountDAO {
	DBCollection coll = null; 
	MongodbConnectionManager mongodbConnectionManager;
	public void setMongodbConnectionManager(MongodbConnectionManager mongodbConnectionManager){
		this.mongodbConnectionManager = mongodbConnectionManager;
	}

	/**
	 * Count the documents in that collection.
	 * @should return the count of data
	 */
	@Override
	public Integer documentsCounter(){
		this.coll = mongodbConnectionManager.getDbConn();
		DBCursor cursorDoc = coll.find();
		Integer counter = 0;

		while (cursorDoc.hasNext()) { 
			cursorDoc.next();
			counter++;
		}
		System.out.println("[mongo]: Total Documents: " + counter);
		return counter;
	}
}