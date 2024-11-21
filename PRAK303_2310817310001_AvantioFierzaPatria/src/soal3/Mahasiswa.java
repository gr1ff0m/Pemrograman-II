package soal3;


class Mahasiswa {
    // Atribut private untuk enkapsulasi
    private String nama;
    private String nim;

    // Konstruktor
    public Mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    // Getter untuk nama
    public String getNama() {
        return nama;
    }

    // Getter untuk NIM
    public String getNim() {
        return nim;
    }
}