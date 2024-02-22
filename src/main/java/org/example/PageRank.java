package org.example;

public class PageRank {
    private Matrix adjacencyMatrix;
    private Matrix transitionMatrix;
    private double alpha;

    public PageRank(Matrix adjacencyMatrix, double alpha) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.alpha = alpha;
        computeTransitionMatrix();
    }

    private void computeTransitionMatrix() {
        int n = adjacencyMatrix.getSize();
        transitionMatrix = new Matrix(n);
        for (int i = 0; i < n; i++) {
            int outDegree = 0;
            for (int j = 0; j < n; j++) {
                if (adjacencyMatrix.get(i, j) == 1) {
                    outDegree++;
                }
            }
            if (outDegree == 0) {
                for (int j = 0; j < n; j++) {
                    transitionMatrix.set(i, j, 1.0 / n);
                }
            } else {
                for (int j = 0; j < n; j++) {
                    double rij = adjacencyMatrix.get(i, j) / outDegree;
                    double value = (1 - alpha) / n + (alpha * rij);
                    transitionMatrix.set(i, j, value);
                }
            }
        }
    }

    private double[] computeOwnVector() {
        int n = transitionMatrix.getSize();
        double[] vector = new double[n];
        double[] prevVector = new double[n];
        for (int i = 0; i < n; i++) {
            vector[i] = 1.0/n;
        }
        double epsilon = 1e-6;
        do {
            System.arraycopy(vector, 0, prevVector, 0, n);
            vector = transitionMatrix.multiply(prevVector);

        } while (transitionMatrix.distance(prevVector, vector) > epsilon);

        return vector;
    }



    public double[] calculatePageRank() {
        return computeOwnVector();
    }
}
