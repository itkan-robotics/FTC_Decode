package org.firstinspires.ftc.teamcode.subsystems.servos;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class BlockerSubsystem implements Servo {
    ServoSubsystem blocker;
    public BlockerSubsystem(HardwareMap h, String name){
        blocker = new ServoSubsystem(h, name);
    }
    public void set(double pos) {
        blocker.set(pos);
    }
}