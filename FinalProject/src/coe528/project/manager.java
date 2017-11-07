/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author stephanietreacy
 */

public class manager {
   private String userName = "admin";
   private String adminPassword = "admin";
   static private int accountNumber = 0;
   static private movies[] movieArr;  
   static private int k = 0;
   
    public manager(){
        
    }
    
    public void addMovie(String movieName, int numSeats, double ticketPrice){
        movieArr[k] = new movies(movieName, numSeats, ticketPrice);
        k++;
    }
    
    public String getUserNAme(){
        return userName;
    }
    
    public String getAdminPassword(){
        return adminPassword;
    }
    
    public int getAccountNum(){
        return accountNumber;
    }
    
    public movies[] getMovies(){
        return movieArr;
    }
}
