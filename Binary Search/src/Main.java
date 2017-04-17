/**
 * Created by Hassan Shahbazi on 05/04/2017.
 */

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    int[] items = {3, 41, 52, 26, 38, 57, 9, 49};
    boolean itemFound = false;

    @Override
    public void start(Stage primaryStage) {
        items = sortArray(items);
        binarySearch(0, items.length-1, 12);
        if (itemFound)
            System.out.print("Item Found");
        else
            System.out.print("Not Found");
    }

    private int[] sortArray(int[] items) {
        MergeSort sort = new MergeSort();
        return sort.Sort(items);
    }
    private void binarySearch(int startIndex, int endIndex, int target) {
        if (startIndex <= endIndex) {
            int middleIndex = (endIndex + startIndex)/2;
            if (target == items[middleIndex])
                itemFound = true;
            else if (target < items[middleIndex])
                binarySearch(startIndex, middleIndex-1, target);
            else
                binarySearch(middleIndex+1, endIndex, target);
        }
    }
}
