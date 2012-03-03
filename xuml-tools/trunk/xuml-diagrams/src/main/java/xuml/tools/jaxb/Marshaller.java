package xuml.tools.jaxb;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.transform.stream.StreamSource;

import xuml.metamodel.jaxb.Domain;

public class Marshaller {

	private Unmarshaller unmarshaller;

	public Marshaller() {
		
		 try {
			 JAXBContext context = JAXBContext.newInstance(xuml.metamodel.jaxb.ObjectFactory.class);
			unmarshaller = context.createUnmarshaller();
			unmarshaller.setEventHandler(
				    new ValidationEventHandler() {
				        public boolean handleEvent(ValidationEvent event ) {
				            throw new RuntimeException(event.getMessage(),
				                                       event.getLinkedException());
				        }
				});
		} catch (JAXBException e) {
			throw new RuntimeException(e);
		}
	}
	
	public synchronized Domain unmarshal(InputStream is){
		try {
			return unmarshaller.unmarshal(new StreamSource(is),Domain.class).getValue();
		} catch (JAXBException e) {
			throw new RuntimeException(e);
		}
	}
	
}
