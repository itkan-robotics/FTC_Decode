package org.firstinspires.ftc.teamcode.subsystems.servos;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class IntakeRotSubsystem implements Servo {
    ServoSubsystem intakeRot;
    public IntakeRotSubsystem(HardwareMap h, String name){
        intakeRot = new ServoSubsystem(h, name);
    }
    public void set(double pos) {
        intakeRot.set(pos);
    }
}