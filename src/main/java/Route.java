import java.util.ArrayList;
import java.util.Collections;

public class Route {
    private ArrayList<Client> clients = new ArrayList<>();

    public Route(ArrayList<Client> clients) {
        this.clients.addAll(clients);
        Collections.shuffle(this.clients);
    }
    public Route(Route route){
        this.clients.addAll(route.clients);
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    @Override
    public String toString() {
        return "Route{" +
                "clients=" + clients +
                '}';
    }
}
