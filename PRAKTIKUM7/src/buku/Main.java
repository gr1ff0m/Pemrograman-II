package buku;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main extends Application {
    private final TableView<PelangganBuku> tablePelanggan = new TableView<>();
    private final TableView<Buku> tableBuku = new TableView<>();
    private final TableView<PenjualanBuku> tablePenjualan = new TableView<>();

    private final ObservableList<PelangganBuku> dataPelanggan = FXCollections.observableArrayList();
    private final ObservableList<Buku> dataBuku = FXCollections.observableArrayList();
    private final ObservableList<PenjualanBuku> dataPenjualan = FXCollections.observableArrayList();

    private final TextField pelangganNamaField = new TextField();
    private final TextField pelangganEmailField = new TextField();
    private final TextField pelangganTeleponField = new TextField();

    private final TextField bukuJudulField = new TextField();
    private final TextField bukuPenulisField = new TextField();
    private final TextField bukuHargaField = new TextField();

    private final TextField penjualanPelangganIdField = new TextField();
    private final TextField penjualanBukuIdField = new TextField();
    private final TextField penjualanJumlahField = new TextField();

    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();

        Tab pelangganTab = new Tab("Data Pelanggan", createPelangganLayout());
        pelangganTab.setClosable(false);

        Tab bukuTab = new Tab("Data Buku", createBukuLayout());
        bukuTab.setClosable(false);

        Tab penjualanTab = new Tab("Data Penjualan", createPenjualanLayout());
        penjualanTab.setClosable(false);

        tabPane.getTabs().addAll(pelangganTab, bukuTab, penjualanTab);

        Scene scene = new Scene(tabPane, 800, 600);
        primaryStage.setTitle("Manajemen Buku dan Penjualan");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createPelangganLayout() {
        TableColumn<PelangganBuku, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getPelangganId()));

        TableColumn<PelangganBuku, String> colNama = new TableColumn<>("Nama");
        colNama.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getNama()));

        TableColumn<PelangganBuku, String> colEmail = new TableColumn<>("Email");
        colEmail.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getEmail()));

        TableColumn<PelangganBuku, String> colTelepon = new TableColumn<>("Telepon");
        colTelepon.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getTelepon()));

        tablePelanggan.getColumns().addAll(colId, colNama, colEmail, colTelepon);
        tablePelanggan.setItems(dataPelanggan);

        loadDataPelanggan();

        pelangganNamaField.setPromptText("Nama");
        pelangganEmailField.setPromptText("Email");
        pelangganTeleponField.setPromptText("Telepon");

        Button addButton = new Button("Add");
        Button editButton = new Button("Edit");
        Button deleteButton = new Button("Delete");

        addButton.setOnAction(e -> addPelanggan());
        editButton.setOnAction(e -> editPelanggan());
        deleteButton.setOnAction(e -> deletePelanggan());

        HBox inputLayout = new HBox(10);
        inputLayout.setPadding(new Insets(10));
        inputLayout.getChildren().addAll(
            pelangganNamaField,
            pelangganEmailField,
            pelangganTeleponField,
            addButton,
            editButton,
            deleteButton
        );

        VBox layout = new VBox(10);
        layout.getChildren().addAll(inputLayout, tablePelanggan);
        return layout;
    }

    private VBox createBukuLayout() {
        TableColumn<Buku, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getBukuId()));

        TableColumn<Buku, String> colJudul = new TableColumn<>("Judul");
        colJudul.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getJudul()));

        TableColumn<Buku, String> colPenulis = new TableColumn<>("Penulis");
        colPenulis.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getPenulis()));

        TableColumn<Buku, Double> colHarga = new TableColumn<>("Harga");
        colHarga.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getHarga()));

        tableBuku.getColumns().addAll(colId, colJudul, colPenulis, colHarga);
        tableBuku.setItems(dataBuku);

        loadDataBuku();

        bukuJudulField.setPromptText("Judul");
        bukuPenulisField.setPromptText("Penulis");
        bukuHargaField.setPromptText("Harga");

        Button addButton = new Button("Add");
        Button editButton = new Button("Edit");
        Button deleteButton = new Button("Delete");

        addButton.setOnAction(e -> addBuku());
        editButton.setOnAction(e -> editBuku());
        deleteButton.setOnAction(e -> deleteBuku());

        HBox inputLayout = new HBox(10);
        inputLayout.setPadding(new Insets(10));
        inputLayout.getChildren().addAll(
            bukuJudulField,
            bukuPenulisField,
            bukuHargaField,
            addButton,
            editButton,
            deleteButton
        );

        VBox layout = new VBox(10);
        layout.getChildren().addAll(inputLayout, tableBuku);
        return layout;
    }

    private VBox createPenjualanLayout() {
        TableColumn<PenjualanBuku, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getPenjualanId()));

        TableColumn<PenjualanBuku, Integer> colPelangganId = new TableColumn<>("Pelanggan ID");
        colPelangganId.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getPelangganId()));

        TableColumn<PenjualanBuku, Integer> colBukuId = new TableColumn<>("Buku ID");
        colBukuId.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getBukuId()));

        TableColumn<PenjualanBuku, Integer> colJumlah = new TableColumn<>("Jumlah");
        colJumlah.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getJumlah()));

        tablePenjualan.getColumns().addAll(colId, colPelangganId, colBukuId, colJumlah);
        tablePenjualan.setItems(dataPenjualan);

        loadDataPenjualan();

        penjualanPelangganIdField.setPromptText("Pelanggan ID");
        penjualanBukuIdField.setPromptText("Buku ID");
        penjualanJumlahField.setPromptText("Jumlah");

        Button addButton = new Button("Add");
        Button deleteButton = new Button("Delete");

        addButton.setOnAction(e -> addPenjualan());
        deleteButton.setOnAction(e -> deletePenjualan());

        HBox inputLayout = new HBox(10);
        inputLayout.setPadding(new Insets(10));
        inputLayout.getChildren().addAll(
            penjualanPelangganIdField,
            penjualanBukuIdField,
            penjualanJumlahField,
            addButton,
            deleteButton
        );

        VBox layout = new VBox(10);
        layout.getChildren().addAll(inputLayout, tablePenjualan);
        return layout;
    }

    private void loadDataPelanggan() {
        dataPelanggan.clear();
        try (Connection conn = DatabaseBuku.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM pelanggan")) {

            while (rs.next()) {
                dataPelanggan.add(new PelangganBuku(
                    rs.getInt("pelanggan_id"),
                    rs.getString("nama"),
                    rs.getString("email"),
                    rs.getString("telepon")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
            showErrorAlert("Error loading customer data: " + e.getMessage());
        }
    }

    private void addPelanggan() {
        String nama = pelangganNamaField.getText();
        String email = pelangganEmailField.getText();
        String telepon = pelangganTeleponField.getText();

        if (nama.isEmpty() || email.isEmpty() || telepon.isEmpty()) {
            showErrorAlert("Semua field harus diisi!");
            return;
        }

        try (Connection conn = DatabaseBuku.connect();
             Statement stmt = conn.createStatement()) {
            String sql = String.format(
                "INSERT INTO pelanggan (nama, email, telepon) VALUES ('%s', '%s', '%s')",
                nama, email, telepon);
            stmt.executeUpdate(sql);
            loadDataPelanggan();
            pelangganNamaField.clear();
            pelangganEmailField.clear();
            pelangganTeleponField.clear();
        } catch (Exception e) {
            e.printStackTrace();
            showErrorAlert("Error adding customer: " + e.getMessage());
        }
    }

    private void editPelanggan() {
        PelangganBuku selected = tablePelanggan.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showErrorAlert("Pilih pelanggan yang ingin diedit!");
            return;
        }

        String nama = pelangganNamaField.getText();
        String email = pelangganEmailField.getText();
        String telepon = pelangganTeleponField.getText();

        if (nama.isEmpty() || email.isEmpty() || telepon.isEmpty()) {
            showErrorAlert("Semua field harus diisi!");
            return;
        }

        try (Connection conn = DatabaseBuku.connect();
             Statement stmt = conn.createStatement()) {
            String sql = String.format(
                "UPDATE pelanggan SET nama = '%s', email = '%s', telepon = '%s' WHERE pelanggan_id = %d",
                nama, email, telepon, selected.getPelangganId());
            stmt.executeUpdate(sql);
            loadDataPelanggan();
            pelangganNamaField.clear();
            pelangganEmailField.clear();
            pelangganTeleponField.clear();
        } catch (Exception e) {
            e.printStackTrace();
            showErrorAlert("Error editing customer: " + e.getMessage());
        }
    }

    private void deletePelanggan() {
        PelangganBuku selected = tablePelanggan.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showErrorAlert("Pilih pelanggan yang ingin dihapus!");
            return;
        }

        try (Connection conn = DatabaseBuku.connect();
             Statement stmt = conn.createStatement()) {
            String sql = String.format("DELETE FROM pelanggan WHERE pelanggan_id = %d", selected.getPelangganId());
            stmt.executeUpdate(sql);
            loadDataPelanggan();
        } catch (Exception e) {
            e.printStackTrace();
            showErrorAlert("Error deleting customer: " + e.getMessage());
        }
    }

    private void loadDataBuku() {
        dataBuku.clear();
        try (Connection conn = DatabaseBuku.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM buku")) {

            while (rs.next()) {
                dataBuku.add(new Buku(
                    rs.getInt("buku_id"),
                    rs.getString("judul"),
                    rs.getString("penulis"),
                    rs.getDouble("harga"), 0
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
            showErrorAlert("Error loading book data: " + e.getMessage());
        }
    }

    private void addBuku() {
        String judul = bukuJudulField.getText();
        String penulis = bukuPenulisField.getText();
        String hargaStr = bukuHargaField.getText();

        if (judul.isEmpty() || penulis.isEmpty() || hargaStr.isEmpty()) {
            showErrorAlert("Semua field harus diisi!");
            return;
        }

        try {
            double harga = Double.parseDouble(hargaStr);
            try (Connection conn = DatabaseBuku.connect();
                 Statement stmt = conn.createStatement()) {
                String sql = String.format(
                    "INSERT INTO buku (judul, penulis, harga) VALUES ('%s', '%s', %f)",
                    judul, penulis, harga);
                stmt.executeUpdate(sql);
                loadDataBuku();
                bukuJudulField.clear();
                bukuPenulisField.clear();
                bukuHargaField.clear();
            }
        } catch (NumberFormatException e) {
            showErrorAlert("Harga harus berupa angka!");
        } catch (Exception e) {
            e.printStackTrace();
            showErrorAlert("Error adding book: " + e.getMessage());
        }
    }

    private void editBuku() {
        Buku selected = tableBuku.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showErrorAlert("Pilih buku yang ingin diedit!");
            return;
        }

        String judul = bukuJudulField.getText();
        String penulis = bukuPenulisField.getText();
        String hargaStr = bukuHargaField.getText();

        if (judul.isEmpty() || penulis.isEmpty() || hargaStr.isEmpty()) {
            showErrorAlert("Semua field harus diisi!");
            return;
        }

        try {
            double harga = Double.parseDouble(hargaStr);
            try (Connection conn = DatabaseBuku.connect();
                 Statement stmt = conn.createStatement()) {
                String sql = String.format(
                    "UPDATE buku SET judul = '%s', penulis = '%s', harga = %f WHERE buku_id = %d",
                    judul, penulis, harga, selected.getBukuId());
                stmt.executeUpdate(sql);
                loadDataBuku();
                bukuJudulField.clear();
                bukuPenulisField.clear();
                bukuHargaField.clear();
            }
        } catch (NumberFormatException e) {
            showErrorAlert("Harga harus berupa angka!");
        } catch (Exception e) {
            e.printStackTrace();
            showErrorAlert("Error editing book: " + e.getMessage());
        }
    }

    private void deleteBuku() {
        Buku selected = tableBuku.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showErrorAlert("Pilih buku yang ingin dihapus!");
            return;
        }

        try (Connection conn = DatabaseBuku.connect();
             Statement stmt = conn.createStatement()) {
            String sql = String.format("DELETE FROM buku WHERE buku_id = %d", selected.getBukuId());
            stmt.executeUpdate(sql);
            loadDataBuku();
        } catch (Exception e) {
            e.printStackTrace();
            showErrorAlert("Error deleting book: " + e.getMessage());
        }
    }

    private void loadDataPenjualan() {
        dataPenjualan.clear();
        try (Connection conn = DatabaseBuku.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM penjualan")) {

            while (rs.next()) {
                dataPenjualan.add(new PenjualanBuku(
                    rs.getInt("penjualan_id"),
                    rs.getInt("pelanggan_id"),
                    rs.getInt("buku_id"),
                    null, rs.getInt("jumlah"), 0
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
            showErrorAlert("Error loading sales data: " + e.getMessage());
        }
    }

    private void addPenjualan() {
        String pelangganIdStr = penjualanPelangganIdField.getText();
        String bukuIdStr = penjualanBukuIdField.getText();
        String jumlahStr = penjualanJumlahField.getText();

        if (pelangganIdStr.isEmpty() || bukuIdStr.isEmpty() || jumlahStr.isEmpty()) {
            showErrorAlert("Semua field harus diisi!");
            return;
        }

        try {
            int pelangganId = Integer.parseInt(pelangganIdStr);
            int bukuId = Integer.parseInt(bukuIdStr);
            int jumlah = Integer.parseInt(jumlahStr);

            try (Connection conn = DatabaseBuku.connect();
                 Statement stmt = conn.createStatement()) {
                String sql = String.format(
                    "INSERT INTO penjualan (pelanggan_id, buku_id, jumlah) VALUES (%d, %d, %d)",
                    pelangganId, bukuId, jumlah);
                stmt.executeUpdate(sql);
                loadDataPenjualan();
                penjualanPelangganIdField.clear();
                penjualanBukuIdField.clear();
                penjualanJumlahField.clear();
            }
        } catch (NumberFormatException e) {
            showErrorAlert("ID pelanggan, ID buku, dan jumlah harus berupa angka!");
        } catch (Exception e) {
            e.printStackTrace();
            showErrorAlert("Error adding sale: " + e.getMessage());
        }
    }

    private void deletePenjualan() {
        PenjualanBuku selected = tablePenjualan.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showErrorAlert("Pilih penjualan yang ingin dihapus!");
            return;
        }

        try (Connection conn = DatabaseBuku.connect();
             Statement stmt = conn.createStatement()) {
            String sql = String.format("DELETE FROM penjualan WHERE penjualan_id = %d", selected.getPenjualanId());
            stmt.executeUpdate(sql);
            loadDataPenjualan();
        } catch (Exception e) {
            e.printStackTrace();
            showErrorAlert("Error deleting sale: " + e.getMessage());
        }
    }

    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
