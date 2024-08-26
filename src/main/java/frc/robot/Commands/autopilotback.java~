package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.Drive;

public class autopilotback extends Command {

    private Drive drive;
    
    public autopilotback(Drive drive) {
       this.drive = drive;
    }

    @Override
    public void initialize() {
     }

    @Override
    public void execute(){
        drive.autopilotback();
    }
    
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        drive.brake();
    }
}
