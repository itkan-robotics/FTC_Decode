package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.MecanumDriveKinematics;
import com.arcrobotics.ftclib.trajectory.Trajectory;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.commands.*;
import org.firstinspires.ftc.teamcode.subsystems.*;
import org.firstinspires.ftc.teamcode.subsystems.servos.*;
import org.firstinspires.ftc.teamcode.subsystems.slides.*;
import org.firstinspires.ftc.teamcode.util.*;


public class Robot {
    public static DriveSubsystem drive;
    public static FollowerSubsystem follower;
    public static TurretSubsystem turret;
    public static PinpointSubsystem pinpoint;
    public static IntakeSubsystem intake;
    public static ShooterSubsystem shooter;
    public static RSlideSubsystem climb;
    public static LimelightSubsystem ll;
    public static HoldSubsystem hold;

    public static void init(HardwareMap h) {
        drive = new DriveSubsystem(h, Constants.frontLeftName, Constants.frontRightName, Constants.backLeftName, Constants.backRightName, Constants.frontLeftMotorDirectionReversed, Constants.frontRightMotorDirectionReversed, Constants.backLeftMotorDirectionReversed, Constants.backRightMotorDirectionReversed);
        pinpoint = new PinpointSubsystem(h, Constants.pinpointName);
        turret =  new TurretSubsystem(h, Constants.turretName);
        shooter = new ShooterSubsystem(h, Constants.shooterName);
        climb = new RSlideSubsystem(h, Constants.climbName, false);
        ll = new LimelightSubsystem(h, Constants.llName);
        hold = new HoldSubsystem(h, Constants.holdName);
        //follower = new FollowerSubsystem(new HolonomicDriveController(new PIDController(Constants.followerXkP, Constants.followerXkI, Constants.followerXkD), new PIDController(Constants.followerYkP, Constants.followerYkI, Constants.followerYkD), new HeadingProfiledPIDController(Constants.followerThetakP, Constants.followerThetakI, Constants.followerThetakD, new TrapezoidProfile.Constraints(Constants.maxVelocity, Constants.maxAcceleration))), new MecanumDriveKinematics(Constants.frontLeftWheelMeters, Constants.frontRightWheelMeters, Constants.backLeftWheelMeters, Constants.backRightWheelMeters));
        follower = null;
        ll.get().setPollRateHz(10);
        ll.get().start();
        ll.get().pipelineSwitch(0);
    }









}