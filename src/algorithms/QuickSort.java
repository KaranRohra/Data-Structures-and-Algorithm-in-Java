package algorithms;

public class QuickSort {
    public static void sort(int[] arr){
        quickSort(arr,0,arr.length-1);
    }
    private static void quickSort(int[] arr, int lowerBound, int upperBound) {
        if(lowerBound<=upperBound){
            int i=lowerBound,j=upperBound,mid=(lowerBound+upperBound)/2,pivot=arr[mid];
            while (i<j){
                while (i<=upperBound && arr[i]<pivot)
                    i++;
                while (j>=lowerBound && arr[j]>pivot)
                    j--;
                if (i<j){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
            int temp=arr[j];
            arr[j]=arr[mid];
            arr[mid]=temp;

            quickSort(arr,lowerBound,j-1);
            quickSort(arr,j+1,upperBound);
        }
    }
}