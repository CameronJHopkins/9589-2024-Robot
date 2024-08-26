package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.Shooter;

public class armtorpedoes extends Command {

    private Shooter shooter;
    public armtorpedoes(Shooter shooter) {
        this.shooter = shooter;
        addRequirements(shooter);
    }
        @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        shooter.armtorpedoes();
    }
    
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean i) {
        shooter.arret();
    }
}
