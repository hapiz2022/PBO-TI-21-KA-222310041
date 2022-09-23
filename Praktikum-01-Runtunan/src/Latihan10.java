import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

class Students {
	static int NPM;
	String Fullname;
	String ClassName;
	int Semester;
	Double GPA;

	public static int getNPM() {
		Scanner input = new Scanner(System.in);
		System.out.print("NPM :");
		NPM = input.nextInt();
		return NPM;
	}

	public String getFullname() {
		Scanner input = new Scanner(System.in);
		System.out.println("Masukkan Member name :");
		Fullname = input.nextLine();
		return Fullname;
	}

	public String getClassName() {
		Scanner input = new Scanner(System.in);
		System.out.print("ClassName :");
		ClassName = input.nextLine();
		return ClassName;
	}

	public int getSemester() {
		Scanner input = new Scanner(System.in);
		System.out.print("Semester :");
		Semester = input.nextInt();
		return Semester;
	}

	public Double getGPA() {
		Scanner input = new Scanner(System.in);
		System.out.print("GPA :");
		GPA = input.nextDouble();
		return GPA;
	}
}

public class Latihan10 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Students get = new Students();
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy (HH:mm)");
		String nama_barang = "ROTI ENAK";
		int jumlah_barang, totalharga, diskon, totaldiskon;
		int harga = 6300;
		String member = get.getFullname();
		
		
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
		System.out.println(member);
		System.out.println("Member Name: " + member);
	}
}
