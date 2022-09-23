import java.util.Scanner;


public class Latihan05 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String txt;
		System.out.print("Input text :");
		txt  = input.nextLine();
		System.out.print("HURUF BESAR :" + txt.toUpperCase());
	}
}