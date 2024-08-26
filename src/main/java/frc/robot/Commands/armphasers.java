package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.Shooter;

public class armphasers extends Command {

    private Shooter shooter;

    public armphasers(Shooter shooter) {

        this.shooter = shooter;
        addRequirements(shooter); 

    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {

        shooter.armphasers();

    }
    
    @Override
    public boolean isFinished() {

        return false;

    }

    @Override
    public void end(boolean interrupted) {

        shooter.arret();

    }
}
