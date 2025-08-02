package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.MecanumDriveWheelSpeeds;
import com.arcrobotics.ftclib.trajectory.Trajectory;

import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.FollowerSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.PinpointSubsystem;



public class FollowerCommand extends CommandBase {

    private final FollowerSubsystem follower;
    private final DriveSubsystem drive;
    private final PinpointSubsystem pinpoint;
    private final Trajectory trajectory;
    private long startTime, currentTime;
    double trajectoryTime;

    public FollowerCommand(FollowerSubsystem follower, DriveSubsystem drive, PinpointSubsystem pinpoint, Trajectory trajectory) {
        this.follower = follower;
        this.drive = drive;
        this.pinpoint = pinpoint;
        this.trajectory = trajectory;
        startTime = System.nanoTime();
        addRequirements(follower);
        trajectoryTime = 0;
    }

    @Override
    public void execute() {
            currentTime = System.nanoTime();
            trajectoryTime =(currentTime-startTime)/1000000000.0;
            Trajectory.State targetState = trajectory.sample(trajectoryTime);
            MecanumDriveWheelSpeeds targetWheelSpeeds = follower.getTargetWheelSpeeds(targetState, pinpoint.getPose());
            drive.setSpeed(targetWheelSpeeds.frontLeftMetersPerSecond, targetWheelSpeeds.frontRightMetersPerSecond, targetWheelSpeeds.rearLeftMetersPerSecond, targetWheelSpeeds.rearRightMetersPerSecond);
    }
    @Override
    public boolean isFinished(){
//        Trajectory.State finalState = trajectory.getStates().get(trajectory.getStates().size()-1);
//        return Math.abs(finalState.poseMeters.getX()-pinpoint.getPose().getX()) < 1 && Math.abs(finalState.poseMeters.getY()-pinpoint.getPose().getY()) < 1 && Math.abs(finalState.poseMeters.getHeading()-pinpoint.getPose().getHeading()) < 1;
        return trajectoryTime == trajectory.getStates().get(trajectory.getStates().size()-1).timeSeconds;
    }

}
