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
import frc.robot.commands.PushHatch;
import frc.robot.commands.ToggleBackClimb;
import frc.robot.commands.ToggleFrontClimb;
import edu.wpi.first.wpilibj.buttons.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  public static Joystick driveJoystick = new Joystick(RobotMap.driveJoyPort);

  public static Button casUp = new JoystickButton(driveJoystick, 0); //moves cascade up
  public static Button casDown = new JoystickButton(driveJoystick, 0); //moves cascade down

  public static Button hatch = new JoystickButton(driveJoystick,1); //release and acquire hatch

  public static Button climbFront = new JoystickButton(driveJoystick, 0);
  public static Button climbBack = new JoystickButton(driveJoystick, 0);

  public void bindButtons(){
    casUp.whenPressed(new CascadeUp());
    casDown.whenPressed(new CascadeDown());

    hatch.whenPressed(new PushHatch());

    climbFront.toggleWhenPressed(new ToggleFrontClimb());
    climbBack.toggleWhenPressed(new ToggleBackClimb());
  }
  }
 

