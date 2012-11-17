import com.ridgesoft.intellibrain.IntelliBrain;
import com.ridgesoft.intellibrain.IntelliBrainDigitalIO;
import com.ridgesoft.io.Display;

public class SonarSensor {
    public static void main(String args[]) throws InterruptedException {
        double distance = 0;
        Display display = IntelliBrain.getLcdDisplay();
        IntelliBrainDigitalIO ping = IntelliBrain.getDigitalIO(3);
        ping.enablePulseMeasurement(true);
        
        while(true){
            ping.pulse(20);
            Thread.sleep(50);
            distance = ping.readPulseDuration() /150.0; //Distance in inches
            
            display.print(0, "Ping Value");
            display.print(1, " " + distance);
        }
    }
}