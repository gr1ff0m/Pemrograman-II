package buku;

public class PelangganBuku {
    private int pelangganId;
    private String nama;
    private String email;
    private String telepon;

    // Constructor
    public PelangganBuku(int pelangganId, String nama, String email, String telepon) {
        this.pelangganId = pelangganId;
        this.nama = nama;
        this.email = email;
        this.telepon = telepon;
    }

    // Getters and Setters
    public int getPelangganId() {
        return pelangganId;
    }

    public void setPelangganId(int pelangganId) {
        this.pelangganId = pelangganId;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    // toString untuk debugging dan logging
    @Override
    public String toString() {
        return "PelangganBuku{" +
                "pelangganId=" + pelangganId +
                ", nama='" + nama + '\'' +
                ", email='" + email + '\'' +
                ", telepon='" + telepon + '\'' +
                '}';
    }
}
