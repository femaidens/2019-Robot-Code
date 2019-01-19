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
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static DoubleSolenoid cargoPistLeft = new DoubleSolenoid(RobotMap.cargoPistPortL1, RobotMap.cargoPistPortL2);
  public static DoubleSolenoid cargoPistRight = new DoubleSolenoid(RobotMap.cargoPistPortR1, RobotMap.cargoPistPortR2);
  public static TalonSRX intakeCargo = new TalonSRX(RobotMap.intakeCargoPort);
  public static TalonSRX usquishMotorLeft = new TalonSRX(RobotMap.leftusquishPort);
  public static TalonSRX usquishMotorRight = new TalonSRX(RobotMap.rightusquishPort);

  public static void extendIntake(){
    cargoPistLeft.set(DoubleSolenoid.Value.kForward);
    cargoPistRight.set(DoubleSolenoid.Value.kForward);
  }

  public static void retractIntake(){
    cargoPistLeft.set(DoubleSolenoid.Value.kReverse);
    cargoPistRight.set(DoubleSolenoid.Value.kReverse);
  }

  public static void intake(double s){
    intakeCargo.set(ControlMode.PercentOutput,s);
    usquishMotorLeft.set(ControlMode.PercentOutput, s);
    usquishMotorRight.set(ControlMode.PercentOutput, s);
  }

  public static void shootCargo(double s){
    usquishMotorLeft.set(ControlMode.PercentOutput, -s);
    usquishMotorRight.set(ControlMode.PercentOutput, -s);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
