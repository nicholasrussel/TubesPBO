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
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.TopUp;

/**
 *
 * @author ASUS
 */
public class UpdateTopUp {
     private JLabel title;
    //private JTextField ;
    private JButton confirm,lihatSemuaTransaksi;
    private JComboBox textId_TopUp,textJenisPembayaran,textHarga_TopUp;
    
    public UpdateTopUp(){
        JFrame f = new JFrame();
        f.setTitle("Detail Penjualan Top Up ");
        f.setSize(800, 800);
        f.setResizable(false);
        f.setLayout(null);  
        f.setLocationRelativeTo(null);
    
        title = new JLabel(" Pilih Update Top Up berdasarkan Id ");
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        title.setSize(400, 20);
        title.setLocation(300, 30);
        f.add(title);
        
         ControllerTopUp c = new ControllerTopUp();
        ArrayList<TopUp> topUp = c.getIdTopUpHargaTopUp();
        String [] jenis = new String[topUp.size()];
        for (int i = 0; i < topUp.size(); i++) {
            jenis[i] = topUp.get(i).getId_TopUp();           
        }
        textId_TopUp = new JComboBox(jenis);
        f.add(textId_TopUp);
        textId_TopUp.setSize(200, 30);
        textId_TopUp.setLocation(100,60);
        
        
        
        //Tombol Confrim 
        confirm = new JButton("Confirm");
        confirm.setFont(new Font("Arial", Font.PLAIN, 15));
        confirm.setSize(200, 30);
        confirm.setLocation(100, 150);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                
                JFrame f2 = new JFrame();
                f2.setTitle("Detail Top Up ");
                f2.setSize(800, 800);
                f2.setResizable(false);
                f2.setLayout(null);  
                f2.setLocationRelativeTo(null);
                
                title = new JLabel(" Top Up ");
                title.setFont(new Font("Arial", Font.PLAIN, 20));
                title.setSize(400, 20);
                title.setLocation(300, 30);
                f2.add(title);
                
                float pajakTopUp = 0;
                double harga = 0;
                String namaPajakTopUp = null;
                String namaHarga = null;
                String namaTypeTopUp = null;
                String cekIdTopUp = textId_TopUp.getSelectedItem().toString();
                for (int i = 0; i < topUp.size(); i++) {
                    if(cekIdTopUp.equals(topUp.get(i).getId_TopUp())){
                        pajakTopUp = topUp.get(i).getPajak_TopUp();
                        harga = topUp.get(i).getHarga_TopUp();
                        namaPajakTopUp = String.valueOf(pajakTopUp);
                        namaHarga = String.valueOf(harga);
                        namaTypeTopUp = topUp.get(i).getType_TopUp();
                        JLabel pajakTopUpSebelumUpdate = new JLabel("Pajak : "+namaPajakTopUp);
                        f2.add(pajakTopUpSebelumUpdate);
                        pajakTopUpSebelumUpdate.setSize(200, 30);
                        pajakTopUpSebelumUpdate.setLocation(100,90);
                        JLabel hargaTopUpSebelumUpdate = new JLabel("harga  : "+namaHarga);
                        f2.add(hargaTopUpSebelumUpdate);
                        hargaTopUpSebelumUpdate.setSize(200, 30);
                        hargaTopUpSebelumUpdate.setLocation(100,120);
                        JLabel typeTopUp = new JLabel("typeTopUp  : "+namaTypeTopUp);
                        f2.add(typeTopUp);
                        typeTopUp.setSize(200, 30);
                        typeTopUp.setLocation(100,150);
                    }
                } 
                //input harga topup baru
                JLabel hargaTopUpSetelahUpdate = new JLabel("harga TopUp baru");
                    f2.add(hargaTopUpSetelahUpdate);
                    hargaTopUpSetelahUpdate.setSize(200, 30);
                    hargaTopUpSetelahUpdate.setLocation(100,180);
                JTextField textHargaTopUpSetelahUpdate = new JTextField();
                    f2.add(textHargaTopUpSetelahUpdate);
                    textHargaTopUpSetelahUpdate.setSize(200, 30);
                    textHargaTopUpSetelahUpdate.setLocation(100,210);
                
                
                 
                //tombol update setelah confrim 
                JButton insert = new JButton("udpate");
                insert.setFont(new Font("Arial", Font.PLAIN, 15));
                insert.setSize(100, 20);
                insert.setLocation(240, 270);
                insert.addActionListener(new ActionListener() {
                    @Override
                   public void actionPerformed(ActionEvent e) {
                       double cekHargaTopUp = Double.parseDouble(textHargaTopUpSetelahUpdate.getText());
                       f.setVisible(false);
                      // double cekHargaTopUp = Double.parseDouble(textHargaTopUpSetelahUpdate.getText());
                        JFrame konfirmasiUpdate = new JFrame("Confirmation");
                        JFrame updateLagi = new JFrame("Another Update?");
                        ControllerTopUp c = new ControllerTopUp();

                        
                        if (JOptionPane.showConfirmDialog(konfirmasiUpdate, "confirm if you Want to Update", "Minimarket",
                                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            f2.setVisible(false);
                            boolean status = c.updateDataTopUp(cekIdTopUp, cekHargaTopUp);
                            
                            if (status) {
                                JOptionPane.showMessageDialog(null, "update berhasil");
                                if (JOptionPane.showConfirmDialog(updateLagi, "Update lagi?", "Minimarket",
                                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                                    f.setVisible(true);
                                } else {
                                    //new MainMenuAdmin();
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "update gagal");
                                //new MainMenuAdmin();
                            }
                        } else {
                            f2.setVisible(false);
                            JOptionPane.showMessageDialog(null, "update batal");
                            //new MainMenuAdmin();
                        }
                   }
                });
                f2.add(insert);
                
                //Tombol Cancel setelah confrim
                JButton cancel = new JButton("Cancel");
                cancel.setFont(new Font("Arial", Font.PLAIN, 15));
                cancel.setSize(100, 20);
                cancel.setLocation(100, 270);
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
        
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new UpdateTopUp();
    }
}
