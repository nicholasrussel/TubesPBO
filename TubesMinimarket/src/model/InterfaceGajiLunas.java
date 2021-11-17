/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Nicholas Russel
 */
public interface InterfaceGajiLunas {
    final int LUNAS = 1;
    final int BELUM_LUNAS = 0;
    
    abstract String selectPelunasanGaji(int statusGaji);
}
