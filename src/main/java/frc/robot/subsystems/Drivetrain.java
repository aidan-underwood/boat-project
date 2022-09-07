package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
    CANSparkMax leftFront;
    CANSparkMax leftBack;
    CANSparkMax rightFront;
    CANSparkMax rightBack;
    MotorControllerGroup leftDrive;
    MotorControllerGroup rightDrive;
    DifferentialDrive tankDrive;
    MecanumDrive mecanumDrive;
    DoubleSolenoid mecanumSolenoid;

    public Drivetrain() {
        leftFront = new CANSparkMax(Constants.Motors.leftFront, MotorType.kBrushless);
        leftBack = new CANSparkMax(Constants.Motors.leftBack, MotorType.kBrushless);
        rightFront = new CANSparkMax(Constants.Motors.rightFront, MotorType.kBrushless);
        rightBack = new CANSparkMax(Constants.Motors.rightBack, MotorType.kBrushless);

        leftDrive = new MotorControllerGroup(
            new CANSparkMax(Constants.Motors.leftFront, MotorType.kBrushless),
            new CANSparkMax(Constants.Motors.leftBack, MotorType.kBrushless));
        rightDrive = new MotorControllerGroup(
            new CANSparkMax(Constants.Motors.rightFront, MotorType.kBrushless),
            new CANSparkMax(Constants.Motors.rightBack, MotorType.kBrushless));

        tankDrive = new DifferentialDrive(leftDrive, rightDrive);
        mecanumSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,
            Constants.Pneumatics.forwardChan, Constants.Pneumatics.reverseChan);
        mecanumSolenoid.set(Value.kForward);
        mecanumDrive = new MecanumDrive(leftFront, leftBack, rightFront, rightBack);
    }

    public void driveTank(double left, double right) {
        tankDrive.tankDrive(left, right);
    }

    public void driveMecanum(double yAxis, double xAxis, double zRotation) {
        mecanumDrive.driveCartesian(yAxis, xAxis, zRotation);
    }
}
