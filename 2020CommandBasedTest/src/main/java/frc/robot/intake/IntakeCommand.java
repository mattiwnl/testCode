package frc.robot.intake;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.*;

public class IntakeCommand extends CommandBase {

    public IntakeCommand(final IntakeSubsystem intakeSub) {
    }
    @Override
    public void initialize() {
        RobotContainer.intakeSub.cIntake(ControlMode.PercentOutput, Constants.intakePow);
    }
    @Override
    public void execute() {
    }
    @Override
    public void end(final boolean interrupted) {
        super.end(interrupted);
        RobotContainer.intakeSub.cIntake(ControlMode.PercentOutput, 0);
    }
    @Override
    public boolean isFinished() {
        return false;
    }
}