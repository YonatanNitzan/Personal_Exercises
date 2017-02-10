package stuffs;

import java.util.Random;
import java.util.Scanner;

public class Pi_From_Random_Numbers {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int count = 0;
		double x, y, estimatedPi, aboveCount = 0, belowCount = 0;
		char in;
		Random rn = new Random();
		
		while(true)
		{
			System.out.print("Enter the amount of dots: ");
			try {
				count = sc.nextInt();

				for (int i = 0; i < count; i++) {
					x = rn.nextDouble();
					y = rn.nextDouble();

					if ((Math.pow(x, 2) + Math.pow(y, 2)) > 1)
						aboveCount++;
					else
						belowCount++;
				}

				estimatedPi = belowCount / (belowCount + aboveCount);
				estimatedPi *= 4;

				System.out.println("Estimated Pi: " + estimatedPi);
				System.out.println("Pi: " + Math.PI);

				System.out.print("\nAgain? ");
				in = sc.next().charAt(0);
				if(in == 'Y' || in == 'y')
					System.out.println();
				else
				{
					System.out.println("\nT E R M I N A T E D");
					break;
				}
			}
			
			catch (Exception e) {
				System.out.println("E R R O R \nT R Y  A G A I N \n");
				sc.next();
			}
		}
	}
}