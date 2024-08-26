package frc.robot.Autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.robotcontainer;
import frc.robot.Commands.armtorpedoes;
import frc.robot.Commands.arret;
import frc.robot.Commands.fire;
import frc.robot.Contants.AutoConstants;
import frc.robot.Subsystems.Shooter;

public class fireatwill extends SequentialCommandGroup {
    private final Shooter shooterSubsystem;
    public fireatwill(robotcontainer robot, Shooter shooterSubsystem2){
            this.shooterSubsystem = shooterSubsystem2;
            System.out.println("Fire");

            addCommands(new armtorpedoes(shooterSubsystem).withTimeout(AutoConstants.PrimerTimer).andThen(new fire(shooterSubsystem2, 0.99).withTimeout(AutoConstants.FireTimer).andThen(new arret(shooterSubsystem2))));
    }
}