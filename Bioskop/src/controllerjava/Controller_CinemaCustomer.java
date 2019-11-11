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
import java.util.*;

public class Controller_CinemaCustomer implements ActionListener {
    private Cinema_Customer CC;
    Database db = new Database();
    Aplikasi apl = new Aplikasi();
    public Controller_CinemaCustomer() {
        CC = new Cinema_Customer();
        CC.addListener(this);
        CC.setVisible(true);
        CC.setListCinemaDropDown(apl.getCinemalist());
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(CC.getBtnNext())){
            String s = CC.getSelectedCin();
            apl.setTampungCinema(s);
            CC.dispose();
            new Controller_pilih_jadwal();
            
        }
        else if(source.equals(CC.getBtnBack())){
            Controller_LokasiCustomer cl = new Controller_LokasiCustomer();
            CC.dispose();
        }
    }    
}
