package by.epam.code_review.module6.task03.server;

import by.epam.code_review.module6.task03.entity.Person;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Archive extends UnicastRemoteObject implements ArchiveService{

	private static final long serialVersionUID = 1L;

	private static Archive instance;

	private List<Person> list;

	private Archive() throws RemoteException {
		super();
		this.list = new ArrayList<>();
	}

	public static Archive getInstance() throws RemoteException {
		if (instance == null) {
			return new Archive();
		} else {
			return instance;
		}
	}

	@Override
	public void addPerson(Person person) throws RemoteException {
		list.add(person);
	}

	@Override
	public Person getPersonByLastname(String lastname) throws RemoteException {
		return list.stream().filter(p -> p.getLastname().equalsIgnoreCase(lastname)).findFirst().orElse(null);
	}

	@Override
	public void updatePersonById(int id, Person person) throws RemoteException {
		list.stream().filter(p -> p.getId() == id).findFirst().ifPresent(p -> list.set(list.indexOf(p), person));
	}
}
