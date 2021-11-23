/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author PauL
 */
public class ConfirmPenjualan implements ActionListener{
    JFrame frame;
    JLabel lbJudul,lbNominal,lbPembayaran,lbTest;
    JTextArea areaNominal;
    JComboBox cbPembayaran;
    JButton confirm,cancel;
    Controller conn = new Controller();
    public FormPenjualanBarangUtama form1;
    public ConfirmPenjualan (){
        frame = new JFrame ();
        
        
        
        
        
        lbPembayaran = new JLabel("Pilih Metode Pembayaran");
        lbPembayaran.setBounds(60, 95, 150, 20);
        frame.add(lbPembayaran);
       
        String[] Pembayaran = {"Cash", "BCA", "OVO", "Go - Pay", "Shopee - Pay"};
        cbPembayaran = new JComboBox(Pembayaran);
        cbPembayaran.setBounds(60, 120, 150, 20);
        frame.add(cbPembayaran);
        
        confirm = new JButton ("Confirm");
        confirm.setBounds(60, 150, 150, 25);
        confirm.addActionListener(this);
        frame.add(confirm);
        
        cancel = new JButton ("Cancel");
        cancel.setBounds(60, 185, 150, 25);
        cancel.addActionListener(this);
        frame.add(cancel);
        
       
        
        
        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new ConfirmPenjualan ();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if(e.getSource() == confirm){
            frame.setVisible(false);
            
           
            
            
            
        }
    }
}
