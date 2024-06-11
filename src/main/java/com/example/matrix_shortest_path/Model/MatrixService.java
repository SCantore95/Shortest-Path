package com.example.matrix_shortest_path.Model;

import org.springframework.stereotype.Service;

@Service
public class MatrixService {

    public int[] findShortestPath(int[][] matrix) {
        int minDistance = Integer.MAX_VALUE;
        int minDistanceRow = -1;

        int startingRow = 4;

        for (int i = 0; i < matrix.length; i++) {
            if (i != startingRow) {
                int sum = sumRow(matrix, i);
                if (sum < minDistance) {
                    minDistance = sum;
                    minDistanceRow = i;
                }
            }
        }

        return new int[]{minDistanceRow, minDistance};
    }

    public int[] calculateRowSums(int[][] matrix) {
        int[] rowSums = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            rowSums[i] = sumRow(matrix, i);
        }
        return rowSums;
    }

    private int sumRow(int[][] matrix, int row) {
        int sum = 0;
        for (int j = 0; j < matrix[row].length; j++) {
            if (matrix[row][j] != 0) {
                sum += matrix[row][j];
            }
        }
        return sum;
    }

    public String generateGraph(int[][] matrix) {
        StringBuilder graph = new StringBuilder();
        char node = 'A';
        for (int[] matrix1 : matrix) {
            graph.append(node++).append(": ");
            for (int j = 0; j < matrix1.length; j++) {
                if (matrix1[j] != 0) {
                    graph.append((char)('A' + j)).append("(").append(matrix1[j]).append(") ");
                }
            }
            graph.append("\n");
        }
        return graph.toString();
    }
}

