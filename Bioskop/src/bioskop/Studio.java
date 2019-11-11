package bioskop;


import bioskop.Seat;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Intan Maharani
 */
public class Studio {
    private String nomor_theater;
    LinkedList<Seat> list_kursi = new LinkedList<>();
    private int jumlah_kursi = 20; //jumlah kursi /baris
    private int jumlah_kursi_ttl = 240;
    
    public Studio(String nomor_theater) {
        this.nomor_theater = nomor_theater;
        
        int r = 1;
        String lbl="";
        while (r<13) {
            switch (r) {
                case 1:
                    lbl = "A";
                    break;
                case 2:
                    lbl = "B";
                    break;
                case 3:
                    lbl = "C";
                    break;
                case 4:
                    lbl = "D";
                    break;
                case 5:
                    lbl = "E";
                    break;                    
                case 6:
                    lbl = "F";
                    break;
                case 7:
                    lbl = "G";
                    break;
                case 8:
                    lbl = "H";
                    break;
                case 9:
                    lbl = "J";
                    break;
                case 10:
                    lbl = "K";
                    break;
                case 11:
                    lbl = "L";
                    break;
                case 12:
                    lbl = "M";
                    break;
                default:
                    break;
            }
            
            for (int i = 0; i < jumlah_kursi; i++) {
                list_kursi.add(new Seat(i+1,lbl));
            }
            
           r++;         
        }
    }

    public String getNomor_theater() {
        return nomor_theater;
    }

    public int getJumlah_kursi() {
        return jumlah_kursi;
    }
    
    public void show_kursi(){
           for (Seat x:list_kursi){
               System.out.println(x.getNomor_kursi()+x.getBaris_kursi());
           };
        
        }
    
 } //end_of_class
