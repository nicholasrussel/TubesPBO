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
public class DetailPenjualan {
    private String nomorFaktur;
    private String kodeBarang;
    private String tanggalJual;
    private int kuantitas;

    public DetailPenjualan() {
    }

    public DetailPenjualan(String nomorFaktur, String kodeBarang, String tanggalJual, int kuantitas) {
        this.nomorFaktur = nomorFaktur;
        this.kodeBarang = kodeBarang;
        this.tanggalJual = tanggalJual;
        this.kuantitas = kuantitas;
    }

    public String getNomorFaktur() {
        return nomorFaktur;
    }

    public void setNomorFaktur(String nomorFaktur) {
        this.nomorFaktur = nomorFaktur;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public String getTanggalJual() {
        return tanggalJual;
    }

    public void setTanggalJual(String tanggalJual) {
        this.tanggalJual = tanggalJual;
    }

    public int getKuantitas() {
        return kuantitas;
    }

    public void setKuantitas(int kuantitas) {
        this.kuantitas = kuantitas;
    }

    @Override
    public String toString() {
        return "DetailPenjualan{" + "nomorFaktur=" + nomorFaktur + ", kodeBarang=" + kodeBarang + ", tanggalJual=" + tanggalJual + ", kuantitas=" + kuantitas + '}';
    }
    
    
    
    
}
