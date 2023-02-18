package lab2.lab2work;


class MyClass implements IConstants,IFunctions{
    @Override
    public void count(String[] args) {
        int even = 0;
        int odd = 0;
        try{
            for (String x : args) {
                int num = Integer.parseInt(x);
                checkNumber(num);
                if ( num % 2 == 0) {
                    even =even + 1;//добавление в список чётного
                } else {
                    odd = odd + 1;//добавление в список нечётного
                }
            }
            if (even > odd) {
                System.out.println("Четных больше. " + even + " > " + odd);
            } else if (even < odd) {
                System.out.println("Нечетных больше. " + odd + " > " + even);
            } else {
                System.out.println("Поровну. " + even + "==" + odd);
            }

        }
        catch (NumberGreaterConst e) {
            System.out.println(e +"("+ max_number+")");
        }
        catch (NumberLessConst e) {
            System.out.println(e);
        }

    }
    @Override
    public void checkNumber(int number) throws NumberLessConst, NumberGreaterConst {
        if (number < min_number)    throw new NumberLessConst();
        else if (number > max_number)  throw new NumberGreaterConst();
    }

    @Override
    public void checkSize(String[] args) throws ArrayIsTooSmall {
        if (args.length < min_array_length)    throw new ArrayIsTooSmall();
    }
}

public class MainClass {
    static MyClass working = new MyClass();
    public static void main(String[] args) {
        String result;
        try {
            working.checkSize(args);
            working.count(args);
        }
        catch (ArrayIsTooSmall e){
            System.out.println(e);
        }
    }
}
