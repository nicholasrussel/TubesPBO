/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;


public class DetailPenjualanTopUp {
    private static String Id_TopUp;
    private String Nomor_FakturTopUp;
    private Date Tanggal_JualTopUp;
    private String Nomor_teleponPelanggan;

    public DetailPenjualanTopUp() {
    }

    public DetailPenjualanTopUp(String Id_TopUp, String Nomor_FakturTopUp, Date Tanggal_JualTopUp, String Nomor_teleponPelanggan) {
        this.Id_TopUp = Id_TopUp;
        this.Nomor_FakturTopUp = Nomor_FakturTopUp;
        this.Tanggal_JualTopUp = Tanggal_JualTopUp;
        this.Nomor_teleponPelanggan = Nomor_teleponPelanggan;
    }

    public  String getId_TopUp() {
        return Id_TopUp;
    }

    public void setId_TopUp(String Id_TopUp) {
        this.Id_TopUp = Id_TopUp;
    }

    public String getNomor_FakturTopUp() {
        return Nomor_FakturTopUp;
    }

    public void setNomor_FakturTopUp(String Nomor_FakturTopUp) {
        this.Nomor_FakturTopUp = Nomor_FakturTopUp;
    }

    public Date getTanggal_JualTopUp() {
        return Tanggal_JualTopUp;
    }

    public void setTanggal_JualTopUp(Date Tanggal_JualTopUp) {
        this.Tanggal_JualTopUp = Tanggal_JualTopUp;
    }

    public String getNomor_teleponPelanggan() {
        return Nomor_teleponPelanggan;
    }

    public void setNomor_teleponPelanggan(String Nomor_teleponPelanggan) {
        this.Nomor_teleponPelanggan = Nomor_teleponPelanggan;
    }
    
    public String toString(){
        return "Id TopUp:\t"+getId_TopUp()+
                "\nNomore FakturTopUp:\t"+getNomor_FakturTopUp()+
                "\nTanggal JualTopUp:\t"+getTanggal_JualTopUp()+
                "\nNomor TeleponPelanggan:\t"+getNomor_teleponPelanggan();
    }
}
