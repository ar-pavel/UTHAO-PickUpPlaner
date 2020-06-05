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

            for (Client client: route.getClients()) {
                line = String.format("%f,%f,%d,%d,%d\n",client.getLongitude(), client.getLatitude(), client.getStTime(), client.getEndTime(), client.getPickupTime());
                outputFile.writeBytes(line);
            }
            line = "Penalty count for this route : " + route.getPenaltyCount();
            outputFile.writeBytes(line);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
