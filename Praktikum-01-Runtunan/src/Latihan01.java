import java.util.Scanner;

public class Latihan01 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Masukkan suhu celcius = ");
		int celcius = input.nextInt();
		
		
		int fahrenheit = convertToFahrenheit(celcius);
		int rheamur = convertToRheamur(celcius);
		int kelvin = convertToKelvin(celcius);

		System.out.println("Hasil konversi :");
		System.out.println("Celcius To Fahrenheit = " + fahrenheit + " F");
		System.out.println("Celcius To Reamur = " + rheamur + " R");
		System.out.println("Celcius To Kelvin = " + kelvin + " K");
		input.close();
	}

	static int convertToFahrenheit(int suhu) {
		int fahrenheit = ((9 / 5) * suhu) + 32;
		return fahrenheit;
	}

	static int convertToRheamur(int suhu) {
		int rheamur = suhu * 4 / 5;
		return rheamur;
	}

	static int convertToKelvin(int suhu) {
		int kelvin = suhu + 273;
		return kelvin;
	}
}