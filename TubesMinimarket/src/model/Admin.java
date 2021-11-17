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
public class Admin extends Person {

    public Admin(String name, String nomorTelepon, String alamat, String ttl,String gender, int id_person, String password, EnumJabatan jabatan) {
        super(name, nomorTelepon, alamat, ttl,gender, id_person, password, jabatan);
    }

    public Admin() {

    }
    @Override
    public String toString(){
        return "\nId Person:\t"+getId_person()+
                "\nName:\t\t"+getName()+
                "\nTTL:\t\t"+getTtl()+
                "\nAlamat:\t\t"+getAlamat()+
                "\nTelepon:\t"+getNomorTelepon()+
                "\nJabatan:\t"+getJabatan();
    }
}
