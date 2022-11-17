import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Latihan02 {
	public static void main(String[] args) {
		JOptionPane jop = new JOptionPane();
		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> C = new ArrayList<ArrayList<Integer>>();

		String output = "";
		output += "Matrix A : \n";
		for (int i = 0; i < 2; i++) {
			A.add(new ArrayList<Integer>());
			for (int j = 0; j < 2; j++) {
				String value = jop.showInputDialog(null, "Masukkan angka :", "Matrix A [" + i + "][" + j + "]",
						jop.QUESTION_MESSAGE);
				A.get(i).add(j, Integer.parseInt(value));
				output += A.get(i).get(j) + " ";
			}
			output += "\n";
		}
		output += "Matrix B : \n";

		for (int i = 0; i < 2; i++) {
			B.add(new ArrayList<Integer>());
			for (int j = 0; j < 2; j++) {
				String value = jop.showInputDialog(null, "Masukkan angka :", "Matrix B [" + i + "][" + j + "]",
						jop.QUESTION_MESSAGE);
				B.get(i).add(j, Integer.parseInt(value));
				output += B.get(i).get(j) + " ";
			}
			output += "\n";
		}

		for (int i = 0; i < 2; i++) {
			C.add(new ArrayList<Integer>());
			for (int j = 0; j < 2; j++) {
				int c = A.get(i).get(j) * B.get(i).get(j);
				C.get(i).add(j, c);
			}
		}

		output += "Perkalian Matrix A dengan Matrix B : \n";
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				output += C.get(i).get(j) + " ";
			}
			output += "\n";
		}

		jop.showMessageDialog(null, output);
	}
}
