/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

  //drivtrain motors (spark max)
  public static int frontRightPort = 4;
  public static int frontLeftPort = 3;
  public static int centerRightPort = 13;
  public static int centerLeftPort = 1;
  public static int rearRightPort = 12;
  public static int rearLeftPort = 6;

  public static int gyroPort = 0;

  //ports for hatch DoubleSolenoid 
  public static int pcmHatchPort1 = 02; //placeholder
  public static int pcmHatchPort2 = 02; //placeholder
  public static int hatchPort1a = 0; //placeholder
  public static int hatchPort1b = 1; //placeholder
  public static int hatchPort2a = 2; //placeholder
  public static int hatchPort2b = 3; //placeholder

  //ports for cascade motors
  public static int leftCasPort = 0; //placeholder
  public static int rightCasPort = 2; //placeholder

  //joystick 
  public static int driveJoyPort = 0; //placeholder

  //climber (front pistons)
  public static int pcmClimberFrontPort = 01;
  public static int frontClimbPort1 = 6; 
  public static int frontClimbPort2 = 7; 
  //public static int frontClimbPort3 = 0; 
  //public static int frontClimbPort4 = 0; 

  //(back pistons)
  public static int pcmClimberBackPort = 01;
  public static int backClimbPort1 = 4; 
  public static int backClimbPort2 = 5; 
  //public static int backClimbPort3 = 0; 
  //public static int backClimbPort4 = 0; 

  //cargo ports (pistons)
  public static int cargoPcmPort = 01;
  public static int cargoPistPort1 = 2;
  public static int cargoPistPort2 = 3;
  //public static int cargoPistPortR1 = 0;
  //public static int cargoPistPortR2 = 0;

  //cargo motor ports 
  public static int level1CargoPort = 0;
  public static int level2CargoPort = 0;

  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
