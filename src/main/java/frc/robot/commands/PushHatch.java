/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Hatch;
import frc.robot.Robot;

public class PushHatch extends Command {
  public static boolean extended = false;
  public PushHatch() {
    System.out.println("command");
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.hatch);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  //@Override
  protected void execute() {  
    //Hatch.extend();
    //System.out.println("extenddd");
   
    if (extended){
      Hatch.retract();
      extended = false;
      System.out.println("retractt");

    }
    else{
      Hatch.extend();
      extended = true;
      System.out.println("extendd");
      
    } 
    
    /*
    if (Hatch.hatchPiston.get() == DoubleSolenoid.Value.kForward){
      Hatch.retract();
      System.out.println("retractttt");
    }  
    else{
      Hatch.extend();
      System.out.println("extenddd");
    }
    */
  }

  // Make this return true when this Command no longer needs to run execute()
 // @Override
  protected boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    //Hatch.retract();
    //System.out.println("retractttt");
  }
}
