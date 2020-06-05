import java.util.Collections;

public class SimulatedAnnealing {
    public static final double RATE_OF_COOLING = 0.005;
    public static final double INITIAL_TEMPERATURE = 999;
    public static final double MIN_TEMPERATURE = 0.99;

    public Route findRoute(double temperature, Route currentRoute){
        Route bestRoute = new Route(currentRoute);
        bestRoute.setPenaltyCount(calculatePenalty(bestRoute));

        Route adjacentRoute;

        while (temperature > MIN_TEMPERATURE){
            adjacentRoute = getAdjacent(new Route(currentRoute));

            currentRoute.setPenaltyCount(calculatePenalty(currentRoute));

//            if(calculatePenalty(currentRoute) < calculatePenalty(bestRoute))
            if(currentRoute.getPenaltyCount() < bestRoute.getPenaltyCount())
                bestRoute = new Route(currentRoute);

//            if(acceptableRoute(calculatePenalty(currentRoute),calculatePenalty(adjacentRoute),temperature))
            if(acceptableRoute(currentRoute.getPenaltyCount(),adjacentRoute.getPenaltyCount(),temperature))
                currentRoute = new Route(adjacentRoute);

            temperature *= 1-RATE_OF_COOLING;
        }

        return bestRoute;
    }


    public boolean acceptableRoute(long currentPenalty, long adjacentPenalty, double temperature){

        double acceptProbability = 1.0;

        if(adjacentPenalty >= currentPenalty)
            acceptProbability = Math.exp(-(adjacentPenalty - currentPenalty)/temperature);

        boolean acceptableRouteFlag = acceptProbability >= Math.random();

//        System.err.println( acceptableRouteFlag? "Stay (Random <= Prob Function)":"Random > Prob Function");

        return acceptableRouteFlag;
    }

    public long calculatePenalty(Route route){

//        System.out.println("Checking Penalty for : ");
//        System.out.println(route);

        long penalty = 0L;
        int curTime = HQ.stTime;
        double curLongitude = HQ.longitude;
        double curLatitude = HQ.latitude;

        for (Client client: route.getClients()) {

            if (Util.possibleToTake(curTime, curLongitude, curLatitude, client)) {
                curTime += Util.timeNeed(curLongitude, curLatitude, client.getLongitude(), client.getLatitude()) ;
                client.setPickupTime(curTime);
                curTime += + Util.PICKUP_TIME;
                curLongitude = client.getLongitude();
                curLatitude = client.getLatitude();
            } else {
                penalty += Util.PENALTY;
                client.setPickupTime(-1);
            }
        }

        return  penalty;
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
