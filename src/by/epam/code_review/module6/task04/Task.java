package by.epam.code_review.module6.task04;

import by.epam.code_review.module6.task04.entity.Cargo;
import by.epam.code_review.module6.task04.entity.Harbor;
import by.epam.code_review.module6.task04.entity.Ship;

import java.util.Random;

/**
 * 4. Корабли заходят в порт для загрузки/разгрузки контейнеров. Число контейнеров, находящихся в текущий момент в
 * порту и на корабле, должно быть неотрицательным и непревышающим заданную грузоподъемность судна и вместимость порта.
 * В порту работает несколько причалов. У одного причала может стоять один корабль. Корабль может загружаться у причала,
 * Разгружаться или выполнять оба действия.
 */

public class Task {

	public static void main(String[] args) {

		Harbor harbor = new Harbor("Central", 3, 10);

		Thread[] shipThreads = new Thread[5];
		Random random = new Random();

		for (int i = 0; i < shipThreads.length; i++) {
			int current = random.nextInt(2) + 3;
			int max = random.nextInt(current) + current;
			shipThreads[i] = new Thread(new Ship(current, max, harbor));
		}

		for (Thread ship : shipThreads) {
			ship.start();
			try {
				ship.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("The cargoes are remaining in the harbor storage:");
		for (Cargo cargo : harbor.getStorage()){
			System.out.print(cargo + ", ");
		}
	}
}
