package soal1;

import java.util.Random;

//Kelas Dadu dengan implementasi enkapsulasi
class Dadu {
 private int nilai; // Atribut private untuk menyimpan nilai dadu

 // Constructor untuk mengatur nilai dadu
 public Dadu() {
     this.nilai = generateRandomValue();
 }

 // Method private untuk menghasilkan nilai acak
 private int generateRandomValue() {
     return new Random().nextInt(6) + 1;
 }

 // Method getter untuk mengakses nilai dadu
 public int getNilai() {
     return nilai;
 }
}