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
        JOptionPane.showMessageDialog(null, "Maaf, menu tidak ada!", "Pesan Error" ,JOptionPane.ERROR_MESSAGE);
    }
    
    public void pesanGagalHapusDatabase(){
        JOptionPane.showMessageDialog(null, "Maaf, data Anda tidak berhasil dihapus di database!", "Pesan Gagal", JOptionPane.ERROR_MESSAGE);
    }
    
    public void pesanGagalPembayaran(){
        JOptionPane.showMessageDialog(null, "Pembayaran Anda Tidak Berhasil!", "Maaf!", JOptionPane.ERROR_MESSAGE);
    }
}
