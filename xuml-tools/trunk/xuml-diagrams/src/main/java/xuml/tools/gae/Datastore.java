package xuml.tools.gae;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class Datastore {

	public void put(String keyType, String key, String entity, String property,String value){
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		Key k = KeyFactory.createKey(keyType, key);
		Entity ent = new Entity(entity, k);
		ent.setProperty(property, value);
		ds.put(ent);
	}
	
	public String get(String keyType, String key, String entity,String property){
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		Key k = KeyFactory.createKey(keyType, key);
		String result;
		Entity ent;
		try {
			ent = ds.get(k);
			Object prop = ent.getProperty(property);
			if (property != null)
				result = property.toString();
			else
				result = null;
		} catch (EntityNotFoundException e) {
			result = null;
		}
		return result;
	}
	
}
