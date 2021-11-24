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
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.TopUp;

/**
 *
 * @author ASUS
 */
public class DeleteTopUp {

    private JLabel title;
    //private JTextField ;
    private JButton confirm, lihatSemuaTransaksi;
    private JComboBox textId_TopUp, textJenisPembayaran, textHarga_TopUp;

    public DeleteTopUp() {
        JFrame f = new JFrame();
        f.setTitle("Delete Top Up ");
        f.setSize(400, 300);
        f.setResizable(false);
        f.setLayout(null);
        f.setLocationRelativeTo(null);

        title = new JLabel(" Delete Top Up");
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        title.setSize(200, 20);
        title.setLocation(100, 30);
        f.add(title);

        ControllerTopUp c = new ControllerTopUp();
        ArrayList<TopUp> topUp = c.getIdTopUpHargaTopUp();
        String[] jenis = new String[topUp.size()];
        for (int i = 0; i < topUp.size(); i++) {
            jenis[i] = topUp.get(i).getId_TopUp();
        }
        textId_TopUp = new JComboBox(jenis);
        f.add(textId_TopUp);
        textId_TopUp.setSize(200, 30);
        textId_TopUp.setLocation(70, 60);

        //Tombol Confrim 
        confirm = new JButton("Confirm");
        confirm.setFont(new Font("Arial", Font.PLAIN, 15));
        confirm.setSize(100, 30);
        confirm.setLocation(70, 150);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);

                JFrame f2 = new JFrame();
                f2.setTitle("Delete Top Up ");
                f2.setSize(400, 400);
                f2.setResizable(false);
                f2.setLayout(null);
                f2.setLocationRelativeTo(null);

                title = new JLabel(" Delete Top Up ");
                title.setFont(new Font("Arial", Font.PLAIN, 20));
                title.setSize(220, 20);
                title.setLocation(130, 30);
                f2.add(title);

                float pajakTopUp = 0;
                double harga = 0;
                String namaPajakTopUp = null;
                String namaHarga = null;
                String nampungNamaTypeTopUp = null;
                String cekIdTopUp = textId_TopUp.getSelectedItem().toString();
                for (int i = 0; i < topUp.size(); i++) {
                    if (cekIdTopUp.equals(topUp.get(i).getId_TopUp())) {
                        pajakTopUp = topUp.get(i).getPajak_TopUp();
                        harga = topUp.get(i).getHarga_TopUp();
                        namaPajakTopUp = String.valueOf(pajakTopUp);
                        namaHarga = String.valueOf(harga);
                        nampungNamaTypeTopUp = topUp.get(i).getType_TopUp();
                        JLabel pajakTopUpSebelumUpdate = new JLabel("Pajak : " + namaPajakTopUp);
                        f2.add(pajakTopUpSebelumUpdate);
                        pajakTopUpSebelumUpdate.setSize(200, 30);
                        pajakTopUpSebelumUpdate.setLocation(100, 90);
                        JLabel hargaTopUpSebelumUpdate = new JLabel("harga  : " + namaHarga);
                        f2.add(hargaTopUpSebelumUpdate);
                        hargaTopUpSebelumUpdate.setSize(200, 30);
                        hargaTopUpSebelumUpdate.setLocation(100, 120);
                        JLabel typeTopUp = new JLabel("typeTopUp  : " + nampungNamaTypeTopUp);
                        f2.add(typeTopUp);
                        typeTopUp.setSize(200, 30);
                        typeTopUp.setLocation(100, 150);
                    }
                }
                double cekHargaTopUp = Double.parseDouble(namaHarga);
                float cekPajakTopUp = Float.parseFloat(namaPajakTopUp);
                String typeTopUp = nampungNamaTypeTopUp;

                //tombol bayar setelah confrim 
                JButton insert = new JButton("Delete");
                insert.setFont(new Font("Arial", Font.PLAIN, 15));
                insert.setSize(100, 20);
                insert.setLocation(240, 270);
                insert.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        f.setVisible(false);
                        JFrame konfirmasiUpdate = new JFrame("Confirmation");
                        JFrame updateLagi = new JFrame("Another Update?");
                        ControllerTopUp c = new ControllerTopUp();

                        if (JOptionPane.showConfirmDialog(konfirmasiUpdate, "confirm if you Want to Delete", "Minimarket",
                                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            f2.setVisible(false);
                            boolean status = c.deleteDataTopUp(cekIdTopUp);

                            if (status) {
                                JOptionPane.showMessageDialog(null, "Delete berhasil");
                                if (JOptionPane.showConfirmDialog(updateLagi, "Delete lagi?", "Minimarket",
                                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                                    f.setVisible(true);
                                } else {
                                    //new MainMenuAdmin();
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Delete gagal");
                                //new MainMenuAdmin();
                            }
                        } else {
                            f2.setVisible(false);
                            JOptionPane.showMessageDialog(null, "Delete batal");
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
        
        JButton exit = new JButton("Cancel");
        exit.setFont(new Font("Arial", Font.PLAIN, 15));
        exit.setSize(100, 30);
        exit.setLocation(170, 150);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
            }
        });
        f.add(exit);
        f.setVisible(true);

    }
}
