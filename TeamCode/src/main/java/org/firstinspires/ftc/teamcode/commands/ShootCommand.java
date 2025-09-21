package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.robotcore.external.Const;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.PinpointSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.ShooterSubsystem;

public class ShootCommand extends CommandBase {
    ShooterSubsystem shooter;
    PinpointSubsystem pinpoint;
    public ShootCommand(ShooterSubsystem shooter, PinpointSubsystem pinpoint){
        this.shooter = shooter;
        this.pinpoint = pinpoint;
        addRequirements(shooter);
    }
    @Override
    public void execute(){
        double d = Math.hypot(pinpoint.getPose().getY(), pinpoint.getPose().getX());
        int x = 0;
        for(int i = 0; i < Constants.distLT.length; i++){
            if(Constants.distLT[i] > d){
                x = i;
                break;
            }
        }
        double c = (d-Constants.distLT[x-1])/(Constants.distLT[x] - Constants.distLT[x-1]);
        double v = c * (Constants.veloLT[x] - Constants.veloLT[x-1]) + Constants.veloLT[x-1];
        shooter.set(v);



    }


}
