/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioskop;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author ariq
 */
public class Customer extends user implements Serializable{
    private double balance;
    LinkedList<film_booking> list_history_film = new LinkedList<>();
    LinkedList<top_up>list_top_up = new LinkedList<>();
    private int topup_amm;
    private int film_amm;
    
    public Customer(String name, String pass, String phone, String email) {
        super(name, pass, phone, email);
        this.balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }
    
    
    
    public void addTopUp(top_up x){
        list_top_up.add(x);
        this.balance += x.getAmmount();
        topup_amm++;
    }
    
    public void show_top_up_history(){
        for (top_up x : list_top_up){
            System.out.println("Ammount  : "+x.getAmmount());
            System.out.println("Method   : "+x.getMethod());
            System.out.println("Date     : "+x.getDate());
        }
    }
    
    public void add_film(film_booking x){
        list_history_film.add(x);
        this.balance = this.balance - x.getHarga();
        film_amm++;
    }
    
    public void show_history_film(){
        for (film_booking x : list_history_film) {
            System.out.println("Bioskop  : " + x.getNama_bioskop());
            System.out.println("Studio   : " + x.getNomor_studio());
            System.out.println("Film     : " + x.getJudul_film());
            System.out.println("Tanggal  : " + x.getTgl_tayang());
            System.out.println("Jam      : " + x.getJam_tayang());
            System.out.println("Seat     : " + x.getNo_seat());
            System.out.println("Harga    : " + x.getHarga());
        }
    
    }

    
    
}
