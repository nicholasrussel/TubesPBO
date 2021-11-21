/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Controller.ControllerTopUp;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.*;
import model.DetailPenjualanTopUp;

/**
 *
 * @author ASUS
 */
public class BayarTunai {
    
    public BayarTunai(String cekIdTopUp,String cekNomorFakturTopUp,double harga,String cekNomorTeleponPelanggan,String cekJenisPembayaran){
        JFrame f = new JFrame();
        f.setTitle("Detail Penjualan Top Up ");
        f.setSize(800, 800);
        f.setResizable(false);
        f.setLayout(null);  
        f.setLocationRelativeTo(null);
        
        JLabel title = new JLabel("Menu Bayar Tunai");
            title.setFont(new Font("Arial", Font.PLAIN, 20));
            title.setSize(400, 20);
            title.setLocation(300, 30);
            f.add(title);
        
        JLabel hargaBayar = new JLabel("harga : "+harga);
            hargaBayar.setSize(400, 20);
            hargaBayar.setLocation(100, 60);
            f.add(hargaBayar);
        
        JLabel uangPembeli = new JLabel("Input uang yang dikasih pembeli");
            uangPembeli.setSize(400, 20);
            uangPembeli.setLocation(100, 90);
            f.add(uangPembeli);
        JTextField textUangPembeli = new JTextField();
            textUangPembeli.setSize(200, 30);
            textUangPembeli.setLocation(100, 120);
            f.add(textUangPembeli);
        JButton bayar = new JButton("Bayar");
            bayar.setSize(200, 30);
            bayar.setLocation(100, 150);
            bayar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //variable
                            ControllerTopUp c = new ControllerTopUp();
                            double uangPembeli = Double.parseDouble(textUangPembeli.getText());
                            double kembalian = c.getKembalian(harga,uangPembeli);
                        if(uangPembeli>= harga){
                            f.setVisible(false);

                            JFrame f2 = new JFrame();
                            f2.setTitle("Detail Top Up ");
                            f2.setSize(800, 800);
                            f2.setResizable(false);
                            f2.setLayout(null);  
                            f2.setLocationRelativeTo(null);

                            
                            JLabel title = new JLabel("Menu Bayar Tunai");
                                title.setFont(new Font("Arial", Font.PLAIN, 20));
                                title.setSize(400, 20);
                                title.setLocation(300, 30);
                                f2.add(title);
                            //label cekHarga
                            JLabel cekHargaBayar = new JLabel("Harga : "+harga);
                                cekHargaBayar.setSize(400, 20);
                                cekHargaBayar.setLocation(100, 60);
                                f2.add(cekHargaBayar);
                            //label cek UangPembeli
                            JLabel cekUangPembeli = new JLabel("Uang pembeli : "+uangPembeli);
                                cekUangPembeli.setSize(400, 20);
                                cekUangPembeli.setLocation(100, 90);
                                f2.add(cekUangPembeli);
                            //label cek kembalian
                            JLabel cekKembalian = new JLabel("kembalian : "+kembalian);
                                cekKembalian.setSize(400, 20);
                                cekKembalian.setLocation(100, 120);
                                f2.add(cekKembalian);
                            
                            //Tombol bayar setelah confrim
                            JButton confirm = new JButton("confirm");
                            confirm.setFont(new Font("Arial", Font.PLAIN, 15));
                            confirm.setSize(100, 20);
                            confirm.setLocation(100, 180);
                            confirm.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    f2.setVisible(false);
                                    
                                    JFrame konfirmasiUpdate = new JFrame("Confirmation");
                                    JFrame updateLagi = new JFrame("Another Update?");
                                    LocalDate now = LocalDate.now();
                                    java.sql.Date sqlDate = java.sql.Date.valueOf(now);

                                    if (JOptionPane.showConfirmDialog(konfirmasiUpdate, "confirm if you Want to Update", "Minimarket",
                                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                                        f2.setVisible(false);
                                        boolean statusDetail = c.insertDataDetailPenjualanTopUp(cekIdTopUp,cekNomorFakturTopUp,sqlDate,cekNomorTeleponPelanggan);
                                        boolean statusPenjualan = c.insertDataPenjualanTopUp(cekIdTopUp, cekNomorFakturTopUp, cekJenisPembayaran);
                                        if (statusDetail && statusPenjualan) {
                                            JOptionPane.showMessageDialog(null, "Bayar berhasil");
                                            if (JOptionPane.showConfirmDialog(updateLagi, "Insert Lagi ?", "Minimarket",
                                                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                                                new MenuDetailPenjualanTopUp();
                                            } else {
                                                //new MainMenuAdmin();
                                                new MenuDetailPenjualanTopUp();
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Bayar gagal");
                                            //new MainMenuAdmin();
                                        }
                                    } else {
                                        f2.setVisible(false);
                                        JOptionPane.showMessageDialog(null, "Bayar batal");
                                        new MenuDetailPenjualanTopUp();
                                    }
                                }
                            });
                            f2.add(confirm);
                                
                            //Tombol Cancel setelah confrim
                            JButton cancel = new JButton("Cancel");
                            cancel.setFont(new Font("Arial", Font.PLAIN, 15));
                            cancel.setSize(100, 20);
                            cancel.setLocation(240, 180);
                            cancel.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    f2.setVisible(false);
                                    new MenuDetailPenjualanTopUp();
                                }
                            });
                            f2.add(cancel);
                            f2.setVisible(true);
                        }else{
                            JOptionPane.showMessageDialog(null, "Uang anda tidak cukup!!!!");
                        }
                    }
                }
            );
            f.add(bayar);
        f.setVisible(true);
            
    }
}
