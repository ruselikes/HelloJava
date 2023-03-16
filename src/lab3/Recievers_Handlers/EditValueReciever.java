package lab3.Recievers_Handlers;
import lab3.LogWriter;
import java.io.IOException;
public class EditValueReciever implements IEv {
    public LogWriter logWriter;

    public EditValueReciever(LogWriter lw) {
        logWriter = lw;
    }

    public void Handler() {
        var response = "Editing value";
        System.out.printf("Event '%s' has occurred!\n", response);
        logWriter.LogString("Event 'Editing value' has occurred!");
    }
}