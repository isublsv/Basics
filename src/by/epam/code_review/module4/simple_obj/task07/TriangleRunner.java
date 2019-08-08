package by.epam.code_review.module4.simple_obj.task07;

/**
 * 7. Описать класс, представляющий треугольник. Предусмотреть методы создания объектов, вычисления площади, периметра и
 * точки пересечения медиан.
 */

public class TriangleRunner {

	public static void main(String[] args) {

		Point a = new Point(1, 2);
		Point b = new Point(-2, 4);
		Point c = new Point(5, 6);

		Triangle triangle = new Triangle(a, b , c);

		double perimeter = triangle.getPerimeter();

		System.out.println("The triangle perimeter P = " + perimeter);

		double square = triangle.getSquare();

		System.out.println("The triangle square S = " + square);

		Point medianPoint = triangle.getMedianPoint();

		System.out.println("The median point of triangle " + medianPoint);

		/*Output:
		The triangle perimeter P = 16.542515414236888
		The triangle square S = 10.000000000000002
		The median point of triangle x = 1.3333333333333333, y = 4.0*/

	}
}
