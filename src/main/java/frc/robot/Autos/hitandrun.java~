package frc.robot.Autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Commands.armtorpedoes;
import frc.robot.Commands.arret;
import frc.robot.Commands.autopilotback;
import frc.robot.Commands.brake;
import frc.robot.Commands.fire;
import frc.robot.Contants.AutoConstants;
import frc.robot.Subsystems.Drive;
import frc.robot.Subsystems.Shooter;

public class hitandrun extends SequentialCommandGroup {
    static Drive driveSubsystem = new Drive();
    static Shooter shooterSybsystem = new Shooter();
    public hitandrun(Drive driveSubsystem, Shooter shooterSubsystem){
            hitandrun.driveSubsystem = driveSubsystem;
            hitandrun.shooterSybsystem = shooterSubsystem;
            System.out.println("Combo");

            addCommands(new armtorpedoes(shooterSubsystem).withTimeout(AutoConstants.PrimerTimer).andThen(new fire(shooterSubsystem, 0.99).withTimeout(AutoConstants.FireTimer).andThen(new arret(shooterSubsystem).withTimeout(1).andThen(new autopilotback(driveSubsystem).withTimeout(AutoConstants.DriverTimer).andThen(new brake(driveSubsystem, shooterSubsystem))))));
        }
}