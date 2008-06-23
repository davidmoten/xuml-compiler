package moten.david.xuml.model.compiler.deps;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import moten.david.net.Download;

public class DependencyGetter {

	private static final String URL_EMF_ECORE_COMMON = "http://repo1.maven.org/maven2/org/eclipse/emf/common/2.3.0-v200706262000/common-2.3.0-v200706262000.jar";
	private static final String URL_ECORE_XMI = "http://repo1.maven.org/maven2/org/eclipse/emf/ecore/xmi/2.3.0-v200706262000/xmi-2.3.0-v200706262000.jar";
	private static final String URL_EMF_ECORE = "http://repo1.maven.org/maven2/org/eclipse/emf/ecore/2.3.0-v200706262000/ecore-2.3.0-v200706262000.jar";
	private String directoryName;

	public DependencyGetter(String directoryName) {
		this.directoryName = directoryName;
	}

	private static final String URL_MAVEN_ANT_TASKS_JAR = "http://repo1.maven.org/maven2/org/apache/maven/maven-ant-tasks/2.0.9/maven-ant-tasks-2.0.9.jar";
	private static final String URL_ANT_LAUNCHER_JAR = "http://repo1.maven.org/maven2/org/apache/ant/ant-launcher/1.7.0/ant-launcher-1.7.0.jar";
	private static final String URL_ANT_JAR = "http://repo1.maven.org/maven2/org/apache/ant/ant/1.7.0/ant-1.7.0.jar";

	private void addUrlToClasspath(URL u) throws IOException {
		final Class[] parameters = new Class[] { URL.class };
		URLClassLoader sysloader = (URLClassLoader) ClassLoader
				.getSystemClassLoader();
		Class sysclass = URLClassLoader.class;
		try {
			Method method = sysclass.getDeclaredMethod("addURL", parameters);
			method.setAccessible(true);
			method.invoke(sysloader, new Object[] { u });
		} catch (Throwable t) {
			t.printStackTrace();
			throw new IOException(
					"Error, could not add URL to system classloader");
		}// end try catch
	}// end method

	public void getDependencies() throws MalformedURLException, IOException {
		String[] deps = { URL_ANT_JAR, URL_ANT_LAUNCHER_JAR,
				URL_MAVEN_ANT_TASKS_JAR };

		for (String urlString : deps) {
			URL url = new URL(urlString);
			String name = url.getFile();
			name = name.substring(name.lastIndexOf("/") + 1);
			File file = new File(directoryName, name);
			System.out.println("getting " + name);
			Download.get(url, file);
			addUrlToClasspath(file.toURI().toURL());
		}

		System.out.println("writing build.xml");
		File buildXml = new File(directoryName, "build.xml");
		Download.get(getClass().getResource("/build.xml"), buildXml);
	}

	public void getMavenDependencies(String destination)
			throws ClassNotFoundException, SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		System.setProperty("dependencies", destination);
		Class antLauncherClass = Class
				.forName("org.apache.tools.ant.launch.Launcher");
		String[] temp = new String[] { "hello" };
		Class[] argumentTypes = new Class[] { temp.getClass() };
		Method main = antLauncherClass.getMethod("main", argumentTypes);
		Object[] args = new Object[] { new String[] { "get.maven.dependencies" } };
		main.invoke(null, args);
	}

	public static void main(String[] args) throws MalformedURLException,
			IOException, ClassNotFoundException, SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		String destination = ".";
		DependencyGetter deps = new DependencyGetter(destination);
		deps.getDependencies();
		System.out.println("getting dependencies using maven ant tasks");
		deps.getMavenDependencies(destination);
	}
}
