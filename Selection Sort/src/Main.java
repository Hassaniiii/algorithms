/**
 * Created by Hassan Shahbazi on 03/04/2017.
 */

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        int[] items = {10, 20, 5, 15, 60, 32, 80};
        items = this.SelectionSort(items);

        for (int i=0; i<items.length; i++)
            System.out.print(items[i] + ", ");
    }

    //exercise 2.2-1
    public int[] SelectionSort(int[] items) {
        for (int i=0; i<items.length; i++) {
            int minIndex = i;
            for (int j=i; j<items.length; j++) {
                if (items[j] < items[minIndex])
                    minIndex = j;
            }
            int temp = items[i];
            items[i] = items[minIndex];
            items[minIndex] = temp;
        }
        return items;
    }
}
