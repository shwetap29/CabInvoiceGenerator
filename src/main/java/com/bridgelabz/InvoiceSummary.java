package com.bridgelabz;


public class InvoiceSummary {

    private final  double averageFarePerRide;
    private final int numberOfRides;
    private final double totalFare;

    public InvoiceSummary(int numOfRides, double totalFare) {
        this.numberOfRides = numOfRides;
        this.totalFare = totalFare;
        this.averageFarePerRide = this.totalFare/this.numberOfRides;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return numberOfRides == that.numberOfRides && Double.compare(that.totalFare, totalFare) == 0 && Double.compare(that.averageFarePerRide, averageFarePerRide) == 0;
    }
}

