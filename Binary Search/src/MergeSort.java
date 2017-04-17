/**
 * Created by Hassan Shahbazi on 05/04/2017.
 */
public class MergeSort {
    int[] items;

    public int[] Sort(int[] items) {
        this.items = items;
        MergeSort(0, this.items.length-1);
        return this.items;
    }

    private void MergeSort(int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int middleIndex = (endIndex + startIndex) / 2;
            MergeSort(startIndex, middleIndex);
            MergeSort(middleIndex + 1, endIndex);
            Merge(startIndex, middleIndex, endIndex);
        }
    }
    private void Merge(int startIndex, int middleIndex, int endIndex) {
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
