/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerjava;

import bioskop.Aplikasi;
import bioskop.Database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.chart.PieChart;
import tampilan.now_playing;

/**
 *
 * @author ariq
 */
public class Controller_now_playing implements ActionListener{
    private now_playing view;
    Aplikasi apl = new Aplikasi();
    Database db = new Database();

    public Controller_now_playing() {
        view = new now_playing();
        view.setVisible(true);
        view.addListener(this);
        view.setComboLoc(apl.getLocationlist());
        view.setComboCin(apl.getCinemalist());
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source.equals(view.getBtnExit())) {
            new Controller_Main_Customer();
            view.dispose();
        }
        if (source.equals(view.getBtnGo())) {
            String loc = view.getLokasi();
            String cin = view.getCinema();
            view.setTableJadwal(db.loadJadwal(), loc, cin);
        }
    }
    
}
