import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientAddressGeneratorService {

    public void generateLocations(String fileName, int n, double hqLongitude, double hqLatitude ){

        try {
            RandomAccessFile outputFile = new RandomAccessFile(fileName, "rw");

            outputFile.setLength(0);

//            ArrayList<Client> clients = new ArrayList<>();


            String line = "Longitude,Latitude,StartTime,EndTime,PickupTime\n";
            outputFile.writeBytes(line);
            line = String.format("%f,%f,%d,%d\n",hqLongitude, hqLatitude, 600, 1800);
            outputFile.writeBytes(line);

            for (int i = 0; i < n; i++) {
//                double x = Math.random()/10.0 +HQ.longitude ;
                double x = Math.random()/10.0 + hqLongitude;
//                double y = Math.random()/10.0 + HQ.latitude;
                double y = Math.random()/10.0 + hqLatitude;

//                int sttime = (int) ((Math.random() * (HQ.endTime-HQ.stTime))+HQ.stTime);
                int sttime = (int) ((Math.random() * (1200))+600);
                int slot = (int) ( Math.random()*100);
                int endtime = Math.min(1800, sttime+slot);

                line = String.format("%f,%f,%d,%d\n",x, y, sttime, endtime);
                outputFile.writeBytes(line);
//            clients.add(new Client(HQ.longitude +x, HQ.latitude+y, sttime, endtime));
            }
//
//        for (Object client:clients) {
//            System.err.println(client);
//        }

//        return new Route(clients);


        } catch (IOException e) {
            Logger.getLogger(ClientAddressGeneratorService.class.getName()).log(Level.SEVERE, null, e);
        }


    }
}
