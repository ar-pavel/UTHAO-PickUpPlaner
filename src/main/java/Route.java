import java.util.ArrayList;
import java.util.Collections;

public class Route {
    private ArrayList<Client> clients = new ArrayList<>();
    private long penaltyCount;

    public Route(ArrayList<Client> clients) {
        this.clients.addAll(clients);
        Collections.shuffle(this.clients);
    }

    public Route(Route route){
        this.clients.addAll(route.clients);
        this.penaltyCount = route.penaltyCount;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public long getPenaltyCount() {
        return penaltyCount;
    }

    public void setPenaltyCount(long penaltyCount) {
        this.penaltyCount = penaltyCount;
    }

    @Override
    public String toString() {
        return "Route{" +
                "clients=" + clients +
                "Penalty=" + penaltyCount +
                '}';
    }
}
