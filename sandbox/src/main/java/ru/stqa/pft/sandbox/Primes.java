package ru.stqa.pft.sandbox;

public class Primes {
    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) { //  i = i + 1  == i += 1  == i++ интримент
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeFast(int n) {
        int m = (int) Math.sqrt(n);
        for (int i = 2; i < m; i++) {//  i = i + 1  == i += 1  == i++ интримент
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeWhile(int n) {
        int i = 2; // инициализация счетчика
        while (i < n && n % i != 0) { // проверка условия окончания
            i++; // действие, которое совершается с ней на каждой итерации цикла
        }
        return i==n;
    }

    public static boolean isPrime(long n) {
        for (long i = 2; i < n; i++) { //  i = i + 1  == i += 1  == i++ интримент
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}