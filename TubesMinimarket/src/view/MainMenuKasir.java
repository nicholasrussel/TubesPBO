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
    private JButton changePass,logout,jual;
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

        title = new JLabel(orang.getName());
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);
        
        muncul = new JLabel(orang.getName());
        muncul.setFont(new Font("Arial", Font.PLAIN, 15));
        muncul.setSize(300, 30);
        muncul.setLocation(300, 100);
        c.add(muncul);
        
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
        
        jual = new JButton("Jual");
        jual.setFont(new Font("Arial", Font.PLAIN, 15));
        jual.setSize(300, 20);
        jual.setLocation(10, 200);
        jual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ChangePassword();
            }
        });
        c.add(jual);
        
        logout = new JButton("Log Out");
        logout.setFont(new Font("Arial", Font.PLAIN, 15));
        logout.setSize(300, 20);
        logout.setLocation(10, 250);
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
   
    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly


