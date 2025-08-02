package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.commands.DriveCommand;

public class Solo extends CommandOpMode {
    @Override
    public void initialize() {
        Robot.init(hardwareMap);
        GamepadEx gamepad = new GamepadEx(gamepad1);

        Robot.drive.setDefaultCommand(new DriveCommand(Robot.drive,gamepad));

        new GamepadButton(gamepad, GamepadKeys.Button.A).whenPressed(
                Robot.extendAndIntakeCommand
        );
        new GamepadButton(gamepad, GamepadKeys.Button.Y).whenPressed(
                Robot.highBasketPosCommand
        );
        new GamepadButton(gamepad, GamepadKeys.Button.X).whenPressed(
                Robot.transferCommand
        );
        new GamepadButton(gamepad, GamepadKeys.Button.B).whenPressed(
                Robot.basketScoreCommand
        );
        new GamepadButton(gamepad, GamepadKeys.Button.DPAD_DOWN).whenPressed(
                Robot.retractCommand
        );

    }
}
