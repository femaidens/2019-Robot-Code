/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightAuton extends CommandGroup {
  /**
   * Add your docs here.
   */
  public RightAuton() {
    addSequential(new DriveUltra(0.5,5));
    addSequential(new TurnDegrees(-90));
    addSequential(new AutoAlignAuton());
    addSequential(new PushHatch());
  }
}