package org.firstinspires.ftc.teamcode.subsystems.servos;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class HandSubsystem extends SubsystemBase implements Servo {
    ServoSubsystem hand;
    public HandSubsystem(HardwareMap h, String name){
        hand = new ServoSubsystem(h, name);
    }
    public void set(double pos) {
        hand.set(pos);
    }
}