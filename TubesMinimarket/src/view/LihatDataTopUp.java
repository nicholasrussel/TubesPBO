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
import model.PenjualanTopUp;
import model.TopUp;

/**
 *
 * @author HP
 */
public class LihatDataTopUp extends JFrame{
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane sp;
    private Container c;
    private JLabel title;
    private JButton back;
    ArrayList<Integer> listDetail = new ArrayList<>();
    
    public LihatDataTopUp(int pilih) {
        ControllerTopUp controller = new ControllerTopUp();
        ArrayList<TopUp> users = controller.getAllTopUp();
        
        setTitle("Lihat TopUp");
        setBounds(300, 90, 600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Data Top UP");
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        title.setSize(400, 30);
        title.setLocation(220, 30);
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
        model.addColumn("Id_TopUP");
        model.addColumn("Pajak_TopUp");
        model.addColumn("Harga_TopUp");
        model.addColumn("Type_TopUp");
        table = new JTable(model);
        
        //Looping Data to Table
        for (int i=0; i<users.size(); i++) {
            TopUp current = users.get(i);
            Object[] addTopUp = new Object[4];
            addTopUp[0] = current.getId_TopUp();
            addTopUp[1] = current.getPajak_TopUp();
             addTopUp[2] = current.getHarga_TopUp();
             addTopUp[3] = current.getType_TopUp();
            model = (DefaultTableModel)table.getModel();
            model.addRow(addTopUp);
        }

        //Set Column Size
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        table.getColumnModel().getColumn(1).setPreferredWidth(60);
        table.getColumnModel().getColumn(2).setPreferredWidth(60);
        table.getColumnModel().getColumn(3).setPreferredWidth(60);
        
        
        
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
                if (pilih == 1) {
                    setVisible(false);
                    new MainMenuAdmin();
                } else {
                    setVisible(false);
                    new MainMenuKasir();
                }
            }
        });
        c.add(back);
    }
}
