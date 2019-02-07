/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.*;
import frc.robot.commands.*;


public class AutoalignAuton extends Command {
  public AutoalignAuton() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //Robot.limelight.table.getEntry("camMode").setNumber(0);
    //Robot.limelight.table.getEntry("ledMode").setNumber(3);
    Limelight.setLiveStream(0);
    Limelight.setLEDMode(3);

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double degrees = Robot.limelight.getTx();
    while(Robot.drivetrain.ultra1.getRangeInches() > 0){
      if(degrees > 10 || degrees < -10){
        Robot.drivetrain.turnDegrees(degrees);
      }
      else{
       Drivetrain.driveAuton(0.3, 0.3);
      }
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
