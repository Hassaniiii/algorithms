/**
 * Created by hassaniiii on 4/16/2017 AD.
 */

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        int[] items = {0, 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        MaxResult RESULT = FindMaxSubArray(items);
        System.out.print("Result:\nLow:" + RESULT.left_index + "\nHigh:" + RESULT.right_index + "\nSUM:" + RESULT.sum);
    }

    private MaxResult FindMaxSubArray(int[] items) {
        MaxResult max = new MaxResult();
        max.left_index = 0;
        max.right_index = 1;
        max.sum = items[0] + items[1];

        int sum = 0;
        for (int i=0; i<items.length; i++) {
            sum += items[i];
            if (sum < 0) {
                max.left_index = i + 1;
                sum = 0;
            }
            if (sum > max.sum) {
                max.right_index = i;
                max.sum = sum;
            }
        }
        return max;
    }
}

class MaxResult {
    int left_index;
    int right_index;
    int sum;

    MaxResult() {
        left_index = -1;
        right_index = -1;
        sum = Integer.MIN_VALUE;
    }
}
