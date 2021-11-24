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
import java.util.Properties;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import model.Barang;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
/**
 *
 * @author HP
 */
public class InputBarang {
    private JFrame f, f2, konfirmasiUpdate, updateLagi;
    private JLabel title, kodeProduk, name, stok, harga, persenDiskon , tanggalKadaluarsa, kategori;
    private JTextField tKodeProduk, tname, tStok, tHarga, tPersenDiskon, tKategori;
    private JButton sub, reset, cancel, insert;
    private JRadioButton konsumsi, nonKonsumsi;
    private ButtonGroup gengp;

    public InputBarang() {
        f = new JFrame();
        f.setTitle("Input Data Barang");
        f.setSize(550, 600);
        f.setResizable(false);
        f.setLayout(null);
        f.setLocationRelativeTo(null);

        title = new JLabel("Input Data Barang Form");
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        title.setSize(500, 30);
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
        tPersenDiskon.setSize(200, 20);
        tPersenDiskon.setLocation(150, 300);
        f.add(tPersenDiskon);
        
        tanggalKadaluarsa = new JLabel("Tanggal Kadaluarsa");
        tanggalKadaluarsa.setFont(new Font("Arial", Font.PLAIN, 15));
        tanggalKadaluarsa.setSize(300, 20);
        tanggalKadaluarsa.setLocation(20, 350);
        f.add(tanggalKadaluarsa);

        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new controller.DateFormatter());
        datePicker.setBounds(180, 350, 200, 50);
        f.add(datePicker);
        
        kategori = new JLabel("Kategori");
        kategori.setFont(new Font("Arial", Font.PLAIN, 15));
        kategori.setSize(300, 20);
        kategori.setLocation(20, 400);
        f.add(kategori);

        konsumsi = new JRadioButton("Konsumsi");
        konsumsi.setFont(new Font("Arial", Font.PLAIN, 15));
        konsumsi.setSelected(false);
        konsumsi.setSize(100, 20);
        konsumsi.setLocation(150, 400);
        f.add(konsumsi);
        
        nonKonsumsi = new JRadioButton("Non Konsumsi");
        nonKonsumsi.setFont(new Font("Arial", Font.PLAIN, 15));
        nonKonsumsi.setSelected(true);
        nonKonsumsi.setSize(150, 20);
        nonKonsumsi.setLocation(250, 400);
        f.add(nonKonsumsi);
        
        gengp = new ButtonGroup();
        gengp.add(konsumsi);
        gengp.add(nonKonsumsi);
        
        sub = new JButton("Insert");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(20, 500);
        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cekKodeProduk = tKodeProduk.getText();
                String stringHarga = tHarga.getText();
                String cekNama = tname.getText();
                String cekStok = tStok.getText();
                String cekPersenDiskon = tPersenDiskon.getText();
                String hari = String.valueOf(datePicker.getModel().getDay());
                String bulan = String.valueOf(datePicker.getModel().getMonth());
                String tahun = String.valueOf(datePicker.getModel().getYear());
                String tanggalKadaluarsa2 = hari + "-" + bulan + "-" + tahun;
                String cekKategori = "";
                if (konsumsi.isSelected()) {
                    cekKategori = konsumsi.getText();
                } else if (nonKonsumsi.isSelected()) {
                    cekKategori = nonKonsumsi.getText();
                }
                if (cekKodeProduk.trim().isEmpty() || stringHarga.trim().isEmpty() || cekNama.trim().isEmpty() || cekStok.trim().isEmpty()
                        || cekPersenDiskon.trim().isEmpty() || tanggalKadaluarsa2.trim().isEmpty() || cekKategori.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Isi data harus lengkap!");
                } else {
                    int harga2 = Integer.parseInt(stringHarga);
                    int stok2 = Integer.parseInt(cekStok);
                    float persen = Float.parseFloat(cekPersenDiskon);
                    f.setVisible(false);
                    f2 = new JFrame();
                    f2.setTitle("Check Again");
                    f2.setSize(400, 600);
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

                    harga = new JLabel("Harga : " + harga2);
                    harga.setFont(new Font("Arial", Font.PLAIN, 15));
                    harga.setSize(300, 20);
                    harga.setLocation(50, 200);
                    f2.add(harga);

                    persenDiskon = new JLabel("Persen diskon : " + persen);
                    persenDiskon.setFont(new Font("Arial", Font.PLAIN, 15));
                    persenDiskon.setSize(300, 20);
                    persenDiskon.setLocation(50, 250);
                    f2.add(persenDiskon);
                    
                    tanggalKadaluarsa = new JLabel("Tanggal kadaluarsa : " + tanggalKadaluarsa2);
                    tanggalKadaluarsa.setFont(new Font("Arial", Font.PLAIN, 15));
                    tanggalKadaluarsa.setSize(300, 50);
                    tanggalKadaluarsa.setLocation(50, 300);
                    f2.add(tanggalKadaluarsa);
                    
                    kategori = new JLabel("Kategori : " + cekKategori);
                    kategori.setFont(new Font("Arial", Font.PLAIN, 15));
                    kategori.setSize(300, 50);
                    kategori.setLocation(50, 350);
                    f2.add(kategori);
                    
                    String kategoriFinal = cekKategori;
                    
                    insert = new JButton("Insert");
                    insert.setFont(new Font("Arial", Font.PLAIN, 15));
                    insert.setSize(100, 20);
                    insert.setLocation(50, 400);
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
                                
                                Barang barang = new Barang ();
                                barang.setNamaBarang(cekNama);
                                barang.setHargaBarang(harga2);
                                barang.setKodeBarang(cekKodeProduk);
                                barang.setKarduluasaBarang(tanggalKadaluarsa2);
                                barang.setPersenDiskon(persen);
                                barang.setKategori(kategoriFinal);
                                barang.setStokBarang(stok2);
                                boolean status = c.insertBarang(barang);
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
                    cancel.setLocation(160, 400);
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
        reset.setLocation(130, 500);
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
        cancel.setLocation(240, 500);
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
