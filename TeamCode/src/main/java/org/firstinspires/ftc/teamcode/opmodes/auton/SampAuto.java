package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.geometry.Pose2d;
import com.arcrobotics.ftclib.geometry.Rotation2d;
import com.arcrobotics.ftclib.geometry.Translation2d;
import com.arcrobotics.ftclib.trajectory.Trajectory;
import com.arcrobotics.ftclib.trajectory.TrajectoryConfig;
import com.arcrobotics.ftclib.trajectory.TrajectoryGenerator;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Robot;

import java.util.ArrayList;
import java.util.List;

public class SampAuto extends OpMode {
    Trajectory preloadScore, samp1Intake, samp1Score, samp2Intake, samp2Score, samp3Intake, samp3Score;
    Pose2d startPose = new Pose2d(new Translation2d(0, 0), new Rotation2d(0));
    Pose2d basketPose = new Pose2d(new Translation2d(7,20), new Rotation2d(-45));
    Pose2d samp1IntakePose = new Pose2d(new Translation2d(10, 17), new Rotation2d(-15));
    Pose2d samp2IntakePose = new Pose2d(new Translation2d(10, 17), new Rotation2d(0));
    Pose2d samp3IntakePose = new Pose2d(new Translation2d(10, 17), new Rotation2d(15));

    @Override
    public void init() {
        Robot.init(hardwareMap);
        List<Translation2d> interiorPoses = new ArrayList<>();
        interiorPoses.add(new Translation2d(5, 5));
        preloadScore = TrajectoryGenerator.generateTrajectory(startPose, interiorPoses, basketPose, new TrajectoryConfig(Constants.maxVelocity, Constants.maxAcceleration));
        interiorPoses = new ArrayList<>();
        samp1Intake = TrajectoryGenerator.generateTrajectory(basketPose, interiorPoses, samp1IntakePose, new TrajectoryConfig(Constants.maxVelocity, Constants.maxAcceleration));
        samp1Score = TrajectoryGenerator.generateTrajectory(samp1IntakePose, interiorPoses, basketPose, new TrajectoryConfig(Constants.maxVelocity, Constants.maxAcceleration));
        samp2Intake = TrajectoryGenerator.generateTrajectory(basketPose, interiorPoses, samp2IntakePose, new TrajectoryConfig(Constants.maxVelocity, Constants.maxAcceleration));
        samp2Score = TrajectoryGenerator.generateTrajectory(samp2IntakePose, interiorPoses, basketPose, new TrajectoryConfig(Constants.maxVelocity, Constants.maxAcceleration));
        samp3Intake = TrajectoryGenerator.generateTrajectory(basketPose, interiorPoses, samp3IntakePose, new TrajectoryConfig(Constants.maxVelocity, Constants.maxAcceleration));
        samp3Score = TrajectoryGenerator.generateTrajectory(samp3IntakePose, interiorPoses, basketPose, new TrajectoryConfig(Constants.maxVelocity, Constants.maxAcceleration));

//        Command autonomous = new SequentialCommandGroup(
//                Robot.getHighBasketScoreCommand(preloadScore),
//                Robot.cycleCommand(samp1Intake, samp1Score),
//                Robot.cycleCommand(samp2Intake, samp2Score),
//                Robot.cycleCommand(samp3Intake, samp3Score)
//        );


        //CommandScheduler.getInstance().schedule(autonomous);

    }

    @Override
    public void loop() {
        CommandScheduler.getInstance().run();
    }
}
