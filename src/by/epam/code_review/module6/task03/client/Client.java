package by.epam.code_review.module6.task03.client;

import by.epam.code_review.module6.task03.entity.Address;
import by.epam.code_review.module6.task03.entity.Person;
import by.epam.code_review.module6.task03.entity.Sex;
import by.epam.code_review.module6.task03.entity.Student;
import by.epam.code_review.module6.task03.server.ArchiveService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {

	public static void main(String[] args) {

		String localhost = "127.0.0.1";
		String RMI_HOSTNAME = "java.rmi.server.hostname";
		String SERVICE_PATH = "rmi://localhost/Archive";

		try {

			System.setProperty(RMI_HOSTNAME, localhost);

			ArchiveService archive = (ArchiveService) Naming.lookup(SERVICE_PATH);

			Address address = new Address("220120", "Minsk", "Odincova st.", "22", "181");
			Person person = new Student("Fedor", "Ivanov", Sex.MALE, address,
					"The Faculty of Computer-Aided Design");

			archive.addPerson(person);

			System.out.println(archive.getPersonByLastname("Ivanov"));

			person.setLastname("Petrenko");

			archive.updatePersonById(1, person);

			System.out.println(archive.getPersonByLastname("Petrenko"));

		} catch (RemoteException | MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			System.err.println("NotBoundException : " +
					e.getMessage());
		}


	}
}
