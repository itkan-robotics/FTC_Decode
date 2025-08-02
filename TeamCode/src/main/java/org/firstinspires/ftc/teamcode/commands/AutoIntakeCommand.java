package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.ColorSensorSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;



public class AutoIntakeCommand extends CommandBase {

    private final IntakeSubsystem intake;
    private final ColorSensorSubsystem colorSensor;
    private final double speed;
    private final String color;

    public AutoIntakeCommand(IntakeSubsystem intake, ColorSensorSubsystem colorSensor, double speed, String color) {
        this.intake = intake;
        this.colorSensor = colorSensor;
        this.speed = speed;
        this.color = color;
        addRequirements(intake);
    }

    @Override
    public void execute() {
        intake.set(speed);
    }

    @Override
    public boolean isFinished(){
        return color.contains(colorSensor.getColor());
    }

    @Override
    public void end(boolean inturrupted){
        intake.set(0);
    }

}