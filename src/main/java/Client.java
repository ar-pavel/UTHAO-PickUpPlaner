public class Client {
    private double longitude;
    private double latitude;
    private int stTime;
    private int endTime;
    private int pickupTime;

    public Client(double longitude, double latitude, int stTime, int endTime) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.stTime = stTime;
        this.endTime = endTime;
    }

    public Client(double longitude, double latitude, int stTime, int endTime, int pickupTime) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.stTime = stTime;
        this.endTime = endTime;
        this.pickupTime = pickupTime;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public int getStTime() {
        return stTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public int getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(int pickupTime) {
        this.pickupTime = pickupTime;
    }

    @Override
    public String toString() {
        return "Client{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                ", stTime=" + stTime +
                ", endTime=" + endTime +
                ", pickUpTime=" + pickupTime +
                '}';
    }


}
