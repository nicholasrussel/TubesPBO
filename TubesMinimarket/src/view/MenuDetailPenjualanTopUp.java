/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.DetailPenjualanTopUp;
import controller.ControllerTopUp;
import java.sql.Date;
import java.time.LocalDate;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.JenisPembayaran;
import model.TopUp;


public class MenuDetailPenjualanTopUp {
    private JLabel title,Id_TopUp,Nomor_FakturTopUp,Tanggal_JualTopUp,nomor_TeleponPelanggan;
    private JTextField textNomor_FakturTopUp,textTanggal_JualTopUp,textNomor_TeleponPelanggan;
    private JButton confirm,lihatSemuaTransaksi;
    private JComboBox textId_TopUp,textJenisPembayaran;
    public MenuDetailPenjualanTopUp(){
        
        JFrame f = new JFrame();
        f.setTitle("Detail Penjualan Top Up ");
        f.setSize(800, 800);
        f.setResizable(false);
        f.setLayout(null);  
        f.setLocationRelativeTo(null);
    
        title = new JLabel(" Form Detail Penjualan Top Up ");
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        title.setSize(400, 20);
        title.setLocation(200, 30);
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
             
        Nomor_FakturTopUp = new JLabel("Nomor Faktur TopUp");
        Nomor_FakturTopUp.setFont(new Font("Arial", Font.PLAIN, 15));
        Nomor_FakturTopUp.setSize(200, 30);
        Nomor_FakturTopUp.setLocation(100, 90);
        f.add(Nomor_FakturTopUp);
        
        textNomor_FakturTopUp = new JTextField();
        textNomor_FakturTopUp.setFont(new Font("Arial", Font.PLAIN, 15));
        textNomor_FakturTopUp.setSize(200, 30);
        textNomor_FakturTopUp.setLocation(100, 120);
        f.add(textNomor_FakturTopUp);
        
        nomor_TeleponPelanggan = new JLabel("Nomor Telepon Pelanggan");
        nomor_TeleponPelanggan.setFont(new Font("Arial", Font.PLAIN, 15));
        nomor_TeleponPelanggan.setSize(200, 30);
        nomor_TeleponPelanggan.setLocation(100, 150);
        f.add(nomor_TeleponPelanggan);
        
        textNomor_TeleponPelanggan = new JTextField();
        textNomor_TeleponPelanggan.setFont(new Font("Arial", Font.PLAIN, 15));
        textNomor_TeleponPelanggan.setSize(200, 30);
        textNomor_TeleponPelanggan.setLocation(100, 180);
        f.add(textNomor_TeleponPelanggan);
        
//        ControllerTopUp c = new ControllerTopUp();
        ArrayList<JenisPembayaran> kategori = c.getAllNamaJenisPembayaran();
        String [] jenisP = new String[kategori.size()];
        for (int i = 0; i < kategori.size(); i++) {
            jenisP[i] = kategori.get(i).getNamaPembayaran();
        }

        textJenisPembayaran = new JComboBox(jenisP);
        f.add(textJenisPembayaran);
        textJenisPembayaran.setSize(200, 20);
        textJenisPembayaran.setLocation(100,210);
        
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
                JLabel title,Id_TopUp,Nomor_FakturTopUp,Tanggal_JualTopUp,nomor_TeleponPelanggan,Harga,jenisPembayaran,jenisTopUp;
                String cekIdTopUp = textId_TopUp.getSelectedItem().toString();
                String cekNomorFakturTopUp = textNomor_FakturTopUp.getText();
                double harga = ControllerTopUp.Harga(cekIdTopUp);
                LocalDate now = LocalDate.now();
                java.sql.Date sqlDate = java.sql.Date.valueOf(now);
                Date cekTanggalJualTopUp = sqlDate;
                String cekNomorTeleponPelanggan = textNomor_TeleponPelanggan.getText();
                String cekJenisPembayaran = textJenisPembayaran.getSelectedItem().toString();
                
                String cekJenisTopUp = c.getJenisTopUp(cekIdTopUp);
                
                
                JFrame f2 = new JFrame();
                f2.setTitle("Detail Penjualan Top Up ");
                f2.setSize(500, 500);
                f2.setResizable(false);
                f2.setLayout(null);  
                f2.setLocationRelativeTo(null);
                
                title = new JLabel(" Detail Penjualan Top Up ");
                title.setFont(new Font("Arial", Font.PLAIN, 20));
                title.setSize(400, 20);
                title.setLocation(100, 30);
                f2.add(title);
                
                Id_TopUp = new JLabel("ID TopUp : "+cekIdTopUp);
                Id_TopUp.setFont(new Font("Arial", Font.PLAIN, 15));
                Id_TopUp.setSize(500, 30);
                Id_TopUp.setLocation(100, 60);
                f2.add(Id_TopUp);
                
                Nomor_FakturTopUp = new JLabel("Nomor Faktur TopUp : "+cekNomorFakturTopUp);
                Nomor_FakturTopUp.setFont(new Font("Arial", Font.PLAIN, 15));
                Nomor_FakturTopUp.setSize(500, 30);
                Nomor_FakturTopUp.setLocation(100, 90);
                f2.add(Nomor_FakturTopUp);
                
                Tanggal_JualTopUp = new JLabel("Tanggal Jual TopUp : "+cekTanggalJualTopUp);
                Tanggal_JualTopUp.setFont(new Font("Arial", Font.PLAIN, 15));
                Tanggal_JualTopUp.setSize(500, 30);
                Tanggal_JualTopUp.setLocation(100, 120);
                f2.add(Tanggal_JualTopUp);
                
                nomor_TeleponPelanggan = new JLabel("Nomor Telepon Pelanggan : "+cekNomorTeleponPelanggan);
                nomor_TeleponPelanggan.setFont(new Font("Arial", Font.PLAIN, 15));
                nomor_TeleponPelanggan.setSize(500, 30);
                nomor_TeleponPelanggan.setLocation(100, 150);
                f2.add(nomor_TeleponPelanggan);
                
                jenisTopUp = new JLabel("Jenis TopUp : "+cekJenisTopUp);
                jenisTopUp.setFont(new Font("Arial", Font.PLAIN, 15));
                jenisTopUp.setSize(500, 30);
                jenisTopUp.setLocation(100, 180);
                f2.add(jenisTopUp);
                
                Harga = new JLabel("Harga : "+harga);
                Harga.setFont(new Font("Arial", Font.PLAIN, 15));
                Harga.setSize(500, 30);
                Harga.setLocation(100, 210);
                f2.add(Harga);
                
                jenisPembayaran = new JLabel("jenis pembayaran : "+cekJenisPembayaran);
                jenisPembayaran.setFont(new Font("Arial", Font.PLAIN, 15));
                jenisPembayaran.setSize(500, 30);
                jenisPembayaran.setLocation(100, 240);
                f2.add(jenisPembayaran);
                
                //tombol bayar setelah confrim 
                JButton insert = new JButton("Bayar");
                insert.setFont(new Font("Arial", Font.PLAIN, 15));
                insert.setSize(100, 20);
                insert.setLocation(240, 270);
                insert.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    f2.setVisible(false);
                    //mengecek jika bayar secara tunai dan ATM
                    if(cekJenisPembayaran.equals("Tunai")){
                         new BayarTunai(cekIdTopUp,cekNomorFakturTopUp,harga,cekNomorTeleponPelanggan,cekJenisPembayaran);
                    }else if(cekJenisPembayaran.equals("ATM")){
                         new BayarATM(cekIdTopUp,cekNomorFakturTopUp,harga,cekNomorTeleponPelanggan,cekJenisPembayaran);
                    }
                        
                        
//                        JFrame konfirmasiUpdate = new JFrame("Confirmation");
//                        JFrame updateLagi = new JFrame("Another Update?");
//                        ControllerTopUp c = new ControllerTopUp();
//                        LocalDate now = LocalDate.now();
//                        java.sql.Date sqlDate = java.sql.Date.valueOf(now);
//                        
//                        if (JOptionPane.showConfirmDialog(konfirmasiUpdate, "confirm if you Want to Update", "Minimarket",
//                                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
//                            f2.setVisible(false);
//                            boolean statusDetail = c.insertDataDetailPenjualanTopUp(cekIdTopUp,cekNomorFakturTopUp,sqlDate,cekNomorTeleponPelanggan);
//                            boolean statusPenjualan = c.insertDataPenjualanTopUp(cekIdTopUp, cekNomorFakturTopUp, cekJenisPembayaran);
//                            if (statusDetail && statusPenjualan) {
//                                JOptionPane.showMessageDialog(null, "update berhasil");
//                                if (JOptionPane.showConfirmDialog(updateLagi, "Insert Lagi ?", "Minimarket",
//                                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
//                                    f.setVisible(true);
//                                } else {
//                                    //new MainMenuAdmin();
//                                    f.setVisible(true);
//                                }
//                            } else {
//                                JOptionPane.showMessageDialog(null, "update gagal");
//                                //new MainMenuAdmin();
//                            }
//                        } else {
//                            f2.setVisible(false);
//                            JOptionPane.showMessageDialog(null, "update batal");
//                            //new MainMenuAdmin();
//                        }
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
        
        f.add(lihatSemuaDetail);
        
        //tombol lihat semua Penjualan TopUp
        JButton lihatSemuaPenjualan = new JButton("Lihat semua Penjualan TopUp");
        lihatSemuaPenjualan.setFont(new Font("Arial", Font.PLAIN, 13));
        lihatSemuaPenjualan.setSize(250, 30);
        lihatSemuaPenjualan.setLocation(300, 300);
        lihatSemuaPenjualan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new LihatPenjualanTopUp();
            }
        });
        
        JButton exit = new JButton("Cancel");
                exit.setFont(new Font("Arial", Font.PLAIN, 15));
                exit.setSize(100, 20);
                exit.setLocation(100, 330);
                exit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        f.setVisible(false);
                        new MainMenuKasir();
                    }
                });
                f.add(exit);
        
        f.add(lihatSemuaPenjualan);
        f.setVisible(true);
        
        
        
    }
}
