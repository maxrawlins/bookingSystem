/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingsystemproject;

//import static bookingsystemproject.usefulMethods.bookings;
import java.awt.Toolkit;

/**
 *
 * @author maxra
 */
public class BookingSystemProject {

    
    public static void main(String[] args) {
        usefulMethods um = new usefulMethods();
        um.start();
        // bookings = usefulMethods.readFile();
            startingMenu start = new startingMenu(); 
        Toolkit tk = Toolkit.getDefaultToolkit();
        int width =(int) tk.getScreenSize().getWidth();
         int height =(int) tk.getScreenSize().getHeight();

        start.setSize(width,height);
        start.setVisible(true);
    }
    
}
