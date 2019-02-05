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
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * Add your docs here.
 */
public class Cargo extends Subsystem {

  public Cargo(){
  }
//
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  //the 2 cargo pistons with 1 double solenoid
  public static DoubleSolenoid cargoPistons = new DoubleSolenoid(RobotMap.cargoPistPort1, RobotMap.cargoPistPort2);
  //public static DoubleSolenoid cargoPistRight = new DoubleSolenoid(RobotMap.cargoPistPortR1, RobotMap.cargoPistPortR2);
  public static TalonSRX level1CargoMotor = new TalonSRX(RobotMap.level1CargoPort);
  //public static TalonSRX usquishMotorLeft = new TalonSRX(RobotMap.leftusquishPort);
  public static TalonSRX level2CargoMotor = new TalonSRX(RobotMap.level2CargoPort);

  public static void extendIntake(){
    cargoPistons.set(DoubleSolenoid.Value.kForward);
    //cargoPistRight.set(DoubleSolenoid.Value.kForward);
  }

  public static void retractIntake(){
    //cargoPistLeft.set(DoubleSolenoid.Value.kReverse);
    //cargoPistRight.set(DoubleSolenoid.Value.kReverse);
    cargoPistons.set(DoubleSolenoid.Value.kReverse);
  }

  public static void intake(double s){
    level1CargoMotor.set(ControlMode.PercentOutput,s);
    level2CargoMotor.set(ControlMode.PercentOutput, s);
    //usquishMotorRight.set(ControlMode.PercentOutput, s);
  }

  public static void shootCargo(double s){
    level2CargoMotor.set(ControlMode.PercentOutput, s);
   // usquishMotorRight.set(ControlMode.PercentOutput, -s);
  }

  public static void outtake(double s){
    level1CargoMotor.set(ControlMode.PercentOutput, s);
    level2CargoMotor.set(ControlMode.PercentOutput, s);
  }
  
  @Override
  public void initDefaultCommand() { 
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
