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

/**
 *
 * @author Nicholas Russel
 */
public class UpdateDataKasir {
    private JFrame f,f2,konfirmasiUpdate,updateLagi;
    private JLabel title, id, name, mno, alamat, gaji;
    private JTextField tid, tname, tmno, tgaji;
    private JButton sub, reset, cancel,insert;
    private JTextArea talamat;

    public UpdateDataKasir() {
        new LihatKasir(0);
        f = new JFrame();
        f.setTitle("Update Kasir");
        f.setSize(500, 500);
        f.setResizable(false);
        f.setLayout(null);
        f.setLocationRelativeTo(null);

        title = new JLabel("Update Kasir Form");
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        title.setSize(200, 30);
        title.setLocation(50, 30);
        f.add(title);

        id = new JLabel("ID");
        id.setFont(new Font("Arial", Font.PLAIN, 15));
        id.setSize(300, 20);
        id.setLocation(20, 100);
        f.add(id);

        tid = new JTextField();
        tid.setFont(new Font("Arial", Font.PLAIN, 15));
        tid.setSize(200, 20);
        tid.setLocation(150, 100);
        f.add(tid);

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

        mno = new JLabel("Nomor Telepon");
        mno.setFont(new Font("Arial", Font.PLAIN, 15));
        mno.setSize(300, 20);
        mno.setLocation(20, 200);
        f.add(mno);

        tmno = new JTextField();
        tmno.setFont(new Font("Arial", Font.PLAIN, 15));
        tmno.setSize(200, 20);
        tmno.setLocation(150, 200);
        f.add(tmno);

        gaji = new JLabel("Gaji");
        gaji.setFont(new Font("Arial", Font.PLAIN, 15));
        gaji.setSize(300, 20);
        gaji.setLocation(20, 250);
        f.add(gaji);

        tgaji = new JTextField();
        tgaji.setFont(new Font("Arial", Font.PLAIN, 15));
        tgaji.setSize(200, 20);
        tgaji.setLocation(150, 250);
        f.add(tgaji);

        alamat = new JLabel("Alamat");
        alamat.setFont(new Font("Arial", Font.PLAIN, 15));
        alamat.setSize(300, 20);
        alamat.setLocation(20, 300);
        f.add(alamat);

        talamat = new JTextArea();
        talamat.setFont(new Font("Arial", Font.PLAIN, 15));
        talamat.setSize(200, 75);
        talamat.setLocation(150, 300);
        talamat.setLineWrap(true);
        f.add(talamat);

        sub = new JButton("Update");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(20, 400);
        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cekID = Integer.parseInt(tid.getText());
                int cekGaji = Integer.parseInt(tgaji.getText());
                String cekNama = tname.getText();
                String cekmno = tmno.getText();
                String cekAlamat = talamat.getText();
                
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

                id = new JLabel("ID : " + cekID);
                id.setFont(new Font("Arial", Font.PLAIN, 15));
                id.setSize(300, 20);
                id.setLocation(50, 50);
                f2.add(id);

                name = new JLabel("Nama : " + cekNama);
                name.setFont(new Font("Arial", Font.PLAIN, 15));
                name.setSize(300, 20);
                name.setLocation(50, 100);
                f2.add(name);

                mno = new JLabel("Nomor Telepon : " + cekmno);
                mno.setFont(new Font("Arial", Font.PLAIN, 15));
                mno.setSize(300, 20);
                mno.setLocation(50, 150);
                f2.add(mno);

                alamat = new JLabel("Alamat : " + cekAlamat);
                alamat.setFont(new Font("Arial", Font.PLAIN, 15));
                alamat.setSize(300, 20);
                alamat.setLocation(50, 200);
                f2.add(alamat);

                gaji = new JLabel("Gaji : " + cekGaji);
                gaji.setFont(new Font("Arial", Font.PLAIN, 15));
                gaji.setSize(300, 20);
                gaji.setLocation(50, 250);
                f2.add(gaji);
                
                cancel = new JButton("Cancel");
                cancel.setFont(new Font("Arial", Font.PLAIN, 15));
                cancel.setSize(100, 20);
                cancel.setLocation(50, 300);
                cancel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        f2.setVisible(false);
                        f.setVisible(true);
                    }
                });
                f2.add(cancel);
                
                insert = new JButton("Insert");
                insert.setFont(new Font("Arial", Font.PLAIN, 15));
                insert.setSize(100, 20);
                insert.setLocation(160, 300);
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
                            boolean status = c.updateKasir(cekID,cekNama,cekAlamat,cekmno,cekGaji);
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
                
                f2.setVisible(true);
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
                tid.setText(def);
                tname.setText(def);
                tmno.setText(def);
                talamat.setText(def);
                tgaji.setText(def);
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
