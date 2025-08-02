package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.ChassisSpeeds;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.MecanumDriveWheelSpeeds;
import com.arcrobotics.ftclib.trajectory.Trajectory;
import com.pedropathing.follower.Follower;

import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.FollowerSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.PinpointSubsystem;

import java.util.concurrent.TimeUnit;
import java.util.function.DoubleSupplier;


public class FollowerCommand extends CommandBase {

    private final FollowerSubsystem follower;
    private final DriveSubsystem drive;
    private final PinpointSubsystem pinpoint;
    private final Trajectory trajectory;
    private long startTime, currentTime;

    public FollowerCommand(FollowerSubsystem follower, DriveSubsystem drive, PinpointSubsystem pinpoint, Trajectory trajectory) {
        this.follower = follower;
        this.drive = drive;
        this.pinpoint = pinpoint;
        this.trajectory = trajectory;
        startTime = System.nanoTime();
        addRequirements(follower);
    }

    @Override
    public void execute() {
            currentTime = System.nanoTime();
            double trajectoryTime = TimeUnit.SECONDS.convert(currentTime-startTime, TimeUnit.NANOSECONDS);
            Trajectory.State targetState = trajectory.sample(trajectoryTime);
            MecanumDriveWheelSpeeds targetWheelSpeeds = follower.getTargetWheelSpeeds(targetState, pinpoint.getPose());
            drive.setSpeed(targetWheelSpeeds.frontLeftMetersPerSecond, targetWheelSpeeds.frontRightMetersPerSecond, targetWheelSpeeds.rearLeftMetersPerSecond, targetWheelSpeeds.rearRightMetersPerSecond);
    }
    @Override
    public boolean isFinished(){
        Trajectory.State finalState = trajectory.getStates().get(trajectory.getStates().size()-1);
        return Math.abs(finalState.poseMeters.getX()-pinpoint.getPose().getX()) < 1 && Math.abs(finalState.poseMeters.getY()-pinpoint.getPose().getY()) < 1 && Math.abs(finalState.poseMeters.getHeading()-pinpoint.getPose().getHeading()) < 1;
    }

}
