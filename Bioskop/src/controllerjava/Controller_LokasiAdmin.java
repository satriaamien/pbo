/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerjava;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import tampilan.*;
import bioskop.*;

/**
 *
 * @author IntanMaharani
 */
public class Controller_LokasiAdmin implements ActionListener{
    private Lokasi_Admin LA;

    public Controller_LokasiAdmin() {
        LA = new Lokasi_Admin();
        LA.addListener(this);
        LA.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(LA.getBtnSubmit())){
            Database db = new Database();
              String id_lokasi = LA.getInsertID().getText();
              String nama_lokasi = LA.getInsertNama().getText();
              Location l = new Location(nama_lokasi,Integer.parseInt(id_lokasi));
              db.insertLokasi(l);
              db.disconnect();
            Controller_CinemaAdmin ca = new Controller_CinemaAdmin();
            
        }
        if (source.equals(LA.getBtnExit())) {
            new Controller_Main_Admin();
        }
        LA.dispose();
    }
    

}
