
public class PickupBoyDriver {

    public static void main(String[] args) {

        new ClientAddressGeneratorService().generateLocations("input.in", 100, 30.00, 70.00);

        Route initialRoute = new AddressReaderService().readAddress("input.in");

        System.out.println(HQ.info());

        System.out.println(initialRoute);


        System.out.println("Number of clients : " + initialRoute.getClients().size());

        System.err.println( "Penalty count for initial route : " + new SimulatedAnnealing().calculatePenalty(initialRoute));

        Route route = new SimulatedAnnealing().findRoute(SimulatedAnnealing.INITIAL_TEMPERATURE, initialRoute);

        System.err.println( "Penalty count for best route : " + route.getPenaltyCount());

        new OutputWriterService().writeResult("output.csv", route);



    }

}
