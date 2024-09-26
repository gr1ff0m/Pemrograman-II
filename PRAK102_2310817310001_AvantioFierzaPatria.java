package praktikum1;

import java.util.Scanner;
public class PRAK102_2310817310001_AvantioFierzaPatria {
	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		
	        // Meminta input angka awal dari pengguna
	        System.out.print("Masukkan angka awal: ");
	        int angkaAwal = scanner.nextInt();
	        
	        // Inisialisasi counter dengan angka awal
	        int counter = angkaAwal;
	        int jumlahBaris = 1;  // Penghitung jumlah angka yang sudah ditampilkan

	        // Perulangan untuk menampilkan 11 angka
	        while (jumlahBaris <= 11) {
	            int bilangan;

	            // Cek jika angka awal adalah kelipatan 5
	            if (counter % 5 == 0) {
	                bilangan = (counter / 5) - 1; // Jika kelipatan 5
	            } else {
	                bilangan = counter; // Jika bukan kelipatan 5
	            }

	            // Tampilkan bilangan
	            if (jumlahBaris == 11) {
	                System.out.print(bilangan); // Tidak ada koma di akhir baris terakhir
	            } else {
	                System.out.print(bilangan + ", ");
	            }

	            // Tambahkan counter untuk iterasi berikutnya
	            counter++; // Penambahan counter dimulai setelah iterasi pertama
	            jumlahBaris++; // Menambah jumlah angka yang sudah ditampilkan
	        }

	        System.out.println(); // Pindah ke baris baru setelah deret selesai
	        scanner.close(); // Tutup scanner
	    }
	}