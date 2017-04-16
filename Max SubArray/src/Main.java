/**
 * Created by hassaniiii on 4/15/2017 AD.
 */

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    int result_left_low, result_right_high, result_corss_sum;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        int[] items = {0, 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        MaxItemResult RESULT = FindMaxSubarray(items, 0, items.length-1);
        System.out.print("Result:\nLow:" + RESULT.low + "\nHigh:" + RESULT.high + "\nSUM:" + RESULT.sum);
    }

    private MaxItemResult FindMaxSubarray(int[] items, int low, int high) {
        if (low == high) {
            MaxItemResult res = new MaxItemResult();
            res.low = low;
            res.high = high;
            res.sum = items[low];
            return res;
        }
        else {
            int mid = (low+high)/2;
            MaxItemResult left_res = FindMaxSubarray(items, low, mid);
            MaxItemResult right_res = FindMaxSubarray(items, mid+1, high);
            CrossItemsHolder cross_res = FindMaxCrossingSubArray(items, low, mid, high);

            if ((left_res.sum >= right_res.sum) && (left_res.sum >= cross_res.sum)) {
                MaxItemResult res = new MaxItemResult();
                res.low = left_res.low;
                res.high = left_res.high;
                res.sum = left_res.sum;
                return res;
            }
            else if ((right_res.sum >= left_res.sum) && (right_res.sum >= cross_res.sum)) {
                MaxItemResult res = new MaxItemResult();
                res.low = right_res.low;
                res.high = right_res.high;
                res.sum = right_res.sum;
                return res;
            }
            else {
                MaxItemResult res = new MaxItemResult();
                res.low = cross_res.max_left;
                res.high = cross_res.max_right;
                res.sum = cross_res.sum;
                return res;
            }
        }
    }

    private CrossItemsHolder FindMaxCrossingSubArray(int[] items, int low, int mid, int high) {
        CrossItemsHolder res = new CrossItemsHolder();
        int left_sum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i=mid; i>= low; i--) {
            sum += items[i];
            if (sum > left_sum) {
                left_sum = sum;
                res.max_left = i;
            }
        }

        int right_sum = Integer.MIN_VALUE;
        sum = 0;
        for (int j=mid+1; j<=high; j++) {
            sum += items[j];
            if (sum > right_sum) {
                right_sum = sum;
                res.max_right = j;
            }
        }
        res.sum = left_sum + right_sum;
        return res;
    }
}

class MaxItemResult {
    int low, high, sum;
}

class CrossItemsHolder {
    int max_left, max_right, sum;
}