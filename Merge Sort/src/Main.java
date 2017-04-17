/**
 * Created by Hassan Shahbazi on 03/04/2017.
 */

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    int[] items = {5, 2, 4, 7, 1, 3, 2, 6};

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        MergeSort(0, items.length-1);
        for (int i=0; i<items.length; i++)
            System.out.print(items[i] + ", ");
    }

    public void MergeSort(int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int middleIndex = (endIndex + startIndex) / 2;
            MergeSort(startIndex, middleIndex);
            MergeSort(middleIndex + 1, endIndex);
            Merge(startIndex, middleIndex, endIndex);
        }
    }
    public void Merge(int startIndex, int middleIndex, int endIndex) {
        int leftLen = middleIndex - startIndex + 1;
        int rightLen = endIndex - middleIndex;
        int[] leftArray = new int[leftLen+1];
        int[] rightArray = new int[rightLen+1];

        middleIndex += 1;
        for (int i=0; i<leftLen; i++)
            leftArray[i] = items[startIndex+i];
        leftArray[leftLen] = 100000;
        for (int i=0; i<rightLen; i++)
            rightArray[i] = items[middleIndex+i];
        rightArray[rightLen] = 100000;

        int leftIndex = 0, rightIndex = 0;
        for (int i=startIndex; i<=endIndex; i++) {
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                items[i] = leftArray[leftIndex];
                leftIndex++;
            }
            else {
                items[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }

    }

}
