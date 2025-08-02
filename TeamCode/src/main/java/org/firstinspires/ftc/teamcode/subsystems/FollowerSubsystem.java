package org.firstinspires.ftc.teamcode.subsystems;


import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.ChassisSpeeds;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.MecanumDriveKinematics;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.MecanumDriveWheelSpeeds;
import com.arcrobotics.ftclib.trajectory.Trajectory;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.PinpointSubsystem;
import org.firstinspires.ftc.teamcode.util.HolonomicDriveController;

import java.util.concurrent.TimeUnit;

public class FollowerSubsystem extends SubsystemBase {

    private final HolonomicDriveController holonomicDriveController;
    private final PinpointSubsystem pinpointSubsystem;
    private long currentTime;
    private long startTime;
    Trajectory currentTrajectory;
    boolean isTrajectoryRunning;
    private final MecanumDriveKinematics mecanumDriveKinematics;
    private final DriveSubsystem driveSubsystem;
    public FollowerSubsystem(HolonomicDriveController holonomicDriveController, PinpointSubsystem pinpointSubsystem, MecanumDriveKinematics mecanumDriveKinematics, DriveSubsystem driveSubsystem) {
        this.holonomicDriveController = holonomicDriveController;
        currentTime = 0;
        startTime = -1;
        currentTrajectory = null;
        isTrajectoryRunning = false;
        this.pinpointSubsystem = pinpointSubsystem;
        this.mecanumDriveKinematics = mecanumDriveKinematics;
        this.driveSubsystem = driveSubsystem;
    }
    public void setTrajectory(Trajectory t){
        currentTrajectory = t;
    }
    public void startTrajectory(){
        isTrajectoryRunning = true;
        startTime = System.nanoTime();
    }




    @Override
    public void periodic() {
        if(isTrajectoryRunning){
            currentTime = System.nanoTime();
            double trajectoryTime = TimeUnit.SECONDS.convert(currentTime-startTime, TimeUnit.NANOSECONDS);
            Trajectory.State targetState = currentTrajectory.sample(trajectoryTime);
            ChassisSpeeds targetSpeed = holonomicDriveController.calculate(pinpointSubsystem.getPose(), targetState, targetState.poseMeters.getRotation());
            MecanumDriveWheelSpeeds targetWheelSpeeds = mecanumDriveKinematics.toWheelSpeeds(targetSpeed);
            driveSubsystem.setSpeed(targetWheelSpeeds.frontLeftMetersPerSecond, targetWheelSpeeds.frontRightMetersPerSecond, targetWheelSpeeds.rearLeftMetersPerSecond, targetWheelSpeeds.rearRightMetersPerSecond);
        }
    }
}