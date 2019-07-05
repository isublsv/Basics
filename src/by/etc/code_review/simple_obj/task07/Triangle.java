package by.etc.code_review.simple_obj.task07;

/**
 * 7. Описать класс, представляющий треугольник. Предусмотреть методы создания объектов, вычисления площади, периметра и
 * точки пересечения медиан.
 */

public class Triangle {

	private Point pointA;
	private Point pointB;
	private Point pointC;

	public Triangle(Point a, Point b, Point c) {
		double sumAB = getSide(a, b) + getSide(b, c);
		double sumAC = getSide(a, b) + getSide(a, c);
		double sumBC = getSide(a, c) + getSide(b, c);

		if (sumAB <= getSide(a, c) || sumAC <= getSide(b, c) || sumBC <= getSide(a, b)) {
			throw new RuntimeException("The triangle doesn't exist!");
		}

		this.pointA = a;
		this.pointB = b;
		this.pointC = c;
	}

	public Point getPointA() {
		return pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	private double getSide(Point first, Point second) {
		return Math.sqrt(Math.pow(second.getX() - first.getX(), 2) + Math.pow(second.getY() - first.getY(), 2));
	}

	public double getPerimeter() {
		return getSide(pointA, pointB) + getSide(pointB, pointC) + getSide(pointA, pointC);
	}

	public double getSquare() {
		double p = getPerimeter() / 2;
		return Math.sqrt(p * (p - getSide(pointA, pointB)) * (p - getSide(pointB, pointC)) * (p - getSide(pointA, pointC)));
	}

	public Point getMedianPoint() {
		double x = (pointA.getX() + pointB.getX() + pointC.getX()) / 3;
		double y = (pointA.getY() + pointB.getY() + pointC.getY()) / 3;

		return new Point(x, y);
	}
}
