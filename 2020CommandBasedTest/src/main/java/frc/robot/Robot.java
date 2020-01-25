/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.*;

public class Robot extends TimedRobot {
    private RobotContainer m_robotContainer;

    public static final TalonFX tfxLeftMaster = new TalonFX(Constants.DriveMasterLeft);
    public static final TalonFX tfxLeftSlave1 = new TalonFX(Constants.DriveSlaveLeft);
    public static final TalonFX tfxRightMaster = new TalonFX(Constants.DriveMasterRight);
    public static final TalonFX tfxRightSlave1 = new TalonFX(Constants.DriveSlaveRight);

    @Override
    public void robotInit() {
        // Instantiate our RobotContainer. This will perform all our button bindings.
        m_robotContainer = new RobotContainer();
        
        // Follows
        tfxLeftSlave1.follow(tfxLeftMaster);
        tfxRightSlave1.follow(tfxRightMaster);

        // Invert Right
        tfxRightMaster.setInverted(true);
        tfxRightSlave1.setInverted(true);

        // Motor Settings
        tfxLeftMaster.setNeutralMode(NeutralMode.Coast);
        tfxRightMaster.setNeutralMode(NeutralMode.Coast);
        tfxLeftMaster.configNeutralDeadband(.075, 0);
        tfxRightMaster.configNeutralDeadband(.075, 0);
    }
    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }
    @Override
    public void autonomousInit() {
    }
    @Override
    public void autonomousPeriodic() {
    }
    @Override
    public void teleopInit() {
    }
    @Override
    public void teleopPeriodic() {
        // Forza/GTA Drive
        double LT = RobotContainer.xbox.getTriggerAxis(Hand.kLeft);
        double RT = RobotContainer.xbox.getTriggerAxis(Hand.kRight);
        double LXAxis = RobotContainer.xbox.getX(Hand.kLeft);
        double drive = RT - LT;
        double turn = LXAxis * .5;
        tfxLeftMaster.set(ControlMode.PercentOutput, drive - turn);
        tfxRightMaster.set(ControlMode.PercentOutput, drive + turn);
    }
}
