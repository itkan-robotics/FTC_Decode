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
}
