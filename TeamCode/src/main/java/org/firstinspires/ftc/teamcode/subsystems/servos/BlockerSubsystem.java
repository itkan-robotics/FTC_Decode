package org.firstinspires.ftc.teamcode.subsystems.servos;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class BlockerSubsystem extends SubsystemBase implements Servo {
    ServoSubsystem blocker;
    public BlockerSubsystem(HardwareMap h, String name){
        blocker = new ServoSubsystem(h, name);
    }
    public void set(double pos) {
        blocker.set(pos);
    }
}