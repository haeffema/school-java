package de.mhae03.school.matrixCalculator;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        double[][] firstMatrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        double[][] secondMatrix = { { 1, 4 }, { 2, 5 }, { 3, 6 } };
        double[][] result = new double[firstMatrix.length][secondMatrix[0].length];
        FieldCalculator f1 = new FieldCalculator(0, 1, 0, 2, firstMatrix, secondMatrix, result);
        FieldCalculator f2 = new FieldCalculator(1, 2, 0, 2, firstMatrix, secondMatrix, result);
        FieldCalculator f3 = new FieldCalculator(2, 3, 0, 2, firstMatrix, secondMatrix, result);
        f1.start();
        f2.start();
        f3.start();
        f1.join();
        f2.join();
        f2.join();
        System.out.println(Arrays.deepToString(result));
    }

}
