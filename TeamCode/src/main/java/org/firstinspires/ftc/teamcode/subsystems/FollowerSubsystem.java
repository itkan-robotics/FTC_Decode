package org.firstinspires.ftc.teamcode.subsystems;


import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.geometry.Pose2d;
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
    private final MecanumDriveKinematics mecanumDriveKinematics;
    public FollowerSubsystem(HolonomicDriveController holonomicDriveController, MecanumDriveKinematics mecanumDriveKinematics) {
        this.holonomicDriveController = holonomicDriveController;
        this.mecanumDriveKinematics = mecanumDriveKinematics;
    }
    public MecanumDriveWheelSpeeds getTargetWheelSpeeds(Trajectory.State targetState, Pose2d currentPose){
        ChassisSpeeds targetSpeed = holonomicDriveController.calculate(currentPose, targetState, targetState.poseMeters.getRotation());
        return mecanumDriveKinematics.toWheelSpeeds(targetSpeed);
    }
}