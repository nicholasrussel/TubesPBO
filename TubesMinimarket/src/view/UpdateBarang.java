/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.Barang;

/**
 *
 * @author HP
 */
public class UpdateBarang {
    private JFrame f, f2, konfirmasiUpdate, updateLagi;
    private JLabel title, kodeProduk, name, stok, harga, persenDiskon;
    private JTextField tKodeProduk, tname, tStok, tHarga, tPersenDiskon;
    private JButton sub, reset, cancel, insert;

    public UpdateBarang() {
        f = new JFrame();
        f.setTitle("Update Barang");
        f.setSize(500, 500);
        f.setResizable(false);
        f.setLayout(null);
        f.setLocationRelativeTo(null);

        title = new JLabel("Update Barang Form");
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        title.setSize(200, 30);
        title.setLocation(50, 30);
        f.add(title);

        kodeProduk = new JLabel("Kode Produk");
        kodeProduk.setFont(new Font("Arial", Font.PLAIN, 15));
        kodeProduk.setSize(300, 20);
        kodeProduk.setLocation(20, 100);
        f.add(kodeProduk);

        tKodeProduk = new JTextField();
        tKodeProduk.setFont(new Font("Arial", Font.PLAIN, 15));
        tKodeProduk.setSize(200, 20);
        tKodeProduk.setLocation(150, 100);
        f.add(tKodeProduk);

        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 15));
        name.setSize(300, 20);
        name.setLocation(20, 150);
        f.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(200, 20);
        tname.setLocation(150, 150);
        f.add(tname);

        stok = new JLabel("Stok");
        stok.setFont(new Font("Arial", Font.PLAIN, 15));
        stok.setSize(300, 20);
        stok.setLocation(20, 200);
        f.add(stok);

        tStok = new JTextField();
        tStok.setFont(new Font("Arial", Font.PLAIN, 15));
        tStok.setSize(200, 20);
        tStok.setLocation(150, 200);
        f.add(tStok);

        harga = new JLabel("Harga");
        harga.setFont(new Font("Arial", Font.PLAIN, 15));
        harga.setSize(300, 20);
        harga.setLocation(20, 250);
        f.add(harga);

        tHarga = new JTextField();
        tHarga.setFont(new Font("Arial", Font.PLAIN, 15));
        tHarga.setSize(200, 20);
        tHarga.setLocation(150, 250);
        f.add(tHarga);

        persenDiskon = new JLabel("Persen Diskon");
        persenDiskon.setFont(new Font("Arial", Font.PLAIN, 15));
        persenDiskon.setSize(300, 20);
        persenDiskon.setLocation(20, 300);
        f.add(persenDiskon);

        tPersenDiskon = new JTextField();
        tPersenDiskon.setFont(new Font("Arial", Font.PLAIN, 15));
        tPersenDiskon.setSize(200, 75);
        tPersenDiskon.setLocation(150, 300);
        f.add(tPersenDiskon);

        sub = new JButton("Update");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(20, 400);
        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cekKodeProduk = tKodeProduk.getText();
                String stringHarga = tHarga.getText();
                String cekNama = tname.getText();
                String cekStok = tStok.getText();
                String cekPersenDiskon = tPersenDiskon.getText();
                if (cekKodeProduk.trim().isEmpty() || stringHarga.trim().isEmpty() || cekNama.trim().isEmpty() || cekStok.trim().isEmpty()
                        || cekPersenDiskon.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Isi data harus lengkap!");
                } else {
                    int harga2 = Integer.parseInt(stringHarga);
                    int stok2 = Integer.parseInt(cekStok);
                    float persen = Float.parseFloat(cekPersenDiskon);
                    f.setVisible(false);
                    f2 = new JFrame();
                    f2.setTitle("Check Again");
                    f2.setSize(400, 400);
                    f2.setResizable(false);
                    f2.setLocationRelativeTo(null);
                    f2.setLayout(null);

                    title = new JLabel("Confirmation Detail");
                    title.setFont(new Font("Arial", Font.PLAIN, 20));
                    title.setSize(300, 20);
                    title.setLocation(50, 10);
                    f2.add(title);

                    kodeProduk = new JLabel("ID : " + cekKodeProduk);
                    kodeProduk.setFont(new Font("Arial", Font.PLAIN, 15));
                    kodeProduk.setSize(300, 20);
                    kodeProduk.setLocation(50, 50);
                    f2.add(kodeProduk);

                    name = new JLabel("Nama : " + cekNama);
                    name.setFont(new Font("Arial", Font.PLAIN, 15));
                    name.setSize(300, 20);
                    name.setLocation(50, 100);
                    f2.add(name);

                    stok = new JLabel("Stok: " + stok2);
                    stok.setFont(new Font("Arial", Font.PLAIN, 15));
                    stok.setSize(300, 20);
                    stok.setLocation(50, 150);
                    f2.add(stok);

                    harga = new JLabel("Alamat : " + harga2);
                    harga.setFont(new Font("Arial", Font.PLAIN, 15));
                    harga.setSize(300, 20);
                    harga.setLocation(50, 200);
                    f2.add(harga);

                    persenDiskon = new JLabel("Gaji : " + persen);
                    persenDiskon.setFont(new Font("Arial", Font.PLAIN, 15));
                    persenDiskon.setSize(300, 20);
                    persenDiskon.setLocation(50, 250);
                    f2.add(persenDiskon);
                    
                    insert = new JButton("Insert");
                    insert.setFont(new Font("Arial", Font.PLAIN, 15));
                    insert.setSize(100, 20);
                    insert.setLocation(50, 300);
                    insert.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            f.setVisible(false);
                            konfirmasiUpdate = new JFrame("Confirmation");
                            updateLagi = new JFrame("Another Update?");
                            Controller c = new Controller();

                            if (JOptionPane.showConfirmDialog(konfirmasiUpdate, "confirm if you Want to Update", "Minimarket",
                                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                                f2.setVisible(false);
                                boolean status = c.updateBarang(cekKodeProduk, cekNama, harga2, stok2, persen);
                                if (status) {
                                    JOptionPane.showMessageDialog(null, "update berhasil");
                                    if (JOptionPane.showConfirmDialog(updateLagi, "Update lagi?", "Minimarket",
                                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                                        f.setVisible(true);
                                    } else {
                                        new MainMenuAdmin();
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "update gagal");
                                    new MainMenuAdmin();
                                }
                            } else {
                                f2.setVisible(false);
                                JOptionPane.showMessageDialog(null, "update batal");
                                new MainMenuAdmin();
                            }
                        }
                    });
                    f2.add(insert);
                    
                    cancel = new JButton("Cancel");
                    cancel.setFont(new Font("Arial", Font.PLAIN, 15));
                    cancel.setSize(100, 20);
                    cancel.setLocation(160, 300);
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

            }
        });
        f.add(sub);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(130, 400);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String def = "";
                kodeProduk.setText(def);
                tname.setText(def);
                stok.setText(def);
                harga.setText(def);
                persenDiskon.setText(def);
            }
        });
        f.add(reset);
        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Arial", Font.PLAIN, 15));
        cancel.setSize(100, 20);
        cancel.setLocation(240, 400);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new MainMenuAdmin();
            }
        });
        f.add(cancel);
        f.setVisible(true);
    }
}
