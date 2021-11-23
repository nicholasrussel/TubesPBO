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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ASUS
 */
public class MenuTopUp {
    private JLabel title,Id_TopUp,Harga_TopUp;
    private JTextField textId_TopUp,textHarga_TopUp;
    private JButton confirm,lihatSemuaTransaksi;
    private JComboBox textJenisPembayaran;
    public MenuTopUp(){
        JFrame f = new JFrame();
        f.setTitle("Detail Penjualan Top Up ");
        f.setSize(800, 800);
        f.setResizable(false);
        f.setLayout(null);  
        f.setLocationRelativeTo(null);
    
        title = new JLabel(" Form insert Top Up ");
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        title.setSize(400, 20);
        title.setLocation(300, 30);
        f.add(title);
        
        //insert ID  
        Id_TopUp = new JLabel("Id Top Up : ");
        Id_TopUp.setFont(new Font("Arial", Font.PLAIN, 20));
        Id_TopUp.setSize(200, 20);
        Id_TopUp.setLocation(200, 60);
        f.add(Id_TopUp);
        textId_TopUp = new JTextField();
        textId_TopUp.setFont(new Font("Arial", Font.PLAIN, 20));
        textId_TopUp.setSize(200, 20);
        textId_TopUp.setLocation(200, 90);
        f.add(textId_TopUp);
        
        //insert Harga  
        Harga_TopUp = new JLabel("Harga Top Up : ");
        Harga_TopUp.setFont(new Font("Arial", Font.PLAIN, 20));
        Harga_TopUp.setSize(200, 20);
        Harga_TopUp.setLocation(200, 120);
        f.add(Harga_TopUp);
        textHarga_TopUp = new JTextField();
        textHarga_TopUp.setFont(new Font("Arial", Font.PLAIN, 20));
        textHarga_TopUp.setSize(200, 20);
        textHarga_TopUp.setLocation(200, 150);
        f.add(textHarga_TopUp);
        
        //Tombol Confrim 
        confirm = new JButton("Confirm");
        confirm.setFont(new Font("Arial", Font.PLAIN, 15));
        confirm.setSize(200, 30);
        confirm.setLocation(100, 270);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                ControllerTopUp c = new ControllerTopUp();
                JLabel title,Id_TopUp,jenisTopUp,HargaTopUp,pajakTopUp;
                String cekIdTopUp = textId_TopUp.getText();
                double cekHargaTopUp = Double.parseDouble(textHarga_TopUp.getText());
                float cekPajakTopUp = (float) 0.1;
                String cekJenisTopUp = c.getJenisTopUp(cekIdTopUp);
                
                
                JFrame f2 = new JFrame();
                f2.setTitle("Detail Top Up ");
                f2.setSize(500, 500);
                f2.setResizable(false);
                f2.setLayout(null);  
                f2.setLocationRelativeTo(null);
                
                title = new JLabel(" Detail Top Up ");
                title.setFont(new Font("Arial", Font.PLAIN, 20));
                title.setSize(400, 20);
                title.setLocation(300, 30);
                f2.add(title);
                
                Id_TopUp = new JLabel("ID TopUp : "+cekIdTopUp);
                Id_TopUp.setFont(new Font("Arial", Font.PLAIN, 15));
                Id_TopUp.setSize(300, 30);
                Id_TopUp.setLocation(100, 60);
                f2.add(Id_TopUp);
                
                pajakTopUp = new JLabel("Pajak TopUp : "+cekPajakTopUp);
                pajakTopUp.setFont(new Font("Arial", Font.PLAIN, 15));
                pajakTopUp.setSize(500, 30);
                pajakTopUp.setLocation(100, 90);
                f2.add(pajakTopUp);
                
                HargaTopUp = new JLabel("Harga TopUp : "+cekHargaTopUp);
                HargaTopUp.setFont(new Font("Arial", Font.PLAIN, 15));
                HargaTopUp.setSize(500, 30);
                HargaTopUp.setLocation(100, 120);
                f2.add(HargaTopUp);
                
                
                jenisTopUp = new JLabel("Jenis TopUp : "+cekJenisTopUp);
                jenisTopUp.setFont(new Font("Arial", Font.PLAIN, 15));
                jenisTopUp.setSize(500, 30);
                jenisTopUp.setLocation(100, 150);
                f2.add(jenisTopUp);
                
                
                //tombol bayar setelah confrim 
                JButton insert = new JButton("Bayar");
                insert.setFont(new Font("Arial", Font.PLAIN, 15));
                insert.setSize(100, 20);
                insert.setLocation(240, 240);
                insert.addActionListener(new ActionListener() {
                    @Override
                   public void actionPerformed(ActionEvent e) {

                        f.setVisible(false);
                        JFrame konfirmasiUpdate = new JFrame("Confirmation");
                        JFrame updateLagi = new JFrame("Another Update?");
                        ControllerTopUp c = new ControllerTopUp();
//                        LocalDate now = LocalDate.now();
//                        java.sql.Date sqlDate = java.sql.Date.valueOf(now);
                        
                        if (JOptionPane.showConfirmDialog(konfirmasiUpdate, "confirm if you Want to Update", "Minimarket",
                                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            f2.setVisible(false);
                            boolean status = c.insertDataTopUp(cekIdTopUp,cekPajakTopUp,cekHargaTopUp,cekJenisTopUp);
                            //boolean statusPenjualan = c.insertDataPenjualanTopUp(cekIdTopUp, cekNomorFakturTopUp, cekJenisPembayaran);
                            if (status) {
                                new pesan.PesanBerhasil().pesanBerhasilUpdate();
                                if (JOptionPane.showConfirmDialog(updateLagi, "Update lagi?", "Minimarket",
                                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                                    f.setVisible(true);
                                } else {
                                    //new MainMenuAdmin();
                                }
                            } else {
                                new pesan.PesanGagal().pesanGagalUpdate();
                                //new MainMenuAdmin();
                            }
                        } else {
                            f2.setVisible(false);
                            new pesan.PesanBatal().pesanBatalUpdate();
                            //new MainMenuAdmin();
                        }
                    }
                });
                f2.add(insert);
                
                //Tombol Cancel setelah confrim
                JButton cancel = new JButton("Cancel");
                cancel.setFont(new Font("Arial", Font.PLAIN, 15));
                cancel.setSize(100, 20);
                cancel.setLocation(100, 240);
                cancel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        f2.setVisible(false);
                        f.setVisible(true);
                    }
                });
                f2.add(cancel);
                
                
                f2.setVisible(true);
            }

            
        });    
        f.add(confirm);
        
        //tombol lihat semua detailPenjualan TopUp
        JButton lihatSemuaDetail = new JButton("Lihat semua Detail Penjualan TopUp");
        lihatSemuaDetail.setFont(new Font("Arial", Font.PLAIN, 13));
        lihatSemuaDetail.setSize(250, 30);
        lihatSemuaDetail.setLocation(300, 270);
        lihatSemuaDetail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new LihatDetailPenjualanTopUp();
            }
        });
                
                f.setVisible(true);
    }
    public static void main(String[] args) {
        new MenuTopUp();
    }
}
