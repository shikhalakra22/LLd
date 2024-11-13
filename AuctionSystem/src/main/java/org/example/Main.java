package org.example;

import service.AuctionService;

public class Main {
    public static void main(String[] args) {
        AuctionService auctionService = new AuctionService();

        // Test Case 1
        System.out.println("----- Test Case 1 -----");
        auctionService.addBuyer("buyer1");
        auctionService.addBuyer("buyer2");
        auctionService.addBuyer("buyer3");
       auctionService.addBuyer("buyer4");

        auctionService.addSeller("seller1");
        auctionService.createAuction("A1", 10, 30, 1, "seller1");

        auctionService.createOrUpdateBid("buyer1", "A1", 17);
        auctionService.createOrUpdateBid("buyer2", "A1", 15);
        auctionService.createOrUpdateBid("buyer2", "A1", 19);
        auctionService.createOrUpdateBid("buyer3", "A1", 19);
  //      auctionService.createOrUpdateBid("buyer4", "A1", 30);

        auctionService.closeAuction("A1");
        auctionService.getProfitLoss("seller1", "A1");
       // auctionService.getProfitLoss("seller2", "A1");
        // Expected: -12.4

        // Test Case 2
        System.out.println("\n----- Test Case 2 -----");
        auctionService.addSeller("seller2");
        auctionService.createAuction("A2", 5, 20, 2, "seller2");

        auctionService.createOrUpdateBid("buyer3", "A2", 25); // Should fail
        auctionService.createOrUpdateBid("buyer2", "A2", 5);
        auctionService.withdrawBid("buyer2", "A2");
        auctionService.closeAuction("A2");
       // auctionService.getProfitLoss("seller2", "A2"); // Expected: 0.4
        auctionService.getProfitLoss("seller2", "A1");
    }
}