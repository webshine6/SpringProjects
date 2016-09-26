import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBExample {

	private static final String FILE_NAME = "jaxb-employee.xml";

	public static void main(String[] args) {

		Employee employee = new Employee();
		employee.setId(5);
		employee.setName("Pesho");
		employee.setRole("developer");
		employee.setAge(25);
		employee.setGender("male");

		jaxbObjectToXML(employee);

		Employee emp = jaxbXMLtoObject();
		System.out.println(emp.toString());

	}

	private static Employee jaxbXMLtoObject() {

		try {
			JAXBContext context = JAXBContext.newInstance(Employee.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();

			Employee employee = (Employee) unmarshaller.unmarshal(new File(FILE_NAME));
			return employee;
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return null;
	}

	private static void jaxbObjectToXML(Employee emp) {

		try {

			JAXBContext context = JAXBContext.newInstance(Employee.class);

			Marshaller m = context.createMarshaller();

			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			m.marshal(emp, new File(FILE_NAME));

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
