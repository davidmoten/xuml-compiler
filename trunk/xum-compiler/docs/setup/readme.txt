To download all dependencies for xUmlCompiler, place xuml-compiler.jar
in the folder where you want the dependencies to be downloaded and

cd to the folder containing xuml-compiler.jar
java -jar xuml-compiler.jar

If you have a proxy server then run the command below (replacing the
host and port values with your settings):

java -Dhttp.proxyHost=proxy -Dhttp.proxyPort=8080 -jar xuml-compiler.jar

This command downloads the ant and maven-ant-tasks jars from 
http://repo1.maven.org/maven2/ then uses an ant build to get 
the rest.


