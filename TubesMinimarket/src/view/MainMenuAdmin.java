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
    private JButton registerKasir,updateKasir,deleteKasir,logout,bayarGaji, lihatTopUp, tambahTopUp, 
            lihatDataTopUp,lihatDataBarang, lihatDataDetilPenjualanBarang, lihatDataPenjualanBarang,
            updateBarang, insert, deleteTopUp, deleteBarang, update;
            
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
                
        title = new JLabel("Selamat Datang di Menu Admin" +  admin.getName());
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        title.setSize(400, 30);
        title.setLocation(300, 30);
        c.add(title);

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
        
        lihatTopUp = new JButton("Lihat Top Up");
        lihatTopUp.setFont(new Font("Arial", Font.PLAIN, 15));
        lihatTopUp.setSize(300, 20);
        lihatTopUp.setLocation(10, 300);
        lihatTopUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LihatPenjualanTopUp(1);
                new LihatDetailPenjualanTopUp(1);
            }
        });
        c.add(lihatTopUp);
        
        tambahTopUp = new JButton("Tambah TopUp");
        tambahTopUp.setFont(new Font("Arial", Font.PLAIN, 15));
        tambahTopUp.setSize(300, 20);
        tambahTopUp.setLocation(10, 350);
        tambahTopUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuTopUp();
            }
        });
        c.add(tambahTopUp);
        
        lihatDataTopUp = new JButton("Lihat data top up");
        lihatDataTopUp.setFont(new Font("Arial", Font.PLAIN, 15));
        lihatDataTopUp.setSize(300, 20);
        lihatDataTopUp.setLocation(10, 400);
        lihatDataTopUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LihatDataTopUp(1);
            }
        });
        c.add(lihatDataTopUp);
        
        lihatDataBarang = new JButton("Lihat Data Barang");
        lihatDataBarang.setFont(new Font("Arial", Font.PLAIN, 15));
        lihatDataBarang.setSize(300, 20);
        lihatDataBarang.setLocation(330, 100);
        lihatDataBarang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LihatBarang(1);
            }
        });
        c.add(lihatDataBarang);
        
        lihatDataDetilPenjualanBarang = new JButton("Lihat Data Detil Penjualan Barang");
        lihatDataDetilPenjualanBarang.setFont(new Font("Arial", Font.PLAIN, 15));
        lihatDataDetilPenjualanBarang.setSize(300, 20);
        lihatDataDetilPenjualanBarang.setLocation(330, 150);
        lihatDataDetilPenjualanBarang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LihatDetailPenjualanBarang(1);
            }
        });
        c.add(lihatDataDetilPenjualanBarang);

        lihatDataPenjualanBarang = new JButton("Lihat Data Penjualan Barang");
        lihatDataPenjualanBarang.setFont(new Font("Arial", Font.PLAIN, 15));
        lihatDataPenjualanBarang.setSize(300, 20);
        lihatDataPenjualanBarang.setLocation(330, 200);
        lihatDataPenjualanBarang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LihatPenjualanBarang(1);
            }
        });
        c.add(lihatDataPenjualanBarang);
        
        updateBarang = new JButton("Update Barang");
        updateBarang.setFont(new Font("Arial", Font.PLAIN, 15));
        updateBarang.setSize(300, 20);
        updateBarang.setLocation(330, 250);
        updateBarang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateBarang();
            }
        });
        c.add(updateBarang);
        
        insert = new JButton("Insert Barang");
        insert.setFont(new Font("Arial", Font.PLAIN, 15));
        insert.setSize(300, 20);
        insert.setLocation(330, 350);
        insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InputBarang();
            }
        });
        c.add(insert);
        
        update = new JButton("Update TopUp");
        update.setFont(new Font("Arial", Font.PLAIN, 15));
        update.setSize(300, 20);
        update.setLocation(330, 450);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateTopUp();
            }
        });
        c.add(update);
        
        deleteBarang = new JButton("Delete Barang");
        deleteBarang.setFont(new Font("Arial", Font.PLAIN, 15));
        deleteBarang.setSize(300, 20);
        deleteBarang.setLocation(330, 300);
        deleteBarang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteBarang();
            }
        });
        c.add(deleteBarang);
        
        deleteTopUp = new JButton("Delete TopUp");
        deleteTopUp.setFont(new Font("Arial", Font.PLAIN, 15));
        deleteTopUp.setSize(300, 20);
        deleteTopUp.setLocation(330, 400);
        deleteTopUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteTopUp();
            }
        });
        c.add(deleteTopUp);
        
        logout = new JButton("Log Out");
        logout.setFont(new Font("Arial", Font.PLAIN, 15));
        logout.setSize(300, 20);
        logout.setLocation(10, 450);
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
    
