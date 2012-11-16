/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Hello_World;
import com.ridgesoft.intellibrain.*;
import com.ridgesoft.io.*;
import com.ridgesoft.robotics.*;
/**
 *
 * @author Phong
 */
public class Hello_World {
    private static Display screen = IntelliBrain.getLcdDisplay();
    public static void main(String[] args) {
        while(true){
            screen.print(0, "P. Sherman");
            screen.print(1, "42 Wallaby");
        }
    }
}
