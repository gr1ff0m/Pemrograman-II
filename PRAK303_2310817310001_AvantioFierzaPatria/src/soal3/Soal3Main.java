package soal3;

import java.util.ArrayList;
import java.util.Scanner;

public class Soal3Main {
    public static void main(String[] args) {
        // List untuk menyimpan objek Mahasiswa
        ArrayList<Mahasiswa> listMahasiswa = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        while (true) {
            // Menampilkan menu
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa berdasarkan NIM");
            System.out.println("3. Cari Mahasiswa berdasarkan NIM");
            System.out.println("4. Tampilkan Daftar Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            int pilihan = input.nextInt();
            input.nextLine(); // Membersihkan buffer

            switch (pilihan) {
                case 1:
                    // Tambah Mahasiswa
                    System.out.print("Masukkan Nama Mahasiswa: ");
                    String nama = input.nextLine();
                    System.out.print("Masukkan NIM Mahasiswa (harus unik): ");
                    String nim = input.nextLine();

                    // Periksa apakah NIM sudah ada
                    boolean nimExists = listMahasiswa.stream().anyMatch(m -> m.getNim().equals(nim));

                    if (nimExists) {
                        System.out.println("Gagal: NIM " + nim + " sudah terdaftar.");
                    } else {
                        listMahasiswa.add(new Mahasiswa(nama, nim));
                        System.out.println("Mahasiswa " + nama + " berhasil ditambahkan.");
                    }
                    break;

                case 2:
                    // Hapus Mahasiswa
                    System.out.print("Masukkan NIM Mahasiswa yang ingin dihapus: ");
                    String nimHapus = input.nextLine();
                    boolean ditemukan = false;

                    for (int i = 0; i < listMahasiswa.size(); i++) {
                        if (listMahasiswa.get(i).getNim().equals(nimHapus)) {
                            listMahasiswa.remove(i);
                            System.out.println("Mahasiswa dengan NIM " + nimHapus + " telah dihapus.");
                            ditemukan = true;
                            break;
                        }
                    }

                    if (!ditemukan) {
                        System.out.println("Mahasiswa dengan NIM " + nimHapus + " tidak ditemukan.");
                    }
                    break;

                case 3:
                    // Cari Mahasiswa
                    System.out.print("Masukkan NIM Mahasiswa yang ingin dicari: ");
                    String nimCari = input.nextLine();
                    Mahasiswa hasilCari = null;

                    for (Mahasiswa m : listMahasiswa) {
                        if (m.getNim().equals(nimCari)) {
                            hasilCari = m;
                            break;
                        }
                    }

                    if (hasilCari != null) {
                        System.out.println("Mahasiswa ditemukan: ");
                        System.out.println("NIM: " + hasilCari.getNim() + ", Nama: " + hasilCari.getNama());
                    } else {
                        System.out.println("Mahasiswa dengan NIM " + nimCari + " tidak ditemukan.");
                    }
                    break;

                case 4:
                    // Tampilkan seluruh daftar Mahasiswa
                    if (listMahasiswa.isEmpty()) {
                        System.out.println("Daftar Mahasiswa kosong.");
                    } else {
                        System.out.println("Daftar Mahasiswa:");
                        for (Mahasiswa m : listMahasiswa) {
                            System.out.println("NIM: " + m.getNim() + ", Nama: " + m.getNama());
                        }
                    }
                    break;

                case 0:
                    // Keluar
                    System.out.println("Terima kasih!");
                    listMahasiswa.clear();
                    input.close();
                    return;

                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }
        }
    }
}