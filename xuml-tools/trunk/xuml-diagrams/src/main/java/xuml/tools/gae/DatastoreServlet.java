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

	private static final String keyType = "xuml-tools";
	private static final String key = "diagram";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String entity = req.getParameter("entity");
		String property = req.getParameter("property");
		Datastore ds = new Datastore();
		String result = ds.get(keyType, key, entity, property);
		if (result != null)
			resp.getOutputStream().write(result.getBytes());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String entity = req.getParameter("entity");
		String property = req.getParameter("property");
		String value = req.getParameter("value");
		Datastore ds = new Datastore();
		ds.put(keyType, key, entity, property, value);
	}

}
