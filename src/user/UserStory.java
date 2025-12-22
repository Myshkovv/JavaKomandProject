package user;

import ride.Ride;

public class UserStory implements addNewRides {
    private int ridesCount = 0;
    private User user;
    private Ride[] rides = new Ride[ridesCount];

    public UserStory(User user) {
        this.user = user;
    }

    @Override
    public void addRide(Ride ride) {
        ridesCount++;
        Ride[] newRides = new Ride[rides.length + 1];
        for (int i = 0; i < rides.length; i++) {
            newRides[i] = rides[i];
        }
        newRides[ridesCount] = ride;
        rides = newRides;
    }

    public Ride getRide(int index){
        if (index < 0 | index >= ridesCount){
            throw new IndexOutOfBoundsException();
        } else {
            return rides[index];
        }
    }

    public void clearRides(Ride[] ride){
        ridesCount = 0;
        rides = new Ride[ridesCount];
    }

    public int getRidesCount(){
        return ridesCount;
    }

    public int getUser(){
        return user.getId();
    }
}
