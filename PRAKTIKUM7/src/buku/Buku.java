package buku;

public class Buku {
    private int bukuId;
    private String judul;
    private String penulis;
    private double harga;
    private int stok;

    // Constructor
    public Buku(int bukuId, String judul, String penulis, double harga, int stok) {
        this.bukuId = bukuId;
        this.judul = judul;
        this.penulis = penulis;
        this.harga = harga;
        this.stok = stok;
    }

    // Getters and Setters
    public int getBukuId() {
        return bukuId;
    }

    public void setBukuId(int bukuId) {
        this.bukuId = bukuId;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    // toString untuk debugging dan logging
    @Override
    public String toString() {
        return "Buku{" +
                "bukuId=" + bukuId +
                ", judul='" + judul + '\'' +
                ", penulis='" + penulis + '\'' +
                ", harga=" + harga +
                ", stok=" + stok +
                '}';
    }
}