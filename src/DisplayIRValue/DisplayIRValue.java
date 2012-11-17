import com.ridgesoft.intellibrain.IntelliBrain;
import com.ridgesoft.io.Display;
import com.ridgesoft.robotics.AnalogInput; //library we need to import to be able to use the IR Sensors

public class DisplayIRValue {
    public static void main(String args[]) {
        Display display = IntelliBrain.getLcdDisplay();
        AnalogInput rightIR = IntelliBrain.getAnalogInput(0);
        AnalogInput leftIR = IntelliBrain.getAnalogInput(1);
        
        int leftIRvalue = leftIR.sample(); //method to obtain a value from the IR sensor located in port 1
        int rightIRvalue = rightIR.sample(); //getting the Right Sensor value
        while(true){
            display.print(0, "LEFT: " + Integer.toString(leftIRvalue));
            display.print(1, "RIGHT: " + Integer.toString(rightIRvalue));
        }
    }
}