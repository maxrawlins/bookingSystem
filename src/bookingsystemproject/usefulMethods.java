package bookingsystemproject;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class usefulMethods {

    public static ArrayList<bookingSlot> bookings = new ArrayList<>();
    
    
    public void start(){
        bookings=readFile();
    }

    public String outputBooking(){
        String b = "";
        for(int i = 0 ; i<bookings.size();i++){
            b=b+"\n "+ bookings.get(i).toString();
        }
        return b;
    }
   
    public boolean alreadyGotBooking(String month, String day , String time,String email){
         boolean isAvailable = true;
        for (int i=0 ; i<bookings.size();i++){
            
            String alreadyBooked = bookings.get(i).getMonth()+" "+bookings.get(i).getDay()+" "+bookings.get(i).getTime()+" "+bookings.get(i).email;
            String attemptedBooking = month +" "+ day +" "+ time + " "+ email;
           // System.out.println(alreadyBooked +"\n"+attemptedBooking+"\n\n");
            if(alreadyBooked.equals(attemptedBooking)){
                isAvailable =false;
                //System.out.println(isAvailable);
            }
        }
        return isAvailable;
    }
    public boolean availablity(String month, String day , String time,int roomNo){
        boolean isAvailable = true;
        for (int i=0 ; i<bookings.size();i++){
            
            String alreadyBooked = bookings.get(i).getMonth()+" "+bookings.get(i).getDay()+" "+bookings.get(i).getTime()+" "+bookings.get(i).getRoomNo();
            String attemptedBooking = month +" "+ day +" "+ time + " "+ roomNo;
           // System.out.println(alreadyBooked +"\n"+attemptedBooking+"\n\n");
            if(alreadyBooked.equals(attemptedBooking)){
                isAvailable =false;
                //System.out.println(isAvailable);
            }
        }
        return isAvailable;
    }
    public boolean checkDetails(char[] password,String username){
       // System.out.println(password +" 0000 "+username);
       boolean validDetails = false;
        for (int i = 0; i < bookings.size(); i++) {
            String pword = new String(password);
            String uname = username;
            
         
            if ((bookings.get(i).getEmail().equals(uname) && (bookings.get(i).getPassword().equals(pword)))) {
   //int currentUNameIndex = i;
 validDetails = true;
 
               /* viewBookings start = new viewBookings();
                Toolkit tk = Toolkit.getDefaultToolkit();
                int width = (int) tk.getScreenSize().getWidth();
                int height = (int) tk.getScreenSize().getHeight();

                start.setSize(width, height);
                start.setVisible(true);*/
                
                //this.dispose();
            } 
        }
        return validDetails;
    }

    public void mainMenu() {
        bookings = usefulMethods.readFile();
        Scanner input = new Scanner(System.in);
        while (true) {
            boolean validOption = false;
            int option = 0;
            while (validOption == false) {
                System.out.println("hi would you like to\n1>book a room\n2>view rooms booked in your name\n3>exit");
                try {
                    option = input.nextInt();
                    validOption = true;
                } catch (Exception e) {
                    System.out.println("needs to be an integer");
                }

            }
            if (option == 1) {
                newBooking();
            } else if (option == 2) {
                printBookings();
            } else if (option == 3) {
                writeFile(bookings);
                System.exit(0);
            }
        }
    }

    public void newBooking() {
        Scanner input = new Scanner(System.in);
        System.out.println("what is your name:");
        String name = input.nextLine();
        boolean validEmail = false;
        String email = null;
        while (validEmail == false) {
            System.out.println("what is your email:");
            email = input.nextLine();
            if (email.contains("@")) {
                validEmail = true;
            } else {
                System.out.println("invalid email please try again!");
                //input.next();
            }
        }

        boolean validPassword = false;
        String password = null;
        while (validPassword == false) {
            System.out.println("please choose a password to use;");
            password = input.nextLine();
            System.out.println("please re-enter password");
            String password2 = input.nextLine();
            if (password.equals(password2)) {
                validPassword = true;
            } else {
                System.out.println("passwords did not match please try again");
            }
        }
        System.out.println("how many people are you booking for ");
        int numOfpeople = input.nextInt();

        String wheelchair = null;
        System.out.println("do you need wheelchair access?\n1>yes\n2>no\n(enter as an integer)");
        int wheelChairAccess = input.nextInt();
        if (wheelChairAccess == 1) {
            wheelchair = "yes";
        } else if (wheelChairAccess == 2) {
            wheelchair = "no";
        }
        //int roomNo = suggestedRoom(numOfpeople);//
        System.out.println("what month do you require?");
        input.nextLine();
        String month = input.nextLine();
        int daysInMonth = 0;
        if (month.equals("january")) {
            daysInMonth = 31;
        } else if (month.equals("february")) {
            daysInMonth = 28;
        } else if (month.equals("march")) {
            daysInMonth = 31;
        } else if (month.equals("april")) {
            daysInMonth = 30;
        } else if (month.equals("may")) {
            daysInMonth = 31;
        } else if (month.equals("june")) {
            daysInMonth = 30;
        } else if (month.equals("july")) {
            daysInMonth = 31;
        } else if (month.equals("august")) {
            daysInMonth = 31;
        } else if (month.equals("september")) {
            daysInMonth = 30;
        } else if (month.equals("october")) {
            daysInMonth = 31;
        } else if (month.equals("november")) {
            daysInMonth = 30;
        } else if (month.equals("december")) {
            daysInMonth = 31;
        }
        boolean validDay = false;
        int date = 0;
        while (validDay == false) {
            System.out.println("which date do you want to book for");
            date = input.nextInt();
            if (date > daysInMonth) {
                System.out.println("this date does not exist as there are not " + date + " days in " + month);
            } else if (date < daysInMonth) {
                validDay = true;
            }
        }
        boolean validTime = false;
        String time=null;
        while (validTime == false) {
            time=null;
            try{
            System.out.println(" the times available on " + month + " " + date + " are :\n1> 09:00\n2> 10:30\n3> 12:00\n4> 13:30\n5> 15:00\n6> 16:30\n7> 18:00");
            
            int timeOption = input.nextInt();
            if (timeOption == 1) {
                time = "09:00";
            } else if (timeOption == 2) {
                time = "10:30";
            } else if (timeOption == 3) {
                time = "12:00";
            } else if (timeOption == 4) {
                time = "13:30";
            } else if (timeOption == 5) {
                time = "15:00";
            } else if (timeOption == 6) {
                time = "16:30";
            } else if (timeOption == 7) {
                time = "18:00";
            }
            validTime=true;
            }catch (Exception e) {
                System.out.println("this wasn't a valid option, please make sure you entered an integer");
            }
        }
        //input.nextLine();
        //String time = input.nextLine();
        System.out.println("do you require refreshments?");
        input.nextLine();
        String refreshments = input.nextLine();

        System.out.println("what time do you require these at?");
        String refreshmentTime = input.nextLine();
        System.out.println("do you require any other resources for the event, e.g. pens paper?");
        String resources = input.nextLine();
//        bookingSlot b = new bookingSlot(name, email, password, roomNo, wheelchair, refreshments, refreshmentTime, month, date, time, resources);
       // bookings.add(b);

    }

    public static void writeFile(ArrayList<bookingSlot> bookings) {
        try {
            FileWriter writeToFile = new FileWriter(System.getProperty("user.dir") + "\\bookingSlotsFile.txt", false);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            for (int i = 0; i < bookings.size(); i++) {
                printToFile.println(bookings.get(i).toString());
            }
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
public void write(){
    writeFile(bookings);
}
    public static ArrayList<bookingSlot> readFile() {
        ArrayList<bookingSlot> bookings = new ArrayList<>();
        String lineFromFile;
        try {
            BufferedReader read = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\bookingSlotsFile.txt"));
            while ((lineFromFile = read.readLine()) != null) {
                String[] bookingDetails = lineFromFile.split(", ");
                //System.out.println(bookingDetails.length);

                bookingSlot booking = new bookingSlot(bookingDetails[0], bookingDetails[1], bookingDetails[2], Integer.parseInt(bookingDetails[3]), bookingDetails[4], bookingDetails[5], bookingDetails[6], bookingDetails[7], Integer.parseInt(bookingDetails[8]), bookingDetails[9], bookingDetails[10]);
                bookings.add(booking);

            }
            read.close();
        } catch (Exception e) {
            System.out.println("error" + e);
        }
        return bookings;

    }

    public void reset() {
        try {
            FileWriter writeToFile = new FileWriter(System.getProperty("user.dir") + "\\bookingSlotsFile.txt", false);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            printToFile.println("");
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

    public void printBookings() {
        ArrayList<bookingSlot> booked = readFile();
        System.out.println("\n\n\nThe current bookings");
        for (int i = 0; i < booked.size(); i++) {
            System.out.println(booked.get(i));
        }
    }

    public int suggestedRoom(int people,String wc) {
        int roomNo = 0;
        if (people <= 2) {
            roomNo = 1;
        } else if (people <= 4) {
            roomNo = 2;
        } else if (people <= 8) {
            roomNo = 3;
        } else if (people <= 15) {
            roomNo = 4;
        } else if (people <= 50) {
            roomNo = 5;
        }
        if (wc.equals("wheelchair")){
            roomNo=4;
        }
        return roomNo;
    }
    public void homeButton(){
         startingMenu start = new startingMenu(); 
        Toolkit tk = Toolkit.getDefaultToolkit();
        int width =(int) tk.getScreenSize().getWidth();
         int height =(int) tk.getScreenSize().getHeight();

        start.setSize(width,height);
        start.setVisible(true);
        //this.dispose();
    }
}
