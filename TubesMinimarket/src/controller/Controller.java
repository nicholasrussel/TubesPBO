/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.*;

/**
 *
 * @author Nicholas Russel
 */
public class Controller {

    static DatabaseHandler conn = new DatabaseHandler();

    public ArrayList<Kasir> getAllKasirs() {
        ArrayList<Kasir> cashier = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM person WHERE Jabatan = '" + EnumJabatan.KASIR + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Kasir kasir = new Kasir();
                kasir.setName(rs.getString("Name"));
                kasir.setAlamat(rs.getString("Alamat"));
                kasir.setId_person(rs.getInt("Id_Person"));
                kasir.setNomorTelepon(rs.getString("Nomor_Telepon"));
                kasir.setTtl(rs.getString("TTL"));
                kasir.setGaji(rs.getInt("Gaji"));
                cashier.add(kasir);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (cashier);
    }

    public Person getUser(int ID) {
        conn.connect();
        String query = "SELECT * FROM person WHERE Id_Person='" + ID + "'";
        Person person = new Person();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

                person.setName(rs.getString("Name"));
                person.setAlamat(rs.getString("Alamat"));
                person.setId_person(rs.getInt("Id_Person"));
                person.setNomorTelepon(rs.getString("Nomor_Telepon"));
                person.setTtl(rs.getString("TTL"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (person);
    }

    public Kasir getGajiKasir(int ID) {
        conn.connect();
        String query = "SELECT * FROM person WHERE Id_Person='" + ID + "'";
        Kasir kasir = new Kasir();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

                kasir.setGaji(rs.getInt("Gaji"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (kasir);
    }

    public boolean updatePassword(String password, int ID) {
        conn.connect();
        String query = "UPDATE person SET Password='" + password + "'"
                + "WHERE Id_Person='" + ID + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public Kasir getKasir(int ID) {
        conn.connect();
        String query = "SELECT * FROM person WHERE Id_Person='" + ID + "'";
        Kasir kasir = new Kasir();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

                kasir.setName(rs.getString("Name"));
                kasir.setAlamat(rs.getString("Alamat"));
                kasir.setId_person(rs.getInt("Id_Person"));
                kasir.setNomorTelepon(rs.getString("Nomor_Telepon"));
                kasir.setTtl(rs.getString("TTL"));
                kasir.setGaji(rs.getInt("Gaji"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (kasir);
    }

    public int hitungGaji(int gaji, int hadir) {
        int total = 0;
        total = gaji * hadir;
        return total;
    }

    public ArrayList<Kehadiran> getAllKehadiran() {
        ArrayList<Kehadiran> Kehadirans = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM kehadiran";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Kehadiran hadir = new Kehadiran();
                hadir.setTanggal(rs.getDate("Tanggal_Masuk"));
                hadir.setId_person(rs.getInt("Id_Person"));
                hadir.setStatus(rs.getInt("Status"));
                hadir.setStatusGaji(rs.getInt("Status_Gaji"));
                Kehadirans.add(hadir);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (Kehadirans);
    }

    public int getKehadiranKasir(int ID, String tanggal1, String tanggal2) {
        Kehadiran hadir = new Kehadiran();
        int count = 0;
        conn.connect();
        String query = "SELECT COUNT(Status)AS StatusCount FROM kehadiran WHERE Id_Person = '" + ID + "'AND Status = '" + 1 + "'AND Tanggal_Masuk between Date'" + tanggal1 + "'AND Date'" + tanggal2 + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                count = rs.getInt("StatusCount");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (count);
    }

    public String getSelectedPassword(int ID) {
        String password = "";
        conn.connect();
        String query = "SELECT * FROM person WHERE Id_Person = '" + ID + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                password = rs.getString("password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return password;
    }

    public String getSelectedJabatan(int ID) {
        String jabatan = "";
        conn.connect();
        String query = "SELECT * FROM person WHERE Id_Person = '" + ID + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                jabatan = rs.getString("Jabatan");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jabatan;
    }

    public String getMD5(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes());

            BigInteger no = new BigInteger(1, messageDigest);

            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public Kehadiran cekSudahAbsen(int ID, Date absen) {
        Kehadiran hadir = new Kehadiran();
        conn.connect();
        String query = "SELECT * FROM kehadiran WHERE Id_Person = '" + ID + "' AND Tanggal_Masuk = '" + absen + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

                hadir.setTanggal(rs.getDate("Tanggal_Masuk"));
                hadir.setId_person(rs.getInt("Id_Person"));
                hadir.setStatus(rs.getInt("Status"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (hadir);
    }

    public boolean insertAbsenKehadiran(Date absen, int ID, int status, int statusGaji) {
        conn.connect();
        String query = "INSERT INTO kehadiran (Tanggal_Masuk,Id_Person,Status,Status_Gaji)"
                + "VALUES (?, ?, ?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setDate(1, absen);
            stmt.setInt(2, ID);
            stmt.setInt(3, status);
            stmt.setInt(4, status);
            Kehadiran h = cekSudahAbsen(ID, absen);
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public ArrayList<Kehadiran> cekSudahGajian(int ID, String tanggal1, String tanggal2) {
        ArrayList<Kehadiran> kehadirans = new ArrayList<>();
        Kehadiran hadir = new Kehadiran();
        conn.connect();
        String query = "SELECT * FROM kehadiran WHERE Id_Person = '" + ID + "'AND Tanggal_Masuk between Date'" + tanggal1 + "'AND Date'" + tanggal2 + "' AND Status_Gaji='" + 0 + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

                hadir.setTanggal(rs.getDate("Tanggal_Masuk"));
                hadir.setId_person(rs.getInt("Id_Person"));
                hadir.setStatus(rs.getInt("Status_Gaji"));
                kehadirans.add(hadir);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (kehadirans);
    }

    public boolean updateStatusGaji(int statusGaji, String tanggal1, String tanggal2, int ID) {
        conn.connect();
        String query = "UPDATE kehadiran SET Status_Gaji='" + statusGaji + "'"
                + "WHERE Id_Person='" + ID + "'AND Tanggal_Masuk between Date'" + tanggal1 + "'AND Date'" + tanggal2 + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public boolean insertNewUser(Kasir newPerson) {
        conn.connect();
        String query = "INSERT INTO person (Jabatan,Name,Alamat,Nomor_Telepon,TTL,Password,Gaji,Gender)"
                + "VALUES (?, ?, ?,?, ?, ?,?, ?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, newPerson.getJabatan().toString());
            stmt.setString(2, newPerson.getName());
            stmt.setString(3, newPerson.getAlamat());
            stmt.setString(4, newPerson.getNomorTelepon());
            stmt.setString(5, newPerson.getTtl());
            stmt.setString(6, newPerson.getPassword());
            stmt.setDouble(7, newPerson.getGaji());
            stmt.setString(8, newPerson.getGender());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    // UPDATE
    public boolean updateKasir(int ID, String nama, String alamat, String nomor, int gaji) {
        conn.connect();
        String query = "UPDATE person SET Name='" + nama + "', "
                + "Alamat='" + alamat + "', "
                + "Nomor_Telepon='" + nomor + "',"
                + "Gaji='" + gaji + "' "
                + "WHERE Id_Person='" + ID + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    // DELETE
    public boolean deleteUser(int ID) {
        conn.connect();

        String query = "DELETE FROM person WHERE Id_Person='" + ID + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public Barang getBarang(String idBarang) {
        conn.connect();
        String query = "SELECT * FROM barang WHERE Kode_Barang='" + idBarang + "'";
        Barang barang = new Barang();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                barang.setKodeBarang(rs.getString("Kode_Barang"));
                barang.setNamaBarang(rs.getString("Nama_Barang"));
                barang.setStokBarang(rs.getInt("Stok"));
                barang.setHargaBarang(rs.getInt("Harga_Barang"));
                barang.setKarduluasaBarang(rs.getString("Kadaluarsa"));
                barang.setPersenDiskon(rs.getFloat("Persen_Diskon"));
                barang.setKategori(rs.getString("Kategori"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (barang);
    }

    public boolean setPenjualanDB(PenjualanBarang jual) {
        conn.connect();
        String query = "INSERT INTO penjualanbarang (Nomor_Faktur,Total_Penjualan,Jenis_Pembayaran) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, jual.getNomorFaktur());
            stmt.setDouble(2, jual.getTotalPenjualan());
            stmt.setString(3, jual.getJenisPembayaran());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public boolean updateStock(ArrayList<DetailPenjualan> detailJual) {
        conn.connect();
        boolean sukses = false;
        for (int i = 0; i < detailJual.size(); i++) {

            try {
                String query = "UPDATE barang SET Stok = Stok - '" + detailJual.get(i).getKuantitas() + "' "
                        + "WHERE Kode_Barang='" + detailJual.get(i).getKodeBarang() + "'";
                Statement stmt = conn.con.createStatement();
                stmt.executeUpdate(query);
                sukses = true;
            } catch (SQLException e) {
                e.printStackTrace();
                sukses = false;
            }

        }
        return sukses;

    }
    
    public ArrayList<Barang> getAllBarang() {
        ArrayList<Barang> barangs = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM barang";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Barang barang = new Barang();
                barang.setKodeBarang(rs.getString("Kode_Barang"));
                barang.setNamaBarang(rs.getString("Nama_Barang"));
                barang.setStokBarang(rs.getInt("Stok"));
                barang.setHargaBarang(rs.getInt("Harga_Barang"));
                barang.setKarduluasaBarang(rs.getString("Kadaluarsa"));
                barang.setPersenDiskon(rs.getFloat("Persen_Diskon"));
                barang.setKategori(rs.getString("Kategori"));
                barangs.add(barang);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (barangs);
    }
    
    public ArrayList<PenjualanBarang> getAllPenjualanBarang() {
        ArrayList<PenjualanBarang> penjualanBarangs = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM penjualanbarang";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                PenjualanBarang penjualanBarang = new PenjualanBarang();
                penjualanBarang.setNomorFaktur(rs.getString("Nomor_Faktur"));
                penjualanBarang.setTotalPenjualan(rs.getDouble("Total_Penjualan"));
                penjualanBarang.setJenisPembayaran(rs.getString("Jenis_Pembayaran"));
                penjualanBarangs.add(penjualanBarang);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (penjualanBarangs);
    }
    
    public ArrayList<DetailPenjualan> getAllDetailBarang() {
        ArrayList<DetailPenjualan> detailPenjualanBarangs = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM detil_penjualan";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                DetailPenjualan detilPenjualan = new DetailPenjualan();
                detilPenjualan.setKodeBarang(rs.getString("Kode_Barang"));
                detilPenjualan.setNomorFaktur(rs.getString("Nomor_Faktur"));
                detilPenjualan.setTanggalJual(rs.getString("Tanggal_Jual"));
                detilPenjualan.setKuantitas(rs.getInt("Quantity"));
                detailPenjualanBarangs.add(detilPenjualan);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (detailPenjualanBarangs);
    }
    
     public boolean setdetailJual(ArrayList<DetailPenjualan> jual) {
        conn.connect();
        boolean sukses = false;
        
       
        for (int i = 0; i < jual.size(); i++) {

            try {
                String query = "INSERT INTO detil_penjualan (Kode_Barang,Nomor_Faktur,Tanggal_Jual,Quantity) VALUES ('"+jual.get(i).getKodeBarang()+"','"+jual.get(i).getNomorFaktur()+"','"+jual.get(i).getTanggalJual()+"','"+jual.get(i).getKuantitas()+"')";
                PreparedStatement stmt = conn.con.prepareStatement(query);
                stmt.executeUpdate(query);
                
            } catch (SQLException e) {
                e.printStackTrace();
                
            }

        }
        return sukses;
    }
     
     
     public boolean updateBarang(String cekKodeProduk, String cekNama, int harga2, int stok2, float persen) {
        conn.connect();
        boolean sukses = false;
        
       
         try {
                String query = "UPDATE barang SET Nama_Barang='" + cekNama + "', "
                + "Stok='" + stok2 + "', "
                + "Harga_Barang='" + harga2 + "',"          
                + "Persen_Diskon='" + persen + "'"
                + "WHERE Kode_Barang='" + cekKodeProduk + "'";
                Statement stmt = conn.con.createStatement();
                stmt.executeUpdate(query);
                sukses = true;
            } catch (SQLException e) {
                e.printStackTrace();
                sukses = false;
            }
        return sukses;
    }
     
     public boolean insertBarang(Barang barang) {
        conn.connect();
        String query = "INSERT INTO barang (Kode_Barang, Nama_Barang, Stok, Harga_Barang, Kadaluarsa, Persen_Diskon, Kategori) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, barang.getKodeBarang());
            stmt.setString(2, barang.getNamaBarang());
            stmt.setInt(3, barang.getStokBarang());
            stmt.setInt(4, barang.getHargaBarang());
            stmt.setString(5, barang.getKarduluasaBarang());
            stmt.setFloat(6, barang.getPersenDiskon());
            stmt.setString(7, barang.getKategori());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
}
