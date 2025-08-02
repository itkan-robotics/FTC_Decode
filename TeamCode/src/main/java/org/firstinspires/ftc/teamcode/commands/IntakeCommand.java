package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;



public class IntakeCommand extends CommandBase {

    private final IntakeSubsystem intake;
    private final double speed;

    public IntakeCommand(IntakeSubsystem intake, double speed) {
        this.intake=intake;
        this.speed=speed;
        addRequirements(intake);
    }

    @Override
    public void execute() {
        intake.set(speed);
    }

}