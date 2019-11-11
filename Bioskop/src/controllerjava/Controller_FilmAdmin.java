/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerjava;

import bioskop.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tampilan.Film_Admin;

/**
 *
 * @author OWNER
 */
public class Controller_FilmAdmin implements ActionListener{
    private Film_Admin FA;

    public Controller_FilmAdmin() {
        FA = new Film_Admin();
        FA.addListener(this);
        FA.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(FA.getBtnSubmit())){
            Database db = new Database();
              String id_film = FA.getInsertID().getText();
              String judul = FA.getInsertJudul().getText();
              String genre = FA.getInsertGenre().getText();
              String durasi = FA.getInsertDurasi().getText();
              String sinopsis = FA.getInsertSinopsis().getText();
              Film f = new Film(Integer.parseInt(id_film),judul,genre,durasi,sinopsis);
              db.insertFilm(f);
              db.disconnect();
              Controller_FilmAdmin fa = new Controller_FilmAdmin();
              
        }
        
        if (source.equals(FA.getBtnExit())) {
            new Controller_Main_Admin();
        }
        FA.dispose();
    }
}
