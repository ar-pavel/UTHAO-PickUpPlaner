import java.util.ArrayList;
import java.util.Collections;

public class Route {
    private ArrayList<Client> clients;

    public Route(ArrayList<Client> clients) {
        this.clients = clients;
        Collections.shuffle(this.clients);
    }
    public Route(Route route){
        this.clients = route.clients;
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
