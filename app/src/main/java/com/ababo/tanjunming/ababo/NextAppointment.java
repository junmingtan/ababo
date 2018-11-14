package com.ababo.tanjunming.ababo;

public class NextAppointment {
    private static String appointmentLocation;
    private static String appointmentDate;

    public static String getAppointmentDate() {
        return appointmentDate;
    }

    public static String getAppointmentLocation(){
        return appointmentLocation;
    }

    public static void setAppointmentLocation(String location){
        appointmentLocation = location;
    }

    public static void setAppointmentDate(String date){
        appointmentDate = date;
    }
}
