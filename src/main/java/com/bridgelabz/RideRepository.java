package com.bridgelabz;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideRepository {

    Map<String, ArrayList<Ride>> userRides;

    public RideRepository() {
        this.userRides = new HashMap<>();
    }

    public void addRide(String userId, Ride[] rides) {
        this.userRides.put(userId, new ArrayList<>(Arrays.asList(rides)));
    }

    public Ride[] getRides(String userId) {
        return this.userRides.get(userId).toArray(new Ride[0]);
    }

    public ArrayList<Ride> getRidesByuserId(String userId) {
        return ridesByuserId();
    }

    public void adduserRides(String userId, ArrayList<Ride> listOfRides) {
    }
}
