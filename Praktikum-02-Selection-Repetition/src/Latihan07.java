import java.util.Scanner;

class Resto {
	private long harga;

	public void chooseMenu(int menu) {
		switch (menu) {
		case 1:
			System.out.println("Anda memesan Nasi Goreng dengan harga Rp." + getPrices(menu) + ",-");
			break;

		case 2:
			System.out.println("Anda memesan Bubur Ayam dengan harga Rp." + getPrices(menu) + ",-");
			break;

		case 3:
			System.out.println("Anda memesan Soto Ayam dengan harga Rp." + getPrices(menu) + ",-");
			break;

		default:
			System.out.println("Maaf menu yang anda masukkan salah");
			break;
		}
	}

	private long getPrices(int menu) {
		if (menu == 1) {
			harga = 22000;
		} else if (menu == 2) {
			harga = 15000;
		} else if (menu == 3) {
			harga = 25000;
		}
		return harga;
	}
}

public class Latihan07 {
	public static void main(String[] args) {
		Resto resto = new Resto();

		Scanner input = new Scanner(System.in);

		int pilihan;
		char ulang;

		do {
			System.out.println("##  Daftar Menu ##");
			System.out.println("============================");
			System.out.println("1. Nasi Goreng");
			System.out.println("2. Bubur Ayam");
			System.out.println("3. Soto Ayam");
			System.out.println();

			System.out.print("Pilihan anda: ");
			pilihan = input.nextInt();

			resto.chooseMenu(pilihan);

			System.out.println();

			System.out.print("Apakah anda akan memesan kembali (y/n)? ");
			ulang = input.next().charAt(0);

			System.out.println();
		} while (ulang != 'n');

		System.out.println("Terima Kasih");
		input.close();
	}
}