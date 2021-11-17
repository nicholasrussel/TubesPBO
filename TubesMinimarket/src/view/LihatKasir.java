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
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import model.Kasir;

/**
 *
 * @author Nicholas Russel
 */
public class LihatKasir extends JFrame{

    private JTable table;
    private DefaultTableModel model;
    private JScrollPane sp;
    private Container c;
    private JLabel title;
    private JButton back;
    ArrayList<Integer> listKasir = new ArrayList<>();
    public LihatKasir(int pilih) {
        Controller controller = new Controller();
        ArrayList<Kasir> users = controller.getAllKasirs();
        
        setTitle("Lihat Pekerja");
        setBounds(300, 90, 600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Data Kasir");
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        title.setSize(400, 30);
        title.setLocation(250, 30);
        c.add(title);
        
        setVisible(true);
        model = new DefaultTableModel() {
            @Override
            public Class getColumnClass(int columnIndex) {
                switch(columnIndex) {
                    case 0 :
                    case 5 :
                    case 6 :
                    case 7 :
                        return Integer.class;
                    case 8 :
                        return Boolean.class;
                    default :
                        return String.class;
                }
            }
        };
        model.addColumn("ID");
        model.addColumn("Nama");
        model.addColumn("Alamat");
        model.addColumn("Nomor Telepon");
        model.addColumn("Gaji");
        table = new JTable(model);
        
        //Looping Data to Table
        for (int i=0; i<users.size(); i++) {
            Kasir current = users.get(i);
            Object[] addKasir = new Object[5];
            addKasir[0] = current.getId_person();
            addKasir[1] = current.getName();
            addKasir[2] = current.getAlamat();
            addKasir[3] = current.getNomorTelepon();
            addKasir[4] = current.getGaji();
            model = (DefaultTableModel)table.getModel();
            model.addRow(addKasir);
        }

        //Set Column Size
        table.getColumnModel().getColumn(0).setPreferredWidth(2);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(60);
        table.getColumnModel().getColumn(3).setPreferredWidth(60);
        table.getColumnModel().getColumn(4).setPreferredWidth(60);
        
        table.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                boolean added = false;
                for(int i=0;i<table.getModel().getRowCount();i++) {
                    if ((Boolean) table.getModel().getValueAt(i, 8)) {

                            listKasir.add(users.get(table.getSelectedRow()).getId_person());

                        added = true;
                    }
                    if(added) {
                        break;
                    }
                }     
            }
        });
        
        table.setBounds(20, 60, 550, 100);
        sp = new JScrollPane(table);
        sp.setBounds(20, 60, 550, 100);
        c.add(sp);
        
        back = new JButton("Back");
        back.setFont(new Font("Arial", Font.PLAIN, 15));
        back.setSize(100, 20);
        back.setLocation(240, 200);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(pilih==0){
                    setVisible(false);
                } else {
                    setVisible(false);
                    new MainMenuAdmin();
                }
            }
        });
        c.add(back);
    }

}
