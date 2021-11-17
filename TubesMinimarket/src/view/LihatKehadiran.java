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
import model.Kehadiran;

/**
 *
 * @author Nicholas Russel
 */
public class LihatKehadiran extends JFrame {

    private JTable table;
    private DefaultTableModel model;
    private JScrollPane sp;
    private Container c;
    private JLabel title;
    private JButton back;
    ArrayList<Integer> listKasir = new ArrayList<>();

    public LihatKehadiran(int pilih) {
        Controller controller = new Controller();
        ArrayList<Kehadiran> kehadiran = controller.getAllKehadiran();

        setTitle("Lihat Kehadiran");
        setBounds(300, 90, 600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Data Kehadiran");
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        title.setSize(400, 30);
        title.setLocation(250, 30);
        c.add(title);

        setVisible(true);
        model = new DefaultTableModel() {
            @Override
            public Class getColumnClass(int columnIndex) {
                switch (columnIndex) {
                    case 0:
                    case 5:
                    case 6:
                    case 7:
                        return Integer.class;
                    case 8:
                        return Boolean.class;
                    default:
                        return String.class;
                }
            }
        };
        model.addColumn("Tanggal");
        model.addColumn("ID");
        model.addColumn("Status");
        model.addColumn("Status_Gaji");
        table = new JTable(model);

        //Looping Data to Table
        for (int i = 0; i < kehadiran.size(); i++) {
            Kehadiran current = kehadiran.get(i);
            Object[] addKehadiran = new Object[4];
            addKehadiran[0] = current.getTanggal();
            addKehadiran[1] = current.getId_person();
            addKehadiran[2] = current.selectKehadiran(current.getStatus());
            addKehadiran[3] = current.selectPelunasanGaji(current.getStatusGaji());
            System.out.println("hadir :"+current.getStatus());
            System.out.println("gaji :"+current.getStatusGaji());
            model = (DefaultTableModel) table.getModel();
            model.addRow(addKehadiran);
        }

        //Set Column Size
        table.getColumnModel().getColumn(0).setPreferredWidth(95);
        table.getColumnModel().getColumn(1).setPreferredWidth(95);
        table.getColumnModel().getColumn(2).setPreferredWidth(95);
        table.getColumnModel().getColumn(3).setPreferredWidth(95);
        
        table.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                boolean added = false;
                for (int i = 0; i < table.getModel().getRowCount(); i++) {
                    if ((Boolean) table.getModel().getValueAt(i, 8)) {

                        listKasir.add(kehadiran.get(table.getSelectedRow()).getId_person());

                        added = true;
                    }
                    if (added) {
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
                if (pilih == 0) {
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
