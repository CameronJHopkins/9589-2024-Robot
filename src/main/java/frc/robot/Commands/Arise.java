package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.Newmatics;

public class Arise extends Command {

    private Newmatics newmatics;
    public Arise(Newmatics newmatics) {
        this.newmatics = newmatics;
        addRequirements(this.newmatics); 
    }
        @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        newmatics.Arise();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        newmatics.nopshhh();
    }
}
