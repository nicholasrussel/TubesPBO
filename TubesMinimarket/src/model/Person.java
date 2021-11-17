/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Nicholas Russel
 */
public abstract class Person {
    private String name;
    private String nomorTelepon;
    private String alamat;
    private String ttl;
    private String gender;
    private int id_person;
    private String password;
    private EnumJabatan jabatan;

    public Person(String name, String nomorTelepon, String alamat, String ttl,String gender,int id_person,String password,EnumJabatan jabatan) {
        setName(name);
        setNomorTelepon(nomorTelepon);
        setAlamat(alamat);
        setTtl(ttl);
        setGender(gender);
        setId_person(id_person);
        setPassword(password);
        setJabatan(jabatan);
    }
    public Person(){
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public int getId_person() {
        return id_person;
    }

    public void setId_person(int id_person) {
        this.id_person = id_person;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EnumJabatan getJabatan() {
        return jabatan;
    }

    public void setJabatan(EnumJabatan jabatan) {
        this.jabatan = jabatan;
    }

    
}
