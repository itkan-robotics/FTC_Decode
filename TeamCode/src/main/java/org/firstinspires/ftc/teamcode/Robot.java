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
        vSlide = new VerticalSlideSubsystem(h, Constants.vSlideRightName, Constants.vSlideLeftName, Constants.vSlideRightEncoderDirectionReversed, Constants.vSlideLeftEncoderDirectionReversed);
        blocker = new BlockerSubsystem(h, Constants.blockerName);
        grabber = new GrabberSubsystem(h, Constants.grabberName);
        hand = new HandSubsystem(h, Constants.handName);
        intakeRot = new IntakeRotSubsystem(h, Constants.intakeRotName);
        follower = new FollowerSubsystem(new HolonomicDriveController(new PIDController(Constants.followerXkP, Constants.followerXkI, Constants.followerXkD), new PIDController(Constants.followerYkP, Constants.followerYkI, Constants.followerYkD), new HeadingProfiledPIDController(Constants.followerThetakP, Constants.followerThetakI, Constants.followerThetakD, new TrapezoidProfile.Constraints(Constants.maxVelocity, Constants.maxAcceleration))), new MecanumDriveKinematics(Constants.frontLeftWheelMeters, Constants.frontRightWheelMeters, Constants.backLeftWheelMeters, Constants.backRightWheelMeters));
    }
    public static Command cycleCommand(Trajectory intakeTrajectory, Trajectory scoreTrajectory){
        return new SequentialCommandGroup(
                new ParallelCommandGroup(
                        new FollowerCommand(follower, drive, pinpoint, intakeTrajectory),
                        new SetSlideCommand(vSlide, 0),
                        new SetSlideCommand(hSlide, 590),
                        new SetServoCommand(intakeRot, Constants.intakeRotIntakePos),
                        new SetServoCommand(blocker, Constants.blockerClosePos),
                        new SetServoCommand(hand, Constants.handTransferPos),
                        new SetServoCommand(grabber, Constants.grabberOpenPos),
                        new AutoIntakeCommand(intake, colorSensor, -1, "BlueYellow")
                ),
                new ParallelCommandGroup(
                       new SequentialCommandGroup(
                               new ParallelCommandGroup(
                                       new SetSlideCommand(hSlide, 0),
                                       new SetServoCommand(intakeRot, Constants.intakeRotTransferPos),
                                       new IntakeCommand(intake, -0.5)
                               ),
                               new SetServoCommand(blocker, Constants.blockerOpenPos),
                               new WaitCommand(0.2),
                               new ParallelCommandGroup(
                                       new SetServoCommand(grabber, Constants.grabberClosePos),
                                       new IntakeCommand(intake, 0),
                                       new SetSlideCommand(vSlide, Constants.highBasketHeight),
                                       new SetServoCommand(hand, Constants.handBasketScorePos)
                               )
                       ),
                       new FollowerCommand(follower, drive, pinpoint, scoreTrajectory),
                        new SetServoCommand(grabber, Constants.grabberOpenPos)
                )


        );
    }
    public static Command getHighBasketScoreCommand(Trajectory trajectory){
        return new SequentialCommandGroup(
                new ParallelCommandGroup(
                        new FollowerCommand(follower, drive, pinpoint, trajectory),
                        new SetSlideCommand(vSlide, Constants.highBasketHeight),
                        new SetServoCommand(hand, Constants.handBasketScorePos)
                ),
                new SetServoCommand(grabber, Constants.grabberOpenPos)
        );
    }

    public static Command extendAndIntakeCommand = new ParallelCommandGroup(
            new SetSlideCommand(hSlide, 590),
            new SetServoCommand(blocker, Constants.blockerClosePos),
            new SetServoCommand(intakeRot, Constants.intakeRotIntakePos),
            new IntakeCommand(intake, -1),
            new SetSlideCommand(vSlide, 0),
            new SetServoCommand(grabber, Constants.grabberOpenPos),
            new SetServoCommand(hand, Constants.handTransferPos)
    );

    public static Command transferCommand = new SequentialCommandGroup(
            new ParallelCommandGroup(
                    new SetSlideCommand(hSlide, 0),
                    new SetServoCommand(intakeRot, Constants.intakeRotTransferPos),
                    new IntakeCommand(intake, -0.5)
            ),
            new SetServoCommand(blocker, Constants.blockerOpenPos),
            new WaitCommand(0.2),
            new ParallelCommandGroup(
                    new SetServoCommand(grabber, Constants.grabberClosePos),
                    new IntakeCommand(intake, 0)
            )
    );

    public static Command highBasketPosCommand = new ParallelCommandGroup(
            new SetSlideCommand(vSlide, Constants.highBasketHeight),
            new SetServoCommand(hand, Constants.handBasketScorePos)
    );

    public static Command basketScoreCommand = new SetServoCommand(grabber, Constants.grabberOpenPos);

    public static Command retractCommand = new ParallelCommandGroup(
            new SetServoCommand(hand, Constants.handTransferPos),
            new SetSlideCommand(vSlide, 0)
    );







}