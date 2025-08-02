package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.Subsystem;
import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.*;
import org.firstinspires.ftc.teamcode.subsystems.servos.Servo;
import org.firstinspires.ftc.teamcode.subsystems.slides.Slide;

import java.util.function.DoubleSupplier;

/**
 * A command to drive the robot with joystick input
 * (passed in as {@link DoubleSupplier}s). Written
 * explicitly for pedagogical purposes.
 */
public class SetServoCommand extends CommandBase {

    private final Subsystem servo;
    private final double pos;
    private ElapsedTime t;

    private boolean b;

    public SetServoCommand(Subsystem servo, double pos) {
        this.servo = servo;
        this.pos = pos;
        addRequirements(servo);
    }
    @Override
    public void execute() {
        ((Servo)servo).set(pos);
    }
    @Override
    public boolean isFinished(){
        return true;
    }


}