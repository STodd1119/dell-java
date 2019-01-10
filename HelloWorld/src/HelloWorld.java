import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World!");
		System.out.println("Hi I am Stephen what is your name?");
		Scanner reader = new Scanner(System.in);
		String input = reader.nextLine();
		System.out.println("Hi " + input + ", hope you are doing well.");
		reader.close();
	}

}
