package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

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

}
