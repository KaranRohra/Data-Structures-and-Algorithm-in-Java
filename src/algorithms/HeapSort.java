package algorithms;

public class HeapSort{
    public static void sort(int[] arr){
        int length=arr.length;
        makeMaxHeap(arr, length-1);
        for(int i=length-1;i>=2;i--){
             int temp=arr[1];
             arr[1]=arr[i];
             arr[i]=temp;
             adjustTree(arr, 1,i-1);// regain max heap tree
        }
    }

    private static void makeMaxHeap(int[] arr, int length) {
        for(int i=length/2;i>=1;i--){
            adjustTree(arr,i,length);
        }
    }

    private static void adjustTree(int[] arr, int parentIndex, int numberOfElements) {
        int j=parentIndex*2;
        int item=arr[parentIndex];
        while (j<=numberOfElements){
            if(j<numberOfElements && arr[j]<arr[j+1])
                j++;
            if(item>arr[j])
                break;
            arr[j/2]=arr[j];
            j=j*2;
        }
        arr[j/2]=item;
    }
}






