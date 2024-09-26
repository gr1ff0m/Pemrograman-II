package praktikum1;

import java.util.Scanner;
public class PRAK105_2310817310001_AvantioFierzaPatria {
	// Konstanta nilai phi (π)
	  public static final double PHI = 3.14;

    public static void main(String[] args) {
    	 // Menampilkan judul program
        System.out.println("Program Menghitung Volume Tabung");
        System.out.println("---------------------------------");
        
        // Membuat Scanner untuk input dari pengguna
        Scanner input = new Scanner(System.in);

        // Meminta pengguna untuk memasukkan jari-jari
        System.out.print("Masukkan jari-jari (cm): ");
        double jariJari = input.nextDouble();

        // Meminta pengguna untuk memasukkan tinggi
        System.out.print("Masukkan tinggi (cm): ");
        double tinggi = input.nextDouble();

        // Menghitung volume tabung
        double volume = PHI * Math.pow(jariJari, 2) * tinggi;

        // Menampilkan hasil perhitungan
        System.out.printf("Volume tabung dengan jari-jari %.1f cm dan tinggi %.1f cm adalah %.3f m3\n", jariJari, tinggi, volume);
        
        // Menutup scanner
        input.close();
    }
}