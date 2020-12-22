package main;

import algorithms.*;

import java.util.Scanner;

public class Sorting {
    public static void main(String[] args) {

        int option;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("1: Bubble Sort");
            System.out.println("2: Selection Sort");
            System.out.println("3: Insertion Sort");
            System.out.println("4: Quick Sort");
            System.out.println("5: Merge Sort");
            System.out.println("6: Heap Sort");
            System.out.println("7: Radix Sort");
            System.out.println("8: Quit");
            System.out.print("Enter your option:");
            option = sc.nextInt();
            int[] arr=new int[1000000];
            for(int i=1;i<arr.length;i++){
                arr[i]= arr.length-i;
            }
            long start = System.currentTimeMillis();
            switch (option) {
                case 1:
                    BubbleSort.sort(arr);
                    long end = System.currentTimeMillis();
                    System.out.println("Bubble sort takes " + (end - start) + " ms" + "  to sort 10 thousand element");
                    break;
                case 4:
                    QuickSort.sort(arr);
                    end = System.currentTimeMillis();
                    System.out.println("Quick sort takes " + (end - start) + " ms" + "  to sort 10 thousand element");
                    break;
                case 5:
                    MergeSort.sort(arr);
                    end = System.currentTimeMillis();
                    System.out.println("Merge sort takes " + (end - start) + " ms" + "  to sort 10 thousand element");
                    break;
                case 6:
                    HeapSort.sort(arr);
                    end = System.currentTimeMillis();
                    System.out.println("Heap sort takes " + (end - start) + " ms" + "  to sort 10 thousand element");
                    break;
            }
//            printSort(arr);
            System.out.println();
        }while (option>=1 && option<=7);
    }

    private static void printSort(int[] arr) {
        for(int i:arr)
            System.out.print(i+" ");
        System.out.println();
    }
}
