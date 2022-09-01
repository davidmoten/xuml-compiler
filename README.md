So you are a java programmer, you have a data model (a Class Diagram) and you want to implement your system?

Get your State Machines sorted, then you can specify a system to xUmlCompiler, and validate, test and execute it.

The result is an executable system so that we satisfy to a fair degree that _"the model is the code"_.

[Overview], [Guide], [Example1Simple QuickStart], [Plan]

For background 
 * [Executable UML](http://en.wikipedia.org/wiki/Executable_UML) at Wikipedia.
 * [Executable UML](http://books.google.com.au/books?id=zBS0aWNjBqcC&printsec=frontcover&dq=mellor+balcer&sig=d0MsWNbJjscwjy4Uj1w6YZls-uc) (Mellor & Balcer, 2002) at Google Books

In detail, a system specified in java code using helper methods provided by xUmlCompiler is used to generate java persistence annotated (JPA) classes. [Guice](https://github.com/google/guice) is used to inject action language (java) for methods and events. xUmlCompiler offers a swing viewer for the system and generates persistence.xml resources for quick testing turnaround. 

Note that a completely reworked model compiler is at http://github.com/davidmoten/xuml-tools. The primary difference is a reworked metamodel in accordance with Leon Starr's work and support for concurrency.

===News===
| Date      | Comment     |
|:-----------|:-----------------------|
| 2022 Sep 01|  Upgraded to hibernate 5.6.x, numerous dependency and plugin updates |
| 2012 July|  [http://github.com/davidmoten/xuml-tools New project] being developed supporting asynchronous messaging and more features from Mellor and Balcer| 
| 2012 July 2| New production system released in AMSA generated by xuml-compiler. Performing beautifully.| 
| 2011 May 4| Fixed so builds with Maven 3| 
| 2011 Apr 15| Released version 4.10| 
| 2011 Apr 15| Tested with Hibernate 3.6.3 and stopped using `@PostLoad` in generated classes because of Hibernate bug [http://opensource.atlassian.com/projects/hibernate/browse/HHH-6043 HHH-6043]| 
| 2010 May 25| Built version 0.4.8| 
| 2010 Feb 17| Two example projects (two artifacts each) and maven parent build in svn| 
| 2010 Feb 11| Uploaded sample Eclipse project| 
| 2010 Feb 10| Converted build from Ant to Maven| 
| 2009 Mar 27| Fixed generated jsp pages| 
| 2009 Feb 10| All associations are lazy fetch| 
| 2009 Jan 13| Generate shared interface implemented by members of a specialization group| 
| 2008 Sep 06| Mutual exclusion enforced on specializations| 
| 2008 Sep 04| Multiple generalizations enabled| 
| 2008 July 02| Specialization needs work to ensure a generalization is abstract and to allow multiple generalizations| 
| 2008 July 01| Improved Viewer Specializations, ant task to generate diagrams as jpeg| 
| 2008 June 25| State Machine Viewer is in| 
| 2008 June 23| Uploaded first download. Included jar downloads all dependencies when run via java -jar.| 
| 2008 June 22| Sorted out download of Ecore dependencies via Maven| 
| 2008 June 18| Viewer now uses ecore data model generated classes for serialization/deserialization| 
| 2008 June 11| Simple system wiki page done| 
| 2008 June 10| Documenting a simpler system to demonstrate the complete development cycle (Shop can wait till later)| 
| 2008 May 29| Documenting a more interesting Shop system| 
| 2008 May 22| First commit| 






