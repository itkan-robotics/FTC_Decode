package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

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

        double d = Math.toDegrees(Math.atan2(pinpoint.getPose().getY(), pinpoint.getPose().getX()));
        double theta =  Math.toDegrees(pinpoint.getPose().getHeading()) - d;
        int targetTick = 225;
        if(d <= -90){
            targetTick = 0;
        }
        else if (d >= 90){
            targetTick = 550;
        }
        else {
            targetTick = (int)(550.0 / 180 * (d+90));
        }
        turret.set(targetTick);
    }
}
