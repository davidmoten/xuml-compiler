package xuml.tools.jaxb;

import xuml.tools.gae.Datastore;

public class ModelPersistence {
	
	private static final String KEY_KIND = "diagram";
	private static ModelPersistence instance = new ModelPersistence();
	
	public static ModelPersistence instance() {
		return instance;
	}
	public String getXml(String id){
		String entity = id + "-model";
		String property = "model";
		Datastore ds = new Datastore();
		String result = ds.get(KEY_KIND, entity, property);
		return result;
	}
	
	public void save(String id, String xml){
		String entity = id+"-model";
		String property = "model";
		Datastore ds = new Datastore();
		ds.put(KEY_KIND, entity, property, xml);
	}
}
