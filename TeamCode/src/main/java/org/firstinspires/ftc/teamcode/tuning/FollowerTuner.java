package org.firstinspires.ftc.teamcode.tuning;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.geometry.Pose2d;
import com.arcrobotics.ftclib.geometry.Rotation2d;
import com.arcrobotics.ftclib.geometry.Translation2d;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.ChassisSpeeds;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.MecanumDriveKinematics;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.MecanumDriveWheelSpeeds;
import com.arcrobotics.ftclib.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.PinpointSubsystem;
import org.firstinspires.ftc.teamcode.util.HeadingProfiledPIDController;
import org.firstinspires.ftc.teamcode.util.HolonomicDriveController;
import org.firstinspires.ftc.teamcode.util.TrapezoidProfile;

import java.util.ArrayList;
import java.util.List;

@Config
@TeleOp
public class FollowerTuner extends OpMode {
    PinpointSubsystem pinpoint;
    DriveSubsystem drive;
    HolonomicDriveController holonomicDriveController;
    MecanumDriveKinematics mecanumDriveKinematics;
    Trajectory trajectory;
    public static double xP, xI, xD, yP, yI, yD, tP, tI, tD;
    @Override
    public void init() {
        drive = new DriveSubsystem(hardwareMap, Constants.frontLeftName, Constants.frontRightName, Constants.backLeftName, Constants.backRightName, Constants.frontLeftMotorDirectionReversed, Constants.frontRightMotorDirectionReversed, Constants.backLeftMotorDirectionReversed, Constants.backRightMotorDirectionReversed);
        pinpoint = new PinpointSubsystem(hardwareMap, Constants.pinpointName);
        //holonomicDriveController = new HolonomicDriveController(new PIDController(Constants.followerXkP, Constants.followerXkI, Constants.followerXkD), new PIDController(Constants.followerYkP, Constants.followerYkI, Constants.followerYkD), new HeadingProfiledPIDController(Constants.followerThetakP, Constants.followerThetakI, Constants.followerThetakD, new TrapezoidProfile.Constraints(Constants.maxVelocity, Constants.maxAcceleration)));
        holonomicDriveController = null;
        mecanumDriveKinematics = new MecanumDriveKinematics(Constants.frontLeftWheelMeters, Constants.frontRightWheelMeters, Constants.backLeftWheelMeters, Constants.backRightWheelMeters);
        xP = 0;
        xI = 0;
        xD = 0;
        yP = 0;
        yI = 0;
        yD = 0;
        tP = 0;
        tI = 0;
        tD = 0;
    }

    @Override
    public void loop() {
        holonomicDriveController = new HolonomicDriveController(new PIDController(xP, xI, xD), new PIDController(yP, yI, yD), new HeadingProfiledPIDController(tP, tI, tD, new TrapezoidProfile.Constraints(Constants.maxVelocity, Constants.maxAcceleration)));
        ChassisSpeeds targetSpeed = holonomicDriveController.calculate(pinpoint.getPose(), new Trajectory.State(0, 0, 0, new Pose2d(new Translation2d(0, 0), new Rotation2d(0)), 0), new Rotation2d(0));
        MecanumDriveWheelSpeeds targetWheelSpeeds = mecanumDriveKinematics.toWheelSpeeds(targetSpeed);
        drive.setSpeed(targetWheelSpeeds.frontLeftMetersPerSecond, targetWheelSpeeds.frontRightMetersPerSecond, targetWheelSpeeds.rearLeftMetersPerSecond, targetWheelSpeeds.rearRightMetersPerSecond);
    }
}
