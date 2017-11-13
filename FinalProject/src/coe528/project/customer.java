
package coe528.project;

public class customer {

    
    private String Username;
    private String password;
    private int accnum, seatnum=0;
    private String title, q;
    private double totalprice;
    private Booked booked;
    private movies movie1;
    private int age;

    public String getUsername() {
        return Username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public movies getMovie1() {
        return movie1;
    }

    public void setMovie1(movies movie1) {
        this.movie1 = movie1;
    }

    public void setBooked(movies movies1, int j, int k,int stat) {
        booked = new Booked(movies1, j, k,stat);
    }

    public String getPassword() {
        return password;
    }

    public int getAccnum() {
        return accnum;
    }

    public customer(String Username, String password, int accnum, int age) {

        this.Username = Username;
        this.password = password;
        this.accnum = accnum;
        this.age=age;

    }

    public int getSeatnum() {
        return seatnum;
    }

    public void setSeatnum(int seatnum) {
        this.seatnum = seatnum;
    }

    public String getTitle() {
        return title;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void purchaseTicket(int age, int seats, String movieName, movies movies1,int status) {
        //customer should get discounts as applicable, based on age if they buy one ticket,number of seats purchased
        //need access to movies array here

        totalprice = movies1.getTicketPrice();
        title = movies1.getMovie();
        seatnum = seats;
        setSeatnum(seatnum);
        setMovie1(movies1);
        System.out.println("seats"+seats);
        // need to decrement the amount of seats availble will make another class called booked that will access the seat booking
        // will be accessed via book.seatavailable()

        if (seats == 1) {//discount on age, 10% discount
            if (age < 12 || age > 64) {
                totalprice = totalprice * 0.9;
                System.out.println("Age discount");
                System.out.println("new ticket price $ " + totalprice);

            }else System.out.println("full price ticket");

        }
        if (seats == 2)//discount 5%
        {
            totalprice = totalprice * 0.95;
            System.out.println("2 seat discount");
            System.out.println("new ticket price$ " + totalprice);
        }
        if (seats == 3)//discount 10%
        {
            totalprice = totalprice * 0.9;
            System.out.println("3 seat discount");
            System.out.println("new ticket price$ " + totalprice);
        }
        if (seats == 4)//discount 20%
        {
            System.out.println("4 seat discount");

            totalprice = totalprice * 0.8;
            System.out.println("new ticket price$ " + totalprice);
        }
      if(status==1){
        setBooked(movies1, 1, seats, 1);}
      else{
      setBooked(movies1,1, seats/2, 2);
      }
        
        
       
        

    }

    public void refundTicket(movies movies1, int seats) {

        setBooked(movies1, 0, getSeatnum(),0); //this should be the calling to booked from refund ticket

        title = null;
        seatnum = 0;
        totalprice = 0;
    }

    public void SetinformationONticket() {
        //will use this method to possibly gather info from customer array in the main login screen
            if(getTitle()==null){
            
            System.out.println("No purchases made, no info to display");}
            else{
        System.out.println("Movie Title: " + getTitle() + "\n Number of seats" + getSeatnum() + "\n Price:$ " + getTotalprice());
            }
    }

}
