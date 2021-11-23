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
import javax.swing.JPasswordField;
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
        orang = UserManager.getInstance().getUser();
        f = new JFrame();
        f.setTitle("Change Password");
        f.setSize(400, 400);
        f.setResizable(false);
        f.setLayout(null);
        f.setLocationRelativeTo(null);

        title = new JLabel("Change Password Form");
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        title.setSize(300, 15);
        title.setLocation(50, 30);
        f.add(title);

        password = new JLabel("Password");
        password.setFont(new Font("Arial", Font.PLAIN, 15));
        password.setSize(300, 20);
        password.setLocation(50, 100);
        f.add(password);

        tpassword = new JPasswordField();
        tpassword.setFont(new Font("Arial", Font.PLAIN, 15));
        tpassword.setSize(200, 20);
        tpassword.setLocation(50, 150);
        f.add(tpassword);

        confirm = new JButton("Confirm");
        confirm.setFont(new Font("Arial", Font.PLAIN, 15));
        confirm.setSize(100, 20);
        confirm.setLocation(50, 320);
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
                String cekPasswordDariMethod = c.getSelectedPassword(orang.getId_person()).substring(0,20);
                String pass = c.getMD5(String.valueOf(tpassword.getPassword()));

                String olahPassword = pass.substring(0, 20);

                if (olahPassword.equals(cekPasswordDariMethod)) {
                    JOptionPane.showMessageDialog(null, "cek password berhasil!");

                    password = new JLabel("New Password");
                    password.setFont(new Font("Arial", Font.PLAIN, 15));
                    password.setSize(300, 20);
                    password.setLocation(50, 50);
                    f2.add(password);

                    tpassword = new JPasswordField();
                    tpassword.setFont(new Font("Arial", Font.PLAIN, 15));
                    tpassword.setSize(200, 20);
                    tpassword.setLocation(50, 100);
                    f2.add(tpassword);

                    retype = new JLabel("Retype");
                    retype.setFont(new Font("Arial", Font.PLAIN, 15));
                    retype.setSize(300, 20);
                    retype.setLocation(50, 150);
                    f2.add(retype);

                    tretype = new JPasswordField();
                    tretype.setFont(new Font("Arial", Font.PLAIN, 15));
                    tretype.setSize(200, 20);
                    tretype.setLocation(50, 200);
                    f2.add(tretype);

                    change = new JButton("Change");
                    change.setFont(new Font("Arial", Font.PLAIN, 15));
                    change.setSize(100, 20);
                    change.setLocation(50, 320);
                    change.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String oldPass = String.valueOf(tpassword.getPassword());
                            String retypePass = String.valueOf(tretype.getPassword());
                            
                            if(oldPass.equals(retypePass)){
                                String hashedPass = c.getMD5(String.valueOf(tpassword.getPassword()));
                                boolean updatePass = c.updatePassword(hashedPass, orang.getId_person());
                                if(updatePass){
                                    JOptionPane.showMessageDialog(null, "update password berhasil!");
                                } else {
                                    JOptionPane.showMessageDialog(null, "update password gagal!");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "password dan retype tidak sama!");
                            }
                            new MainMenuKasir();
                            f2.setVisible(false);
                        }
                    });
                    f2.add(change);

                    cancel = new JButton("Cancel");
                    cancel.setFont(new Font("Arial", Font.PLAIN, 15));
                    cancel.setSize(100, 20);
                    cancel.setLocation(160, 320);
                    cancel.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            f.setVisible(false);
                            new MainMenuKasir();
                        }
                    });
                    f2.add(cancel);
                    f2.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Password Salah");

                }

            }
        });
        f.add(confirm);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Arial", Font.PLAIN, 15));
        cancel.setSize(100, 20);
        cancel.setLocation(160, 320);
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
