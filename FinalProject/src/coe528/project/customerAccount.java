/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.util.ArrayList;

/**
 *
 * @author stephanietreacy
 */
public abstract class customerAccount {
    static ArrayList<customer> activeUsers; 
    public abstract void purchaseTicket(int age, int seats, String movieName);
    public abstract void refundTicket(String movieName);
    
}
