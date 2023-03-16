package lab3;

import lab3.Recievers_Handlers.ConOuputReciever;
import lab3.Recievers_Handlers.EqValueReciever;
import lab3.Recievers_Handlers.EditValueReciever;
import java.io.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static final Integer particularValue = 78;
    public static void main(String[] args) throws IOException {
        String path_to_log = null;
        var file_with_logfs_path = new FileReader("C:\\Study\\JAVA_6_semestr\\helloapp\\src\\lab3\\logs_path.txt");
        var scn = new Scanner(file_with_logfs_path);
        path_to_log = scn.nextLine();
        System.out.println("File with path: " + path_to_log);

        LogWriter log_writer = new LogWriter(path_to_log);

        Source srcConOutput = new Source(new ConOuputReciever(log_writer));
        Source srcEqValue = new Source(new EqValueReciever(log_writer));
        Source srcEdValue = new Source(new EditValueReciever(log_writer));


        Scanner scanner = new Scanner(System.in);
        String user_answer;

        System.out.println("""
                                
                Data input from:
                    0 - console
                    1 - file:
                Enter the choice:""");
        srcConOutput.genEv();
        user_answer = scanner.nextLine();
        while (!user_answer.equals("1") & !user_answer.equals("0")) {
            System.out.println("Wrong unput. ONLY 1 OR 0!\nTry again: ");
            user_answer = scanner.nextLine();
            srcConOutput.genEv();//генерим события по выводу в консоль
            System.out.println("Your input: " + user_answer);

        }
        Scanner scf = null;
        FileReader fr = null;
        switch (user_answer) {
            case ("0") -> {
                scf = new Scanner(System.in);

                System.out.println("Enter a number ('non-number' to complete the input)");
                srcConOutput.genEv();//генерим события по выводу в консоль

            }
            case ("1") -> {
                File file_input = new File("C:\\Study\\JAVA_6_semestr\\helloapp\\src\\lab3\\input_data.txt");
                try {
                    fr = new FileReader(file_input.getAbsoluteFile());
                    scf = new Scanner(fr);
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }

            default -> {
                System.out.println("Something bad happened");
                srcConOutput.genEv();
            }
        }
        ArrayList<Integer> int_data_array = new ArrayList<Integer>();
        while (scf.hasNextInt()) {
            int new_elem = scf.nextInt();
            if (new_elem == particularValue) {
                srcEqValue.genEv();
            }
            int_data_array.add(new_elem);
        }

        System.out.println("GIVEN ARRAY FROM FILE:");
        System.out.println(int_data_array);
        log_writer.LogString("GIVEN ARRAY FROM FILE:");
        log_writer.LogString(int_data_array.toString());

//        Count_Odd_Even_in_array c = new Count_Odd_Even_in_array(log_writer);
//        c.counter(int_data_array);
        int even = 0;
        int odd = 0;
        for (Integer x : int_data_array) {
            if (x % 2 == 0) {
                even =even + 1;//добавление в список чётного
                srcEdValue.genEv();

            } else {
                odd = odd + 1;//добавление в список нечётного
                srcEdValue.genEv();
            }
        }
        if (even > odd){
            System.out.println("Четных больше."+even + " > " + odd);
            log_writer.LogString("Четных больше."+even + " > " + odd);
        }
        else if (even < odd) {
            System.out.println("Нечетных больше. "+odd + " > " + even);
            log_writer.LogString("Нечетных больше. "+odd + " > " + even);
        }
        else {
            System.out.println("Поровну. "+even + "==" + odd);
            log_writer.LogString("Поровну. "+even + "==" + odd);
        }
        if (fr != null) {
            fr.close();
        }
        log_writer.CloseFile();
    }
}
