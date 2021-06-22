package com.bridgelabz;

import java.util.ArrayList;

public class InvoiceGenerator {
    private double MINIMUM_FARE;
    private double PER_KILOMETER_COST;
    private int PER_MINUTE_COST;

    public enum subscriptionPlan {PremiumRides, NormalRides}


    RideRepository rideRepository = new RideRepository();
    ArrayList<Ride> listOfRides = new ArrayList<>();

    public InvoiceGenerator(InvoiceGenerator.subscriptionPlan plan) {
        if (plan.equals(subscriptionPlan.PremiumRides)) {
            this.MINIMUM_FARE = 15;
            this.PER_KILOMETER_COST = 20;
            this.PER_MINUTE_COST = 2;
        }
        if (plan.equals(subscriptionPlan.NormalRides)) {
            this.MINIMUM_FARE = 5;
            this.PER_KILOMETER_COST = 10;
            this.PER_MINUTE_COST = 1;
        }
    }

    public Double calculateFare(double distance, int time) {
        double totalFare = (distance * PER_KILOMETER_COST) + (time * PER_MINUTE_COST);
        return Math.max(totalFare, MINIMUM_FARE);
    }

    public double calculateFareForMultipleRides(Ride[] rides) {
        double aggregateFare = 0;
        for (Ride ride : rides) {
            listOfRides.add(ride);
            aggregateFare += calculateFare(ride.distance, ride.time);
        }
        return aggregateFare;
    }

    public InvoiceSummary getInvoiceSummary(Ride[] rides) {
        return new InvoiceSummary(rides.length, calculateFareForMultipleRides(rides));
    }

    public void addRides(String userId) {
        rideRepository.adduserRides(userId, listOfRides);
    }

    public ArrayList<Ride> getRidesByUserId(String userId) {
        ArrayList<Ride> ridesByuserId = rideRepository.getRidesByuserId(userId);
        return ridesByuserId;
    }


}
