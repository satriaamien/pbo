/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioskop;
import java.io.Serializable;

/**
 *
 * @author ariq
 */
public class top_up implements Serializable{
    private String method;
    private int ammount;
    private String date;

    public top_up(String method, int ammount, String date) {
        this.method = method;
        this.ammount = ammount;
        this.date = date;
    }

    public String getMethod() {
        return method;
    }

    public int getAmmount() {
        return ammount;
    }

    public String getDate() {
        return date;
    }
    
    
    
    
    
}
