package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.PushHatch;

public class Hatch extends Subsystem{

  public static DoubleSolenoid hatchPiston1 = new DoubleSolenoid(RobotMap.pcmHatchPort1, RobotMap.hatchPort1a, RobotMap.hatchPort1b);
  public static DoubleSolenoid hatchPiston2 = new DoubleSolenoid(RobotMap.pcmHatchPort2, RobotMap.hatchPort2a, RobotMap.hatchPort2b);

  public Hatch(){
    System.out.println("subsytsem");
  }

  public static void extend1(){
    System.out.println(hatchPiston1.get());
    hatchPiston1.set(DoubleSolenoid.Value.kForward);
    System.out.println(hatchPiston1.get());
  }

  public static void retract1(){
    hatchPiston1.set(DoubleSolenoid.Value.kReverse);
    System.out.println(hatchPiston1.get());
  }

  public static void extend2(){
    System.out.println(hatchPiston2.get());
    hatchPiston2.set(DoubleSolenoid.Value.kForward);
    System.out.println(hatchPiston2.get());
  }
  
  public static void retract2(){
    hatchPiston2.set(DoubleSolenoid.Value.kReverse);
    System.out.println(hatchPiston2.get());
  }

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


