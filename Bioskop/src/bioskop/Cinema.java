package bioskop;

import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Intan Maharani
 */
public class Cinema {
    private int id_cinema;
    private String name_cinema;
    private int jumlah_film;
    private int jumlah_studio;
    private int jumlah_jadwal;
    LinkedList<Film> film_list = new LinkedList<>();
    LinkedList<Studio>studio_list = new LinkedList<>();
    LinkedList<jadwal_film>list_jadwal = new LinkedList<>();
    //jadwal film
    
    public Cinema (String nama_cinema, int id_cinema){
        this.name_cinema = nama_cinema;
        this.id_cinema = id_cinema;
        this.jumlah_film = 0;
        this.jumlah_jadwal = 0;
        this.jumlah_studio = 0;
    }

    public int getId_cinema() {
        return id_cinema;
    }

    public String getName_cinema() {
        return name_cinema;
    }
    
    public void add_Jadwal(jadwal_film j){
        list_jadwal.add(j);
        jumlah_jadwal++;
    }
    
    public void add_film(Film f){
        film_list.add(f);
        jumlah_film++;
    }
    
    public void add_studio(Studio s){
        studio_list.add(s);
        jumlah_studio++;
    }
    
    public void show_list_film(){
        for (Film f : film_list){
            System.out.println("Title     : "+ f.getJudul_film());
            System.out.println("Genre     : "+ f.getGenre_film());
            System.out.println("Duration  : "+ f.getDurasi_film());
            System.out.println("Sinopsis  : "+ f.getSinopsis_film());
        }
    }
    
    public void show_list_studio(){
        for (Studio s : studio_list){
            System.out.println("Nomor Theater     : "+ s.getNomor_theater());
            System.out.println("Jumlah Kursi      : "+ s.getJumlah_kursi()+"/baris");
        }
    }
    

}
