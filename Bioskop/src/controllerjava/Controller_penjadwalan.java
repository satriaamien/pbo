/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerjava;

import bioskop.Aplikasi;
import bioskop.Database;
import bioskop.jadwal_film;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tampilan.penjadwalan_film;

/**
 *
 * @author owner
 */
public class Controller_penjadwalan implements ActionListener{
    private penjadwalan_film pf;
    Aplikasi apl = new Aplikasi();
    private Database db;
        
    public Controller_penjadwalan(){
        pf = new penjadwalan_film();
        db = new Database();
        pf.AddListener(this);
        pf.setVisible(true);
        pf.setLocationRelativeTo(null);
        pf.setComboLoc(apl.getLocationlist());
        pf.setComboCin(apl.getCinemalist());
        pf.setComboStud(apl.getStudioList());
        pf.setComboFilm(apl.getFilmlist());
    }
        
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(pf.getBExit())){
            pf.dispose();
            new Controller_Main_Admin();
            
        } 
        if(source.equals(pf.getBsubmit())){
            String id = pf.getIdJadwal();
            String cinema = pf.getCinema();
            String tanggal = pf.getTanggal();
            String jam = pf.getJam();
            String lokasi = pf.getLokasi();
            String studio = pf.getStudio();
            String film = pf.getFilm();
            int harga = Integer.parseInt(pf.getHarga());
            jadwal_film jm = new jadwal_film(id,lokasi,cinema,studio,film,tanggal,harga,jam);
            db.insertJadwal(jm);
            System.out.println("lewaatt");
            apl.addJadwalFilm(jm);
            
            
        }           
    }
}



