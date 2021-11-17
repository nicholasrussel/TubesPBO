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
import java.util.Properties;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.EnumJabatan;
import model.Kasir;

/**
 *
 * @author Nicholas Russel
 */
public class DeleteKasir {

    private JLabel title, id;
    private JTextField tid;
    private JButton delete,cancel;

    public DeleteKasir() {
        JFrame f = new JFrame();
        f.setTitle("Delete Kasir");
        f.setSize(400, 400);
        f.setResizable(false);
        f.setLayout(null);
        f.setLocationRelativeTo(null);

        title = new JLabel("Delete Kasir Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(50, 30);
        f.add(title);

        id = new JLabel("Id Person : ");
        id.setFont(new Font("Arial", Font.PLAIN, 15));
        id.setSize(300, 20);
        id.setLocation(50, 100);
        f.add(id);

        tid = new JTextField();
        tid.setFont(new Font("Arial", Font.PLAIN, 15));
        tid.setSize(200, 20);
        tid.setLocation(50, 150);
        f.add(tid);

        delete = new JButton("Delete");
        delete.setFont(new Font("Arial", Font.PLAIN, 15));
        delete.setSize(100, 20);
        delete.setLocation(50, 200);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                JFrame Frame = new JFrame("Confirmation");
                Controller c = new Controller();
                if (JOptionPane.showConfirmDialog(Frame, "confirm if you Want to Delete", "Minimarket",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    boolean status = c.deleteUser(Integer.parseInt(tid.getText()));
                    if (status) {
                        JOptionPane.showMessageDialog(null, "Delete berhasil");
                        new MainMenuAdmin();
                    } else {
                        JOptionPane.showMessageDialog(null, "Delete gagal");
                        new MainMenuAdmin();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Delete batal");
                    new MainMenuAdmin();
                }
            }
        });
        f.add(delete);
        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Arial", Font.PLAIN, 15));
        cancel.setSize(100, 20);
        cancel.setLocation(200, 200);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new MainMenuAdmin();
            }
        });
        f.add(cancel);
        
        f.setVisible(true);
    }
}
