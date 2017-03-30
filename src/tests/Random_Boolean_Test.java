package tests;

import java.util.Random;

public class Random_Boolean_Test {

	public static void main(String[] args) {
		int x = 0, trueC = 0, falseC = 0;
		Random rn = new Random();
		Boolean b;
		
		while(x < 100)
		{
			b = rn.nextBoolean();
			
			System.out.println(b);
			if(b)
				trueC++;
			else
				falseC++;
			x++;
		}
		
		System.out.printf("\nTrue - %d\nFalse - %d", trueC, falseC);
	}

}
