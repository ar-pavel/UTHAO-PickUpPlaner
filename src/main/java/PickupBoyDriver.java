
public class PickupBoyDriver {

    public static void main(String[] args) {

        // Provide a File name, number of clients and base/HQ longitude and latitude to generate random clients
        new ClientAddressGeneratorService().generateLocations("input.in", 100, 30.00, 70.00);

        // Read clients and HQ info form the input file
        Route initialRoute = new AddressReaderService().readAddress("input.in");


        // If Debug
        System.out.println(HQ.info());
        System.out.println(initialRoute);
        System.out.println("Number of clients : " + initialRoute.getClients().size());
        System.err.println( "Penalty count for initial route : " + new SimulatedAnnealing().calculatePenalty(initialRoute));
        // End Debug


        // Call simulated annealing class to find a relative better route
        Route route = new SimulatedAnnealing().findRoute(SimulatedAnnealing.INITIAL_TEMPERATURE, initialRoute);

        System.err.println( "Penalty count for best route : " + route.getPenaltyCount());

        // Write output to file According to the Assignment instructed format
        new OutputWriterService().writeResult("output.csv", route);



    }

}
