package frc.robot;

// import java.io.IOException;

import edu.wpi.first.wpilibj.RobotBase;

public final class Main {
  private Main() {}

  public static void main(String... args) {
    RobotBase.startRobot(Robot::new);
    // startVoiceRecognition();
    }
    // private static void startVoiceRecognition() {
    //     // Command to run the voice recognition code
    //     String[] command = {"java", "-cp", "null", "/C:/TheCodingOne/Skooble AI/src"};

    
    //     try {
    //         // Start the voice recognition code as a separate process
    //         ProcessBuilder processBuilder = new ProcessBuilder(command);
    //         processBuilder.start();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }
}

//DO NOT CHANGE ANYTHING HERE OR SKOOBLE DIES