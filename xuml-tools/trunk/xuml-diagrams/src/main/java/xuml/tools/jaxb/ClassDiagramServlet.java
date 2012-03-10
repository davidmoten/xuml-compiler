package xuml.tools.jaxb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import xuml.metamodel.jaxb.System;
import xuml.tools.gae.Datastore;

public class ClassDiagramServlet extends HttpServlet{

	private static final long serialVersionUID = 2511746331522695068L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		String xml = Datastore.instance().get("diagram", id+"-model", "model");
		System system = new Marshaller().unmarshal(IOUtils.toInputStream(xml));
		String html = new ClassDiagramGenerator().generate(system);
		resp.setContentType("text/html");
		IOUtils.copy(IOUtils.toInputStream(html), resp.getOutputStream());
	}

}