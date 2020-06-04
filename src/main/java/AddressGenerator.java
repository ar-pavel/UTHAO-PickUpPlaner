import java.util.ArrayList;

public class AddressGenerator {

    public static Route generateLocations(int n){

        ArrayList<Client> clients = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            double x = Math.random()/10.0;
            double y = Math.random()/10.0;

            int sttime = (int) ((Math.random() * (1200))+600);
            int slot = (int) ( Math.random()*100);
            int endtime = Math.min(1800, sttime+slot);

            clients.add(new Client(HQ.longitude +x, HQ.latitude+y, sttime, endtime));
        }
//
//        for (Object client:clients) {
//            System.err.println(client);
//        }

        return new Route(clients);

    }
}
