package com.ababo.tanjunming.ababo;

public class InterestFormManager {

    /**
     * take in param from the buttons of the indicate interest activity class
     * @param o
     * @param location
     */

    // calls this when user indicated interest , takes in the donor information and the location of interest
    public static void  submitInterest( Donor o , String location){
    InterestList.getInstance().addObserver(o,location);
    }
    // call when the withdraw interest button is pressed
    public static void  withdrawInterest( Donor o , String location){
        InterestList.getInstance().removeObserver(o,location);
    }


}
