

import java.util.Scanner;
import java.sql.Timestamp;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Latihan04 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy (HH:mm)");
		String nama_barang = "ROTI ENAK";
		int jumlah_barang, totalharga;
		int harga = 6300;
		int diskon;
		int totaldiskon;

		System.out.println("================================================================");
		System.out.println("                       TOKO SERBAGUNA IBIK                      ");
		System.out.println("================================================================");
		System.out.print("Masukan jumlah produk yang dibeli :");
		jumlah_barang = input.nextInt();
		if (jumlah_barang <= 0) {
			System.out.println("Mohon masukan jumlah yang benar dan ulangi program");
			System.exit(0);
		}
		totalharga = jumlah_barang * harga;
		System.out.println("\n" + formatter.format(ts));
		System.out.println("ITEM              QTY            HARGA          TOTAL ");
		System.out.println("================================================================");

		System.out.println(nama_barang + "          " + jumlah_barang + "             " + "Rp " + harga + ",-"
				+ "      " + "Rp " + totalharga + ",-");
		System.out.println("----------------------------------------------------------------");

		diskon = jumlah_barang / 3 * 5;
		totaldiskon = totalharga * diskon / 100;
		System.out.println("Diskon : " + diskon + "%");
		System.out.println("Sub Total : Rp " + totaldiskon + ",-");

	}
}