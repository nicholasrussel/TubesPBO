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
        JOptionPane.showMessageDialog(null, "Selamat, data Anda berhasil ditambahkan dalam database!", "Pesan Berhasil", JOptionPane.INFORMATION_MESSAGE);
    }
    public void pesanBerhasilDeleteDatabase(){
        JOptionPane.showMessageDialog(null, "Selamat, data Anda berhasil dihapus dalam database!", "Pesan Berhasil", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void pesanBerhasilPembayaran(){
        JOptionPane.showMessageDialog(null, "Selamat, pembayaran Anda Berhasil!", "Pesan berhasil", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void pesanBerhasilUpdate(){
        JOptionPane.showMessageDialog(null, "Selamat, update berhasil", "Pesan berhasil", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void pesanBerhasilAbsen(){
        JOptionPane.showMessageDialog(null, "Selamat, absen Berhasil!", "Pesan berhasil", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void pesanBerhasilLogin(){
        JOptionPane.showMessageDialog(null, "Selamat, login Berhasil!", "Pesan berhasil", JOptionPane.INFORMATION_MESSAGE);
    }
}
