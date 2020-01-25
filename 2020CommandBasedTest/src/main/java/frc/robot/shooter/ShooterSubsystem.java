package frc.robot.shooter;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;
import frc.robot.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {

    private static final TalonFX tfxShooter = new TalonFX(Constants.Shooter);

    public ShooterSubsystem() {
        // Shooter Mode
        tfxShooter.setNeutralMode(NeutralMode.Coast);
    }

    public void cShoot(ControlMode mode, double pow) {
        // Shooter
        tfxShooter.set(mode, pow);
    }
}