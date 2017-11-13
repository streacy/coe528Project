
package coe528.project;

public class movies {

    String movieName;
    public int[] seats;
    double ticketPrice;

    public movies(String movieName, int numseats, double ticketPrice) {
        this.movieName = movieName;
        seats = new int[numseats];

        for (int i = 0; i < seats.length; i++) {
            seats[i] = 0;

        }
        this.ticketPrice = ticketPrice;
        System.out.println("Movie title: " + movieName + "\n Number of seats: " + numseats + "\n TicketPrice: " + ticketPrice);

    }

    public String getMovie() {
        return movieName;

    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void getNumSeats() {

    }

    public int SeatsAvailable() {
        int count1 = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {

                count1++;

            } else {

            }

        }
        // System.out.println("seats available: " + count1);
        if (count1 <= 0) {
            System.out.println("movie full");
        }
        return count1;
    }

}
