package by.it.chatovich.lesson01;

import java.math.BigInteger;

/**
 * Created by Yultos_ on 07.12.2016
 */
public class Fibo {

    private long startTime = System.currentTimeMillis();

    private long time() {
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {
        Fibo fibo = new Fibo();
        int n = 33;
        System.out.printf("calc(%d)=%d \n\t time=%d \n\n", n, fibo.calc(n), fibo.time());

        //вычисление чисел фибоначчи медленным методом (рекурсией)
        fibo = new Fibo();
        n = 33;
        System.out.printf("slowA(%d)=%d \n\t time=%d \n\n", n, fibo.slowA(n), fibo.time());

        //вычисление чисел простым быстрым методом
        fibo = new Fibo();
        n = 55555;
        System.out.printf("fastB(%d)=%d \n\t time=%d \n\n", n, fibo.fastB(n), fibo.time());

        //вычисление чисел фибоначчи самым быстрым методом
        fibo = new Fibo();
        n = 55555;
        System.out.printf("fasterC(%d)=%d \n\t time=%d \n\n", n, fibo.fasterC(n), fibo.time());
    }


    private int calc(int n) {

        if (n<=1){
            return n;
        } else {
            return calc(n-1)+calc(n-2);
        }

        //время O(2^n)
    }


    BigInteger slowA(Integer n) {

        if (n==0){
            return BigInteger.ZERO;
        } else if (n==1){
            return BigInteger.ONE;
        } else {
            return slowA(n-1).add(slowA(n-2));
        }
        //время O(2^n)

    }

    BigInteger fastB(Integer n) {
        //здесь нужно реализовать вариант с временем O(n) и памятью O(n)
        BigInteger [] arr = new BigInteger[n+1];
        arr[0] = BigInteger.ZERO;
        arr[1] = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i-1].add(arr[i-2]);
        }
        return arr[n];
    }

    BigInteger fasterC(Integer n) {

        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        BigInteger c = BigInteger.ZERO;

        for (int i = 0; i < n-1; i++) {
            c = a.add(b);
            a = b;
            b = c;
        }
        return c;
    }
}
