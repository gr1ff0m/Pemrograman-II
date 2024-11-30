package soal1;

import java.util.Scanner;

public class Soal1Main{
    public static void main(String[] args) {
    	try (Scanner scanner = new Scanner(System.in)) {

        System.out.print("Nama Hewan Peliharaan: ");
        String nama = scanner.nextLine();

        System.out.print("Ras: ");
        String ras = scanner.nextLine();

        HewanPeliharaan hp = new HewanPeliharaan(nama, ras);
        hp.display();
    	}
    }
}