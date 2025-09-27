package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.servos.HoldSubsystem;


public class IntakeCommand extends CommandBase {

    private final IntakeSubsystem intake;
    private final double speed;
    private final HoldSubsystem hold;

    public IntakeCommand(IntakeSubsystem intake, HoldSubsystem hold, double speed) {
        this.intake=intake;
        this.speed=speed;
        this.hold = hold;
        addRequirements(intake, hold);
    }

    @Override
    public void execute() {
        intake.set(speed);
        hold.set(Constants.holdClosePos);
    }

}