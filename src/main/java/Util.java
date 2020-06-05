import java.util.ArrayList;

public class Util {
    public static int SPEED = 50;
    public static int PICKUP_TIME = 2;
    public static int PENALTY = 10000;

    public static double EARTH_EQ_RADIUS = 6378.1370D;
//    public static double CONVERT_DEGREE_TO_RADIANS = Math.PI/180D;

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

    public static Route getPickUpTimes(Route route){

        ArrayList<Client> clients = new ArrayList<>();

        clients.add(new Client(HQ.longitude, HQ.latitude, HQ.stTime, HQ.endTime, HQ.stTime));


        int curTime = HQ.stTime;
        double curLongitude = HQ.longitude;
        double curLatitude = HQ.latitude;

        for (Client client: route.getClients()) {

            if (possibleToTake(curTime, curLongitude, curLatitude, client)) {
                curTime += Util.timeNeed(curLongitude, curLatitude, client.getLongitude(), client.getLatitude()) ;
                client.setPickupTime(curTime);
                curTime += + Util.PICKUP_TIME;
                curLongitude = client.getLongitude();
                curLatitude = client.getLatitude();
            } else {
                client.setPickupTime(-1);
            }
            clients.add(client);
        }

        return new Route(clients);
    }

    public static boolean possibleToTake(int timeNow, double curLongitude, double curLatitude, Client client) {

//      check if it is possible to go back to HQ from current node by visiting this node withing time
//      also check if the time slot match as well

        int timeNeedToReach = Util.timeNeed(curLongitude, curLatitude,  client.getLongitude(), client.getLatitude());
        timeNow += timeNeedToReach;

//        System.out.print(client);
//        System.out.println("\t time: Now : " + timeNow + "\t NeedToReach : " + timeNeedToReach);

        if(timeNow > client.getEndTime()) {
//            System.out.println("Unable To take!");
            return false;
        }

        timeNow = Math.max(timeNow, client.getStTime());
        timeNow += Util.PICKUP_TIME;

        int timeNeedToBackToHQ = Util.timeNeed(client.getLongitude(),  client.getLatitude(), HQ.longitude, HQ.latitude);
        timeNow += timeNeedToBackToHQ;

//        System.out.println("\t NeedToBackToHQ : " + timeNeedToBackToHQ);

        return  timeNow<=HQ.endTime;
    }



}
