package lab2.lab2work;

public interface IFunctions {

    void count(String[] args);
    void checkNumber(int number) throws NumberLessConst, NumberGreaterConst;
    void checkSize(String[] args) throws ArrayIsTooSmall;
}
