
package coe528.project;

public class Booked {

    private movies movies1;

    public Booked(movies movies1, int j, int k, int stat) {

        this.movies1 = movies1;
        System.out.println(movies1.getMovie());
        if (j == 1) {// j=1 we are reserving seats
            SeatsAvailableDecremenet(k,stat);

        }
        if (j == 0) {//j=0 we are returning seats 

            SeatsAvailableIncremenet(k);

        }

    }

    public void SeatsAvailableDecremenet(int k,int status) {//k is the number of seats to reserve
        //number of available seats after purchase of tickets
        int count = k;
       
        for (int i = 0; i < movies1.seats.length; i++) {
            if (movies1.seats[i] == 0 && count > 0) {
                movies1.seats[i] = 1;
                count--;

            }
        }
    if(status==1){
        System.out.println("seats booked: " + k);
    }else System.out.println("total seats booked: " + 2*k);
    }

    public void SeatsAvailableIncremenet(int k) {// is the number of seats to return
        //number of available seats after a refund
        int count = k;
        System.out.println(movies1.seats.length);
        for (int i = 0; i < movies1.seats.length; i++) {
            if (movies1.seats[i] == 1 && count > 0) {
                movies1.seats[i] = 0;
                count--;

            } 
                // what if customer wants 4 seats but can only book 3 
            
        }

        System.out.println("seats refunded: " + k);// will be implemented later on in refund methods

    }

}
