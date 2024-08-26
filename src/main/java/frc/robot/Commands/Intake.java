package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.Shooter;

public class Intake extends Command {

    private Shooter shooter;

    public Intake(Shooter shooter) {

        this.shooter = shooter;
        addRequirements(this.shooter); 

    }
    
    @Override
    public void initialize() {

    }

    @Override
    public void execute() {

        shooter.Intake();

    }

    @Override
    public void end(boolean interrupted) {

        shooter.arret();

    }
}
