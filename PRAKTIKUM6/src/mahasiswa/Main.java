package mahasiswa;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        // Membuat list untuk menampung data Mahasiswa
        ArrayList<Mahasiswa> listMahasiswa = new ArrayList<>();

        // Menambahkan data mahasiswa
        listMahasiswa.add(new Mahasiswa("220101", "Asep Suherman"));
        listMahasiswa.add(new Mahasiswa("220102", "Budi Santoso"));
        listMahasiswa.add(new Mahasiswa("220103", "Citra Dewi"));
        listMahasiswa.add(new Mahasiswa("220104", "Dian Saputra"));
        listMahasiswa.add(new Mahasiswa("220105", "Eka Putri"));
        listMahasiswa.add(new Mahasiswa("220106", "Faisal Rahman"));
        listMahasiswa.add(new Mahasiswa("220107", "Gina Marlina"));
        listMahasiswa.add(new Mahasiswa("220108", "Hendra Wijaya"));
        listMahasiswa.add(new Mahasiswa("220109", "Intan Permata"));
        listMahasiswa.add(new Mahasiswa("220110", "Joko Widodo"));
        
        // Membuat frame untuk tampilan GUI
        JFrame frame = new JFrame("Data Mahasiswa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Menyiapkan kolom dan data untuk tabel
        String[] columnNames = {"NIM", "Nama"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        // Mengisi data ke dalam tabel
        for (Mahasiswa mhs : listMahasiswa) {
            Object[] rowData = {mhs.getNim(), mhs.getNama()};
            tableModel.addRow(rowData);
        }

        // Membuat JTable dan mengatur model tabel
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Menambahkan tabel ke frame
        frame.add(scrollPane, BorderLayout.CENTER);

        // Menampilkan frame
        frame.setVisible(true);
    }
}