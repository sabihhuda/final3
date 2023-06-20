package com.example.final3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Auction {
    private String auctionName;
    private Date endTime;
    private List<Vehicle> vehicles;

    public Auction(String auctionName, Date endTime) {
        this.auctionName = auctionName;
        this.endTime = endTime;
        this.vehicles = new ArrayList<>();
    }

    public String getAuctionName() {
        return auctionName;
    }

    public Date getEndTime() {
        return endTime;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    @Override
    public String toString() {
        return auctionName;
    }

    public void placeBid(AuthenticationService.User user, double bidAmount, Vehicle vehicle) {
    }
}
