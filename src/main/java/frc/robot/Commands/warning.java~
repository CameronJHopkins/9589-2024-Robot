package frc.robot.Commands;

// import java.util.Timer;
// import java.util.TimerTask;
import edu.wpi.first.wpilibj2.command.Command;

public class warning extends Command{
    private int count = 30;
    // private Timer timer;

    public warning() {
    }

    // @Override
    // public void initialize() {
    //     timer = new Timer();
    //     timer.scheduleAtFixedRate(new TimerTask() {
    //         @Override
    //         public void run() {
    //             if (count > 0) {
    //                 System.out.println("Warning -  Self Destruct Sequence Has Been Engaged.  Skooble Will Self Destruct In " + count + "Seconds.");
    //                 count--;
    //             } else {
    //                 System.out.println("Warning - Self Destruct Imminent");
    //                 timer.cancel();
    //             }
    //         }
    //     }, 0, 1000); 
    // }
    @Override
    public void execute() {
    }

    @Override
    public boolean isFinished() {
        return count <= 0; 
    }

    @Override
    public void end(boolean interrupted) {
        System.out.println("Self Destruct Sequence Has Been Aborted");
    }
}
