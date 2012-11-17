import com.ridgesoft.intellibrain.IntelliBrain;
import com.ridgesoft.io.Display;
import com.ridgesoft.robotics.AnalogInput; //library we need to import to be able to use the IR Sensors
import com.ridgesoft.robotics.Motor; //Movement library
import com.ridgesoft.robotics.ContinuousRotationServo; //Movement library

public class TurnUsingIR {
    public static void main(String args[]) {
        //Setting display
        Display display = IntelliBrain.getLcdDisplay();
        //obtaining values from IR sensors
        AnalogInput rightIR = IntelliBrain.getAnalogInput(0);
        AnalogInput leftIR = IntelliBrain.getAnalogInput(1);
        //setting IR values to integers leftIRvalue and rightIRvalue
        int leftIRvalue = leftIR.sample(); //method to obtain a value from the IR sensor located in port 1
        int rightIRvalue = rightIR.sample(); //getting the Right Sensor value
        //setting left and right Motor objects. The number refers to maximum speed...whatever that is.
        Motor leftMotor = new ContinuousRotationServo(IntelliBrain.getServo(1), false, 10);
        Motor rightMotor = new ContinuousRotationServo(IntelliBrain.getServo(2), true, 10);
        
        while(true){
            //I have no idea if the if the number 50 means that the object is close or far away.
            if(rightIRvalue > 50){
                leftMotor.setPower(6);
                rightMotor.setPower(0);
                display.print(0, "TURNING RIGHT");
            }
            else if(leftIRvalue > 50){
                leftMotor.setPower(0);
                rightMotor.setPower(6);
                display.print(0, "TURNING LEFT");
            }
            /*else if(rightIRvalue > 50 && leftIRvalue > 50){
                leftMotor.setPower(0);
                rightMotor.setPower(0);
            }*/ // Making a complete stop if something is right in front should probably be handled by the IR sensor
            else {
                leftMotor.setPower(6);
                rightMotor.setPower(6);
                display.print(0, "FORWARD!");
            }
        }
    }
}
