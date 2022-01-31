package junit;

public class Math {

    public int num1;
    public int num2;

    public Math() {
        num1 = 0;
        num2 = 0;
    }

    public Math(int x, int y) {
        num1 = x;
        num2 = y;
    }

    public void validateDividend(int num2) {
        if(this.num2 == 0)
            throw new RuntimeException("Dividend can't be 0");
    }

    public int add(int x, int y) {
        return x + y;
    }

    public int sub(int x, int y) {
        return x - y;
    }

    public int mult(int x, int y) {
        return x * y;
    }

    public int div(int x, int y) {
        validateDividend(y);
        return x / y;
    }

    public int square(int x) {
        return x * x;
    }
}
