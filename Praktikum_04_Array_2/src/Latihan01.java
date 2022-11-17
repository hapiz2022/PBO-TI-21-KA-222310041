import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Arrays;


public class Latihan01 {
	public static void main(String[] args) {
		JOptionPane jop = new JOptionPane();
		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();

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
		jop.showMessageDialog(null, output);

	}
}
