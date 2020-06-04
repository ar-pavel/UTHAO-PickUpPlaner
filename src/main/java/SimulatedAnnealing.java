import java.util.ArrayList;

public class SimulatedAnnealing {

    public long calculatePenalty(ArrayList<Client> clients){
        long penalty = 0L;

        int curTime = HQ.stTime;
        double curLongitude = HQ.longitude;
        double curLatitude = HQ.latitude;

        for (Client client: clients) {

            // If possible
            // curLongitude = client.longitude
            // curLatitude = client.latitude
            // curTime = reachtime + HQ.pickupTime

            //otherwise
            // penalty += Util.Penalty

        }

        return  penalty;
    }

    public int timeNeed(double sLongitude, double sLatitude, double dLongitude, double dLatitude){
        double prev = Util.getDistance(sLongitude, sLatitude, dLongitude, dLatitude);
        double next = Util.getDistance(HQ.longitude, HQ.latitude, dLongitude, dLatitude);

//        double minimumTimeNeed =



        return  0;
    }




}
