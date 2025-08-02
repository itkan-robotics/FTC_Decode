package org.firstinspires.ftc.teamcode.subsystems.servos;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ServoSubsystem {
    /**
     * Creates a new ExampleSubsystem.
     */
    private final Servo servo;
    public ServoSubsystem(HardwareMap h, String name) {
        this.servo = h.get(Servo.class, name);
    }
    public void set(double pos) {
        this.servo.setPosition(pos);
    }

}