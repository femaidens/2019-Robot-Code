package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

/**
 * Add your docs here.
 */
public class LiftSpark extends Subsystem {
  
  public static double[] height = {0.0, 50.0, 100.0, 150.0, 200.0, 250.0, 300.0};
  public static CANSparkMax leftCasMotor = new CANSparkMax(RobotMap.leftCasPort, CANSparkMaxLowLevel.MotorType.kBrushless);
  public static CANSparkMax rightCasMotor = new CANSparkMax(RobotMap.rightCasPort, CANSparkMaxLowLevel.MotorType.kBrushless);
  //for the hall sensors
  public static CANEncoder leftLiftHall = leftCasMotor.getEncoder();
  public static CANEncoder rightLiftHall = rightCasMotor.getEncoder();
  public static int level  = 0;

  public LiftSpark(){
  }
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public static void up(){
    if(level < 6){
      System.out.println("going up");
      while(leftLiftHall.getPosition() < height[level + 1]) {
        leftCasMotor.set(0.02);
        rightCasMotor.set(0.02);
      }
      leftCasMotor.set(0);
      rightCasMotor.set(0);
      level++;
    }
    System.out.println("level: " + level);
  }
  public static void down(){
    if (level > 0){
      System.out.println("going down");
      while(leftLiftHall.getPosition() > height[level - 1]) {
        leftCasMotor.set(-0.02);
        rightCasMotor.set(-0.02);
      }
      leftCasMotor.set(0);
      rightCasMotor.set(0);
      level--;
    }
    System.out.println("level: " + level);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}

