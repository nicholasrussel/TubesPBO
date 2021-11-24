/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
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
import model.Barang;
import model.TopUp;

/**
 *
 * @author HP
 */
public class DeleteBarang {

    private JLabel title;
    //private JTextField ;
    private JButton delete;
    private JComboBox kodeBarang;
    private JButton cancel;
    private JLabel labelKodeBarang;

    public DeleteBarang() {
        JFrame f = new JFrame();
        f.setTitle(" Delete Barang ");
        f.setSize(350, 400);
        f.setResizable(false);
        f.setLayout(null);
        f.setLocationRelativeTo(null);

        title = new JLabel(" Delete Barang ");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(250, 40);
        title.setLocation(75, 30);
        f.add(title);
        
        labelKodeBarang = new JLabel("Kode barang");
        labelKodeBarang.setFont(new Font("Arial", Font.PLAIN, 15));
        labelKodeBarang.setSize(250, 30);
        labelKodeBarang.setLocation(60, 100);
        f.add(labelKodeBarang);
        
        
        ArrayList<Barang> barang = new controller.Controller().getAllBarang();
        String[] kode = new String[barang.size()];
        for (int i = 0; i < barang.size(); i++) {
            kode[i] = barang.get(i).getKodeBarang();
        }
        kodeBarang = new JComboBox(kode);
        f.add(kodeBarang);
        kodeBarang.setSize(200, 30);
        kodeBarang.setLocation(60, 150);
 
        delete = new JButton("Delete");
        delete.setFont(new Font("Arial", Font.PLAIN, 15));
        delete.setSize(100, 20);
        delete.setLocation(160, 270);
        
        String cekKodeBarang = kodeBarang.getSelectedItem().toString();
        
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                JFrame konfirmasiUpdate = new JFrame("Confirmation");
                JFrame updateLagi = new JFrame("Another Update?");
                Controller c = new Controller();

                if (JOptionPane.showConfirmDialog(konfirmasiUpdate, "confirm if you Want to Delete", "Minimarket",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    f.setVisible(false);
                    boolean status = c.deleteBarang(cekKodeBarang);

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
                    f.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Delete batal");
                    //new MainMenuAdmin();
                }
            }
        });
        f.add(delete);
        
        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Arial", Font.PLAIN, 15));
        cancel.setSize(100, 20);
        cancel.setLocation(60, 270);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
            }
        });
        f.add(cancel);
        
        f.setVisible(true);
    }

}
