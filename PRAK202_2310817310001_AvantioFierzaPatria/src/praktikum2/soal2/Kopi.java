package praktikum2.soal2;

public class Kopi {
    String namaKopi;
    String ukuran;
    double harga;
    private String pembeli; // untuk menyimpan pembeli kopi

    // Method untuk menampilkan informasi tentang kopi
    public void info() {
        System.out.println("Nama Kopi: " + namaKopi);
        System.out.println("Ukuran: " + ukuran);
        System.out.println("Harga: Rp. " + harga);
    }

    // Setter untuk menetapkan pembeli
    public void setPembeli(String pembeli) {
        this.pembeli = pembeli;
    }

    // Getter untuk mendapatkan pembeli
    public String getPembeli() {
        return pembeli;
    }

    // Method untuk menghitung pajak (11% dari harga)
    public double getPajak() {
        return harga * 0.11;
    }
}