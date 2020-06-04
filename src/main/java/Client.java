public class Client {
    private double longitude;
    private double latitude;
    private int stTime;
    private int endTime;

    public Client(double longitude, double latitude, int stTime, int endTime) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.stTime = stTime;
        this.endTime = endTime;
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

    @Override
    public String toString() {
        return "Client{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                ", stTime=" + stTime +
                ", endTime=" + endTime +
                '}';
    }
}
