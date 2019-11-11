/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerjava;

import bioskop.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tampilan.Cinema_Admin;

/**
 *
 * @author OWNER
 */
public class Controller_CinemaAdmin implements ActionListener{
    private Cinema_Admin CA;

    public Controller_CinemaAdmin() {
        CA = new Cinema_Admin();
        CA.addListener(this);
        CA.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(CA.getBtnSubmit())){
            Database db = new Database();

              String id_cinema = CA.getInsertID().getText();
              String nama_cinema = CA.getInsertNama().getText();
              Cinema c = new Cinema(nama_cinema,Integer.parseInt(id_cinema));
              db.insertCinema(c);
              db.disconnect();
            Controller_FilmAdmin ca = new Controller_FilmAdmin();
            
        }
        if (source.equals(CA.getBtnExit())) {
            new Controller_Main_Admin();
        }
        CA.dispose();
    }

}
