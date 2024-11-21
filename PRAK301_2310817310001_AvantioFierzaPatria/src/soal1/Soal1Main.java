package soal1;

import java.util.LinkedList;
import java.util.Scanner;

public class Soal1Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Meminta input jumlah dadu dari pengguna
        System.out.print("Masukkan jumlah dadu: ");
        int jumlahDadu = scanner.nextInt();

        // Menggunakan LinkedList untuk menyimpan objek Dadu
        LinkedList<Dadu> daftarDadu = new LinkedList<>();

        // Menambahkan objek Dadu ke dalam daftar
        for (int i = 1; i <= jumlahDadu; i++) {
            daftarDadu.add(new Dadu());
        }

        // Menampilkan nilai tiap dadu dan menghitung total
        int totalNilai = 0;
        int index = 1;
        for (Dadu dadu : daftarDadu) {
            int nilai = dadu.getNilai();
            System.out.println("Dadu ke-" + index + " bernilai " + nilai);
            totalNilai += nilai;
            index++;
        }

        // Menampilkan total nilai dari semua dadu
        System.out.println("Total nilai dadu keseluruhan " + totalNilai);

        // Menutup scanner
        scanner.close();
    }
}
