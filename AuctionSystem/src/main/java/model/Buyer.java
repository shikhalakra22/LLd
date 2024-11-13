package model;

public class Buyer extends User{
    private int participationCount;
    private boolean isPreferred;

    public Buyer(String name) {
        super(name);
        this.participationCount = 0;
    }

    public int getParticipationCount() { return participationCount; }

    public void incrementParticipation() { participationCount++; }

    public void incrementAuctionCount() {
        participationCount++;
        if (participationCount > 2) {
            isPreferred = true;
        }
    }
}
