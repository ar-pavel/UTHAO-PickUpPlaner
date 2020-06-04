public class Util {
    public static int SPEED = 50;
    public static int PICKUP_TIME = 2;
    public static int PENALTY = 1;

    public static double EARTH_EQ_RADIUS = 6378.1370D;
    public static double CONVERT_DEGREE_TO_RADIANS = Math.PI/180D;

    public static double getDistance(double sLongitude, double sLatitude, double dLongitude, double dLatitude){
        double deltaLongitude = sLongitude - dLongitude;
        double deltaLatitude = sLatitude - dLatitude;

        double d = Math.pow(Math.sin(deltaLatitude / 2D), 2D)+
                Math.cos(dLatitude) * Math.cos(sLatitude) * Math.pow(Math.sin(deltaLongitude / 2D), 2D);

        return Util.EARTH_EQ_RADIUS * 2D * Math.atan2(Math.sqrt(d), Math.sqrt(1D - d));
    }

    public static int timeNeed(double sLongitude, double sLatitude, double dLongitude, double dLatitude){
        double prev = Util.getDistance(sLongitude, sLatitude, dLongitude, dLatitude);
        double next = Util.getDistance(HQ.longitude, HQ.latitude, dLongitude, dLatitude);

        double minimumTimeNeed = prev / SPEED; // time need to travel from prev to current
        minimumTimeNeed += next / SPEED; // time need to go back to HQ

        return (int) Math.ceil(minimumTimeNeed);
    }


}
