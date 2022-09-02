# xUmlMetaModel
## How to build this project
If you change the model/uml.ecore that is the underlying metamodel for the xUmlCompiler then you need to regenerate the source from this new ecore file.
This is what you do:

* Delete model/uml.genmodel
* Select model/uml.ecore in Package Explorer
* Click right mouse and select New - Other - Eclipse Modelling Framework - EMF Model

![image](metamodel-images/img01.jpg)

![image](metamodel-images/img02.jpg)

![image](metamodel-images/img03.jpg)

![image](metamodel-images/img04.jpg)

* Hit the Load button and the Next button will be enabled:

![image](metamodel-images/img05.jpg)

![image](metamodel-images/img06.jpg)

* Delete previously generated code:

![image](metamodel-images/img07.jpg)

* Generate the code (to the src folder):

![image](metamodel-images/img08.jpg)
