package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.Subsystem;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.servos.Servo;
import org.firstinspires.ftc.teamcode.subsystems.slides.RSlideSubsystem;

import java.util.function.DoubleSupplier;

/**
 * A command to drive the robot with joystick input
 * (passed in as {@link DoubleSupplier}s). Written
 * explicitly for pedagogical purposes.
 */
public class RunClimbCommand extends CommandBase {

    private final RSlideSubsystem servo;
    private final double pos;


    public RunClimbCommand(RSlideSubsystem servo, double pos) {
        this.servo = servo;
        this.pos = pos;
        addRequirements(servo);
    }
    @Override
    public void execute() {
        servo.set(pos);
    }
    @Override
    public boolean isFinished(){
        return true;
    }


}