package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.PushHatch;

public class Hatch extends Subsystem{
/*
public Hatch(){
  System.out.println("subsytsem");
}

public static DoubleSolenoid hatchPiston = new DoubleSolenoid(RobotMap.hatchPort1, RobotMap.hatchPort2);

public static void extend(){
System.out.println(hatchPiston.get());
hatchPiston.set(DoubleSolenoid.Value.kForward);
System.out.println(hatchPiston.get());
}

public static void retract(){
hatchPiston.set(DoubleSolenoid.Value.kReverse);
System.out.println(hatchPiston.get());
}
*/
public void initDefaultCommand(){
  //setDefaultCommand(new PushHatch());
}
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


