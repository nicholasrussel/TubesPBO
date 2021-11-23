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
public class TopUp {
    private String Id_TopUp;
    private float Pajak_TopUp;
    private double Harga_TopUp;
    private String Type_TopUp;

    public TopUp() {
    }

    public TopUp(String Id_TopUp, float Pajak_TopUp, double Harga_TopUp, String Type_TopUp) {
        this.Id_TopUp = Id_TopUp;
        this.Pajak_TopUp = Pajak_TopUp;
        this.Harga_TopUp = Harga_TopUp;
        this.Type_TopUp = Type_TopUp;
    }

    public String getId_TopUp() {
        return Id_TopUp;
    }

    public void setId_TopUp(String Id_TopUp) {
        this.Id_TopUp = Id_TopUp;
    }

    public float getPajak_TopUp() {
        return Pajak_TopUp;
    }

    public void setPajak_TopUp(float Pajak_TopUp) {
        this.Pajak_TopUp = Pajak_TopUp;
    }

    public double getHarga_TopUp() {
        return Harga_TopUp;
    }

    public void setHarga_TopUp(double Harga_TopUp) {
        this.Harga_TopUp = Harga_TopUp;
    }

    public String getType_TopUp() {
        return Type_TopUp;
    }

    public void setType_TopUp(String Type_TopUp) {
        this.Type_TopUp = Type_TopUp;
    }
    
    public String toString(){
        return "Id TopUp:\t"+getId_TopUp()+
                "\nPajak TopUp:\t"+getPajak_TopUp()+
                "\nHarga TopUp:\t"+getHarga_TopUp()+
                "\nType TopUp:\t"+getType_TopUp();
    }
    
}
