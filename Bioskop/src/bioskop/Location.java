package bioskop;


import bioskop.Cinema;
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
public class Location {
    private String name_location;
    private int id_location;
    private int jumlah_bioskop;
    LinkedList<Cinema>cinema_list = new LinkedList<>();
    
    public Location (String nama_lokasi, int id_lokasi){
        this.name_location = nama_lokasi;
        this.id_location = id_lokasi;
    }

    public String getName_location() {
        return name_location;
    }

    public int getId_location() {
        return id_location;
    }
    
    public void add_cinema(Cinema c){
        cinema_list.add(c);
        jumlah_bioskop++;
    }
}
