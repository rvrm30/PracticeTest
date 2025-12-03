package JavaProgram;

import java.util.Scanner;

public class TakesUserInput {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		System.out.println("Enter you name");
		System.out.println("Enter you age");
		Scanner stringscanner=new Scanner(System.in);
		
		String name=stringscanner.nextLine();
		int age=stringscanner.nextInt();
		System.out.println(name + "is my name");
		System.out.println(age + "is my age");
	}

}
