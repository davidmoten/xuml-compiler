package xuml.tools.jaxb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PresentationServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			String id = req.getParameter("id");
			String result = PresentationPersistence.instance().get(id);
			resp.setContentType("text/plain");
			if (result != null)
				resp.getOutputStream().write(result.getBytes());
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		String value = req.getParameter("value");
		try {
			// save
			PresentationPersistence.instance().save(id, value);
		} catch (RuntimeException e) {
			resp.setStatus(500);
			resp.getWriter().println(e.getMessage());
		}
	}
}
