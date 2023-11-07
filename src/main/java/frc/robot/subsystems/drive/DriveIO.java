package frc.robot.subsystems.drive;
import org.littletonrobotics.junction.AutoLog;

public interface DriveIO {
  @AutoLog
  public static class DriveIOInputs{
    public double appliedvoltsAvg = 0.0;
      
    public double rightPos = 0.0;
    public double leftPos = 0.0;

    // class DriveIOInputsAutoLogged extends DriveIOInputs implements LoggableInputs {
    //   public void toLog(LogTable table) {
    //     //table.put("Average Drive Temperature", tempAvg);
    //     table.put("Average Applied Drive Voltage", appliedvoltsAvg);
    //     table.put("Right Position", rightPos);
    //     table.put("Left Position", leftPos);
        
    //   }
    //   public void fromLog(LogTable table) {
    //     //tempAvg = table.getDouble("Average Drive Temperature", tempAvg);
    //     appliedvoltsAvg = table.getDouble("Average Applied Drive Voltage", appliedvoltsAvg);
    //     rightPos = table.getDouble("Right Position", rightPos);
    //     leftPos = table.getDouble("Left Position", leftPos);
        
    //   }
    // }
  }
  public default void updateInputs(DriveIOInputs inputs) {}

  public default void setTemp(double tempAvg){}

  public default void setVolts(double left, double right){}

  public default void setPos(double rightPos, double leftPos){}

  public void setVoltage(double d, double e);
}
