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
public class PesanTerimakasih {
    
    public void pesanTerimaKasihMenu(){
        JOptionPane.showMessageDialog(null, "Terima kasih!\n Semoga Hari Anda Menyenangkan!", "Pesan Terima kasih", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void pesanTerimaKasihLogOut(){
        JOptionPane.showMessageDialog(null, "Terima kasih telah menggunakan aplikasi kami!", "Pesan Terima kasih", JOptionPane.INFORMATION_MESSAGE);
    }
}
