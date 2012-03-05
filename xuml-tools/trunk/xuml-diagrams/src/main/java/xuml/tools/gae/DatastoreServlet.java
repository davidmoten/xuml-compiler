package xuml.tools.gae;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class DatastoreServlet extends HttpServlet {

	private static final long serialVersionUID = 7659767941927427251L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		String param = req.getParameter("param");
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		Key key = KeyFactory.createKey("id", id);
		String result;
		Entity entity;
		try {
			entity = ds.get(key);
			Object property = entity.getProperty(param);
			if (property != null)
				result = property.toString();
			else
				result = "";
		} catch (EntityNotFoundException e) {
			result = "";
		}
		resp.getOutputStream().write(result.getBytes());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		String param = req.getParameter("param");
		String value = req.getParameter("value");
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		Key key = KeyFactory.createKey("id", id);
		Entity entity = new Entity(param, key);
		entity.setProperty("value", value);
		ds.put(entity);
	}

}
