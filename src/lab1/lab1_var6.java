package lab1;
import java.util.ArrayList;

public class lab1_var6 {


    public static void main(String[] args) {

        int even = 0;
        int odd = 0;
        for (String x : args) {
            if (Integer.parseInt(x) % 2 == 0) {
                even =even + 1;//добавление в список чётного
            } else {
                odd = odd + 1;//добавление в список нечётного
            }
        }
        if (even > odd){
            System.out.println("Четных больше."+even + " > " + odd);
        }
        else if (even < odd) {
            System.out.println("Нечетных больше. "+odd + " > " + even);
        }
        else {
            System.out.println("Поровну. "+even + "==" + odd);
        }


    }

}
