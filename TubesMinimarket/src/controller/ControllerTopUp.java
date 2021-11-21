/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.*;

/**
 *
 * @author ASUS
 */
public class ControllerTopUp {
    
    static DatabaseHandler conn = new DatabaseHandler();

    public ArrayList<DetailPenjualanTopUp> getAllDetailPenjualanTopUp(){
        ArrayList<DetailPenjualanTopUp> detailPenjualanTopUp = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM detil_penjualantopup";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                DetailPenjualanTopUp  detailPenjualanTU = new DetailPenjualanTopUp();
                detailPenjualanTU.setId_TopUp(rs.getString("Id_TopUp"));
                detailPenjualanTU.setNomor_FakturTopUp(rs.getString("Nomor_FakturTopUp"));
                detailPenjualanTU.setTanggal_JualTopUp(rs.getDate("Tanggal_JualTopUp"));
                detailPenjualanTU.setNomor_teleponPelanggan(rs.getString("nomor_TeleponPelanggan"));
                detailPenjualanTopUp.add(detailPenjualanTU);
            } 
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return (detailPenjualanTopUp);
    }

    public DetailPenjualanTopUp getDetailPenjualanTopUp(String Id_TopUp) {
        conn.connect();
        String query = "SELECT * FROM detil_penjualantopup WHERE Id_TopUp='" + Id_TopUp + "'";
        DetailPenjualanTopUp detailPenjualanTU = new DetailPenjualanTopUp();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

                detailPenjualanTU.setId_TopUp(rs.getString("Id_TopUp"));
                detailPenjualanTU.setNomor_FakturTopUp(rs.getString("Nomor_FakturTopUp"));
                detailPenjualanTU.setTanggal_JualTopUp(rs.getDate("Tanggal_JualTopUp"));
                detailPenjualanTU.setNomor_teleponPelanggan(rs.getString("nomor_TeleponPelanggan"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (detailPenjualanTU);
    }
    
    public ArrayList<PenjualanTopUp> getAllPenjualanTopUp() {
        ArrayList<PenjualanTopUp> penjualanTopUp = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM penjualantopup";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                PenjualanTopUp penjualanTU = new PenjualanTopUp();
                penjualanTU.setNomor_FakturTopUp(rs.getString("Nomor_FakturTopUp"));
                penjualanTU.setidJenisPembayaran((rs.getInt("IdJenisPembayaran")));
                 penjualanTU.setTotal_PenjualanTopUp(rs.getDouble("Total_PenjualanTopUp"));
                penjualanTopUp.add(penjualanTU);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (penjualanTopUp);
    }
    public ArrayList<JenisPembayaran> getAllNamaJenisPembayaran(){
        ArrayList<JenisPembayaran> jenisPembayaran = new ArrayList();
        conn.connect();
        String query = "SELECT * FROM jenispembayaran";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                JenisPembayaran jenisP = new JenisPembayaran();
                jenisP.setIdPembayaran(rs.getInt("id_JenisPembayaran"));
                jenisP.setNamaPembayaran(rs.getString("namaJenisPembayaran"));
//                String jenisPembayaran = rs.getString();
//                penjualanTU.setJenis_Pembayaran.valueOf((rs.getString("Jenis_Pembayaran")));
                jenisPembayaran.add(jenisP);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (jenisPembayaran);
    }

    public  ArrayList<TopUp> getIdTopUpHargaTopUp(){
        ArrayList<TopUp> topUp = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM topup";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                TopUp tu = new TopUp();
                tu.setId_TopUp(rs.getString("Id_TopUp"));
                tu.setPajak_TopUp(rs.getFloat("Pajak_TopUp"));
                tu.setHarga_TopUp(rs.getDouble("Harga_TopUp"));
                tu.setType_TopUp(rs.getString("Type_TopUp"));
                //penjualanTU.setTotal_PenjualanTopUp(rs.getInt("Total_Penjualan Top Up"));
//                String jenisPembayaran = rs.getString();
//                penjualanTU.setJenis_Pembayaran.valueOf((rs.getString("Jenis_Pembayaran")));
                topUp.add(tu);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (topUp);
    }
    public String getJenisTopUp(String cekIdTopUp){
        String cekJenisTopUp = null;
        char g = 'G';
        char p = 'P';
        char o = 'O';
        
            if(cekIdTopUp.charAt(0) == g){
                cekJenisTopUp = "GOPAY";
            }else if(cekIdTopUp.charAt(0) == p){
                cekJenisTopUp = "Pulsa";
            }else if(cekIdTopUp.charAt(0) == o){
                cekJenisTopUp = "OVO";
            }
        return cekJenisTopUp;
    }
    
    public boolean insertDataDetailPenjualanTopUp(String id_TopUp,String nomor_FakturTopUp,Date tanggal_JualTopUp,String nomor_TeleponPelanggan){
        conn.connect();
        String query = "INSERT INTO detil_penjualantopup (Id_TopUp,Nomor_FakturTopUp,Tanggal_JualTopUp,nomor_TeleponPelanggan)"
                + "VALUES (?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, id_TopUp);
            stmt.setString(2, nomor_FakturTopUp);
            stmt.setDate(3, tanggal_JualTopUp);
            stmt.setString(4, nomor_TeleponPelanggan);
            
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    public static double  Harga(String cek_IdTopUp){
        ControllerTopUp c = new ControllerTopUp();
        ArrayList<TopUp> topUp = c.getIdTopUpHargaTopUp();
            String []idTu = new String[topUp.size()];
            Double []hargaTu = new Double[topUp.size()];
            for (int i = 0; i < topUp.size(); i++) {
                idTu[i] = topUp.get(i).getId_TopUp();
                hargaTu[i] = topUp.get(i).getHarga_TopUp();
            }
            double penjualanTopUp = 0;
            for (int i = 0; i < idTu.length; i++) {
                if(cek_IdTopUp.equals(idTu[i])){
                    penjualanTopUp = hargaTu[i]+(0.1*hargaTu[i]);
                    
                } 
            }
            return penjualanTopUp;
    }
    public static double  getKembalian(double harga,double uangPembeli){
        double kembalian = 0;
        kembalian = uangPembeli-harga;
            return kembalian;
    }
    
    public int IdJenisPembayaran(String cekJenisPembayaran){
        ArrayList<JenisPembayaran>jenisPembayaran  = getAllNamaJenisPembayaran();
        String [] jenis = new String[jenisPembayaran.size()];
        
        for (int i = 0; i < jenis.length; i++) {
            jenis[i] = jenisPembayaran.get(i).getNamaPembayaran();
        }
        int id = 0;
        for (int i = 0; i < jenis.length; i++) {
            if(cekJenisPembayaran.equals(jenis[i])){
                id = jenisPembayaran.get(i).getIdPembayaran();
            }
        }
        return id;
    }

    public boolean insertDataPenjualanTopUp(String Id_TopUp,String Nomor_FakturTopUp,String cekJenisPembayaran){
    conn.connect();
        String query = "INSERT INTO penjualantopup (Nomor_FakturTopUp,IdJenisPembayaran,Total_PenjualanTopUp)"
                + "VALUES (?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, Nomor_FakturTopUp);
            stmt.setInt(2, IdJenisPembayaran(cekJenisPembayaran));
            stmt.setDouble(3, Harga(Id_TopUp));
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
        
    }
    public boolean insertDataTopUp(String Id_TopUp,float pajak_TopUp,double harga_TopUp,String type_TopUp){
    conn.connect();
        String query = "INSERT INTO topup (Id_TopUp,Pajak_TopUp,Harga_TopUp,Type_TopUp)"
                + "VALUES (?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, Id_TopUp);
            stmt.setFloat(2, pajak_TopUp);
            stmt.setDouble(3, harga_TopUp);
            stmt.setString(4, type_TopUp);
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    } 
    
    public boolean updateDataTopUp(String Id_TopUp,double harga_TopUp){
    conn.connect();
        String query = "UPDATE  topup SET Harga_TopUp='"+harga_TopUp+"'"
                + "WHERE Id_TopUp='"+Id_TopUp+"'";
                ;
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    public boolean deleteDataTopUp(String Id_TopUp,float pajak_TopUp,double harga_TopUp,String type_TopUp){
    conn.connect();
        String query = "DELETE  FROM topup where Id_TopUp='"+Id_TopUp+"'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

//    public Kehadiran cekSudahAbsen(int ID, Date absen) {
//        Kehadiran hadir = new Kehadiran();
//        conn.connect();
//        String query = "SELECT * FROM kehadiran WHERE Id_Person = '" + ID + "' AND Tanggal_Masuk = '" + absen + "'";
//        try {
//            Statement stmt = conn.con.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//            while (rs.next()) {
//
//                hadir.setTanggal(rs.getDate("Tanggal_Masuk"));
//                hadir.setId_person(rs.getInt("Id_Person"));
//                hadir.setStatus(rs.getInt("Status"));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return (hadir);
//    }
//
//    public boolean insertAbsenKehadiran(Date absen, int ID, int status) {
//        conn.connect();
//        String query = "INSERT INTO kehadiran (Tanggal_Masuk,Id_Person,Status)"
//                + "VALUES (?, ?, ?)";
//        try {
//            PreparedStatement stmt = conn.con.prepareStatement(query);
//            stmt.setDate(1, absen);
//            stmt.setInt(2, ID);
//            stmt.setInt(3, status);
//            Kehadiran h = cekSudahAbsen(ID, absen);
//            stmt.executeUpdate();
//            return (true);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return (false);
//        }
//    }
//
//    public boolean insertNewUser(Kasir newPerson) {
//        conn.connect();
//        String query = "INSERT INTO person (Jabatan,Name,Alamat,Nomor_Telepon,TTL,Password,Gaji,Gender)"
//                + "VALUES (?, ?, ?,?, ?, ?,?, ?)";
//        try {
//            PreparedStatement stmt = conn.con.prepareStatement(query);
//            stmt.setString(1, newPerson.getJabatan().toString());
//            stmt.setString(2, newPerson.getName());
//            stmt.setString(3, newPerson.getAlamat());
//            stmt.setString(4, newPerson.getNomorTelepon());
//            stmt.setString(5, newPerson.getTtl());
//            stmt.setString(6, newPerson.getPassword());
//            stmt.setDouble(7, newPerson.getGaji());
//            stmt.setString(8, newPerson.getGender());
//            stmt.executeUpdate();
//            return (true);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return (false);
//        }
//    }
//
//    // UPDATE
//    public boolean updateKasir(int ID, String nama, String alamat, String nomor, int gaji) {
//        conn.connect();
//        String query = "UPDATE person SET Name='" + nama + "', "
//                + "Alamat='" + alamat + "', "
//                + "Nomor_Telepon='" + nomor + "',"
//                + "Gaji='" + gaji + "' "
//                + "WHERE Id_Person='" + ID + "'";
//        try {
//            Statement stmt = conn.con.createStatement();
//            stmt.executeUpdate(query);
//            return (true);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return (false);
//        }
//    }
//
//    // DELETE
//    public boolean deleteUser(int ID) {
//        conn.connect();
//
//        String query = "DELETE FROM person WHERE Id_Person='" + ID + "'";
//        try {
//            Statement stmt = conn.con.createStatement();
//            stmt.executeUpdate(query);
//            return (true);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return (false);
//        }
//    }
}


