package praktikum2.soal3;

public class Soal3Main {
    public static void main(String[] args) {
        Pegawai p1 = new Pegawai(); // Sudah benar
        // Pada baris ini terjadi error karena kurang tanda titik koma (;)
        // p1.nama = "Roi"
        p1.nama = "Roi"; // Tambahkan tanda titik koma (;)
        
        // Pada baris ini terjadi error karena tipe data asal seharusnya String, bukan char
        // public char asal; (ada di class pegawai)
        p1.asal = "Kingdom of Orvel"; // Sudah sesuai dengan tipe data String
               
        p1.setJabatan("Assasin"); // Berikan parameter string untuk jabatan
        
        System.out.println("Nama Pegawai: " + p1.getNama());

        // Pada baris ini terjadi error karena getAsal() mengembalikan String bukan char,
        // jadi tidak perlu mengubah tipe data lagi
        //  public char asal;
        System.out.println("Asal: " + p1.getAsal());
        
        System.out.println("Jabatan: " + p1.jabatan);
        
        // Pada output yang diinginkan, 'umur' diakhiri dengan "tahun". Jadi ditambahkan format yang sesuai.
        System.out.println("Umur: " + p1.umur + " tahun"); // Tambahkan "tahun" setelah umur
    }
}