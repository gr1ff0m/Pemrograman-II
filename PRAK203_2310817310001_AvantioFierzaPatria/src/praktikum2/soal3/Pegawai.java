package praktikum2.soal3;

// Pada baris ini terjadi error karena nama class adalah 'Employee' namun di kode utama 
// menggunakan 'Pegawai'. Harus konsisten antara nama class di file dan penggunaannya di file lain.
// public class Employee {
public class Pegawai { // Perbaiki nama class menjadi Pegawai
    public String nama;
	// Error: Tipe data asal seharusnya String, bukan char, untuk sesuai dengan contoh "Kingdom of Orvel"
	// public char asal;
    public String asal; 
    public String jabatan;
    public int umur;
    
    public Pegawai() {
        // Pada output contoh diberikan umur 17 tahun, jadi di set umur secara default
        this.umur = 17;
    }

    public String getNama() {
        return nama;
    }

    public String getAsal() {
        return asal;
    }

    // Pada baris ini terjadi error karena parameter j belum didefinisikan di method ini
    // Harus ada parameter untuk menerima jabatan
	//  public void setJabatan() (Tanpa parameter)
    public void setJabatan(String j) { // Tambahkan parameter String j untuk menerima jabatan
        this.jabatan = j;
    }
}