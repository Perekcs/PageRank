package org.example;

public class Matrix {
    private double[][] data;
    private int size;


    public Matrix(int size) {
        this.size = size;
        this.data = new double[size][size];
    }

    public int getSize() {
        return size;
    }

    public double get(int i, int j) {
        return data[i][j];
    }

    public void set(int i, int j, double value) {
        data[i][j] = value;
    }

    public double[] multiply(double[] vector) {
        if (vector.length != size) {
            throw new IllegalArgumentException("The number of columns in the matrix must be equal to the length of the vector.");
        }

        double[] result = new double[size];
        for (int i = 0; i < size; i++) {
            double sum = 0.0;
            for (int j = 0; j < size; j++) {
                sum += data[j][i] * vector[j];
            }
            result[i] = sum;
        }
        return result;
    }

    public double distance(double[] v1, double[] v2) {
        double sum = 0.0;
        for (int i = 0; i < size; i++) {
            sum += Math.pow(v1[i] - v2[i], 2);
        }
        return Math.sqrt(sum);
    }
}
