package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import frc.robot.commands.*;

/**
 * Add your docs here.
 */
public class LiftSpark extends Subsystem {

  public static boolean moving;
  
  public static int[] height;// = {0.0, 10.0, 20.0, 30.0, 40.0, 50.0, 60.0};
  public static CANSparkMax leftCasMotor = new CANSparkMax(RobotMap.leftCasPort, CANSparkMaxLowLevel.MotorType.kBrushless);
  public static CANSparkMax rightCasMotor = new CANSparkMax(RobotMap.rightCasPort, CANSparkMaxLowLevel.MotorType.kBrushless);
  //for the hall sensors
  public static CANEncoder leftLiftHall = leftCasMotor.getEncoder();
  public static CANEncoder rightLiftHall = rightCasMotor.getEncoder();
  public static int level = 0;
  public static int initposition;
  //public static double position = leftLiftHall.getPosition();

  public LiftSpark(){
    initposition = (int)(leftLiftHall.getPosition());
    height = new int[] {initposition, 10 + initposition, 20 + initposition, 30 + initposition, 40 + initposition, 50 + initposition, 60 + initposition};
  }
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static void downToZero(){
    moving = true;
    while(leftLiftHall.getPosition() > 0.0){
      leftCasMotor.set(-0.02);
      rightCasMotor.set(-0.02);
    }
    leftCasMotor.set(0.0);
    rightCasMotor.set(0.0);
    initposition = (int)(leftLiftHall.getPosition());
    height = new int[] {initposition, 10 + initposition, 20 + initposition, 30 + initposition, 40 + initposition, 50 + initposition, 60 + initposition};
    level = 0;
    moving = false;
  }
  public static void up(){
    //position = leftLiftHall.getPosition();
    if(level < 6){
      System.out.println("going up");
      while(leftLiftHall.getPosition() < height[level + 1]) {
        leftCasMotor.set(0.02);
        rightCasMotor.set(0.02);
        //position = leftLiftHall.getPosition();
        if (leftLiftHall.getPosition() == 0) {
          System.out.println("zero");
          Timer.delay(0.1);
        }
      }
      leftCasMotor.set(0);
      rightCasMotor.set(0);
      level++;
  
    }
    System.out.println("level: " + level);
    System.out.println("position: " + leftLiftHall.getPosition());
  }
  public static void down(){
    //position = leftLiftHall.getPosition();
    if (level > 0){
      System.out.println("going down");
      while(leftLiftHall.getPosition() > height[level - 1]) {
        leftCasMotor.set(-0.02);
        rightCasMotor.set(-0.02);
        //position = leftLiftHall.getPosition();
      }
      leftCasMotor.set(0);
      rightCasMotor.set(0);
      level--;
    }
    System.out.println("level: " + level);
    System.out.println("position: " + leftLiftHall.getPosition());
  }
  public static void printPosition(){
    System.out.println("position: " + leftLiftHall.getPosition());
    //System.out.println("position variable: " + position);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new KeepCascadeUP());
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}

