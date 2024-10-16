package praktikum2.soal1;

public class Soal1Main {
	public static void main(String[] args) {
        // Instansiasi objek-objek Buah
        Buah apel = new Buah("Apel", 7000, 0.4, 40);       // Apel 40kg
        Buah mangga = new Buah("Mangga", 3500, 0.2, 20);   // Mangga 20kg
        Buah alpukat = new Buah("Alpukat", 10000, 0.25, 16); // Alpukat 16kg

        // Memanggil method printInfo untuk setiap buah
        apel.printInfo();
        mangga.printInfo();
        alpukat.printInfo();
    }
}