package algorithms;

public class MergeSort {
    public static void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int leftBound, int rightBound) {
        if (leftBound < rightBound) {
            int mid = (leftBound + rightBound) / 2;

            mergeSort(arr, leftBound, mid);
            mergeSort(arr, mid + 1, rightBound);

            merge(arr, leftBound, mid, rightBound);
        }
    }

    private static void merge(int[] arr, int leftBound, int mid, int rightBound) {
        int[] left = new int[mid - leftBound + 1];
        int[] right = new int[rightBound - mid];

        int leftArrLength = left.length;
        int rightArrLength = right.length;

        System.arraycopy(arr, leftBound, left, 0, leftArrLength);
        System.arraycopy(arr, mid + 1, right, 0, rightArrLength);

        int i = 0;
        int j = 0;
        int k = leftBound;

        while (i < leftArrLength && j < rightArrLength) {
            if (left[i] < right[j]) {
                arr[k++] = left[i];
                i++;
            } else if (left[i] > right[j]) {
                arr[k++] = right[j];
                j++;
            } else {
                arr[k++] = right[j];
                arr[k++] = left[i];
                i++;
                j++;
            }
        }

        while (i < leftArrLength) {
            arr[k++] = left[i++];
        }

        while (j < rightArrLength) {
            arr[k++] = right[j++];
        }
    }
}

