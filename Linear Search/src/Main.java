/**
 * Created by hassaniiii on 6/11/17.
 */

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        int[] items = {5, 2, 7, 6, 1, 9};
        System.out.println(LinearSearch(items, 1));
        System.out.println(LinearSearch(items, 10));
    }

    public boolean LinearSearch(int[] items, int target) {
        boolean itemFound = false;
        for (int i=0; i<items.length; i++)
            if (items[i] == target)
                itemFound = true;
        return itemFound;
    }
}
