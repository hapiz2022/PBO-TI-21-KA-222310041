import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Latihan04 {
	public static void main(String[] args) {
		String field[] = { "Nama Lengkap", "Alamat", "No Telp" };
		String jml_arr = JOptionPane.showInputDialog(null, "Masukkan Jumlah Data : ");
		int n = Integer.parseInt(jml_arr);
		ArrayList<ArrayList<String>> x = new ArrayList<ArrayList<String>>();

		for (int i = 0; i < n; i++) {
			x.add(new ArrayList<String>());
			for (int j = 0; j < field.length; j++) {
				String data = JOptionPane.showInputDialog(null, "Masukan " + field[j] + ":",
						"Data array ke - " + (i + 1), JOptionPane.QUESTION_MESSAGE);
				x.get(i).add(j, data);
			}
		}

		String output = "";

		for (int i = 0; i < n; i++) {
			output += "Data ke - " + (i + 1) + "\n";
			for (int j = 0; j < field.length; j++) {
				output += field[j] + ": " + x.get(i).get(j) + "\n";
			}
			output += "\n";
		}

		JOptionPane.showMessageDialog(null, output, "Data", JOptionPane.INFORMATION_MESSAGE);
	}
}