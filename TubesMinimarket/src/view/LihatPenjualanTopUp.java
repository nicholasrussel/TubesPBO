/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerTopUp;
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
import model.DetailPenjualanTopUp;
import model.PenjualanTopUp;

/**
 *
 * @author ASUS
 */
public class LihatPenjualanTopUp extends JFrame{
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane sp;
    private Container c;
    private JLabel title;
    private JButton back;
    ArrayList<Integer> listDetail = new ArrayList<>();
    public LihatPenjualanTopUp() {
        ControllerTopUp controller = new ControllerTopUp();
        ArrayList<PenjualanTopUp> users = controller.getAllPenjualanTopUp();
        
        setTitle("Lihat PenjualanTopUp");
        setBounds(300, 90, 600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Data Penjualan Top UP");
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
//        model.addColumn("ID TopUP");
        model.addColumn("Nomor FakturTopUp");
        model.addColumn("Jenis Pembayaran ");
        model.addColumn("TotalPenjualanTopUp");
        table = new JTable(model);
        
        //Looping Data to Table
        for (int i=0; i<users.size(); i++) {
            PenjualanTopUp current = users.get(i);
            Object[] addPenjualanTopUp = new Object[3];
            addPenjualanTopUp[0] = current.getNomor_FakturTopUp();
            addPenjualanTopUp[1] = current.getidJenisPembayaran();
             addPenjualanTopUp[2] = current.getTotal_PenjualanTopUp();
            model = (DefaultTableModel)table.getModel();
            model.addRow(addPenjualanTopUp);
        }

        //Set Column Size
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        table.getColumnModel().getColumn(1).setPreferredWidth(60);
        table.getColumnModel().getColumn(2).setPreferredWidth(60);
        
        
        
        table.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                boolean added = false;
                for(int i=0;i<table.getModel().getRowCount();i++) {
                    if ((Boolean) table.getModel().getValueAt(i, 8)) {

                            //listDetail.add(users.get(table.getSelectedRow()));

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
                    setVisible(false);
                    new MenuDetailPenjualanTopUp();
            }
        });
        c.add(back);
    }
}
