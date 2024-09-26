package praktikum1;

//Impor Scanner dari java.util
import java.util.Scanner;

public class PRAK101_2310817310001_AvantioFierzaPatria {

 public static void main(String[] args) {
     Scanner input = new Scanner(System.in);

     // Meminta input dari pengguna
     System.out.print("Masukkan Nama Lengkap: ");
     String namaLengkap = input.nextLine();

     System.out.print("Masukkan Tempat Lahir: ");
     String tempatLahir = input.nextLine();

     System.out.print("Masukkan Tanggal Lahir: ");
     int tanggalLahir = input.nextInt();

     // Untuk menangani karakter newline setelah input int
     input.nextLine();

     int bulanLahir;
     while (true) {
         System.out.print("Masukkan Bulan Lahir (1-12): ");
         bulanLahir = input.nextInt();
         if (bulanLahir >= 1 && bulanLahir <= 12) {
             break;
         } else {
             System.out.println("Bulan harus antara 1 hingga 12. Silakan coba lagi.");
         }
     }

     System.out.print("Masukkan Tahun Lahir: ");
     int tahunLahir = input.nextInt();

     // Untuk menangani karakter newline setelah input int
     input.nextLine();

     System.out.print("Masukkan Tinggi Badan (cm): ");
     double tinggiBadan = input.nextDouble();

     System.out.print("Masukkan Berat Badan (kg): ");
     double beratBadan = input.nextDouble();

     // Menampilkan output
     System.out.println("\nNama Lengkap " + namaLengkap + ", Lahir di " + tempatLahir + " pada Tanggal " + tanggalLahir + " " + getBulan(bulanLahir) + " " + tahunLahir);
     System.out.println("Tinggi Badan " + tinggiBadan + " cm dan Berat Badan " + beratBadan + " kilogram");

     // Tutup scanner untuk menghindari kebocoran resource
     input.close();
 }

 // Fungsi untuk mendapatkan nama bulan berdasarkan angka
 public static String getBulan(int bulan) {
     String[] namaBulan = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
     return namaBulan[bulan - 1];
 }
}
