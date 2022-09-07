package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class Drive extends CommandBase {
    private XboxController driver;
    private Drivetrain drivetrain;

    public Drive(Drivetrain drivetrain, XboxController controller) {
        this.drivetrain = drivetrain;
        this.driver = controller;
        addRequirements(drivetrain);
    }

    @Override
    public void execute() {
        double laxis = driver.getRawAxis(XboxController.Axis.kLeftY.value);
        double raxis = driver.getRawAxis(XboxController.Axis.kRightY.value);
        laxis = (Math.abs(laxis) < .01) ? 0 : laxis;
        raxis = (Math.abs(raxis) < .01) ? 0 : raxis;
        this.drivetrain.driveTank(laxis, raxis);
    }
}
