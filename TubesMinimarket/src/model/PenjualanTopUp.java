/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ASUS
 */
public class PenjualanTopUp {
    private String Nomor_FakturTopUp;
    private double Total_PenjualanTopUp;
    private int idJenisPembayaran;

    public PenjualanTopUp() {
    }

    public PenjualanTopUp(String Nomor_FakturTopUp, double Total_PenjualanTopUp, int Jenis_Pembayaran) {
        this.Nomor_FakturTopUp = Nomor_FakturTopUp;
        this.Total_PenjualanTopUp = Total_PenjualanTopUp;
        this.idJenisPembayaran = Jenis_Pembayaran;
    }

    public String getNomor_FakturTopUp() {
        return Nomor_FakturTopUp;
    }

    public void setNomor_FakturTopUp(String Nomor_FakturTopUp) {
        this.Nomor_FakturTopUp = Nomor_FakturTopUp;
    }

    public double getTotal_PenjualanTopUp() {
        return Total_PenjualanTopUp;
    }

    public void setTotal_PenjualanTopUp(double Total_PenjualanTopUp) {
        this.Total_PenjualanTopUp = Total_PenjualanTopUp;
    }

    public int getidJenisPembayaran() {
        return idJenisPembayaran;
    }

    public void setidJenisPembayaran(int Jenis_Pembayaran) {
        this.idJenisPembayaran = Jenis_Pembayaran;
    }
    public String toString(){
        return "Nomor FakturTopUp:\t"+getNomor_FakturTopUp()+
                "\nTotal PenjualanTopUp:\t"+getTotal_PenjualanTopUp()+
                "\nJenis Pembayaran:\t"+getidJenisPembayaran();
    }
}
