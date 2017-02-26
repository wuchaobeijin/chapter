package ch01;

/**
 * @author: wuchao
 * @date： 2017/2/21
 */
public class Calculator implements Runnable {

    private int number;

    public Calculator(int number) {
        this.number = number;
    }

    public void run() {
        for (int i = 1; i<=10; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + number + "*" + i + " = " + number * i);
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i<10; i++) {
            Calculator calculator  = new Calculator(i);
            Thread thread = new Thread(calculator);
            thread.start();
        }
    }
}
