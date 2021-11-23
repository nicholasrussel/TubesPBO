/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerTopUp;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.DetailPenjualanTopUp;

/**
 *
 * @author ASUS
 */
public class BayarATM {
    public BayarATM(String cekIdTopUp,String cekNomorFakturTopUp,double harga,String cekNomorTeleponPelanggan,String cekJenisPembayaran){
        JFrame f = new JFrame();
        f.setTitle("Detail Penjualan Top Up ");
        f.setSize(800, 800);
        f.setResizable(false);
        f.setLayout(null);  
        f.setLocationRelativeTo(null);
        String noRek = "12345";
        String passRek = "123";
        JLabel title = new JLabel("Menu Bayar ATM");
            title.setFont(new Font("Arial", Font.PLAIN, 20));
            title.setSize(400, 20);
            title.setLocation(300, 30);
            f.add(title);
        
        JLabel hargaBayar = new JLabel("harga : "+harga);
            hargaBayar.setSize(400, 20);
            hargaBayar.setLocation(100, 60);
            f.add(hargaBayar);
        
        JLabel nomorRekening = new JLabel("Input nomor rekening");
            nomorRekening.setSize(400, 20);
            nomorRekening.setLocation(100, 90);
            f.add(nomorRekening);
        JTextField textNomorRekening = new JTextField();
            textNomorRekening.setSize(200, 30);
            textNomorRekening.setLocation(100, 120);
            f.add(textNomorRekening);
        
        JLabel passRekening = new JLabel("Input pass Rekening");
            passRekening.setSize(400, 20);
            passRekening.setLocation(100, 150);
            f.add(passRekening);
        JPasswordField textPassRekening = new JPasswordField();
            textPassRekening.setSize(200, 30);
            textPassRekening.setLocation(100, 180);
            f.add(textPassRekening);
            
        JButton bayar = new JButton("Bayar");
            bayar.setSize(200, 30);
            bayar.setLocation(100, 240);
            bayar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //variable
                            ControllerTopUp c = new ControllerTopUp();
                            //double uangPembeli = Double.parseDouble(textUangPembeli.getText());
                            //double kembalian = c.getKembalian(harga,uangPembeli);
                            String cekNoRekening = textNomorRekening.getText();
                            String cekPassRekening = textPassRekening.getText();
                            
                        if(cekNoRekening.equals(noRek) && cekPassRekening.equals(passRek)){
                            f.setVisible(false);

                            JFrame f2 = new JFrame();
                            f2.setTitle("Detail Top Up ");
                            f2.setSize(800, 800);
                            f2.setResizable(false);
                            f2.setLayout(null);  
                            f2.setLocationRelativeTo(null);

                            
                            JLabel title = new JLabel("Menu Bayar ATM");
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
                            JLabel noRekening = new JLabel("Nomor Rekening : "+cekNoRekening);
                                noRekening.setSize(400, 20);
                                noRekening.setLocation(100, 90);
                                f2.add(noRekening);
                            
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
                                            new MenuDetailPenjualanTopUp();
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
                            JOptionPane.showMessageDialog(null, "Rekening/password anda salah!!!!");
                        }
                    }
                }
            );
            f.add(bayar);
        f.setVisible(true);
            
    }
}
