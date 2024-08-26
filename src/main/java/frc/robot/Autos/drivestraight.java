package frc.robot.Autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.robotcontainer;
import frc.robot.Commands.autopilot;
import frc.robot.Commands.brake;
import frc.robot.Contants.AutoConstants;
import frc.robot.Subsystems.Drive;
import frc.robot.Subsystems.Shooter;

public class drivestraight extends SequentialCommandGroup {
	
    private final Drive driveSubsystem;
    private final Shooter shooterSubsystem;

    public drivestraight (robotcontainer robot, Drive driveSubsystem, Shooter shooterSubsystem){

        this.driveSubsystem = driveSubsystem;
        this.shooterSubsystem = shooterSubsystem;
        System.out.println("Drive Straight");

       addCommands(new autopilot(driveSubsystem).withTimeout(AutoConstants.DriverTimer).andThen(new brake(driveSubsystem, shooterSubsystem)));

    }
}
