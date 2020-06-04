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
