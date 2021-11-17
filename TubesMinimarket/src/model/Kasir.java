/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Nicholas Russel
 */
public class Kasir extends Person {

    private int gaji;
    private ArrayList<Kehadiran> listKehadiran = new ArrayList();

    public Kasir(String name, String nomorTelepon, String alamat, String ttl,String gender,int id_person, String password, EnumJabatan jabatan) {
        super(name, nomorTelepon, alamat, ttl,gender, id_person, password, jabatan);
        setGaji(gaji);
    }

    public Kasir() {
    }

    public int getGaji() {
        return gaji;
    }

    public void setGaji(int gaji) {
        this.gaji = gaji;
    }

    public ArrayList<Kehadiran> getListKehadiran() {
        return listKehadiran;
    }

    public void setListKehadiran(ArrayList<Kehadiran> listKehadiran) {
        this.listKehadiran = listKehadiran;
    }
    
    public String toString(){
        return "\nId Person:\t"+getId_person()+
                "\nName:\t\t"+getName()+
                "\nTTL:\t\t"+getTtl()+
                "\nAlamat:\t\t"+getAlamat()+
                "\nTelepon:\t"+getNomorTelepon()+
                "\nGaji:\t"+getGaji();
    }
}
