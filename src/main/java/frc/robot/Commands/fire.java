package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.Shooter;

public class fire extends Command {

    private Shooter shooter;
    private double speed;

    public fire(Shooter shooter, Double speed) {

        this.shooter = shooter;
        this.speed = speed;

    }
        @Override
    public void initialize() {
	   
    }

    @Override
    public void execute() {

        shooter.fire(speed);

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
