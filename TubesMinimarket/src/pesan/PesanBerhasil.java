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
public class PesanBerhasil {
    public void pesanBerhasilDatabase(){
        JOptionPane.showMessageDialog(null, "Data Anda berhasil ditambahkan dalam database!", "Pesan Berhasil", JOptionPane.INFORMATION_MESSAGE);
    }
    public void pesanBerhasilDeleteDatabase(){
        JOptionPane.showMessageDialog(null, "Data Anda berhasil dihapus dalam database!", "Pesan Berhasil", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void pesanBerhasilPembayaran(){
        JOptionPane.showMessageDialog(null, "Pembayaran Anda Berhasil!", "Selamat!", JOptionPane.INFORMATION_MESSAGE);
    }
}
