package com.ababo.tanjunming.ababo;

import java.util.ArrayList;
import java.lang.String ;


public class InterestList implements InterestSubjectInterface {

    private ArrayList<Donor> north = new ArrayList<Donor>();
    private ArrayList<Donor> south = new ArrayList<Donor>();
    private ArrayList<Donor> east = new ArrayList<Donor>();
    private ArrayList<Donor> west = new ArrayList<Donor>();
    private ArrayList<Donor> central = new ArrayList<Donor>();

    @Override  // calls this when user indicated interest , takes in the donor information and the location of interest
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
// call when the withdraw interest button is pressed
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
    // call when the notify button is pressed , take in a input string
    public void notifyObserver(String location, String annoucement) {


        switch (location) {

            case "North":
                for ( Donor o : north){
                    o.update(annoucement);
                }
                break;

            case "South":
                for ( Donor o : south){
                    o.update(annoucement);
                }
                break;

            case "East":
                for ( Donor o : east){
                    o.update(annoucement);
                }
                break;

            case "West":
                for ( Donor o : west){
                    o.update(annoucement);
                }
                break;

            case "Central":
                for ( Donor o : central){
                    o.update(annoucement);
                break;

        }
    }

    // run on create to get the number of donor interested in the location
    public int returnNorthsize(){
        return north.size();
    }
    public int returnSouthsize (){
        return south.size();
    }
    public int returnEastsize (){
        return east.size();
    }
    public int returnWesthsize (){
        return west.size();
    }
    public int returnCentralsize(){
        return central.size();
    }


}
