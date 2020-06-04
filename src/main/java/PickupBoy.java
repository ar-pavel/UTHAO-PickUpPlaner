import java.util.ArrayList;

public class PickupBoy {

    public static void main(String[] args) {

        //Setting base longitude and latitude
        HQ.longitude = 30.0000;
        HQ.latitude = 70.0000;


        System.out.println(HQ.info());

        Route clients = AddressGenerator.generateLocations(10000);

//        System.out.println(clients);

        System.out.println("Number of clients : " + clients.getClients().size());

        System.out.println( "Penalty count for initial route : " + new SimulatedAnnealing().calculatePenalty(clients));

        Route route = new SimulatedAnnealing().findRoute(SimulatedAnnealing.INITIAL_TEMPERATURE, clients);

        System.err.println( "Penalty count for best route : " + new SimulatedAnnealing().calculatePenalty(route));

    }

}
