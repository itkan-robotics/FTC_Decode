package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.LimelightSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.PinpointSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.TurretSubsystem;

public class TrackCommand extends CommandBase {
    TurretSubsystem turret;
    PinpointSubsystem pinpoint;
    public TrackCommand(TurretSubsystem turret, PinpointSubsystem ll){
        this.turret = turret;
        this.pinpoint = ll;
        addRequirements(turret);
    }
    @Override
    public void execute(){
        double d = Math.toDegrees(Math.atan2(Math.abs(Constants.goal.getY() - pinpoint.getPose().getY()), Math.abs(Constants.goal.getX() - pinpoint.getPose().getX())));
        int targetTick = (int)((270 - d - pinpoint.getPose().getHeading()) * 550 / 180);
        turret.set(targetTick);
    }
}
