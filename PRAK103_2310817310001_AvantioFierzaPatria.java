package praktikum1;

import java.util.Scanner;
public class PRAK103_2310817310001_AvantioFierzaPatria {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Meminta input dari pengguna
        System.out.print("Masukkan jumlah N dan bilangan awal (dipisahkan dengan spasi): ");
        int N = scanner.nextInt();  // jumlah bilangan yang ingin ditampilkan
        int awal = scanner.nextInt();  // bilangan awal dari deret
        
        int count = 0;  // menghitung berapa banyak bilangan yang sudah ditampilkan
        int current = awal;  // bilangan yang akan diperiksa
        
        // Perulangan do-while untuk menampilkan deret bilangan
        do {
            if (current % 2 != 0) {  // jika bilangan ganjil
                System.out.print(current);
                count++;
                if (count < N) {
                    System.out.print(", ");
                }
            }
            current++;  // lanjutkan ke bilangan berikutnya
        } while (count < N);  // berhenti setelah N bilangan ganjil ditampilkan
        
        System.out.println();  // garis baru setelah deret selesai ditampilkan
        scanner.close();
    }
}
