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
public class MainMenuAdmin extends JFrame{

    private Container c;
    private JLabel title,muncul;
    private JButton registerKasir,updateKasir,deleteKasir,logout,bayarGaji;
    private Person admin;
    
    public MainMenuAdmin() {
        admin = UserManager.getInstance().getUser();
        setTitle("Menu Admin");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        c = getContentPane();
        c.setLayout(null);
                
        title = new JLabel("Selamat Datang di Menu Admin");
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        title.setSize(400, 30);
        title.setLocation(300, 30);
        c.add(title);
        
        muncul = new JLabel(admin.getName());
        muncul.setFont(new Font("Arial", Font.PLAIN, 15));
        muncul.setSize(300, 30);
        muncul.setLocation(300, 100);
        c.add(muncul);

        registerKasir = new JButton("Register Kasir");
        registerKasir.setFont(new Font("Arial", Font.PLAIN, 15));
        registerKasir.setSize(300, 20);
        registerKasir.setLocation(10, 100);
        registerKasir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Register();
            }
        });
        c.add(registerKasir);
        
        updateKasir = new JButton("Update Kasir");
        updateKasir.setFont(new Font("Arial", Font.PLAIN, 15));
        updateKasir.setSize(300, 20);
        updateKasir.setLocation(10, 150);
        updateKasir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new UpdateDataKasir();
            }
        });
        c.add(updateKasir);
        
        deleteKasir = new JButton("Delete Kasir");
        deleteKasir.setFont(new Font("Arial", Font.PLAIN, 15));
        deleteKasir.setSize(300, 20);
        deleteKasir.setLocation(10, 200);
        deleteKasir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new DeleteKasir();
            }
        });
        c.add(deleteKasir);
        
        bayarGaji = new JButton("Bayar Gaji");
        bayarGaji.setFont(new Font("Arial", Font.PLAIN, 15));
        bayarGaji.setSize(300, 20);
        bayarGaji.setLocation(10, 250);
        bayarGaji.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new BayarGaji();
            }
        });
        c.add(bayarGaji);
        
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
                    new pesan.PesanTerimakasih().pesanTerimaKasihLogOut();
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
    
