/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Climber extends Subsystem {

  public Climber(){
  }
  

  public static DoubleSolenoid frontPistons = new DoubleSolenoid(RobotMap.frontClimbPort1, RobotMap.frontClimbPort2);
  //public static DoubleSolenoid frontPiston2 = new DoubleSolenoid(RobotMap.frontClimbPort3, RobotMap.frontClimbPort4);
  public static DoubleSolenoid backPistons = new DoubleSolenoid(RobotMap.backClimbPort1, RobotMap.backClimbPort2);
  //public static DoubleSolenoid backPiston2 = new DoubleSolenoid(RobotMap.backClimbPort3, RobotMap.backClimbPort4);

  public static void extendFront(){
    //frontPiston1.set(DoubleSolenoid.Value.kForward);
    //frontPiston2.set(DoubleSolenoid.Value.kForward);
    frontPistons.set(DoubleSolenoid.Value.kForward);
  }
  public static void extendBack(){
    //backPiston1.set(DoubleSolenoid.Value.kForward);
    //backPiston2.set(DoubleSolenoid.Value.kForward);
    backPistons.set(DoubleSolenoid.Value.kForward);
  }
  public static void retractFront(){
    //frontPiston1.set(DoubleSolenoid.Value.kReverse);
    //frontPiston2.set(DoubleSolenoid.Value.kReverse);
    frontPistons.set(DoubleSolenoid.Value.kReverse);
    }
  public static void retractBack(){
    //backPiston1.set(DoubleSolenoid.Value.kReverse);
    //backPiston2.set(DoubleSolenoid.Value.kReverse);
    backPistons.set(DoubleSolenoid.Value.kReverse);
  }
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
p
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
