/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerjava;

import bioskop.Aplikasi;
import bioskop.top_up;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tampilan.view_top_up;

/**
 *
 * @author ariq
 */
public class Controller_view_top_up implements ActionListener{
    private view_top_up view;
    Aplikasi apl = new Aplikasi();

    public Controller_view_top_up() {
        view = new view_top_up();
        view.setVisible(true);
        view.addListener(this);
    
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
         if (source.equals(view.getBtExit())) {
            new Controller_Main_Customer();
            view.dispose();
        }
         
        if (source.equals(view.getBtTop())) {
            String met = view.getMethod();
            int i = view.getAmmount();
            String date = view.getTgl();
            top_up tp = new top_up(met,i,date);
            apl.cust_logedin.addTopUp(tp);
            apl.updateUserCust(apl.cust_logedin);
        }
    }
    
}
