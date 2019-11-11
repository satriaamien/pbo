/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerjava;

/**
 *
 * @author Intan Maharani
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import tampilan.*;
import bioskop.*;

public class Controller_LokasiCustomer implements ActionListener{
    private Lokasi_Customer LC;
    Database db = new Database();
    Aplikasi apl = new Aplikasi();
    public Controller_LokasiCustomer() {
        LC = new Lokasi_Customer();
        LC.addListener(this);
        LC.setVisible(true);
        LC.setListLocationDropDown(apl.getLocationlist());
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(LC.getBtnNext())){
            String s = LC.getSelectedLoc();
            apl.setTampungLokasi(s);
            Controller_CinemaCustomer cc = new Controller_CinemaCustomer();
            LC.dispose();
        }
        
        if (source.equals(LC.getBtnBack())) {
            LC.dispose();
            new Controller_Main_Customer();
        }
    }
}
