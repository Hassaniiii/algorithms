/**
 * Created by hassaniiii on 4/17/2017 AD.
 */

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Arrays;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        int[][] matrixA = {{1,2}, {2,1}};
        int[][] matrixB = {{5,6}, {6,5}};
        int[][] matrixResult = SquareMatrixMultiply(matrixA, matrixB);
        for (int i=0; i<matrixResult.length; i++) {
            System.out.print("\n");
            for (int j=0; j<matrixResult.length; j++)
                System.out.print(matrixResult[i][j] + "\t");
        }

    }

    private int[][] SquareMatrixMultiply(int[][] matrixA, int[][] matrixB) {
        int n = matrixA.length;
        int[][] matrixC = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                matrixC[i][j] = 0;
                for (int k=0; k<n; k++) {
                    matrixC[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return matrixC;
    }
}
