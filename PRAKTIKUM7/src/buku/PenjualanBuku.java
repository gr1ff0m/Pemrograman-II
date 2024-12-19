package buku;

import java.time.LocalDate;

public class PenjualanBuku {
    private int penjualanId;
    private int jumlah;
    private double totalHarga;
    private LocalDate tanggal; // Menggunakan LocalDate untuk representasi tanggal modern di Java
    private int pelangganId;
    private int bukuId;

    public PenjualanBuku(int penjualanId, int jumlah, double totalHarga, LocalDate tanggal, int pelangganId, int bukuId) {
        this.penjualanId = penjualanId;
        this.jumlah = jumlah;
        this.totalHarga = totalHarga;
        this.tanggal = tanggal;
        this.pelangganId = pelangganId;
        this.bukuId = bukuId;
    }

    // Getters and Setters
    public int getPenjualanId() {
        return penjualanId;
    }

    public void setPenjualanId(int penjualanId) {
        this.penjualanId = penjualanId;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
    }

    public int getPelangganId() {
        return pelangganId;
    }

    public void setPelangganId(int pelangganId) {
        this.pelangganId = pelangganId;
    }

    public int getBukuId() {
        return bukuId;
    }

    public void setBukuId(int bukuId) {
        this.bukuId = bukuId;
    }

    @Override
    public String toString() {
        return "PenjualanBuku{" +
                "penjualanId=" + penjualanId +
                ", jumlah=" + jumlah +
                ", totalHarga=" + totalHarga +
                ", tanggal=" + tanggal +
                ", pelangganId=" + pelangganId +
                ", bukuId=" + bukuId +
                '}';
    }
}
