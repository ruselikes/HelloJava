package lab3.Recievers_Handlers;
import lab3.LogWriter;
import java.io.IOException;

public class EqValueReciever implements IEv{
    public LogWriter logWriter;
    public EqValueReciever(LogWriter lw){
        logWriter = lw;
    }
    public void Handler(){
        var response = "Equality to the particular value";
        System.out.printf("Event '%s' has occurred!\n", response);
        logWriter.LogString("Event 'Equality to the particular value' has occurred!");
    }
}
