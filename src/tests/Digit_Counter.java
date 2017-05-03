package tests;

import java.util.Scanner;

public class Digit_Counter {
	
	public static void main(String[] args) {
		int in, i, j;
		int c0 = 0, c1 = 0, c2 = 0, c3 = 0, c4 = 0, c5 = 0, c6 = 0, c7 = 0, c8 = 0, c9 = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a number: ");
		in = sc.nextInt();
		for (i = 0; i < in; i++)
		{
			for (j = 0; j < 10; j++)
			{	
				if ((i % 10) == j || ((i % 100) - ((i % 10)) / 10) == j || (i / 100) == j)
				{
					switch(j)
					{
					case 0:
						c0++;
						break;
					case 1:
						c1++;
						break;
					case 2:
						c2++;
						break;
					case 3:
						c3++;
						break;
					case 4:
						c4++;
						break;
					case 5:
						c5++;
						break;
					case 6:
						c6++;
						break;
					case 7:
						c7++;
						break;
					case 8:
						c8++;
						break;
					case 9:
						c9++;
						break;
					}
				}
			}
			j = 0;
		}
		
		sc.close();
		
		System.out.println("0: " + c0);
		System.out.println("1: " + c1);
		System.out.println("2: " + c2);
		System.out.println("3: " + c3);
		System.out.println("4: " + c4);
		System.out.println("5: " + c5);
		System.out.println("6: " + c6);
		System.out.println("7: " + c7);
		System.out.println("8: " + c8);
		System.out.println("9: " + c9);
	}
}
