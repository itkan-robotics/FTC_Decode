
package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;

public class DriveCommand extends RunCommand {
    public DriveCommand(DriveSubsystem drive, GamepadEx gamepad){
        super(() -> drive.set(
                gamepad.getLeftX(),
                -gamepad.getLeftY(),
                gamepad.getRightX()
        ), drive);
    }
}
