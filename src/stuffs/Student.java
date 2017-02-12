package stuffs;

import java.util.Calendar;
import java.util.Scanner;

public class Student {
	private String[] nameArray = new String[4];
	private String fullN, age;
	private int yearOB, monthOB, dayOB; //, yearC, monthC, dayC;
	Scanner sc = new Scanner(System.in);
	
	
	public Student(String[] name)
	{
		this.nameArray = name;
		setName();
		System.out.print("Enter " + nameArray[0] + " " + nameArray[nameArray.length - 1] + "'s year of birth: ");
		this.yearOB = sc.nextInt();
		System.out.print("Enter " + nameArray[0] + " " + nameArray[nameArray.length - 1] + "'s month of birth: ");
		this.monthOB = sc.nextInt();
		System.out.print("Enter " + nameArray[0] + " " + nameArray[nameArray.length - 1] + "'s day of birth: ");
		this.dayOB = sc.nextInt();
		calculateAge();
	}
	
	void setName()
	{
		int i;
		this.fullN = nameArray[0] + " ";
		for(i = 1; i < nameArray.length - 1; i++)
		{
			fullN += nameArray[i] + " ";
		}
		fullN += nameArray[i];
	}

	void calculateAge()
	{
		//Calendar now = Calendar.getInstance();
		Calendar DOB = Calendar.getInstance();
		DOB.set(yearOB, monthOB, dayOB);
		//age = now - DOB;
	}
	
	String getName()
	{
		return fullN;
	}

	String getDateOB()
	{
		return dayOB + "/" + monthOB + "/" + yearOB;
	}
	
	String getAge()
	{
		return age;
	}
}