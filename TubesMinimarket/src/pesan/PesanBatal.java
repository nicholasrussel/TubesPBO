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
public class PesanBatal {
    
    public void pesanBatalUpdate(){
        JOptionPane.showMessageDialog(null, "update batal", "Pesan Batal", JOptionPane.ERROR);
    }
    public void pesanBatalBayar(){
        JOptionPane.showMessageDialog(null, "Bayar batal", "Pesan Batal", JOptionPane.ERROR);    
    }
    public void pesanBatalBayarGaji(){
        JOptionPane.showMessageDialog(null, "Bayar Gaji batal", "Pesan Batal", JOptionPane.ERROR);
    }
    
    public  void pesanBatalHapusKasir(){
        JOptionPane.showMessageDialog(null, "Delete batal", "Pesan Batal", JOptionPane.ERROR);
    }
}
