/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pesan;

import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class PesanWarning {
    public void pesanSudahAbsen(){
        JOptionPane.showMessageDialog(null, "Maaf, anda sudah absen!", "Pesan peringatan", JOptionPane.WARNING_MESSAGE);
    }
    public void pesanSudahBayarGaji(){
        JOptionPane.showMessageDialog(null, "Gaji sudah dibayar", "Pesan peringatan", JOptionPane.WARNING_MESSAGE);
    }
}
