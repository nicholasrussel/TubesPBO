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
public class Barang {
    private String kodeBarang;
    private String namaBarang;
    private int stokBarang;
    private int hargaBarang;
    private String karduluasaBarang;
    private float persenDiskon;
    private String kategori;

    public Barang() {
    }

    public Barang(String kodeBarang, String namaBarang, int stokBarang, int hargaBarang, String karduluasaBarang, float persenDiskon, String kategori) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.stokBarang = stokBarang;
        this.hargaBarang = hargaBarang;
        this.karduluasaBarang = karduluasaBarang;
        this.persenDiskon = persenDiskon;
        this.kategori = kategori;
    }
    
    
    
    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getStokBarang() {
        return stokBarang;
    }

    public void setStokBarang(int stokBarang) {
        this.stokBarang = stokBarang;
    }

    public int getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(int hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    public String getKarduluasaBarang() {
        return karduluasaBarang;
    }

    public void setKarduluasaBarang(String karduluasaBarang) {
        this.karduluasaBarang = karduluasaBarang;
    }

    public float getPersenDiskon() {
        return persenDiskon;
    }

    public void setPersenDiskon(float persenDiskon) {
        this.persenDiskon = persenDiskon;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    @Override
    public String toString() {
        return "Barang{" + "kodeBarang=" + kodeBarang + ", namaBarang=" + namaBarang + ", stokBarang=" + stokBarang + ", hargaBarang=" + hargaBarang + ", karduluasaBarang=" + karduluasaBarang + ", persenDiskon=" + persenDiskon + ", kategori=" + kategori + '}';
    }
    
    
}
