package soal2;

public class HewanPeliharaan {
    private String nama;
    private String ras;

    public HewanPeliharaan(String nama, String ras) {
        this.nama = nama;
        this.ras = ras;
    }

    public void display() {
        System.out.println("Detail Hewan Peliharaan:");
        System.out.println("Nama hewan peliharaanku adalah : " + this.nama);
        System.out.println("Dengan ras : " + this.ras);
    }
}

class Kucing extends HewanPeliharaan {
    private String warnaBulu;

    public Kucing(String nama, String ras, String warnaBulu) {
        super(nama, ras);
        this.warnaBulu = warnaBulu;
    }

    public void displayDetailKucing() {
        super.display();
        System.out.println("Memiliki warna bulu : " + this.warnaBulu);
    }
}

class Anjing extends HewanPeliharaan {
    private String kemampuan;

    public Anjing(String nama, String ras, String warnaBulu, String kemampuan) {
        super(nama, ras);
        this.kemampuan = kemampuan;
    }

    public void displayDetailAnjing() {
        super.display();
        System.out.println("Memiliki kemampuan : " + this.kemampuan);
    }
}