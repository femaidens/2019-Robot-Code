package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class SerialCom extends Subsystem {
  public static edu.wpi.first.wpilibj.SerialPort serialPort;
  public SerialCom(){
      try {
        serialPort = new edu.wpi.first.wpilibj.SerialPort(9600, edu.wpi.first.wpilibj.SerialPort.Port.kUSB);
      }
      catch(Exception E){}
    }
  
  @Override
  public void initDefaultCommand() {
  
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public static String[] receive(){
    // to access whether anything has been sighted, call receivedString[0]
    // to access the distance with ultrasonics, call receivedString[1] and convert into a double
    String[] receivedString = serialPort.readString().split("\t");
    return receivedString;
    /*for (SerialPort.Port c : SerialPort.Port.values())
    System.out.println(c);*/
  }
}