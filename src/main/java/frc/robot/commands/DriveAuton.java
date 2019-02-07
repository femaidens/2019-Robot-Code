/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.Drivetrain;

public class DriveAuton extends Command {
  
  Ultrasonic ultra1 = new Ultrasonic(RobotMap.pingChannel1, RobotMap.echoChannel1);
  Ultrasonic ultra2 = new Ultrasonic(RobotMap.pingChannel2, RobotMap.echoChannel2);
  Ultrasonic ultra3 = new Ultrasonic(RobotMap.pingChannel3, RobotMap.echoChannel3);
  double speed, distance;
  
  public DriveAuton(double s, double d) {
    speed = s;
    distance = d;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (Drivetrain.ultra1.getRangeInches() > distance){
      Robot.drivetrain.driveAuton(speed, speed);
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
