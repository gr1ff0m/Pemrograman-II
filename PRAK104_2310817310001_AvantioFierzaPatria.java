package praktikum1;

import java.util.Scanner;
public class PRAK104_2310817310001_AvantioFierzaPatria {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input tangan Abu dan Bagas
        System.out.print("Tangan Abu: ");
        String[] tanganAbu = scanner.nextLine().split(" ");
        System.out.print("Tangan Bagas: ");
        String[] tanganBagas = scanner.nextLine().split(" ");

        // Inisialisasi poin
        int poinAbu = 0, poinBagas = 0;

        // Evaluasi setiap ronde
        for (int i = 0; i < 3; i++) {
            String abu = tanganAbu[i], bagas = tanganBagas[i];

            if (!abu.equals(bagas)) {
                // Abu menang jika mengikuti aturan permainan
                if ((abu.equals("B") && bagas.equals("G")) || 
                    (abu.equals("G") && bagas.equals("K")) || 
                    (abu.equals("K") && bagas.equals("B"))) {
                    poinAbu++;
                } else {
                    poinBagas++;
                }
            }
        }

        // Output hasil akhir
        System.out.println(poinAbu > poinBagas ? "Abu" : poinBagas > poinAbu ? "Bagas" : "Seri");

        scanner.close();
    }
}