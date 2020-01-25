package frc.robot.intake;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;
import frc.robot.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {

    private static final VictorSPX vspxIntake = new VictorSPX(Constants.Intake);

    public IntakeSubsystem() {
        // Intake Mode
        vspxIntake.setNeutralMode(NeutralMode.Coast);
    }

    public void cIntake(ControlMode mode, double pow) {
        // Intake
        vspxIntake.set(mode, pow);
    }
}