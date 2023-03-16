package lab3;

import java.io.FileWriter;
import java.io.IOException;

public class LogWriter {

    FileWriter fw;
    public LogWriter(String path_to_logfile) throws IOException {
        fw = new FileWriter(path_to_logfile);
    }

    public void LogString(String string_for_logging)  {
        try {
            fw.write(string_for_logging+"\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void CloseFile() throws IOException {
        fw.close();
    }
}