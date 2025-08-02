package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.geometry.Pose2d;
import com.arcrobotics.ftclib.geometry.Rotation2d;
import com.arcrobotics.ftclib.geometry.Translation2d;
import com.arcrobotics.ftclib.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Robot;

import java.util.ArrayList;
import java.util.List;

public class SampAuto extends OpMode {
    Trajectory preloadScore, samp1Intake, samp1Score;

    @Override
    public void init() {
        Robot.init(hardwareMap);
        List<Trajectory.State> trajStates = new ArrayList<>();
        trajStates.add(new Trajectory.State(0, 0, 0, new Pose2d(new Translation2d(0, 0), new Rotation2d(0)), 0));
        trajStates.add(new Trajectory.State(1, 0, 0, new Pose2d(new Translation2d(10, -30), new Rotation2d(-45)), 0));
        preloadScore = new Trajectory(trajStates);
        trajStates = new ArrayList<>();
        trajStates.add(new Trajectory.State(0, 0, 0, new Pose2d(new Translation2d(10, -30), new Rotation2d(-45)), 0));
        trajStates.add(new Trajectory.State(1, 0, 0, new Pose2d(new Translation2d(10, -30), new Rotation2d(-10)), 0));
        samp1Intake = new Trajectory(trajStates);
        samp1Score = new Trajectory(trajStates);
        samp1Score = Robot.reverseTrajectory(new Trajectory(trajStates));

        Command autonomous = new SequentialCommandGroup(
                Robot.getHighBasketScoreCommand(preloadScore),
                Robot.cycleCommand(samp1Intake, samp1Score)
        );


        CommandScheduler.getInstance().schedule(autonomous);

    }

    @Override
    public void loop() {
        CommandScheduler.getInstance().run();
    }
}
