/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.Person;
import model.UserManager;

/**
 *
 * @author Nicholas Russel
 */
public class MainMenuKasir extends JFrame {
    
    private Container c;
    private JLabel title,muncul;
    private JButton changePass,logout, jualBarang, jualTopUp;
    private Person orang;

    public MainMenuKasir() {
        orang = UserManager.getInstance().getUser();
        setTitle("Menu Kasir");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Selamat Datang di Menu Kasir" + " " +orang.getName());
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        title.setBounds(250, 30, 600, 30);
        c.add(title);
        
        changePass = new JButton("Change Pass");
        changePass.setFont(new Font("Arial", Font.PLAIN, 15));
        changePass.setSize(300, 20);
        changePass.setLocation(10, 150);
        changePass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ChangePassword();
            }
        });
        c.add(changePass);
        
        jualBarang = new JButton("Jual barang");
        jualBarang.setFont(new Font("Arial", Font.PLAIN, 15));
        jualBarang.setSize(300, 20);
        jualBarang.setLocation(10, 200);
        jualBarang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new FormPenjualanBarangUtama();
            }
        });
        c.add(jualBarang);
        
        jualTopUp = new JButton("Jual TopUp");
        jualTopUp.setFont(new Font("Arial", Font.PLAIN, 15));
        jualTopUp.setSize(300, 20);
        jualTopUp.setLocation(10, 250);
        jualTopUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new MenuDetailPenjualanTopUp();
            }
        });
        c.add(jualTopUp);
        
        
        logout = new JButton("Log Out");
        logout.setFont(new Font("Arial", Font.PLAIN, 15));
        logout.setSize(300, 20);
        logout.setLocation(10, 300);
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                JFrame Frame = new JFrame("Log Out");

                if (JOptionPane.showConfirmDialog(Frame, "Are you sure want to Log Out?", "Minimarket",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    orang=null;
                    new Login();
                } else {
                    setVisible(true);
                }
            }
        });
        c.add(logout);
        setVisible(true);
    }

}
