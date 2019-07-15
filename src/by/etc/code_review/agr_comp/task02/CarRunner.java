package by.etc.code_review.agr_comp.task02;

import by.etc.code_review.agr_comp.task02.entity.Car;
import by.etc.code_review.agr_comp.task02.entity.Engine;
import by.etc.code_review.agr_comp.task02.entity.Wheel;

/**
 * 2. Создать объект класса Автомобиль, используя классы Колесо, Двигатель. Методы: ехать, заправляться, менять колесо,
 * вывести на консоль марку автомобиля.
 */

public class CarRunner {

	public static void main(String[] args) {

		Engine engine = new Engine(250, 3.0d);

		Car car = new Car("Honda RX", engine);

		car.addWheel(new Wheel(15));
		car.addWheel(new Wheel(15));
		car.addWheel(new Wheel(15));
		car.addWheel(new Wheel(15));

		car.printModel();

		car.fuelUp();
		car.changeWheel();
		car.move();

		car.changeWheel();
	}
}
