
package coe528.project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class manager {

    private String userName = "admin";
    private String adminPassword = "admin";
    static private int accountNumber = 0;
    static private ArrayList< movies> movieArr = new ArrayList<movies>();
    static private ArrayList<String> MovieTitles = new ArrayList<String>();
    static private ArrayList<customer> activeusers = new ArrayList<customer>();

    public manager() {

    }

    public void addMovie(String movieName, int numSeats, double ticketPrice, int movieNumber) {
        movieArr.add(new movies(movieName, numSeats, ticketPrice));
        MovieTitles.add(movieName);

    }

    public static ArrayList<String> getMovieTitles() {
        return MovieTitles;
    }

    public void createAccount(String username, String password, int accnum, int age) {

        activeusers.add(new customer(username, password, accnum, age));

    }

    public String getUserName() {
        return userName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public int getAccountNum() {
        return accountNumber;
    }

    public ArrayList<movies> getMovies() {
        return movieArr;
    }

    public static ArrayList<customer> getList() {

        return activeusers;

    }

}
