package tgi;

import com.codeminders.ardrone.ARDrone;
import java.io.IOException;


public class TakeOffAndLand
{

    private static final long CONNECT_TIMEOUT = 3000;

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        ARDrone drone;
        try
        {
            // Create ARDrone object,
            // connect to drone and initialize it.
            drone = new ARDrone();
            
            drone.connect();
            drone.clearEmergencySignal();

            // Wait until drone is ready
            drone.waitForReady(CONNECT_TIMEOUT);

            // do TRIM operation
            drone.trim();

            // Take off
            System.err.println("Taking off");
            drone.takeOff();

            // Fly a little :)
            Thread.sleep(5000);
            
            //do things
            /*
            FileImageRecorder asd = new FileImageRecorder(new File("C://temp//"), 0, "omg_", null);
            
            drone.addImageListener(asd);
            */
            
            // Land
            System.err.println("Landing");
            drone.land();

            // Give it some time to land
            Thread.sleep(2000);
            
            // Disconnect from the done
            drone.disconnect();

        } catch(IOException | InterruptedException e)
        {
            // omg a exception! run to the hills!!111!!!onze!!!
        }
    }
}
