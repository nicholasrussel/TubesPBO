/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author PauL
 */
public class penjualanBarang {
    private String nomorFaktur;
    private double totalPenjualan;
    private String jenisPembayaran;

    public penjualanBarang() {
    }

    public penjualanBarang(String nomorFaktur, double totalPenjualan, String jenisPembayaran) {
        this.nomorFaktur = nomorFaktur;
        this.totalPenjualan = totalPenjualan;
        this.jenisPembayaran = jenisPembayaran;
    }

    public String getNomorFaktur() {
        return nomorFaktur;
    }

    public void setNomorFaktur(String nomorFaktur) {
        this.nomorFaktur = nomorFaktur;
    }

    public double getTotalPenjualan() {
        return totalPenjualan;
    }

    public void setTotalPenjualan(double totalPenjualan) {
        this.totalPenjualan = totalPenjualan;
    }

    public String getJenisPembayaran() {
        return jenisPembayaran;
    }

    public void setJenisPembayaran(String jenisPembayaran) {
        this.jenisPembayaran = jenisPembayaran;
    }

    @Override
    public String toString() {
        return "penjualanBarang{" + "nomorFaktur=" + nomorFaktur + ", totalPenjualan=" + totalPenjualan + ", jenisPembayaran=" + jenisPembayaran + '}';
    }
    
    
}
