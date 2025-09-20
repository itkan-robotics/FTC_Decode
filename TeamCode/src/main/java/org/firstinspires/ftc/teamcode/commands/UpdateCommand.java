package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.LimelightSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.PinpointSubsystem;

public class UpdateCommand extends CommandBase {
    PinpointSubsystem pinpoint;
    LimelightSubsystem ll;
    public UpdateCommand(PinpointSubsystem pinpoint, LimelightSubsystem ll){
        this.pinpoint = pinpoint;
        this.ll = ll;
    }
}
