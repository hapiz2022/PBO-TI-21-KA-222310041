

import java.util.Scanner;

public class Latihan07 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String text;
		
		System.out.print("Masukkan Nama Lengkap Anda :");
		text = input.nextLine();
		text = text.replaceAll("[a,i,u,e,o]", "X");
        
        System.out.println(text);
		
	}
}
