package praktikum2.soal1;

public class Buah {
    private String namaBuah;
    private double hargaPerUnit;  // Harga per unit (sesuai dengan berat unit)
    private double beratUnit;     // Berat per unit dalam kg
    private double beratBeli;     // Berat total yang dibeli dalam kg

    // Constructor
    public Buah(String namaBuah, double hargaPerUnit, double beratUnit, double beratBeli) {
        this.namaBuah = namaBuah;
        this.hargaPerUnit = hargaPerUnit;
        this.beratUnit = beratUnit;
        this.beratBeli = beratBeli;
    }

    // Method untuk menghitung harga sebelum diskon
    public double hitungHargaSebelumDiskon() {
        return (beratBeli / beratUnit) * hargaPerUnit;
    }

    // Method untuk menghitung total diskon
    public double hitungDiskon() {
        double diskon = 0.02 * (beratBeli / 4); // Diskon 2% per 4kg
        return hitungHargaSebelumDiskon() * diskon;
    }

    // Method untuk menghitung harga setelah diskon
    public double hitungHargaSetelahDiskon() {
        return hitungHargaSebelumDiskon() - hitungDiskon();
    }

    // Method untuk mencetak detail informasi buah
    public void printInfo() {
        System.out.println("Nama Buah: " + namaBuah);
        System.out.println("Berat: " + beratUnit + "kg");
        System.out.println("Harga: Rp" + hargaPerUnit);
        System.out.println("Jumlah Beli: " + beratBeli + "kg");
        System.out.printf("Harga Sebelum Diskon: Rp%.2f%n", hitungHargaSebelumDiskon());
        System.out.printf("Total Diskon: Rp%.2f%n", hitungDiskon());
        System.out.printf("Harga Setelah Diskon: Rp%.2f%n", hitungHargaSetelahDiskon());
        System.out.println();
    }
}
