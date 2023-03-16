package lab3.Recievers_Handlers;
import lab3.LogWriter;
public class ConOuputReciever implements IEv {

        public LogWriter logWriter;
        public ConOuputReciever(LogWriter lw){
            logWriter = lw;
        }
        public void Handler() {
            var response = "Console output called";
            System.out.printf("Event '%s' has occurred!\n", response);
            logWriter.LogString("Event 'Console_output called' has occurred!");
        }


}
