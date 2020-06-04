import java.util.ArrayList;
import java.util.Collections;

public class SimulatedAnnealing {
    public static final double RATE_OF_COOLING = 0.005;
    public static final double INITIAL_TEMPERATURE = 999;
    public static final double MIN_TEMPERATURE = 0.99;

    public Route findRoute(double temperature, Route currentRoute){
        Route shortestRoute = new Route(currentRoute);
        Route adjacentRoute;

        while (temperature > MIN_TEMPERATURE){
            adjacentRoute = getAdjacent(new Route(currentRoute));

            if(calculatePenalty(currentRoute) < calculatePenalty(shortestRoute))
                shortestRoute = new Route(currentRoute);

            if(acceptRoute(calculatePenalty(currentRoute),calculatePenalty(adjacentRoute),temperature))
                currentRoute = new Route(adjacentRoute);

            temperature *= 1-RATE_OF_COOLING;
        }

        return shortestRoute;
    }


    public boolean acceptRoute(long currentPenalty, long adjacentPenalty, double temperature){

        double acceptProbability = 1.0;

        if(adjacentPenalty >= currentPenalty)
            acceptProbability = Math.exp(-(adjacentPenalty - currentPenalty)/temperature);

       return acceptProbability>=Math.random();

    }

    public long calculatePenalty(Route route){

//        System.out.println("Checking Penalty for : ");
//        System.out.println(route);

        long penalty = 0L;
        int curTime = HQ.stTime;
        double curLongitude = HQ.longitude;
        double curLatitude = HQ.latitude;

        for (Client client: route.getClients()) {

            if (possibleToTake(curTime, curLongitude, curLatitude, client)) {
                curTime += Util.timeNeed(curLongitude, curLatitude, client.getLongitude(), client.getLatitude()) + Util.PICKUP_TIME;
                curLongitude = client.getLongitude();
                curLatitude = client.getLatitude();
            } else {
                penalty += Util.PENALTY;
            }
        }

        return  penalty;
    }


    private boolean possibleToTake(int timeNow, double curLongitude, double curLatitude, Client client) {

//        check if it is possible to go back to HQ from current node by visiting this node withing time
//    also check if the time slot match as well

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


    public Route getAdjacent(Route route){
        int x = 0, y = 0;
        while(x==y){
            x = (int) (Math.random()*route.getClients().size());
            y = (int) (Math.random()*route.getClients().size());
        }
        Collections.swap(route.getClients(),x,y);
        return route;
    }



}
