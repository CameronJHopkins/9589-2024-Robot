package frc.robot;

import java.io.File;
import java.io.IOException;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Commands.brake;
import frc.robot.Subsystems.Drive;
import frc.robot.Subsystems.General;
import frc.robot.Subsystems.Newmatics;
import frc.robot.Subsystems.Shooter;
import frc.robot.Subsystems.autopicker;


public class Robot extends TimedRobot {
  private static robotcontainer RobotContainer;
  private SequentialCommandGroup autonomouscommand;


  /*The following is a method to run a python script.  If it is needed, uncomment it and put 'runPythonScript();' into the applicable time part.  Then, add the path to the script
   * to the new ProcessBuilder();.  You will need new imports and dependencies.*/
  public void runPythonScript() {
    try {
      // Set the working directory to the directory where the script is located
      File directory = new File(System.getProperty("user.dir"));
      ProcessBuilder pb = new ProcessBuilder("C:\\Users\\musclowsj1\\AppData\\Local\\Microsoft\\WindowsApps\\python3.exe", "C:\\The coding one\\Skooble\\src\\main\\java\\frc\\robot\\Skooble_AI.py");
      pb.directory(directory);
      Process process = pb.start();
      int exitCode = process.waitFor();
      if (exitCode == 0) {
          System.out.println("Python script executed successfully.");
          
      } else {
          System.out.println("Python script failed with exit code: " + exitCode);
      }
  } catch (IOException | InterruptedException e) {
      e.printStackTrace();
  }
}

  @Override
  public void robotInit() {
    System.out.println("Good Morning");
    Shooter shooterSubsystem = new Shooter();
    Newmatics newmaticsSubsystem = new Newmatics();
    Drive driveSubsystem = new Drive();
    General generalSubsystem = new General();
    RobotContainer = new robotcontainer(shooterSubsystem, newmaticsSubsystem, driveSubsystem, generalSubsystem);
    Shooter.AShooter();
    Drive.prepareDrive();
    Drive.differentialStart();
    autopicker.Shuffleboard(newmaticsSubsystem);
    autopicker.AutoModeSelector(autopicker.getAutoChooser(), RobotContainer, shooterSubsystem, driveSubsystem, generalSubsystem);
    CameraServer.startAutomaticCapture();
    autopicker.getAutoChooser();
    new brake(driveSubsystem, shooterSubsystem);
    runPythonScript();
  }
  
  @Override
  public void robotPeriodic() {
    Drive.prepareDrive();
    Drive.differentialStart();
    CommandScheduler.getInstance().run();
    
        
    }

  @Override
  public void disabledPeriodic() {}

  @Override
  public void autonomousInit() {
    autonomouscommand = robotcontainer.getAutonomousCommand();

    if (autonomouscommand != null) {
      autonomouscommand.schedule();
    }
    else {
      System.out.println("Auto Is Null");
    }
  }

  @Override
  public void autonomousPeriodic() {
    Drive.startDrive();
    CommandScheduler.getInstance().run();

  }

  @Override
  public void teleopInit() {
   
    CommandScheduler.getInstance().cancelAll();
    if (autonomouscommand != null) {
      autonomouscommand.cancel();
    }

  }

  @Override
  public void teleopPeriodic() {
    Drive.startDrive(); 
    CommandScheduler.getInstance().run();
  } 
  @Override
  public void disabledInit(){
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void simulationInit(){
    autopicker.getAutoChooser();
  }

  @Override
  public void simulationPeriodic(){
    CommandScheduler.getInstance().run();
  }
}