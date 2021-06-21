package com.bridgelabz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
    InvoiceGenerator invoiceGenerator = null;

    @Before
    public void setUp() throws Exception {
        invoiceGenerator = new InvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {

        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = { new Ride(25, 30), new Ride(12, 20) };
        InvoiceSummary invoiceSummary = invoiceGenerator.getInvoiceSummary(rides);
        InvoiceSummary summary = new InvoiceSummary(2, 420);
        Assert.assertEquals(summary, invoiceSummary);
    }
    }

