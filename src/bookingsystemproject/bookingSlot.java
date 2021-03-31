
package bookingsystemproject;


public class bookingSlot {
    public String name;
    public String email;
    public String Password;
    public int roomNo;
    public String wheelchair;
    public String refreshments;
    public String refreshmentTime;
   // public boolean booked;
    public String month;
    public int day;
    public String time;
    public String resources;

    public String getRefreshmentTime() {
        return refreshmentTime;
    }

    public void setRefreshmentTime(String refreshmentTime) {
        this.refreshmentTime = refreshmentTime;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public bookingSlot(String name, String email, String Password, int roomNo, String wheelchair, String refreshments, String refreshmentTime, String month, int day, String time, String resources) {
        this.name = name;
        this.email = email;
        this.Password = Password;
        this.roomNo = roomNo;
        this.wheelchair = wheelchair;
        this.refreshments = refreshments;
        this.refreshmentTime = refreshmentTime;
        this.month = month;
        this.day = day;
        this.time = time;
        this.resources = resources;
    }




    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }



    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }



    public String getWheelchair() {
        return wheelchair;
    }

    public void setWheelchair(String wheelchair) {
        this.wheelchair = wheelchair;
    }

    @Override
    public String toString() {
        return  name + ", " + email + ", " + Password + ", " + roomNo + ", " + wheelchair + ", " + refreshments + ", " + refreshmentTime + ", " + month + ", " + day + ", " + time + ", " + resources ;
    }

    

  


   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    

    public String getRefreshments() {
        return refreshments;
    }

    public void setRefreshments(String refreshments) {
        this.refreshments = refreshments;
    }
}
