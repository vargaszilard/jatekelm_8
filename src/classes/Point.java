package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Point {

    private double[][] arr;
    private int N;
    private int M;

    public Point() {
        try {
            File fl = new File("array.txt");
            Scanner sc = new Scanner(fl);

            N = sc.nextInt();
            M = sc.nextInt();
            arr = new double[N][M];

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    arr[i][j] = sc.nextDouble();
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        }
    }

    public boolean existPoint() {
        double rowMin, columnMax;
        int rowIndex, colIndex;
        double[] arrRowMin = new double[N];
        double[] arrColMax = new double[M];

        for(int i = 0; i < N; i++) {
            arrRowMin[i] = rowMinimum(arr, i);
        }

        for(int i = 0; i < M; i++) {
            arrColMax[i] = colMaximum(arr, i);
        }

        rowMin = arrRowMin[0];
        rowIndex = 0;
        for (int i = 1; i < N; i++) {
            if(arrRowMin[i] < rowMin) {
                rowMin = arrRowMin[i];
                rowIndex = i;
            }
        }

        columnMax = arrColMax[0];
        colIndex = 0;
        for (int i = 1; i < N; i++) {
            if(arrColMax[i] < columnMax) {
                columnMax = arrColMax[i];
                colIndex = i;
            }
        }

        return arr[rowIndex][colIndex] == rowMin && rowMin == columnMax;
    }

    private double rowMinimum(double[][] arr, int row) {
        double min = arr[row][0];

        for(int i = 1; i < M; i++) {
            if(arr[row][i] < min) {
                min = arr[row][i];
            }
        }

        return min;
    }

    private double colMaximum(double[][] arr, int col) {
        double max = arr[0][col];

        for(int i = 1; i < N; i++) {
            if(arr[i][col] > max) {
                max = arr[i][col];
            }
        }

        return max;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Point pt = new Point();

        System.out.println(pt.existPoint());
    }
}
