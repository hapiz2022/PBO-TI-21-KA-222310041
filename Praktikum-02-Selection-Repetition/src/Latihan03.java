import java.util.Scanner;

public class Latihan03 {
	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);

		int pilihan;

		System.out.println("##  Menu Sarapan: ##");
		System.out.println("============================");
		System.out.println("1. Nasi Goreng");
		System.out.println("2. Bubur Ayam");
		System.out.println("3. Soto Ayam");
		System.out.println();

		System.out.print("Pilihan anda: ");
		pilihan = input.nextInt();

		switch (pilihan) {
		case 1:
			System.out.println("Anda memesan Nasi Goreng dengan harga Rp22.000,-");
			break;
		case 2:
			System.out.println("Anda memesan Nasi Goreng dengan harga Rp22.000,-");
			break;
		case 3:
			System.out.println("Anda memesan Nasi Goreng dengan harga 22.000,-");
			break;
		default:
			System.out.println("Maaf menu yang anda masukan salah.");
		}
		input.close();

	}
}