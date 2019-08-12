package by.epam.code_review.module6.task03.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Задание 3. Создайте клиент-серверное приложение "Архив".
 *
 * Общие требования к заданию:
 * 1. В архиве хранятся Дела (например, студентов). Архив находится на сервере.
 * 2. Клиент, в зависимости от прав, может запросить дело на просмотр, внести в него изменения, или создать новое дело.
 *
 * Требования к коду лабораторной работы:
 * 1. Для реализации сетевого соединения используйте сокеты.
 * 2. Формат хранения данных на сервере - xml-файлы.
 */
public class Server {

	public static void main(String[] args) {

		String localhost = "127.0.0.1";
		String RMI_HOSTNAME = "java.rmi.server.hostname";

		try {
			System.setProperty(RMI_HOSTNAME, localhost);

			ArchiveService archive = Archive.getInstance();

			String serviceName = "Archive";

			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind(serviceName, archive);

		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
