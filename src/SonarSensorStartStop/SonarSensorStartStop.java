import com.ridgesoft.intellibrain.IntelliBrain;
import com.ridgesoft.intellibrain.IntelliBrainDigitalIO;
import com.ridgesoft.io.Display;
import com.ridgesoft.robotics.Motor; //Movement library
import com.ridgesoft.robotics.ContinuousRotationServo; //Movement library

public class SonarSensorStartStop {
    public static void main(String args[]) throws InterruptedException {
        //Stuff for Sonar Sensor
        double distance = 0;
        Display display = IntelliBrain.getLcdDisplay();
        IntelliBrainDigitalIO ping = IntelliBrain.getDigitalIO(3);
        ping.enablePulseMeasurement(true);
        
        //Stuff for Movement
        Motor leftMotor = new ContinuousRotationServo(IntelliBrain.getServo(1), false, 10);
        Motor rightMotor = new ContinuousRotationServo(IntelliBrain.getServo(2), true, 10);
        
        while(true){
            ping.pulse(20);
            Thread.sleep(50);
            distance = ping.readPulseDuration() /150.0; //Distance in inches
            
            //if something is less than four inches away in front, then stop
            if(distance < 4){
                leftMotor.setPower(0);
                rightMotor.setPower(0);
                display.print(0, "Stopping");
                display.print(1, distance + " in.");
            }
            //in all other cases, keep moving
            else {
                leftMotor.setPower(6);
                rightMotor.setPower(6);
                display.print(0, "Clear");
                display.print(1, distance + " in.");
            }
        }
    }
}