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
    public int toHours (String month, String day, String time){
        int monthHours=0;
        if (month.equals("january")){
            monthHours=0;
        }else if (month.equals("february")){
            monthHours = 744;
        }else if (month.equals("march")){
            monthHours = 1416;
        }else if (month.equals("april")){
            monthHours = 2160;
        }else if (month.equals("may")){
            monthHours = 2880;
        }else if (month.equals("june")){
            monthHours = 3624;
        }else if (month.equals("july")){
            monthHours = 4344;
        }else if (month.equals("august")){
            monthHours = 5088;
        }else if (month.equals("september")){
            monthHours = 5832;
        }else if (month.equals("october")){
            monthHours = 6552;
        }else if (month.equals("november")){
            monthHours = 7296;
        }else if (month.equals("december")){
            monthHours = 8016;
        }else{
            System.out.println("error in to hours");
        }
        int dayHours = Integer.parseInt(day) *24;
        int timeHours = Integer.parseInt(time.substring(0, 2));
        int totalHours = monthHours+dayHours+timeHours;
        return totalHours;
        
    }
    
}
