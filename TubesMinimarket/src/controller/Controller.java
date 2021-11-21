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
    public int hitungGaji(int gaji,int hadir){
        int total =0;
        total = gaji*hadir;
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
        int count=0;
        conn.connect();
        String query = "SELECT COUNT(Status)AS StatusCount FROM kehadiran WHERE Id_Person = '" + ID+
                "'AND Status = '" + 1 + "'AND Tanggal_Masuk between Date'" + tanggal1 + "'AND Date'" + tanggal2 + "'" ;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                count=rs.getInt("StatusCount");
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
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(password.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
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

    public boolean insertAbsenKehadiran(Date absen, int ID, int status,int statusGaji) {
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
    
    public ArrayList<Kehadiran> cekSudahGajian(int ID, String tanggal1,String tanggal2) {
        ArrayList<Kehadiran> kehadirans = new ArrayList<>();
        Kehadiran hadir = new Kehadiran();
        conn.connect();
        String query = "SELECT * FROM kehadiran WHERE Id_Person = '" + ID  + "'AND Tanggal_Masuk between Date'" + tanggal1 + "'AND Date'" + tanggal2 + "' AND Status_Gaji='"+0+"'";
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
}
