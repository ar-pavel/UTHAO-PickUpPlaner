public class HQ {
    public static double longitude;
    public static double latitude;

    public static int endTime = 1800;
    public static int stTime = 600;


    public HQ(double x, double y) {
        latitude = x;
        longitude = y;
    }

    public static String info() {
        return "HQ{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                ", stTime=" + stTime +
                ", endTime=" + endTime +
                '}';
    }
}
