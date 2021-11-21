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
import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import model.EnumJabatan;
import model.Kehadiran;
import model.Person;
import model.UserManager;

/**
 *
 * @author Nicholas Russel
 */
public class ChangePassword {

    private JFrame f, f2;
    private JLabel title, password, retype;
    private JPasswordField tpassword, tretype;
    private JButton confirm, change, cancel;
    private Person orang;

    public ChangePassword() {
        orang = UserManager.getInstance().getKasir();
        f = new JFrame();
        f.setTitle("Change Password");
        f.setSize(400, 400);
        f.setResizable(false);
        f.setLayout(null);
        f.setLocationRelativeTo(null);

        title = new JLabel("Change Password Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(150, 30);
        f.add(title);

        password = new JLabel("Password");
        password.setFont(new Font("Arial", Font.PLAIN, 15));
        password.setSize(300, 20);
        password.setLocation(50, 50);
        f.add(password);

        tpassword = new JPasswordField();
        tpassword.setFont(new Font("Arial", Font.PLAIN, 15));
        tpassword.setSize(200, 20);
        tpassword.setLocation(50, 120);
        f.add(tpassword);

        confirm = new JButton("Change");
        confirm.setFont(new Font("Arial", Font.PLAIN, 15));
        confirm.setSize(100, 20);
        confirm.setLocation(100, 320);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f2 = new JFrame();
                f2.setTitle("Change Password");
                f2.setSize(400, 400);
                f2.setResizable(false);
                f2.setLayout(null);
                f2.setLocationRelativeTo(null);

                Controller c = new Controller();
                String cekPasswordDariMethod = c.getSelectedPassword(orang.getId_person());
                String pass = c.getMD5(String.valueOf(tpassword.getPassword()));

                String olahPassword = pass.substring(0, 30);

                if (olahPassword.equals(cekPasswordDariMethod)) {
                    JOptionPane.showMessageDialog(null, "cek password berhasil!");

                    password = new JLabel("Password");
                    password.setFont(new Font("Arial", Font.PLAIN, 15));
                    password.setSize(300, 20);
                    password.setLocation(50, 50);
                    f2.add(password);

                    tpassword = new JPasswordField();
                    tpassword.setFont(new Font("Arial", Font.PLAIN, 15));
                    tpassword.setSize(200, 20);
                    tpassword.setLocation(50, 120);
                    f2.add(tpassword);

                    retype = new JLabel("New Password");
                    retype.setFont(new Font("Arial", Font.PLAIN, 15));
                    retype.setSize(300, 20);
                    retype.setLocation(50, 190);
                    f2.add(retype);

                    tretype = new JPasswordField();
                    tretype.setFont(new Font("Arial", Font.PLAIN, 15));
                    tretype.setSize(200, 20);
                    tretype.setLocation(50, 260);
                    f2.add(tretype);

                    change = new JButton("Change");
                    change.setFont(new Font("Arial", Font.PLAIN, 15));
                    change.setSize(100, 20);
                    change.setLocation(50, 320);
                    change.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String newPassword = c.getMD5(String.valueOf(tpassword.getPassword()));
                            new MainMenuKasir();
                        }
                    });
                    f2.add(change);

                    cancel = new JButton("Cancel");
                    cancel.setFont(new Font("Arial", Font.PLAIN, 15));
                    cancel.setSize(100, 20);
                    cancel.setLocation(150, 320);
                    cancel.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            f.setVisible(false);
                            new MainMenuKasir();
                        }
                    });
                    f2.add(cancel);

                } else {
                    JOptionPane.showMessageDialog(null, "Password Salah");

                }

            }
        });
        f.add(confirm);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Arial", Font.PLAIN, 15));
        cancel.setSize(100, 20);
        cancel.setLocation(150, 320);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new MainMenuKasir();
            }
        });
        f.add(cancel);
        f.setVisible(true);

    }
}
