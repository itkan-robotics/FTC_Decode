package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.geometry.Pose2d;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.ColorSensorSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.PinpointSubsystem;


public class DriveToCommand extends CommandBase {

    private final DriveSubsystem drive;
    private final PinpointSubsystem pinpoint;
    private final Pose2d pose;

    public DriveToCommand(DriveSubsystem drive, PinpointSubsystem pinpoint, Pose2d pose) {
        this.drive = drive;
        this.pinpoint = pinpoint;
        this.pose = pose;
        addRequirements(drive);

    }

    @Override
    public void execute() {
        double x = Constants.xPID.calculate(pinpoint.getPose().getX(), pose.getX());
        double y = Constants.yPID.calculate(pinpoint.getPose().getY(), pose.getY());
        double t = Constants.tPID.calculate((Math.abs(pinpoint.getPose().getHeading()-pose.getHeading())<=180) ? pinpoint.getPose().getHeading() : (Math.abs(pinpoint.getPose().getHeading() + 360 - pose.getHeading()) <= 180) ? pinpoint.getPose().getHeading() + 360 : pinpoint.getPose().getHeading() - 360 , pose.getHeading());
        double px = x * Math.cos(pinpoint.getPose().getHeading()) + y * Math.sin(pinpoint.getPose().getHeading());
        double py = y * Math.cos(pinpoint.getPose().getHeading()) - x * Math.sin(pinpoint.getPose().getHeading());
        drive.set(px, py, t);
    }

    @Override
    public boolean isFinished(){
        return Math.abs(pinpoint.getPose().getX() - pose.getX()) <= 1 && Math.abs(pinpoint.getPose().getY() - pose.getY()) <= 1 && (Math.abs(pinpoint.getPose().getHeading() - pose.getHeading()) <= 2 || Math.abs(pinpoint.getPose().getHeading() - pose.getHeading() + 360) <= 2 || Math.abs(pinpoint.getPose().getHeading() - pose.getHeading() - 360) <= 2);
    }

    @Override
    public void end(boolean inturrupted){
        drive.set(0, 0, 0);
    }

}