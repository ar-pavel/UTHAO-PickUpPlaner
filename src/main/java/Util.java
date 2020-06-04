public class Util {
    public static int SPEED = 50;
    public static int PICKUP_TIME = 2;

    public static double EARTH_EQ_RADIUS = 6378.1370D;
    public static double CONVERT_DEGREE_TO_RADIANS = Math.PI/180D;

    public static double getDistance(double sLongitude, double sLatitude, double dLongitude, double dLatitude){
        double deltaLongitude = sLongitude - dLongitude;
        double deltaLatitude = sLatitude - dLatitude;

        double d = Math.pow(Math.sin(deltaLatitude / 2D), 2D)+
                Math.cos(dLatitude) * Math.cos(sLatitude) * Math.pow(Math.sin(deltaLongitude / 2D), 2D);

        return Util.EARTH_EQ_RADIUS * 2D * Math.atan2(Math.sqrt(d), Math.sqrt(1D - d));
    }

}
