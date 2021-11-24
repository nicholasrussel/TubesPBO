// Java program to implement
// a Simple Registration Form
// using Java Swing
package view;

import controller.DatabaseHandler;
import controller.Controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import model.*;

public class Login extends JFrame implements ActionListener {

    // Components of the Form
    private Container c;
    private JLabel title, ID, pass;
    private JTextField tID;
    private JPasswordField tpass;
    private JButton sub;
    static DatabaseHandler conn = new DatabaseHandler();


    public Login() {
        setTitle("Login Form");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Login Form");
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        title.setSize(100, 80);
        title.setLocation(100, 30);
        c.add(title);

        ID = new JLabel("ID");
        ID.setFont(new Font("Arial", Font.PLAIN, 15));
        ID.setSize(100, 20);
        ID.setLocation(100, 100);
        c.add(ID);

        tID = new JTextField();
        tID.setFont(new Font("Arial", Font.PLAIN, 15));
        tID.setSize(190, 20);
        tID.setLocation(100, 130);
        c.add(tID);

        pass = new JLabel("Password");
        pass.setFont(new Font("Arial", Font.PLAIN, 15));
        pass.setSize(100, 20);
        pass.setLocation(100, 200);
        c.add(pass);

        tpass = new JPasswordField();
        tpass.setFont(new Font("Arial", Font.PLAIN, 15));
        tpass.setSize(190, 20);
        tpass.setLocation(100, 230);
        c.add(tpass);

        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 30);
        sub.setLocation(150, 300);
        sub.addActionListener(this);
        c.add(sub);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent event) {
        conn.connect();
        Controller c = new Controller();
        int userID = Integer.parseInt(tID.getText());
        String olahInputPassword = c.getMD5(String.valueOf(tpass.getPassword())).substring(0, 20);
        String olahDBPassword= c.getSelectedPassword(userID).substring(0,20);
        
        Person login = c.getUser(userID);

        if (login != null) {
            if (olahInputPassword.equals(olahDBPassword)) {
                JOptionPane.showMessageDialog(rootPane, "Login Berhasil!");
                UserManager.getInstance().setUser(login);
                String jabatan = c.getSelectedJabatan(userID).toLowerCase();
                String jabatanKasir = EnumJabatan.KASIR.toString().toLowerCase();
                if (jabatan.equals(jabatanKasir)) {
                    LocalDate now = LocalDate.now();
                    java.sql.Date sqlDate = java.sql.Date.valueOf(now);
                    Kehadiran absenHariIni = c.cekSudahAbsen(userID, sqlDate);

                    if (absenHariIni.getTanggal() == null) {
                        int statusHadir = 1;
                        int statusGaji = 0;
                        boolean absensi = c.insertAbsenKehadiran(sqlDate, userID, statusHadir,statusGaji);
                        new pesan.PesanBerhasil().pesanBerhasilAbsen();

                    } else {
                        new pesan.PesanWarning().pesanSudahAbsen();
                    }

                    new MainMenuKasir();
                    this.dispose();
                } else {
                    new MainMenuAdmin();
                    this.dispose();
                }

            } else {
                new pesan.PesanGagal().pesanGagalLoginPassword();
            }

        } else {
            new pesan.PesanGagal().pesanGagalLoginUsernamePassword();

        }
    }

}
