import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class OutputWriterService {
    public void writeResult(String fileName, Route route){
        try {
            RandomAccessFile outputFile = new RandomAccessFile(fileName, "rw");
            outputFile.setLength(0);

            String line = "Longitude,Latitude,StartTime,EndTime,PickupTime\n";
            outputFile.writeBytes(line);
            line = String.format("%f,%f,%d,%d,%d\n",HQ.longitude, HQ.latitude, HQ.stTime, HQ.endTime, HQ.stTime);
            outputFile.writeBytes(line);

            Client lastVIsitedClient =route.getClients().get(0);

            for (Client client: route.getClients()) {
                line = String.format("%f,%f,%d,%d,%d\n",client.getLongitude(), client.getLatitude(), client.getStTime(), client.getEndTime(), client.getPickupTime());
                outputFile.writeBytes(line);
                if(client.getPickupTime()!=-1)
                    lastVIsitedClient = client;
            }
            int timeNeeded = Util.timeNeed(lastVIsitedClient.getLongitude(), lastVIsitedClient.getLatitude(), HQ.longitude, HQ.latitude);
            timeNeeded += Util.PICKUP_TIME;

            int returnTime = timeNeeded + lastVIsitedClient.getPickupTime();

            line = String.format("%f,%f,%d,%d,%d\n",HQ.longitude, HQ.latitude, HQ.stTime, HQ.endTime, returnTime);
            outputFile.writeBytes(line);

            line = "Penalty count for this route : " + route.getPenaltyCount();
            outputFile.writeBytes(line);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
