package by.epam.code_review.module6.task03.server;

import by.epam.code_review.module6.task03.entity.Person;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ArchiveService extends Remote {

	/**
	 * Adds new person in the archive.
	 *
	 * @param person the provided entity
	 * @throws RemoteException may occur during the execution of a remote method call.
	 */
	void addPerson(Person person) throws RemoteException;

	/**
	 * Finds a first person in the archive.
	 *
	 * @param lastname of the provided person.
	 * @return the found person or null there is no such person in the archive.
	 * @throws RemoteException may occur during the execution of a remote method call.
	 */
	Person getPersonByLastname(String lastname) throws RemoteException;

	/**
	 * Update information about the person in the archive by id.
	 *
	 * @param id the id of the person in the archive.
	 * @param person the provided entity.
	 * @throws RemoteException may occur during the execution of a remote method call.
	 */
	void updatePersonById(int id, Person person) throws RemoteException;
}
