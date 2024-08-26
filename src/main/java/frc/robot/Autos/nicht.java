package frc.robot.Autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.robotcontainer;
import frc.robot.Commands.brake;
import frc.robot.Subsystems.Drive;
import frc.robot.Subsystems.Shooter;

public class nicht extends SequentialCommandGroup {
	
    public final Drive driveSubsystem;
    public final Shooter shooterSubsystem;

    public nicht (robotcontainer robot, Drive driveSubsystem, Shooter shooterSubsystem){
	    
        this.driveSubsystem = driveSubsystem;
        this.shooterSubsystem = shooterSubsystem;

        System.out.println("Nothing");

        addCommands(new brake(driveSubsystem, shooterSubsystem));

    }
}
