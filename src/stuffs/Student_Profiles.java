package stuffs;

import java.util.Scanner;

public class Student_Profiles {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String name;
		String[] nameSplit = new String[10];
		
		System.out.print("Enter the student's full name: ");
		name = sc.nextLine();
		
		nameSplit = name.split(" ");
		for(int i = 0; i < nameSplit.length; i++)
		{
			String cap = nameSplit[i].substring(0, 1).toUpperCase() + nameSplit[i].substring(1);
			nameSplit[i] = cap;
		}
		Student s1 = new Student(nameSplit);
		System.out.println("Name - " + s1.getName());
		System.out.println("Date of birth - " + s1.getDateOB());
		System.out.println("Age - " + s1.getAge());
	}
}