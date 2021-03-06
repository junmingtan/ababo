package com.ababo.tanjunming.ababo;

import java.util.ArrayList;
import java.lang.String ;

/**
 * entity class that stores all the interested donors
 */
public class InterestList implements InterestSubjectInterface {

    private ArrayList<Donor> north = new ArrayList<Donor>();
    private ArrayList<Donor> south = new ArrayList<Donor>();
    private ArrayList<Donor> east = new ArrayList<Donor>();
    private ArrayList<Donor> west = new ArrayList<Donor>();
    private ArrayList<Donor> central = new ArrayList<Donor>();

    private static InterestList instance;
    private InterestList(){}
    public static InterestList getInstance(){
        if(instance == null){
            synchronized (InterestList.class) {
                instance = new InterestList();
            }
        }
        return instance;
    }



    @Override
public void addObserver (Donor o , String location ){
    boolean e;
    switch (location){

        case "North":
            e =north.add(o);
            if (e == false){
                // show toast that the interest has not been recorded
            }
            break;

        case "South":
            e =south.add(o);
            if (e == false){
                // show toast that the interest has not been recorded
            }
            break;

        case "East":
            e =east.add(o);
            if (e == false){
                // show toast that the interest has not been recorded
            }
            break;

        case "West":
            e =west.add(o);
            if (e == false){
                // show toast that the interest has not been recorded
            }
            break;

        case "Central":
            e = central.add(o);
            if (e == false){
                // show toast that the interest has not been recorded
            }
            break;


    }
}
    @Override
public void removeObserver(Donor o , String location) {

    boolean e;
    switch (location) {

        case "North":
            e = north.remove(o);
            if (e == false){
                // show toast that the interest has not been removed
            }
            break;

        case "South":
            e = south.remove(o);
            if (e == false){
                // show toast that the interest has not been removed
            }
            break;

        case "East":
            e = east.remove(o);
            if (e == false){
                // show toast that the interest has not been removed
            }
            break;

        case "West":
            e =west.remove(o);
            if (e == false){
                // show toast that the interest has not been removed
            }
            break;

        case "Central":
            e =  central.remove(o);
            if (e == false){
                // show toast that the interest has not been removed
            }
            break;

    }

}

    @Override

    public void notifyObserver(String location, String anncmt) {


        switch (location) {

            case "North":
                for (Donor o : north) {
                    o.update(anncmt);
                }
                break;

            case "South":
                for (Donor o : south) {
                    o.update(anncmt);
                }
                break;

            case "East":
                for (Donor o : east) {
                    o.update(anncmt);
                }
                break;

            case "West":
                for (Donor o : west) {
                    o.update(anncmt);
                }
                break;

            case "Central":
                for (Donor o : central) {
                    o.update(anncmt);
                    break;

                }
        }
    }


        public int returnNorthsize () {
            return north.size();
        }
        public int returnSouthsize () {
            return south.size();
        }
        public int returnEastsize () {
            return east.size();
        }
        public int returnWestsize () {
            return west.size();
        }
        public int returnCentralsize () {
            return central.size();
        }


}
