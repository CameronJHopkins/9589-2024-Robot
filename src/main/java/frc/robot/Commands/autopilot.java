package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.Drive;

public class autopilot extends Command {

    private Drive drive;
    
    public autopilot(Drive drive) {
       this.drive = drive;
    }

    @Override
    public void initialize() {
     }

    @Override
    public void execute(){
        drive.autopilot();
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
