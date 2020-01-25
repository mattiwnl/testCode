/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.intake.*;
import frc.robot.shooter.*;

public class RobotContainer {
  	// The robot's subsystems and commands are defined here
  	public final static XboxController xbox = new XboxController(0);
	public final static ShooterSubsystem shootSub = new ShooterSubsystem();
	public final static IntakeSubsystem	intakeSub = new IntakeSubsystem();

  	public RobotContainer() {
		configXboxButtonBindings();
		configButtonBoardBindings();
  	}
  	private void configXboxButtonBindings() {
		new JoystickButton(xbox, 1).toggleWhenPressed(new ShooterCommand(shootSub)); // button A
		new JoystickButton(xbox, 2).toggleWhenPressed(new IntakeCommand(intakeSub)); // button B
	}
	private void configButtonBoardBindings(){
	}  
}