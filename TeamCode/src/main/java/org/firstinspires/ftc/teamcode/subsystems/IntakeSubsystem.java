package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class IntakeSubsystem extends SubsystemBase {
    /**
     * Creates a new ExampleSubsystem.
     */
    private final DcMotorEx intake;
    public IntakeSubsystem(HardwareMap h, String name) {
        this.intake = h.get(DcMotorEx.class, name);
        this.intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }
    public void set(double speed) {
        this.intake.setPower(speed);
    }

}