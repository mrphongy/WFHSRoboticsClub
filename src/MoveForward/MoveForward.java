/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MoveForward;
import com.ridgesoft.intellibrain.IntelliBrain;
import com.ridgesoft.robotics.Motor; //First Library needed to make motors work
import com.ridgesoft.robotics.ContinuousRotationServo; //Second necessary library

/**
 *
 * @author Phong
 */
public class MoveForward {
    public static void main(String[] args){
        Motor leftMotor = new ContinuousRotationServo(IntelliBrain.getServo(1), false, 10);
        Motor rightMotor = new ContinuousRotationServo(IntelliBrain.getServo(2), true, 10);
        
        while(true){
            leftMotor.setPower(6); //setting the power of the left motor using a method from the library
            rightMotor.setPower(6); //setting the power of the right motor using a method from the library
        }
    }
}