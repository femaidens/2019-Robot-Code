/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Drivetrain;

public class DriveTeleop extends Command{
  
  public DriveTeleop(){ 
    requires(Robot.drivetrain);
  }

  protected void initialize(){
  
  }
  protected void execute() {
    System.out.println("commandinggg");
    Drivetrain.driveTeleop();
    //System.out.println(Drivetrain.leftHall.getPosition());
  }
  
  protected boolean isFinished() {
    return false;
  }
  protected void end(){
  //call auton method so we can set the speeds without joystick
  }
  
  protected void interrupted(){
  }
  
  }
  