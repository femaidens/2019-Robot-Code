/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * Add your docs here.
 */
public class Lift extends Subsystem {
  public static double[] height = {0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0};
  public static Encoder leftEncoder = new Encoder(RobotMap.casEncLeft1, RobotMap.casEncLeft2);
  public static Encoder rightEncoder = new Encoder(RobotMap.casEncRight1, RobotMap.casEncRight2);
  public static double distance; //distance desired
  public static TalonSRX leftCasMotor = new TalonSRX(RobotMap.leftCasPort);
  public static TalonSRX rightCasMotor = new TalonSRX(RobotMap.rightCasPort);
  public static int level  = 0;

  public Lift(){
  }
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static void move(double d, double s){
    while (leftEncoder.get() < distance){
      leftCasMotor.set(ControlMode.PercentOutput, s);
      rightCasMotor.set(ControlMode.PercentOutput, s);
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
