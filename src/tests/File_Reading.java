package tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class File_Reading {

	public static void main(String[] args) {
		Scanner sc = null;
		String in;
		char charray[] = new char[10];
		
		try
		{
			File txt = new File("res//TextResource.txt");
			sc = new Scanner(txt);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("No file found");
		}
		
		while(sc.hasNextLine())
		{
			in = sc.next();
			charray = in.toCharArray();
			for(char c : charray)
			{
				if(c == '\n' || c == '\r')
					System.out.println("asdasfasf");
				else
				{
					System.out.print(c);
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			System.out.print(" ");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		sc.close();
	}
}