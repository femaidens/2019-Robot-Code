/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.CascadeDown;
import frc.robot.commands.CascadeUp;
import frc.robot.commands.CascadeZero;
import frc.robot.commands.IntakeCargo;
import frc.robot.commands.PrintTest;
import frc.robot.commands.PushHatch;
import frc.robot.commands.ShootCargo;
import frc.robot.commands.StopAlign;
import frc.robot.commands.ToggleBackClimb;
import frc.robot.commands.ToggleFrontClimb;
import frc.robot.commands.ToggleIntake;
<<<<<<< HEAD
import frc.robot.commands.AutoAlign;
import frc.robot.commands.CamMode;
=======
import frc.robot.commands.AutoAlign_PID;
import frc.robot.commands.*;
>>>>>>> 8fd281bf4b597172542f349a6430418a15b3fdbd
import edu.wpi.first.wpilibj.buttons.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {



  public static Joystick driveJoystick = new Joystick(RobotMap.driveJoyPort);

  //cascade
  /*
  public static Button casUp = new JoystickButton(driveJoystick, 4); //moves cascade up
  public static Button casDown = new JoystickButton(driveJoystick, 1); //moves cascade down
  public static Button casZero = new JoystickButton(driveJoystick, 3);
  */ 

  //hatch
<<<<<<< HEAD
  public static Button autoAlign = new JoystickButton(driveJoystick, 6); //release and acquire hatch
  public static Button printTest = new JoystickButton(driveJoystick, 5); // testing ts and tx values
  public static Button camMode = new JoystickButton(driveJoystick, 2); // toggles cam mode for testing
=======
  public static Button autoAlign = new JoystickButton(driveJoystick, 1); //release and acquire hatch //
  public static Button printTest = new JoystickButton(driveJoystick, 5); // testing ts and tx values

  public static Button autoAlign1 = new JoystickButton(driveJoystick, 2);
>>>>>>> 8fd281bf4b597172542f349a6430418a15b3fdbd
  //xbox
  //1-A
  //2-B
  //3-X
  //4-Y
  //5-top left
  //6-top right

  //climber
  //public static Button climbFront = new JoystickButton(driveJoystick, 0);
  //public static Button climbBack = new JoystickButton(driveJoystick, 0);

  //cargo
  //public static Button intake = new JoystickButton(driveJoystick, 0);
  //public static Button shoot = new JoystickButton(driveJoystick, 0);
  //public static Button toggleIntake = new JoystickButton(driveJoystick, 0);

  public OI(){
    System.out.println("OI running");
    bindButtons();
  }
  public void bindButtons(){
    /*
    casUp.whenPressed(new CascadeUp());
    casDown.whenPressed(new CascadeDown());
    */

    //autoAlign.whenPressed(new AutoAlign()); //A button
    autoAlign1.whileHeld(new AutoAlign_PID());
    autoAlign1.whenReleased(new StopAlign());
    
    autoAlign.whileHeld(new AutoAlign()); 
    autoAlign.whenReleased(new StopAlign());
    printTest.whenPressed(new PrintTest());
<<<<<<< HEAD
    camMode.whenPressed(new CamMode());
    casZero.whenPressed(new CascadeZero());

=======
    //casZero.whenPressed(new CascadeZero());
>>>>>>> 8fd281bf4b597172542f349a6430418a15b3fdbd
    /*
    climbFront.toggleWhenPressed(new ToggleFrontClimb());
    climbBack.toggleWhenPressed(new ToggleBackClimb());

    intake.whileHeld(new IntakeCargo());
    shoot.whileHeld(new ShootCargo());
    toggleIntake.toggleWhenPressed(new ToggleIntake());
*/
  }
  }
 

