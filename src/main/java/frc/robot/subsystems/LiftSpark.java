package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.Encoder;
import frc.robot.RobotMap;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

/**
 * Add your docs here.
 */
public class LiftSpark extends Subsystem {
  
  public static double[] height = {0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0};
  public static Counter leftLiftHall = new Counter(RobotMap.casHallLeft);
  public static Counter rightLiftHall = new Counter(RobotMap.casHallRight);
  public static CANSparkMax leftCasMotor = new CANSparkMax(RobotMap.leftCasPort, CANSparkMaxLowLevel.MotorType.kBrushless);
  public static CANSparkMax rightCasMotor = new CANSparkMax(RobotMap.rightCasPort, CANSparkMaxLowLevel.MotorType.kBrushless);
  public static int level  = 0;

  public LiftSpark(){
  }
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  public static void move(double d, double s){
    leftLiftHall.setDistancePerPulse(0.0); //conversion factor 
    rightLiftHall.setDistancePerPulse(0.0); //placeholder
    while (leftLiftHall.getDistance() < d){
      leftCasMotor.set(s);
      rightCasMotor.set(s);
    }
  }

  public static void up(){
    if(level < 6){
      double difference = height[level +1] - height[level];
        move(difference, 0.5);
        level++;
    }
    }
  public static void down(){
    if (level > 0){
      double difference = height[level] - height[level - 1];
      move(difference, -0.5);
      level--;
  }
}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}

