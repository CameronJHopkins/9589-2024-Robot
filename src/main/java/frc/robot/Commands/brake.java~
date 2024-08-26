package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Subsystems.Drive;
import frc.robot.Subsystems.Shooter;

public class brake extends Command {

    private Drive drive;
    private Shooter shooter;
    public brake(Drive drive, Shooter shooter) {
       this.drive = drive;
       this.shooter = shooter;
    }

    @Override
    public void initialize() {
        CommandScheduler.getInstance().cancelAll();
     }

    @Override
    public void execute(){
        CommandScheduler.getInstance().cancelAll();
        drive.brake();
        shooter.arret();
        CommandScheduler.getInstance().cancelAll();
    }
    
    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public void end(boolean interrupted) {
    }
}
