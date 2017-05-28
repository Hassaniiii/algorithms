/**
 * Created by hassaniiii on 5/28/2017 AD.
 */

import javafx.application.Application;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        int[] items = {5, 2, 4, 6, 1, 3};
        items = InsertionSort(items);
        System.out.print(Arrays.toString(items));
    }

    private int[] InsertionSort(int[] items) {
        for (int i=1; i<items.length; i++) {
            int key = items[i];
            int j = i-1;
            while (j>=0 && items[j]>key) {
                items[j+1] = items[j];
                j -= 1;
            }
            items[j+1] = key;
        }
        return items;
    }
}
