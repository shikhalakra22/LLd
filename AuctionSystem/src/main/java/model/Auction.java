package model;

import enums.AuctionStatus;
import lombok.Builder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
//@Builder
public class Auction {
    private String id;
    private double lowestBidLimit;
    private double highestBidLimit;
    private double participationCost;
    private Seller seller;
    private AuctionStatus status;
    private Map<Buyer, Bid> bids;

    public Auction(String id, double lowestBidLimit, double highestBidLimit, double participationCost, Seller seller) {
        this.id = id;
        this.lowestBidLimit = lowestBidLimit;
        this.highestBidLimit = highestBidLimit;
        this.participationCost = participationCost;
        this.seller = seller;
        this.status = AuctionStatus.OPEN;
        this.bids = new HashMap<>();
    }

    public String getId() { return id; }
    public double getLowestBidLimit() { return lowestBidLimit; }
    public double getHighestBidLimit() { return highestBidLimit; }
    public double getParticipationCost() { return participationCost; }
    public Seller getSeller() { return seller; }
    public AuctionStatus getStatus() { return status; }
    public Map<Buyer, Bid> getBids() { return bids; }

    public boolean addOrUpdateBid(Buyer buyer, double amount) {
        if (status == AuctionStatus.CLOSED) {
            System.out.println("Auction " + id + " is closed. Cannot place or update bids.");
            return false;
        }

        if (amount < lowestBidLimit || amount > highestBidLimit) {
            System.out.println("Bid amount " + amount + " is outside the limits for Auction " + id + ".");
            return false;
        }

        Bid existingBid = bids.get(buyer);
        if (existingBid != null) {
            existingBid.setAmount(amount);
            System.out.println("Bid updated for Buyer " + buyer.getName() + " in Auction " + id + " to " + amount);
        } else {
            bids.put(buyer, new Bid(buyer, amount));
            buyer.incrementParticipation();
            System.out.println("Bid created for Buyer " + buyer.getName() + " in Auction " + id + " with amount " + amount);
        }
        return true;
    }


    public boolean withdrawBid(Buyer buyer) {
        if (status == AuctionStatus.CLOSED) {
            System.out.println("Auction " + id + " is closed. Cannot withdraw bids.");
            return false;
        }

        if (bids.containsKey(buyer)) {
            bids.remove(buyer);
            System.out.println("Bid withdrawn for Buyer " + buyer.getName() + " in Auction " + id);
            return true;
        } else {
            System.out.println("No bid found for Buyer " + buyer.getName() + " in Auction " + id);
            return false;
        }
    }

    public Optional<Bid> determineWinningBid() {
        Map<Double, Long> bidFrequency = bids.values().stream()
                .collect(Collectors.groupingBy(Bid::getAmount, Collectors.counting()));

        List<Bid> uniqueBids = bids.values().stream()
                .filter(bid -> bidFrequency.get(bid.getAmount()) == 1)
                .collect(Collectors.toList());

        if (uniqueBids.isEmpty()) {
            return Optional.empty();
        }

        // Sort unique bids by amount in descending order and preferred status not complete
        uniqueBids.sort((b1, b2) -> Double.compare(b2.getAmount(), b1.getAmount()));
        return Optional.of(uniqueBids.get(0));
    }

    public void closeAuction() {
        if (status == AuctionStatus.CLOSED) {
            System.out.println("Auction " + id + " is already closed.");
            return;
        }

        status = AuctionStatus.CLOSED;
        Optional<Bid> winningBidOpt = determineWinningBid();

        if (winningBidOpt.isPresent()) {
            Bid winningBid = winningBidOpt.get();
            System.out.println("Auction " + id + " closed. Winning bid: " + winningBid.getAmount() + " by Buyer " + winningBid.getBuyer().getName());
        } else {
            System.out.println("Auction " + id + " closed with no winner.");
        }
    }

    public double calculateProfitLoss() {
        double averageBidLimit = (lowestBidLimit + highestBidLimit) / 2;
        long numberOfBidders = bids.size();
        double participationShare = numberOfBidders * 0.2 * participationCost;

        Optional<Bid> winningBidOpt = determineWinningBid();
        if (winningBidOpt.isPresent()) {
            double winningAmount = winningBidOpt.get().getAmount();
            return winningAmount +participationCost-participationShare - averageBidLimit;
        } else {
            return participationShare;
        }
    }
}
