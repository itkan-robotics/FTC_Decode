package org.firstinspires.ftc.teamcode.subsystems.servos;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class IntakeRotSubsystem extends SubsystemBase implements Servo {
    ServoSubsystem intakeRot;
    public IntakeRotSubsystem(HardwareMap h, String name){
        intakeRot = new ServoSubsystem(h, name);
    }
    public void set(double pos) {
        intakeRot.set(pos);
    }
}