
import java.util.Scanner;

public class Latihan06 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String Firstname, Lastname, NPM, Usia, Con; 
		
		System.out.print("Masukkan Usia :");
		Usia = input.nextLine();
		System.out.print("Masukkan Firstname :");
		Firstname = input.nextLine();
		System.out.print("Masukkan Lastname :");
		Lastname = input.nextLine();
		System.out.print("Masukkan NPM :");
		NPM = input.nextLine();
		
		Con = Usia.concat(Firstname).concat(Lastname).concat(NPM);
		System.out.println(Con);
		
	}
}
