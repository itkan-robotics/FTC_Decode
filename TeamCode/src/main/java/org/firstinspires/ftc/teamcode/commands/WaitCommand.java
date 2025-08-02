package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;

import java.util.concurrent.TimeUnit;
import java.util.function.DoubleSupplier;


public class WaitCommand extends CommandBase {

    private final double seconds;
    private final long start;

    public WaitCommand(double seconds) {
        this.seconds = seconds;
        start = System.nanoTime();
    }

    @Override
    public boolean isFinished(){
        return TimeUnit.SECONDS.convert(System.nanoTime() - start, TimeUnit.NANOSECONDS) == seconds;
    }

}