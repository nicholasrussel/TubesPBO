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
public class PesanGagal {
    public void pesanGagalDatabase(){
        JOptionPane.showMessageDialog(null, "Maaf, data Anda tidak berhasil masuk ke database!", "Pesan Gagal", JOptionPane.ERROR_MESSAGE);
    }
    
    public void pesanMenuTidakDitemukan(){
        JOptionPane.showMessageDialog(null, "Maaf, menu tidak ada!", "Pesan Gagal" ,JOptionPane.ERROR_MESSAGE);
    }
    
    public void pesanGagalHapusDatabase(){
        JOptionPane.showMessageDialog(null, "Maaf, data Anda tidak berhasil dihapus di database!", "Pesan Gagal", JOptionPane.ERROR_MESSAGE);
    }
    
    public void pesanGagalPembayaran(){
        JOptionPane.showMessageDialog(null, "Maaf, pembayaran Anda tidak berhasil!", "Pesan Gagal", JOptionPane.ERROR_MESSAGE);
    }
    
    public void pesanGagalUpdate(){
        JOptionPane.showMessageDialog(null, "Maaf, update gagal!", "Pesan Gagal", JOptionPane.ERROR_MESSAGE);
    }
    
    public void pesanGagalLoginPassword(){
        JOptionPane.showMessageDialog(null, "Maaf, password Salah!", "Pesan Gagal", JOptionPane.ERROR_MESSAGE);
    }
    
    public void pesanGagalLoginUsernamePassword(){
        JOptionPane.showMessageDialog(null, "Maaf, Username / Password salah!", "Pesan Gagal", JOptionPane.ERROR_MESSAGE);
    }
    
    public void pesanGagalBayarATM(){
        JOptionPane.showMessageDialog(null, "Nomor Rekening/Password Anda salah!", "Pesan Gagal", JOptionPane.ERROR_MESSAGE);
    }
    
    public void pesanGagalUangTidakCukup(){
        JOptionPane.showMessageDialog(null, "Uang anda tidak cukup!", "Pesan Gagal", JOptionPane.ERROR_MESSAGE);
    }
    
    public void pesanGagalHapusKasir(){
        JOptionPane.showMessageDialog(null, "Delete gagal", "Pesan Gagal", JOptionPane.ERROR_MESSAGE);
    }
}
