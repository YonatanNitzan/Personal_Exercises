package tests;

import java.util.Scanner;

public class Gale {
	public static void main(String[] args) {
		double x = 0, y = 0;
		final double dx;
		final double g = -9.81;
		double dy;

		Scanner in = new Scanner(System.in);

		dx = in.nextDouble();
		dy = in.nextDouble();

		while (x <= 1000 && y >= 0) {
			dy += g;
			y += dy;
			x += dx;
			System.err.printf("(%f, %f)\n", x, y);
		}

		in.close();
	}
}
