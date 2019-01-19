package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.PushHatch;

public class Hatch extends Subsystem{

public Hatch(){
}

public static DoubleSolenoid hatchPiston = new DoubleSolenoid(RobotMap.hatchPort1, RobotMap.hatchPort2);

public static void extend(){
hatchPiston.set(DoubleSolenoid.Value.kForward);
}

public static void retract(){
hatchPiston.set(DoubleSolenoid.Value.kReverse);
}

public void initDefaultCommand(){
  setDefaultCommand(new PushHatch());
}
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


