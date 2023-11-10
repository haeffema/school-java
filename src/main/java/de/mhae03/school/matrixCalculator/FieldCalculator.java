package de.mhae03.school.matrixCalculator;

import java.util.Arrays;

public class FieldCalculator extends Thread {

    private final int rowStart;
    private final int rowEnd;
    private final int columnStart;
    private final int columnEnd;
    private final double[][] firstMatrix;
    private final double[][] secondMatrix;
    private final double[][] result;

    public FieldCalculator(int rowStart, int rowEnd, int columnStart, int columnEnd, double[][] firstMatrix, double[][] secondMatrix, double[][] result) {
        this.rowStart = rowStart;
        this.rowEnd = rowEnd;
        this.columnStart = columnStart;
        this.columnEnd = columnEnd;
        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;
        this.result = result;
    }

    public void run() {
        for (int k = rowStart; k < rowEnd; k++) {
            for (int j = columnStart; j < columnEnd; j++) {
                for (int i = 0; i < result.length; i++) {
                    synchronized (result) {
                        result[k][j] += firstMatrix[k][i] * secondMatrix[i][j];
                    }
                }
            }
        }
    }

}
