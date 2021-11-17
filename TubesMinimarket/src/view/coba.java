/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
/**
 *
 * @author Nicholas Russel
 */
public class coba extends JFrame{
    JFrame frame = new JFrame("ScroolPane pada Java : www.java-sc.com");
    JScrollPane scroll = new JScrollPane();
    JLabel label = new JLabel("Menggunakan ScrollPane");
    JPanel panel = new JPanel();
    public coba(){
        label.setPreferredSize(new Dimension(500, 500));
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setViewportBorder(new LineBorder(Color.RED));
        scroll.getViewport().add(label, null);
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.add(scroll);
    }
    public static void main(String[] args) {
        new coba();
    }
}
