package com.ababo.tanjunming.ababo;

public interface InterestSubjectInterface {
    public void addObserver(Donor o , String location);
    public void removeObserver ( Donor o ,String location);
    public void notifyObserver(String location, String annoucement);
}
