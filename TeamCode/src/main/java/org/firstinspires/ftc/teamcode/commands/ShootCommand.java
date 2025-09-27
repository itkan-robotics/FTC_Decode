package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.hardware.configuration.BuiltInConfigurationTypeJsonAdapter;

import org.firstinspires.ftc.robotcore.external.Const;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.PinpointSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.ShooterSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.servos.HoldSubsystem;

public class ShootCommand extends CommandBase {
    ShooterSubsystem shooter;
    PinpointSubsystem pinpoint;
    HoldSubsystem hold;
    IntakeSubsystem intake;
    public ShootCommand(ShooterSubsystem shooter, PinpointSubsystem pinpoint, HoldSubsystem hold, IntakeSubsystem intake){
        this.shooter = shooter;
        this.pinpoint = pinpoint;
        this.hold = hold;
        this.intake = intake;
        addRequirements(shooter, intake, hold);
    }
    @Override
    public void execute(){
        double d = Math.hypot(pinpoint.getPose().getY() - Constants.goal.getY(), pinpoint.getPose().getX() - Constants.goal.getX());
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
        if(shooter.atVelocity()){
            intake.set(1);
            hold.set(Constants.holdOpenPos);
        }
        else {
            intake.set(0);
        }
    }


}
