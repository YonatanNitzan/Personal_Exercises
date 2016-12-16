package learningNewThings;

import java.util.Scanner;

public class TestingGround {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String str;
		
		System.out.print("Say something: ");
		str = scanner.nextLine();
		
		switch(str)
		{
		case "Shit":
			System.out.println("Fuck");
		case "Puns":
			System.out.println("Punssssssssssssssssssssssssssss");
		case "How are you?":
			System.out.println("Peachy: Bitch");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Peachy: Fine*");
		case "Peachy fails forever!":
			System.out.println("Peachy: We haven't raped for a while");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Peachy: RPED*");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Peachy: RPED-**************");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Peachy: FUCCCCCXXX");
		}
	}

}