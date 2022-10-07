import java.util.Scanner;

import javax.swing.JOptionPane;

public class Latihan10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int pin = 212310001;
        boolean is_valid = false;
        boolean opsi = false;
        int saldo = 0, setor, tarik;

        String label = "SELAMAT DATANG DI ATM \n";
        label += "Masukkan PIN : ";

        do {
            try {
                String validation = JOptionPane.showInputDialog(null, label, "ATM Kita",
                        JOptionPane.INFORMATION_MESSAGE);
                if (validation == null) {
                    int confirm = JOptionPane.showConfirmDialog(null, "Apakah anda ingin keluar?", "Keluar",
                            JOptionPane.YES_NO_OPTION);
                    if (confirm == 0) {
                        JOptionPane.showMessageDialog(null, "Terima Kasih!", "Keluar", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    } else {
                        continue;
                    }
                } else if (validation.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Mohon Masukkan PIN Anda", "Alert!",
                            JOptionPane.ERROR_MESSAGE);
                    continue;
                }

                int conValidation = Integer.parseInt(validation);

                if (conValidation == pin) {
                    is_valid = true;
                } else {
                    is_valid = false;
                    JOptionPane.showMessageDialog(null, "Maaf PIN Salah", "Alert!", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Harap Masukkan Numerik Karakter", "Alert!",
                        JOptionPane.ERROR_MESSAGE);
            }
        } while (is_valid == false);

        JOptionPane.showMessageDialog(null, "PIN Benar", "Pin Benar", JOptionPane.INFORMATION_MESSAGE);

        do {
            try {
                String menu_label = "Menu : \n";
                menu_label += "1. Lihat Saldo\n";
                menu_label += "2. Setor Tunai\n";
                menu_label += "3. Tarik Tunai\n";
                menu_label += "4. Keluar\n\n";
                menu_label += "Pilih menu: ";

                String menu = JOptionPane.showInputDialog(null, menu_label, "ATM Kita",
                        JOptionPane.INFORMATION_MESSAGE);

                if (menu == null) {
                    int confirm = JOptionPane.showConfirmDialog(null, "Apakah anda ingin keluar?", "Keluar",
                            JOptionPane.YES_NO_OPTION);
                    if (confirm == 0) {
                        JOptionPane.showMessageDialog(null, "Terima Kasih!", "Keluar", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    } else {
                        continue;
                    }
                } else if (menu.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Mohon Masukkan Kode Menu", "Alert!",
                            JOptionPane.ERROR_MESSAGE);
                    continue;
                }

                int conMenu = Integer.parseInt(menu);

                switch (conMenu) {
                    case 1:
                        JOptionPane.showMessageDialog(null, "Saldo Anda : " + saldo, "Saldo",
                                JOptionPane.INFORMATION_MESSAGE);
                        break;

                    case 2:
                        String inputSetor = JOptionPane.showInputDialog(null, "Masukkan Jumlah Setor Tunai : ",
                                "Setor Tunai", JOptionPane.INFORMATION_MESSAGE);
                        setor = Integer.parseInt(inputSetor);
                        saldo = saldo + setor;
                        JOptionPane.showMessageDialog(null, "Saldo Anda : " + saldo, "Saldo",
                                JOptionPane.INFORMATION_MESSAGE);
                        break;

                    case 3:
                        tarik = Integer.parseInt(JOptionPane.showInputDialog(null, "Masukkan Jumlah Tarik Tunai : ",
                                "Tarik Tunai", JOptionPane.INFORMATION_MESSAGE));

                        if (tarik > saldo) {
                            JOptionPane.showMessageDialog(null, "Maaf saldo tidak cukup!", "Tarik Tunai",
                                    JOptionPane.ERROR_MESSAGE);
                        } else {
                            saldo = saldo - tarik;
                            JOptionPane.showMessageDialog(null, "Silahkan Ambil Uang Anda!\nSaldo akhir : " + saldo,
                                    "Tarik Tunai",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;

                    case 4:
                        int choose = JOptionPane.showConfirmDialog(null, "Apakah Anda Ingin Keluar? ", "Keluar",
                                JOptionPane.YES_NO_OPTION);

                        if (choose == 0) {
                            opsi = true;
                            JOptionPane.showMessageDialog(null, "Terima Kasih!", "ATM Kita",
                                    JOptionPane.INFORMATION_MESSAGE);
                        } else if (choose == 1) {
                            opsi = false;
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Maaf Menu Tidak Tersedia", "Alert!",
                                JOptionPane.ERROR_MESSAGE);
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Maaf Menu Tidak Tersedia", "Alert!",
                        JOptionPane.ERROR_MESSAGE);
            }
        } while (opsi == false);

        input.close();
    }
}