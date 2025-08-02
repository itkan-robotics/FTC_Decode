package org.firstinspires.ftc.teamcode.subsystems.servos;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class GrabberSubsystem extends SubsystemBase implements Servo {
    ServoSubsystem grabber;
    public GrabberSubsystem(HardwareMap h, String name){
        grabber = new ServoSubsystem(h, name);
    }
    public void set(double pos) {
        grabber.set(pos);
    }
}