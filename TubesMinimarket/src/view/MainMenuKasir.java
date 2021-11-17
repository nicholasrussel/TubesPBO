/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.Kasir;
import model.UserManager;

/**
 *
 * @author Nicholas Russel
 */
public class MainMenuKasir extends JFrame {

    // Components of the Form
    private Container c;
    private JLabel title,muncul;
    private JButton absen,logout;
    private Kasir kasir;

    // constructor, to initialize the components
    // with default values.
    public MainMenuKasir() {
        kasir = UserManager.getInstance().getKasir();
        setTitle("Menu Kasir");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Selamat Datang di Menu Kasir");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);
        
        muncul = new JLabel(kasir.getName());
        muncul.setFont(new Font("Arial", Font.PLAIN, 15));
        muncul.setSize(300, 30);
        muncul.setLocation(300, 100);
        c.add(muncul);
        
        absen = new JButton("absen");
        absen.setFont(new Font("Arial", Font.PLAIN, 15));
        absen.setSize(100, 20);
        absen.setLocation(100, 200);
        absen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame Frame = new JFrame("Absen");
                LocalDateTime now = LocalDateTime.now();
                System.out.println("Before Formatting: " + now);
                DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy--MM--dd");
                String formatDateTime = now.format(format);
                System.out.println("After Formatting: " + formatDateTime);
//                boolean status = Controller.insertAbsenKehadiran();
//                if (status) {
//                    JOptionPane.showMessageDialog(null, "Absen berhasil");
//                } else {
//                    JOptionPane.showMessageDialog(null, "Absen gagal");
//                }

            }
        });
        c.add(absen);
        
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
                    kasir=null;
                    new Login();
                } else {
                    setVisible(true);
                }
            }
        });
        c.add(logout);
        setVisible(true);
    }

    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
}
