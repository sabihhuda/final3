package com.example.final3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class Auction {
    private String auctionName;
    private List<Vehicle> vehicles;
    private Date endTime;
    private Timer timer;
    private AuctionWinnerManager winnerManager;

    public Auction(String auctionName, Date endTime) {
        this.auctionName = auctionName;
        this.vehicles = new ArrayList<>();
        this.endTime = endTime;
        this.timer = new Timer();
        this.winnerManager = new AuctionWinnerManager();

        // Schedule the end of the auction
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                endAuction();
            }
        }, endTime);
    }

    public String getAuctionName() {
        return auctionName;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    // Method to place a bid in the auction
    public void placeBid(AuthenticationService.User user, double amount, Vehicle vehicle) {
        Bid bid = new Bid(user, amount, vehicle);
        vehicle.addBid(bid);
    }

    // Method to get the list of vehicles in the auction
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    private void endAuction() {
        // Determine the highest bid
        Bid highestBid = null;
        for (Vehicle vehicle : vehicles) {
            for (Bid bid : vehicle.getBids()) {
                if (highestBid == null || bid.getAmount() > highestBid.getAmount()) {
                    highestBid = bid;
                }
            }
        }

        // Notify the winner
        if (highestBid != null) {
            System.out.println("The auction '" + auctionName + "' has ended. The highest bid was " + highestBid.getAmount() + " by " + highestBid.getUser().getUsername());
            winnerManager.addAuctionWinner(highestBid.getUser());
        } else {
            System.out.println("The auction '" + auctionName + "' has ended with no bids.");
        }
    }
}