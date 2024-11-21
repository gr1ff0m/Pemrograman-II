package soal2;

import java.util.*;

class Negara {
    private String nama;
    private String jenisKepemimpinan;
    private String namaPemimpin;
    private int tanggalKemerdekaan;
    private int bulanKemerdekaan;
    private int tahunKemerdekaan;

    // Constructor untuk monarki (tanpa tanggal kemerdekaan)
    public Negara(String nama, String jenisKepemimpinan, String namaPemimpin) {
        this.nama = nama;
        this.jenisKepemimpinan = jenisKepemimpinan;
        this.namaPemimpin = namaPemimpin;
        this.tanggalKemerdekaan = 0; // 0 menunjukkan tidak ada tanggal
        this.bulanKemerdekaan = 0;
        this.tahunKemerdekaan = 0;
    }

    // Constructor untuk republik atau sistem lainnya (dengan tanggal kemerdekaan)
    public Negara(String nama, String jenisKepemimpinan, String namaPemimpin, int tanggalKemerdekaan, int bulanKemerdekaan, int tahunKemerdekaan) {
        this.nama = nama;
        this.jenisKepemimpinan = jenisKepemimpinan;
        this.namaPemimpin = namaPemimpin;
        this.tanggalKemerdekaan = tanggalKemerdekaan;
        this.bulanKemerdekaan = bulanKemerdekaan;
        this.tahunKemerdekaan = tahunKemerdekaan;
    }

    // Metode untuk menentukan format jenis kepemimpinan
    private String getJenisKepemimpinanFormatted() {
        switch (jenisKepemimpinan.toLowerCase()) {
            case "monarki":
                return "Raja";
            case "presiden":
                return "Presiden";
            case "perdana menteri":
                return "Perdana Menteri";
            default:
                return "Pemimpin";
        }
    }

    // Metode untuk mendapatkan detail negara
    public String getDetail(HashMap<Integer, String> bulanMap) {
        StringBuilder detail = new StringBuilder();
        detail.append("Negara ").append(nama).append(" mempunyai ")
              .append(getJenisKepemimpinanFormatted()).append(" bernama ")
              .append(namaPemimpin).append("\n");

        if (tanggalKemerdekaan > 0 && bulanKemerdekaan > 0 && tahunKemerdekaan > 0) {
            detail.append("Deklarasi Kemerdekaan pada Tanggal ")
                  .append(tanggalKemerdekaan).append(" ")
                  .append(bulanMap.get(bulanKemerdekaan)).append(" ")
                  .append(tahunKemerdekaan).append("\n");
        }

        return detail.toString();
    }
}
