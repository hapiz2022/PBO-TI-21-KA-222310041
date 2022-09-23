import java.util.Scanner;

class Student {
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
		System.out.println("Fullname :");
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

public class Latihan09 {
	public static void main(String[] args) {
		Students get = new Students();
		get.getNPM();
		get.getFullname();
		get.getClassName();
		get.getSemester();
		get.getGPA();

	}
}
