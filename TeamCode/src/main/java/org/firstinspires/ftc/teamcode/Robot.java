package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.controller.wpilibcontroller.ProfiledPIDController;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.MecanumDriveKinematics;
import com.arcrobotics.ftclib.trajectory.TrapezoidProfile;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystems.ColorSensorSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.FollowerSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.PinpointSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.servos.BlockerSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.servos.GrabberSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.servos.HandSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.servos.IntakeRotSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.slides.HorizontalSlideSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.slides.VerticalSlideSubsystem;
import org.firstinspires.ftc.teamcode.util.HolonomicDriveController;

public class Robot {
    public static IntakeSubsystem intake;
    public static DriveSubsystem drive;
    public static ColorSensorSubsystem colorSensor;
    public static FollowerSubsystem follower;
    public static PinpointSubsystem pinpoint;
    public static HorizontalSlideSubsystem hSlide;
    public static VerticalSlideSubsystem vSlide;
    public static BlockerSubsystem blocker;
    public static GrabberSubsystem grabber;
    public static HandSubsystem hand;
    public static IntakeRotSubsystem intakeRot;

    public static void init(HardwareMap h) {
        intake = new IntakeSubsystem(h, Constants.intakeName);
        drive = new DriveSubsystem(h, Constants.frontLeftName, Constants.frontRightName, Constants.backLeftName, Constants.backRightName, Constants.frontLeftMotorDirectionReversed, Constants.frontRightMotorDirectionReversed, Constants.backLeftMotorDirectionReversed, Constants.backRightMotorDirectionReversed);
        colorSensor = new ColorSensorSubsystem(h, Constants.colorSensorName);
        pinpoint = new PinpointSubsystem(h, Constants.pinpointName);
        hSlide = new HorizontalSlideSubsystem(h, Constants.hSlideName, Constants.hSlideEncoderDirectionReversed);
        vSlide = new VerticalSlideSubsystem(h, Constants.vSlideName, Constants.vSlideEncoderDirectionReversed);
        blocker = new BlockerSubsystem(h, Constants.blockerName);
        grabber = new GrabberSubsystem(h, Constants.grabberName);
        hand = new HandSubsystem(h, Constants.handName);
        intakeRot = new IntakeRotSubsystem(h, Constants.intakeRotName);
        follower = new FollowerSubsystem(new HolonomicDriveController(new PIDController(Constants.followerXkP, Constants.followerXkI, Constants.followerXkD), new PIDController(Constants.followerYkP, Constants.followerYkI, Constants.followerYkD), new ProfiledPIDController(Constants.followerThetakP, Constants.followerThetakI, Constants.followerThetakD, new TrapezoidProfile.Constraints(Constants.maxVelocity, Constants.maxAcceleration))), pinpoint, new MecanumDriveKinematics(Constants.frontLeftWheelMeters, Constants.frontRightWheelMeters, Constants.backLeftWheelMeters, Constants.backRightWheelMeters), drive);
    }
}