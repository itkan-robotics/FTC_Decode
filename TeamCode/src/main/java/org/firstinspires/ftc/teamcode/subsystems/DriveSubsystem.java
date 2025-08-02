package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.Constants;

public class DriveSubsystem extends SubsystemBase {
    public DcMotorEx fl, fr, bl, br;
    public DriveSubsystem(HardwareMap h, String fln, String frn, String bln, String brn, boolean fld, boolean frd, boolean bld, boolean brd){
        fl = h.get(DcMotorEx.class, fln);
        fr = h.get(DcMotorEx.class, frn);
        bl = h.get(DcMotorEx.class, bln);
        br = h.get(DcMotorEx.class, brn);

        if(fld) this.fl.setDirection(DcMotorSimple.Direction.REVERSE);
        if(frd) this.fr.setDirection(DcMotorSimple.Direction.REVERSE);
        if(bld) this.bl.setDirection(DcMotorSimple.Direction.REVERSE);
        if(brd) this.br.setDirection(DcMotorSimple.Direction.REVERSE);

        this.fr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.fl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.br.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.bl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void set(double x, double y, double rx){
        fl.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        fr.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bl.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        br.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower = (y + x + rx) / denominator;
        double backLeftPower = (y - x + rx) / denominator;
        double frontRightPower = (y - x - rx) / denominator;
        double backRightPower = (y + x - rx) / denominator;

        fl.setPower(frontLeftPower);
        bl.setPower(backLeftPower);
        fr.setPower(frontRightPower);
        br.setPower(backRightPower);
    }

    public void setSpeed(double frontLeftMetersPerSecond, double frontRightMetersPerSecond, double backLeftMetersPerSecond, double backRightMetersPerSecond) {
        fl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        br.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        fl.setVelocity(2 * Math.PI * frontLeftMetersPerSecond * Constants.metersToInches / Constants.inchesPerWheelRotation, AngleUnit.RADIANS);
        fr.setVelocity(2 * Math.PI * frontRightMetersPerSecond * Constants.metersToInches / Constants.inchesPerWheelRotation, AngleUnit.RADIANS);
        bl.setVelocity(2 * Math.PI * backLeftMetersPerSecond * Constants.metersToInches / Constants.inchesPerWheelRotation, AngleUnit.RADIANS);
        br.setVelocity(2 * Math.PI * backRightMetersPerSecond * Constants.metersToInches / Constants.inchesPerWheelRotation, AngleUnit.RADIANS);

    }
}