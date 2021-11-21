/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author PauL
 */
public class ScanBarangPenjualan implements ActionListener{
    public JFrame framePenjualan;
    public JLabel labelNamaBarang,lableIDBarang,lableHargaBarang,lableKali,lableBanyakBarang,lableDiskonBarang,lableTHargaBarang;
    public JTextField textNamaBarang,textIDBarang,textHargaBarang,textBanyakBarang,textDiskonBarang,textTHargaBarang;
    public JButton Badd,BReset,BCancel;
    //FormPenjualanBarangUtama penjualan;
    
    public ScanBarangPenjualan(){
        framePenjualan = new JFrame();
        lableIDBarang = new JLabel("ID Barang : ");
        lableIDBarang.setBounds(5,5,70,15);
        framePenjualan.add(lableIDBarang);
        
        textIDBarang = new JTextField();
        textIDBarang.setBounds(5,20,150,20);
        framePenjualan.add(textIDBarang);
        
        labelNamaBarang = new JLabel("Nama Barang : ");
        labelNamaBarang.setBounds(220, 5, 100, 15);
        framePenjualan.add(labelNamaBarang);
        
        textNamaBarang = new JTextField();
        textNamaBarang.setBounds(220, 20, 150, 20);
        framePenjualan.add(textNamaBarang);
        
        lableHargaBarang = new JLabel("Harga Barang  : ");
        lableHargaBarang.setBounds(5,40,150,15);
        framePenjualan.add(lableHargaBarang);
        
        textHargaBarang = new JTextField();
        textHargaBarang.setBounds(5,60,150,20);
        framePenjualan.add(textHargaBarang);
        
        lableKali = new JLabel(" X ");
        lableKali.setBounds(180,60,50,15);
        framePenjualan.add(lableKali);
        
        lableBanyakBarang = new JLabel("Banyak Barang Barang  : ");
        lableBanyakBarang.setBounds(220,40,150,15);
        framePenjualan.add(lableBanyakBarang);
        
        textBanyakBarang = new JTextField();
        textBanyakBarang.setBounds(220,60,150,20);
        framePenjualan.add(textBanyakBarang);
        
        lableDiskonBarang = new JLabel("Diskon Barang  : ");
        lableDiskonBarang.setBounds(5,85,150,15);
        framePenjualan.add(lableDiskonBarang);
        
        textDiskonBarang = new JTextField();
        textDiskonBarang.setBounds(5,105,150,20);
        framePenjualan.add(textDiskonBarang);
        
        lableTHargaBarang = new JLabel("Total Harga Barang  : ");
        lableTHargaBarang.setBounds(220,85,150,15);
        framePenjualan.add(lableTHargaBarang);
        
        textTHargaBarang = new JTextField();
        textTHargaBarang.setBounds(220,105,150,20);
        framePenjualan.add(textTHargaBarang);
        
        Badd = new JButton("Add");
        Badd.setBounds(380, 5, 100, 25);
        Badd.addActionListener(this);
        framePenjualan.add(Badd);
        
        framePenjualan.setSize(500, 200);//400 width and 500 height  
        framePenjualan.setLayout(null);//using no layout managers  
        framePenjualan.setVisible(true);
    }
    public static void main(String[] args) {
        new ScanBarangPenjualan();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //penjualan = new FormPenjualanBarangUtama();
        if(e.getSource() == Badd){
            String idBarang = textIDBarang.getText();
            String namaBarang = textNamaBarang.getText();
            String hargaBarang = textHargaBarang.getText();
            String banyakBarang = textBanyakBarang.getText();
            String diskonBarang = textDiskonBarang.getText();
            String total = textTHargaBarang.getText();
            //penjualan.area.setText(idBarang + " " + namaBarang + "  " + diskonBarang + "    " + hargaBarang + " "+banyakBarang+"    "+total+"\n");
            
            framePenjualan.setVisible(false);
            //penjualan.frame.setVisible(true);
        }
    }
    
}
