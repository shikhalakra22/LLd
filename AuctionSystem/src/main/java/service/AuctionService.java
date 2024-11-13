package service;

import model.Auction;
import model.Buyer;
import model.Seller;

import java.util.HashMap;
import java.util.Map;

public class AuctionService {
    private Map<String, Buyer> buyers;
    private Map<String, Seller> sellers;
    private Map<String, Auction> auctions;

    public AuctionService() {
        buyers = new HashMap<>();
        sellers = new HashMap<>();
        auctions = new HashMap<>();
    }

    // Add Buyer
    public void addBuyer(String name) {
        if (buyers.containsKey(name)) {
            System.out.println("Buyer " + name + " already exists.");
        } else {
            buyers.put(name, new Buyer(name));
            System.out.println("Buyer " + name + " added.");
        }
    }

    // Add Seller
    public void addSeller(String name) {
        if (sellers.containsKey(name)) {
            System.out.println("Seller " + name + " already exists.");
        } else {
            sellers.put(name, new Seller(name));
            System.out.println("Seller " + name + " added.");
        }
    }

    // Create Auction
    public void createAuction(String auctionId, double lowestBid, double highestBid, double participationCost, String sellerName) {
        if (auctions.containsKey(auctionId)) {
            System.out.println("Auction " + auctionId + " already exists.");
            return;
        }

        Seller seller = sellers.get(sellerName);
        if (seller == null) {
            System.out.println("Seller " + sellerName + " does not exist.");
            return;
        }

        if (lowestBid > highestBid) {
            System.out.println("Lowest bid limit cannot be higher than highest bid limit.");
            return;
        }
     //   Auction auction =  Auction.builder().id(auctionId).lowestBidLimit(lowestBid).highestBidLimit(highestBid).participationCost(participationCost).seller(seller).build();

        Auction auction = new Auction(auctionId, lowestBid, highestBid, participationCost, seller);
        auctions.put(auctionId, auction);
        System.out.println("Auction " + auctionId + " created by Seller " + sellerName + ".");
    }

    // Create or Update Bid
    public void createOrUpdateBid(String buyerName, String auctionId, double amount) {
        Buyer buyer = buyers.get(buyerName);
        if (buyer == null) {
            System.out.println("Buyer " + buyerName + " does not exist.");
            return;
        }

        Auction auction = auctions.get(auctionId);
        if (auction == null) {
            System.out.println("Auction " + auctionId + " does not exist.");
            return;
        }

        auction.addOrUpdateBid(buyer, amount);
    }

    // Withdraw Bid
    public void withdrawBid(String buyerName, String auctionId) {
        Buyer buyer = buyers.get(buyerName);
        if (buyer == null) {
            System.out.println("Buyer " + buyerName + " does not exist.");
            return;
        }

        Auction auction = auctions.get(auctionId);
        if (auction == null) {
            System.out.println("Auction " + auctionId + " does not exist.");
            return;
        }

        auction.withdrawBid(buyer);
    }

    // Close Auction
    public void closeAuction(String auctionId) {
        Auction auction = auctions.get(auctionId);
        if (auction == null) {
            System.out.println("Auction " + auctionId + " does not exist.");
            return;
        }

        auction.closeAuction();
    }

    // Get Profit/Loss
    public void getProfitLoss(String sellerName, String auctionId) {
        Seller seller = sellers.get(sellerName);
        if (seller == null) {
            System.out.println("Seller " + sellerName + " does not exist.");
            return;
        }

        Auction auction = auctions.get(auctionId);
        if (auction == null ) {
            System.out.println("Auction " + auctionId + " does not exist.");
            return;
        }

        double profitLoss = auction.calculateProfitLoss();
        System.out.println("Profit/Loss for Seller " + sellerName + " in Auction " + auctionId + ": " + profitLoss);
    }

}
