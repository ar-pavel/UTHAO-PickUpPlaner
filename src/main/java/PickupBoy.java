import java.util.ArrayList;

public class PickupBoy {

    public static void main(String[] args) {
        HQ.longitude = 30.0000;
        HQ.latitude = 70.0000;

        System.out.println(HQ.info());
        ArrayList<Client> clients = AddressGenerator.generateLocations(10);



    }

}
