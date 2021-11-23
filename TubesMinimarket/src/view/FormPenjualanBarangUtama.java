/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Barang;
import com.sun.prism.paint.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import controller.Controller;
import java.awt.Font;
import model.DetailPenjualan;
import model.PenjualanBarang;

/**
 *
 * @author PauL
 */
public class FormPenjualanBarangUtama implements ActionListener {

    JFrame frame;
    JLabel lbIdBarang, lbNamaBarang, lbHargaBarang, lbKuantitas, lbTotalAhkir,lbTotalAhkirText,lbTotal, lbDiskonBarang,lbNomorFaktur;
    JButton BaddBarang, BCancel, BConfirm;

    JTextArea area;
    public JTextField TfNomorFaktur,TfIdBarang, TfNamaBarang, TfHargaBarang, TfKuantitas, TfDiskonBarang, TfTotal;
    ArrayList <DetailPenjualan> detailJual = new ArrayList<>();
    ArrayList <PenjualanBarang> penjualan = new ArrayList<>();
    Controller conn = new Controller();
    public ConfirmPenjualan confirm;
    public int lebar = 20;
    public Barang barang;
    public DetailPenjualan detailJualBarang = new DetailPenjualan ();
    public PenjualanBarang jualBarang = new PenjualanBarang();
    public double total;
    public String nomorFaktur;
    public FormPenjualanBarangUtama() {
        frame = new JFrame();

        lbIdBarang = new JLabel("ID Barang");
        lbIdBarang.setBounds(5, 5, 100, 15);
        frame.add(lbIdBarang);

        lbNamaBarang = new JLabel("Nama Barang");
        lbNamaBarang.setBounds(100, 5, 100, 15);
        frame.add(lbNamaBarang);

        lbDiskonBarang = new JLabel("Diskon");
        lbDiskonBarang.setBounds(240, 5, 100, 15);
        frame.add(lbDiskonBarang);
        lbHargaBarang = new JLabel("Harga Barang");
        lbHargaBarang.setBounds(320, 5, 100, 15);
        frame.add(lbHargaBarang);

        lbKuantitas = new JLabel("Kuantitas");
        lbKuantitas.setBounds(450, 5, 100, 15);
        frame.add(lbKuantitas);

        lbTotal = new JLabel("Total");
        lbTotal.setBounds(550, 5, 100, 15);
        frame.add(lbTotal);
//        
        BaddBarang = new JButton("Add Barang");
        BaddBarang.setBounds(690, 5, 180, 50);
        BaddBarang.addActionListener(this);
        frame.add(BaddBarang);

        BCancel = new JButton("Cancel");
        BCancel.setBounds(690, 60, 180, 50);
        BCancel.addActionListener(this);
        frame.add(BCancel);

        BConfirm = new JButton("Confirm");
        BConfirm.setBounds(690, 115, 180, 50);
        BConfirm.addActionListener(this);
        frame.add(BConfirm);

        lbIdBarang = new JLabel("ID Barang : ");
        lbIdBarang.setBounds(690, 170, 180, 20);
        frame.add(lbIdBarang);

        TfIdBarang = new JTextField();
        TfIdBarang.setBounds(690, 200, 180, 20);
        frame.add(TfIdBarang);

        lbKuantitas = new JLabel("Kuantitas : ");
        lbKuantitas.setBounds(690, 225, 180, 20);
        frame.add(lbKuantitas);

        TfKuantitas = new JTextField();
        TfKuantitas.setBounds(690, 250, 180, 20);
        frame.add(TfKuantitas);
        
        area = new JTextArea("");
        area.setBounds(0, lebar, 680, 20);
        
        lbNomorFaktur = new JLabel("Nomor Faktur : ");
        lbNomorFaktur.setBounds(690, 275, 180, 20);
        frame.add(lbNomorFaktur);

        TfNomorFaktur = new JTextField();
        TfNomorFaktur.setBounds(690, 300, 180, 20);
        frame.add(TfNomorFaktur);
        
        lbTotalAhkir = new JLabel("Total Belanjaan Anda : ");
        lbTotalAhkir.setBounds(690,330, 180, 20);
        frame.add(lbTotalAhkir);
        
        
         lbTotalAhkirText = new JLabel();
        lbTotalAhkirText.setBounds(690,355, 180, 20);
        

        frame.setSize(900, 500);
        frame.setLayout(null);//using no layout managers  
        frame.setVisible(true);

    }

    public static void main(String[] args) {
       new FormPenjualanBarangUtama();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean sukses;
        if (e.getSource() == BaddBarang) {
            barang = new Barang();
            
            barang = conn.getBarang(TfIdBarang.getText());
            detailJualBarang.setKodeBarang(TfIdBarang.getText());
            detailJualBarang.setKuantitas(Integer.parseInt(TfKuantitas.getText()));
            detailJualBarang.setTanggalJual("2021-11-10");
            detailJualBarang.setNomorFaktur(TfNomorFaktur.getText());
            detailJual.add(detailJualBarang);
            total = total + (barang.getHargaBarang() * Integer.parseInt(TfKuantitas.getText()));
            lbTotalAhkirText.setText(total+"");
            frame.add(lbTotalAhkirText);
            area.setText("  " + TfIdBarang.getText() + "   " + barang.getNamaBarang() + "    " + barang.getPersenDiskon() + "  " + barang.getHargaBarang() + "     " + TfKuantitas.getText() + "       " + (barang.getHargaBarang() * Integer.parseInt(TfKuantitas.getText()) - ((barang.getHargaBarang() * Integer.parseInt(TfKuantitas.getText())) * barang.getPersenDiskon())));
            frame.add(area);
            area = new JTextArea();
            lebar += 22;
            area.setBounds(0, lebar, 680, 20);
            
        } else if (e.getSource() == BCancel) {


        }   else if (e.getSource() == BConfirm){
                
                confirm = new ConfirmPenjualan();
                confirm.frame.setVisible(true);
                
                jualBarang.setNomorFaktur(TfNomorFaktur.getText());
                jualBarang.setTotalPenjualan(total);
                
                String pembayaran;
                if(confirm.cbPembayaran.getSelectedIndex() == 0){
                    pembayaran= "Cash";
                }   else if (confirm.cbPembayaran.getSelectedIndex() == 1){
                        pembayaran = "BCA";
                }   else if (confirm.cbPembayaran.getSelectedIndex() == 2){
                        pembayaran = "OVO";
                }   else if (confirm.cbPembayaran.getSelectedIndex() == 3){
                        pembayaran = "Go - Pay";
                }   else {
                        pembayaran  = "Shopee - Pay";
                }
                jualBarang.setJenisPembayaran(pembayaran);
                sukses = conn.setPenjualanDB(jualBarang);
                frame.setVisible(false);
                sukses = conn.updateStock(detailJual);
        }
        
    }
   
}
