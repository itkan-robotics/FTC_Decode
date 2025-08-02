package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.Subsystem;
import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.*;
import org.firstinspires.ftc.teamcode.subsystems.slides.Slide;

import java.util.function.DoubleSupplier;

/**
 * A command to drive the robot with joystick input
 * (passed in as {@link DoubleSupplier}s). Written
 * explicitly for pedagogical purposes.
 */
public class SetSlideCommand extends CommandBase {

    private final Subsystem slide;
    private final int pos;
    private ElapsedTime t;

    private boolean b;

    public SetSlideCommand(Subsystem slide, int pos) {
        this.slide = slide;
        this.pos = pos;
        addRequirements(slide);
    }
    @Override
    public void execute() {
        ((Slide)slide).set(pos);
    }
    @Override
    public boolean isFinished(){
        return Math.abs(pos-((Slide)slide).get()) < 50;
    }


}