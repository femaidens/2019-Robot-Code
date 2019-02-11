/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ClimbAuton extends CommandGroup {
  /**
   * Add your docs here.
   */
  public ClimbAuton() {

    addSequential(new DriveUltra(0.5, 1)); //1 is a placeholder (NOTE: 1 AWAY from level 2)
    addSequential(new ToggleFrontClimb()); //extends front pistons 
    addSequential(new DriveUltra(0.5, 2)); // 2 is a placeholder
    addSequential(new ToggleBackClimb()); //extends back climb 
    addSequential(new DriveUltra(0.5, 1)); //placeholder
    addSequential(new ToggleFrontClimb()); //retracts front climb
    addSequential(new DriveUltra(0.5, 0.5));
    addSequential(new ToggleBackClimb()); //retracts back pistons
    addSequential(new DriveUltra(0.5, 0));

  }
}
