package com.ababo.tanjunming.ababo;

public class InterestListManager {

    // run on create to get the number of donor interested in the location
    public static int northSize(){
       return  InterestList.getInstance().returnNorthsize();
    }
    public static int southSize(){
        return  InterestList.getInstance().returnSouthsize();
    }
    public static int eastSize(){
        return  InterestList.getInstance().returnEastsize();
    }
    public static int westSize(){
        return  InterestList.getInstance().returnWestsize();
    }
    public static int centralSize(){
        return  InterestList.getInstance().returnCentralsize();
    }

    // call when there is a new blood drive in the area of interest and the admin wants to give an annoucement
    // call when the notify button is pressed , take in a input string and the corresponding location

    public static void notifyInterestedObservers(String location, String anncmt){
        InterestList.getInstance().notifyObserver(location , anncmt);
    }


}
