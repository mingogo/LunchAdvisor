package com.mteng.dao.mongo.manager;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.stereotype.Component;

/**
 * Spring managed MONGO Connection Manager. Singleton by default.
 */
@Component("mongodbConnectionManager")
public class MongodbConnectionManager {

	private Integer databasePort;
	private String databaseUsername;
	private String databasePassword;
	private String databaseHost;
	private String databaseInstance;
	private String databaseCollection;

	public void setDatabasePort(Integer databasePort) {
		this.databasePort = databasePort;
	}

	public void setDatabaseUsername(String databaseUsername) {
		this.databaseUsername = databaseUsername;
	}

	public void setDatabasePassword(String databasePassword) {
		this.databasePassword = databasePassword;
	}

	public void setDatabaseHost(String databaseHost) {
		this.databaseHost = databaseHost;
	}

	public void setDatabaseInstance(String databaseInstance) {
		this.databaseInstance = databaseInstance;
	}

	public void setDatabaseCollection(String databaseCollection) {
		this.databaseCollection = databaseCollection;
	}

	public DBCollection getDbConn(){
		DBCollection dBCollection = null;
		try{

			// mongodb://research-usr:dev@ny-vmmongo-d01:27017/research-dev-1
			MongoClientURI uri  = new MongoClientURI("mongodb://" + this.databaseUsername + ":" + this.databasePassword + "@" + this.databaseHost + ":" + this.databasePort + "/" + this.databaseInstance);

			MongoClient client = new MongoClient(uri);
			DB db = client.getDB(uri.getDatabase());
			dBCollection = db.getCollection(this.databaseCollection);

		} catch(Exception e) {
			e.printStackTrace();
		} 
		return dBCollection;
	}
}