/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

/**
 *
 * @author stephanietreacy
 */
public class movies{
    String movieName;
    public int []seats;
    double ticketPrice;
    
    public movies(String movieName, int numseats, double ticketPrice){
        this.movieName=movieName;
        seats = new int[numseats];
        this.ticketPrice = ticketPrice;
              
    }
    public void getMovie(){
        
    }
    
    public void getNumSeats(int seats){
        
    }
}
