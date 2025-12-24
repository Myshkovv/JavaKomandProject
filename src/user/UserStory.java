package user;

import ride.Ride;

public class UserStory implements addNewRides {
    private int ridesCount = 0;
    private User user;
    private Ride[] rides = new Ride[0];

    public UserStory(User user) {
        this.user = user;
    }

    @Override
    public void addRide(Ride ride) {
        Ride[] newRides = new Ride[rides.length + 1];
        for (int i = 0; i < rides.length; i++) {
            newRides[i] = rides[i];
        }
        newRides[ridesCount] = ride;
        rides = newRides;
        ridesCount++;
    }

    public Ride getRide(int index){
        if (index < 0 | index >= ridesCount){
            throw new IndexOutOfBoundsException();
        } else {
            return rides[index];
        }
    }

    public Ride[] getRides(){
        return rides;
    }

    public void clearRides(){
        ridesCount = 0;
        rides = new Ride[0];
    }

    public int getRidesCount(){
        return ridesCount;
    }

    public int getUser(){
        return user.getId();
    }

    public Ride[] getAllRides() {
        Ride[] newRides = new Ride[ridesCount];
        for (int i = 0; i < ridesCount; i++) {
            newRides[i] = rides[i];
        }
        return newRides;
    }

    public int getTotalAmount(){
        return rides.length;
    }
}
