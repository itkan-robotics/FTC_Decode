package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.geometry.Pose2d;
import com.arcrobotics.ftclib.geometry.Rotation2d;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.commands.DriveCommand;
import org.firstinspires.ftc.teamcode.commands.DriveToCommand;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.PinpointSubsystem;
@TeleOp
public class FollowerTester extends CommandOpMode {
    @Override
    public void initialize() {
        DriveSubsystem drive = new DriveSubsystem(hardwareMap, Constants.frontLeftName, Constants.frontRightName, Constants.backLeftName, Constants.backRightName, Constants.frontLeftMotorDirectionReversed, Constants.frontRightMotorDirectionReversed, Constants.backLeftMotorDirectionReversed, Constants.backRightMotorDirectionReversed);
        PinpointSubsystem pinpoint = new PinpointSubsystem(hardwareMap, Constants.pinpointName);
        GamepadEx gamepad = new GamepadEx(gamepad1);
        drive.setDefaultCommand(new DriveToCommand(drive, pinpoint, new Pose2d(0, 0, new Rotation2d(0)))
        );



    }
}
