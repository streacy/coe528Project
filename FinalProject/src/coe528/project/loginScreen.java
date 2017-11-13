
package coe528.project;

import java.util.Scanner;
import java.util.ArrayList;

public class loginScreen {

    static private int k = 0, p = 1;
    private static ArrayList<customer> userspointer;
    private static ArrayList<String> titles;
    static private ArrayList<movies> movieArr;

    public static manager Managersetup(manager one) {
        String password, name;
        int x = 0, x1 = 0, z1 = 0, qw = 0, b = 0;

        System.out.println("Security: Manager Setup: please enter/re Enter a password of 5 characters length, user automatically set as admin (admin,admin)");
        while (x == 0) {
            Scanner v = new Scanner(System.in);
            password = v.nextLine();
            if (password.length() <= 5) {

                if (password.equals(one.getAdminPassword()) == true) {

                    System.out.println("Password Accepted");
                    System.out.println("enter Username");

                    while (z1 == 0) {
                        if (v.hasNextLine() == true) {
                            name = v.nextLine();
                            if (name.equals(one.getUserName())) {
                                System.out.println("Username Accepted");
                                x = 1;
                                z1 = 1;
                            } else {
                                System.out.println("wrong Username or exceeds length 5 char");
                            }

                        } else {
                            System.out.println("enter a valid string");
                        }
                    }
                } else {
                    System.out.println("wrong password");
                }
            } else {
                System.out.println("enter a password of 5 characters length");
            }
        }

        System.out.println("As a manager you must create Movies");

        do {

            System.out.println(" \n Press 1 to create Movie \n Press 2 To LogOut of Manager");

            while (qw == 0) {
                Scanner q = new Scanner(System.in);
                if (q.hasNextInt() == true) {
                    b = q.nextInt();
                    if (b == 1 || b == 2) {
                        break;
                    } else {
                        System.out.println("enter 1 or 2");
                    }
                } else {
                    System.out.println("enter valid integer");
                }
            }

            if (b == 1 || b == 2) {//if statements corresponding to user input

                if (b == 1) {
                    String movieName;
                    double price;
                    int seatNum, y9 = 0, y8 = 0;
                    System.out.println("Type in movie title to create"); // movie title cannot occur twice 
                    Scanner v = new Scanner(System.in);
                    movieName = v.nextLine();

                    while (y9 == 0) {
                        Scanner yo = new Scanner(System.in);
                        System.out.println("enter ticket price, ticket price lies from 5 to 25 dollars");
                        if (yo.hasNextDouble() == true) {
                            price = yo.nextDouble();
                            if (price > 5 && price < 25.0) {

                                while (y8 == 0) {
                                    Scanner yo1 = new Scanner(System.in);
                                    System.out.println("enter # of available seats for the movie between 20 and 30 seats");
                                    if (yo1.hasNextInt() == true) {
                                        seatNum = yo1.nextInt();
                                        if (seatNum > 19 && seatNum <31) {// 19 and 31
                                            if (k > -1 && k < 8) {

                                                one.addMovie(movieName, seatNum, price, k);
                                                y8 = 1;
                                                y9 = 1;
                                                k++;
                                                System.out.println("movie created");

                                            } else {
                                                System.out.println("reached maximum amount of movies to create for the day");
                                                y8 = 1;
                                                y9 = 1;

                                            }
                                        } else {
                                            System.out.println("movie theater capacity lies from 19 to 31 seats ");
                                        }
                                    } else {
                                        System.out.println("Enter a valid decimal number");
                                    }
                                }

                            }
                        } else {
                            System.out.println("ticket prices can only be between 5 and 25 dollars");
                        }
                    }

                }

                if (b == 2) {//Exit Manager
                    System.out.println("exiting manager");
                    x1 = 1;
                }
            } else {
                System.out.println("Enter a valid number to access directory");
            }
        } while (x1 == 0);

        return one;
    }

    public static void CustomerAccess(int i, ArrayList<customer> userspointer1, ArrayList<String> titles1, ArrayList<movies> movies1) {
        // customer should be able to purchase a ticket, refund a ticker
        //and check the information on their seats, need to pass the customer array
        // that customer array needs to have a pointer to the customers specific seat

        int y = 0, x = 0;

        do {
            int x1 = 0;
            int b = 0;
            System.out.println(" \n Press 1 Purchase Ticket\n Press 2 to View Info on Booking\n "
                    + "Press 3 Refund Tickets\n Press 4 for titles playing\n Press 5 Exits");

            while (x1 == 0) {
                Scanner v = new Scanner(System.in);
                if (v.hasNextInt() == true) {
                    b = v.nextInt();
                    x1 = 1;
                } else {
                    System.out.println("enter an integer");
                }
            }

            if (b == 1 || b == 2 || b == 3 || b == 4 || b == 5) {//if statements corresponding to user input

                if (b == 1) {//Purchase Tickets
                    if(movies1.isEmpty()==false){
                    int age = 0, y1 = 0;
                    //Enter age
                   

                    //enter seats and need to check the seat availability, need to pass through movies seats
                    //
                    System.out.println("Available movies");
                    String q = "\n";
                    for (int k = 0; k <= movies1.size() - 1; k++) { // check the movies with a for loop that loops through and macthes the name hence also matching the number of seast along with it
                        if (movies1.get(k) == null) {
                        } else {
                           q = "Movie: " + (k + 1) + " " + movies1.get(k).movieName+ " Seats avaiable: "+ movies1.get(k).SeatsAvailable() + q;
                            System.out.println(q);
                        }

                    }

                    int lp = 0;
                    String titlerequest;
                    do {
                        // ask user to input a string of movie title they like to attend 
                        // title doesnt exist then loop and ask them to  do it again 
                        System.out.println("enter a movie title");
                        Scanner moviet = new Scanner(System.in);
                        titlerequest = moviet.nextLine();
                        if (userspointer1.get(i).getTitle() == null || titlerequest.equals(userspointer1.get(i).getTitle())) {
                         
                            if (titles1.contains(titlerequest)) {
                                int j = 0;
                                for (int k1 = 0; k1 <= movies1.size() - 1; k1++) {
                                    j = movies1.get(i).getMovie().indexOf(titlerequest);
                                }

                                //check available seats for that title
                                // if avaiable ask user to input value for seats
                                //check if user entered a valid int and that their is a number of seats avaiable
                                //  for (int j = 0; j < movies1.length; j++) {//enhanced loop
                                if (titlerequest.equals(movies1.get(j).getMovie())) {
                                    if (movies1.get(j).SeatsAvailable() > 0) {

                                        System.out.println("Available seats");
                                        System.out.println(movies1.get(j).SeatsAvailable());
                                        System.out.println("enter Number of seats you would like to purchase(limited to 4 per person)");
                                        int p1 = 0, seatholder;
                                        while (p1 == 0) {
                                            Scanner seatsnum = new Scanner(System.in);
                                            if (seatsnum.hasNextInt() == true) {
                                                seatholder = seatsnum.nextInt();
                                                   if(userspointer1.get(i).getSeatnum()==0){ //customer can still purchase tickets as long as his seat balance is below 4 ADDED
                                                if (seatholder > 0 && seatholder <= movies1.get(j).SeatsAvailable()) {
                                                    if (seatholder < 5 && seatholder > 0) {
                                                        userspointer1.get(i).purchaseTicket(userspointer.get(i).getAge(), seatholder, titlerequest, movies1.get(j),1);
                                                        // should have a away to decrement the seats in movie and from customer point to movie so user can later access info
                                                        p1 = 1;
                                                        lp = 1;
                                                        break;
                                                    } else {
                                                        System.out.println(" enter any seat number from 1-4");
                                                    }

                                                } else {
                                                    System.out.println("seat number should be less than or equal to the available seats");
                                                }

                                            } else {
                                                   //
                                                       if (seatholder > 0 && seatholder <= movies1.get(j).SeatsAvailable()) {
                                                    if ((seatholder + userspointer1.get(i).getSeatnum())<=4 && seatholder > 0) {
                                                        userspointer1.get(i).purchaseTicket(userspointer.get(i).getAge(), userspointer1.get(i).getSeatnum()+seatholder, titlerequest, movies1.get(j),2);
                                                        // should have a away to decrement the seats in movie and from customer point to movie so user can later access info
                                                        p1 = 1;
                                                        lp = 1;
                                                        break;
                                                    } else {
                                                        if(userspointer.get(i).getSeatnum()==4){
                                                        lp=1;
                                                        p1=1;
                                                        System.out.println("already have max tickets");
                                                        }
                                                        else{
                                                        System.out.println(" enter any seat number from 1-4, new seats exceeds 4");
                                                        }
                                                    }

                                                } else {
                                                    System.out.println("seat number should be less than or equal to the available seats");
                                                }
                                                       
                                                       
                                                 //      
                                                   
                                                   
                                                   
                                                   }
                                            
                                            
                                            
                                            } else {
                                                System.out.println("enter an integer");
                                            }

                                        }
                                    } else {
                                        System.out.println("No seats available for this movie");
                                    }
                                }

                                // }
                            } else {
                                System.out.println("enter a valid movie title from the selection \n" + q);

                            }
                       
                        } else {
                            lp=1;
                            System.out.println("you already purchased tickets, refund tickets to buy tickets to another movie");
                        }

                    } while (lp == 0);

                    //prompt user for input of age cant be negative,seats limit is 1 to 4, moviename must match one of those available
                    //  userspointer1.get(i).purchaseTicket(b, b, movieName);
                }else System.out.println("no movies available");}

                if (b == 2) {//View Info on customers account his/her purchases, #of seats, movie title, 

                    userspointer1.get(i).SetinformationONticket();

                }
                if (b == 3) {//Refund tickets
                    int lp1 = 0;

                    do {

                        if (userspointer1.get(i).getTitle() == null) {
                            System.out.println("You haven't purchased any tickets, no tickets to refund");
                            lp1 = 1;
                        } else {
                            System.out.println("will be refunding this booking");
                            userspointer1.get(i).SetinformationONticket();
                           // System.out.println(userspointer1.get(i).getSeatnum() + " " + userspointer1.get(i).getMovie1());
                            userspointer1.get(i).refundTicket(userspointer1.get(i).getMovie1(), userspointer1.get(i).getSeatnum());
                            lp1 = 1;

                        }

                    } while (lp1 == 0);

                }

                if (b == 5) {//exit
                    x = 1;
                }

                if (b == 4) {
                    String q = "\n";
                    // view movies playing
                    //best to implement this through a method in manager class
                    if(movies1.isEmpty()==false) {
                    System.out.println("Available movies");
                    for (int io = 0; io <= movies1.size() - 1; io++) { // check the movies with a for loop that loops through and matches the name hence also matching the number of seast along with it
                        //System.out.println(io+" "+titles1.size());
                        if (movies1.get(io) == null) {
                            System.out.println("here1");
                        } else {
                            q = "Movie: " + (io + 1) + " " + movies1.get(io).movieName+ " Seats avaiable: "+ movies1.get(io).SeatsAvailable() + q;
                            System.out.println(q);
                        }

                    }
                    }
                    else System.out.println("No movies Available");
                    
                    
                    

                    //  System.out.println("here"); 
                }
            } else {
                System.out.println("Enter a valid number to access directory");
            }
        } while (x == 0);

    }

    public static void main(String[] args) {

        manager one = new manager();
        System.out.println("Manager unique number is 0");

        one = Managersetup(one);
        //exit manager

        System.out.println("Accesssing Main directory");

        String name, password;
        int x = 0, accnum = 0;//set it zero here no account will have 0 for users
        while (x == 0) {
            int access;
            System.out.println("Press 1 to enter to Login As customer\n Press 2 to Register as a user\n 3 To exit");
            Scanner q = new Scanner(System.in);
            if (q.hasNextInt() == true) {
                access = q.nextInt();

                if (access == 1) {

                    System.out.println("Login: enter Username ");
                    Scanner h = new Scanner(System.in);
                    name = h.nextLine();
                    System.out.println("Login: enter password");
                    password = h.nextLine();
                    System.out.println("enter password account number");
                    int x1 = 0;
                    while (x1 == 0) {

                        Scanner pop = new Scanner(System.in);
                        if (pop.hasNextInt() == true) {
                            accnum = pop.nextInt();
                            x1 = 1;
                        } else {
                            System.out.println("enter an integer");

                        }

                    }
                    // useful info needed for purchase ticket
                    userspointer = one.getList();//does this update later on??????
                    titles = one.getMovieTitles();
                    movieArr = one.getMovies();
                    int counter1 = 0;
                    try {
                        //System.out.println(accnum+password+name+" "+one.getAdminPassword()+one.getUserName()+one.getAccountNum());

                        if (password.equals(one.getAdminPassword()) && name.equals(one.getUserName()) && accnum == one.getAccountNum()) {//check manager login

                            Managersetup(one);
                        } else// System.out.println("in here");
                        if (userspointer.size() >= 1) {
                            for (int i = 0; i <= userspointer.size() - 1; i++) {
                                //System.out.println("in here");
                                if (password.equals(userspointer.get(i).getPassword()) && name.equals(userspointer.get(i).getUsername()) && accnum == userspointer.get(i).getAccnum()) {
                                    System.out.println("Logged into Account: " + name);
                                    // System.out.println(titles.size());
                                    CustomerAccess(i, userspointer, titles, movieArr);// customer access account here, customer will have access to customer profile arraylist
                                    System.out.println("logged out");
                                    counter1++;
                                } else {

                                }
                            }
                            //System.out.println(counter);
                            if (counter1 > 0) {
                                //System.out.println("account doesnt exist");//add counter here}
                            } else {
                                System.out.println("account doesnt exist3");
                            }

                        } else {
                            System.out.println("account doesnt exist2");
                        }
                    } catch (IndexOutOfBoundsException a) {
                        System.out.println("account doesnt exist1");
                    }

                }
                if (access == 2) {// register as a user only a Username and Password is required account number is given to user 

                    String name1, password1;

                    Scanner h = new Scanner(System.in);
                    System.out.println("Login: enter password for new account");
                    password1 = h.nextLine();
                    int x3 = 0;
                    while (x3 == 0) {
                        System.out.println("Login: enter Username ");
                        int dido = 0;
                        Scanner v = new Scanner(System.in);
                        name1 = v.nextLine();
                        
                        
                        int y1=0, age=0;
                         while (y1 == 0) {
                        System.out.println("enter age");
                        Scanner v1 = new Scanner(System.in);
                        if (v1.hasNextInt() == true) {
                            age = v1.nextInt();
                            if (age > 0) {
                               
                                y1 = 1;
                            } else {
                                System.out.println("enter value above 0 for age");
                            }
                        } else {
                            System.out.println("enter a valid integer for age");
                        }
                    }
                        
                        
                        
                        

                        try {

                            if (userspointer.isEmpty() == true) {
                                System.out.println("Unique Account Number is: " + p);
                                one.createAccount(name1, password1, p++,age);
                                
                                x3 = 1;
                            } else {
                                for (int i = 0; i < userspointer.size() - 1; i++) {

                                    if (name1.equals(userspointer.get(i).getUsername())) {// change this up to actual user name no tthe names array
                                        dido++;
                                    }
                                }
                                System.out.println("dido value" + dido);
                                if (dido > 1) {
                                    System.out.println("Username already exists, choose another name, Enter another Username");
                                } else {
                                    System.out.println("Unique Account Number is: " + p);
                                    one.createAccount(name1, password1, p++, age);
                                    
                                    x3 = 1;
                                }

                            }

                        } catch (NullPointerException ex) {
                            System.out.println("Unique Account Number is: " + p);
                            one.createAccount(name1, password1, p++,age);
                            //System.out.println("Unique Account Number is: " + p);
                            x3 = 1;

                        }

                    }

                }
                if (access == 3) {
                    x = 1;

                }

            } else {
                System.out.println("enter an integer");
            }

        }

    }

}
