package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;


public class WaitCommand extends CommandBase {

    private final double seconds;
    private final long start;

    public WaitCommand(double seconds) {
        this.seconds = seconds;
        start = System.nanoTime();
    }

    @Override
    public boolean isFinished(){
        return (System.nanoTime()-start)/1000000000.0 >= seconds;
    }

}