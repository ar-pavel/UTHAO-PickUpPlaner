import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AddressReaderService {

    public Route readAddress(String fileName){
        ArrayList<Client> clients = new ArrayList<>();

        try {
            List<String> lineList = Files.readAllLines(Paths.get(fileName));

            String[] tokens = lineList.get(1).split(",");

            //Setting HQ Information
            HQ.longitude = Double.parseDouble(tokens[0]);
            HQ.latitude = Double.parseDouble(tokens[1]);
            HQ.stTime = Integer.parseInt(tokens[2]);
            HQ.endTime = Integer.parseInt(tokens[3]);

            for (int i = 2; i < lineList.size(); i++) {
                tokens = lineList.get(i).split(",");

                double longitude = Double.parseDouble(tokens[0]);
                double latitude = Double.parseDouble(tokens[1]);
                int stTime = Integer.parseInt(tokens[2]);
                int endTime = Integer.parseInt(tokens[3]);

                clients.add(new Client(longitude, latitude, stTime, endTime));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Route(clients);
    }



}
