package soal2;

import java.util.*;

public class Soal2Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Negara> negaraList = new LinkedList<>();
        HashMap<Integer, String> bulanMap = new HashMap<>();

        // Inisialisasi bulan dalam HashMap
        String[] bulan = {
            "Januari", "Februari", "Maret", "April", "Mei", "Juni",
            "Juli", "Agustus", "September", "Oktober", "November", "Desember"
        };
        for (int i = 1; i <= bulan.length; i++) {
            bulanMap.put(i, bulan[i - 1]);
        }

        // Input jumlah negara
        System.out.print("Masukkan jumlah negara: ");
        int jumlahNegara = Integer.parseInt(scanner.nextLine());

        // Input data negara
        for (int i = 0; i < jumlahNegara; i++) {
            System.out.print("Masukkan nama negara: ");
            String nama = scanner.nextLine();

            System.out.print("Masukkan jenis kepemimpinan: ");
            String jenisKepemimpinan = scanner.nextLine();

            System.out.print("Masukkan nama pemimpin: ");
            String namaPemimpin = scanner.nextLine();

            if (jenisKepemimpinan.equalsIgnoreCase("monarki")) {
                // Jika monarki, tidak perlu tanggal kemerdekaan
                negaraList.add(new Negara(nama, jenisKepemimpinan, namaPemimpin));
            } else {
                // Input tanggal, bulan, dan tahun kemerdekaan
                System.out.print("Masukkan tanggal kemerdekaan: ");
                int tanggal = Integer.parseInt(scanner.nextLine());

                int bulanKemerdekaan;
                do {
                    System.out.print("Masukkan bulan kemerdekaan (angka): ");
                    bulanKemerdekaan = Integer.parseInt(scanner.nextLine());
                } while (bulanKemerdekaan < 1 || bulanKemerdekaan > 12);

                System.out.print("Masukkan tahun kemerdekaan: ");
                int tahun = Integer.parseInt(scanner.nextLine());

                negaraList.add(new Negara(nama, jenisKepemimpinan, namaPemimpin, tanggal, bulanKemerdekaan, tahun));
            }
        }

        // Output detail negara
        System.out.println("\nDetail Negara:");
        for (Negara negara : negaraList) {
            System.out.println(negara.getDetail(bulanMap));
        }

        scanner.close();
    }
}