package org.example;

public class Main {
    public static void main(String[] args) {
        int[][] adjacencyArray = {
                {0, 1, 1, 0, 0, 0, 0},
                {1, 0, 1, 1, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 1, 0}
        };


        double alpha = 0.85;
        PageRank pageRank = new PageRank(arrayToMatrix(adjacencyArray), alpha);

        double[] pageRankVector = pageRank.calculatePageRank();

        System.out.println("PageRank:");
        for (int i = 0; i < pageRankVector.length; i++) {
            System.out.printf("Page %d: %.4f\n", i+1, pageRankVector[i]);
        }

    }

    private static Matrix arrayToMatrix(int[][] array) {
        int size = array.length;
        Matrix matrix = new Matrix(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix.set(i, j, array[i][j]);
            }
        }
        return matrix;
    }
}