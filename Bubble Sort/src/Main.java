/**
 * Created by Hassan Shahbazi on 05/04/2017.
 */

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Arrays;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    int[] items = {10, 5, 3, 8, 15, 21, 18, 7};

    @Override
    public void start(Stage primaryStage) {
        BubbleSort(items);
        System.out.print(Arrays.toString(items));
    }

    private void BubbleSort(int[] items) {
        for (int i=0; i<items.length; i++) {
            for (int j=items.length-1; j>i; j--) {
                if (items[j] < items[j-1]) {
                    int temp = items[j-1];
                    items[j-1] = items[j];
                    items[j] = temp;
                }
            }
        }
    }
}
