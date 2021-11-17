/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.Controller;
import java.util.ArrayList;
import model.*;
/**
 *
 * @author Nicholas Russel
 */
public class Main {
    public Main() {
        Controller controller =  new Controller();
        ArrayList<Kasir> users = controller.getAllKasirs();
        for (Kasir user : users) {
            System.out.println(user.toString());
        }
        ArrayList<Kehadiran> hadir = controller.getAllKehadiran();
        for (Kehadiran absen : hadir) {
            System.out.println(absen.toString());
        }
        
        Person pegawaiYangDibayar = controller.getKasir(1);
                System.out.println(pegawaiYangDibayar.toString());
//        User newUser = new User();
//        newUser.setName("Heru");
//        newUser.setAddress("jl Dago");



//        newUser.setAge(15);
//        newUser.setPhone("1234567");
//        
//        boolean status = controller.insertNewUser(newUser);
//        if(status){
//            System.out.println("insert sukses");
//        } else {
//            System.out.println("insert gagal");
//        }
//        System.out.println(controller.getAllUsers());
    }
    
    public static void main(String[] args) {
//   new view.Login();
 //new view.BayarGaji();
//new view.MainMenuAdmin();
//new view.UpdateDataKasir();
//new view.LihatKehadiran();
//       new Main();
new view.Register();
       
    }
}
