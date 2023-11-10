package de.mhae03.school.matrixCalculator;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        double[][] firstMatrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        double[][] secondMatrix = { { 1, 4 }, { 2, 5 }, { 3, 6 } };
        if (firstMatrix.length != secondMatrix.length || firstMatrix[0].length < secondMatrix[0].length) {
            return;
        }
        double[][] result = new double[firstMatrix.length][secondMatrix[0].length];
        FieldCalculator f1 = new FieldCalculator(0, 1, 0, 1, firstMatrix, secondMatrix, result);
        FieldCalculator f2 = new FieldCalculator(0, 1, 1, 2, firstMatrix, secondMatrix, result);
        FieldCalculator f3 = new FieldCalculator(1, 3, 0, 2, firstMatrix, secondMatrix, result);
        f1.start();
        f2.start();
        f3.start();
        f1.join();
        f2.join();
        f3.join();
        System.out.println(Arrays.deepToString(result));
    }

}
