package main;

import data_structures.linked_list.Queue;

import java.util.Scanner;

public class QueueMain {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        Queue<String> queue=new Queue<>();

        String data;
        int option;
        do{
            System.out.println("1: Add");
            System.out.println("2: Remove");
            System.out.println("3: Check Front");
            System.out.println("4: Check Rear");
            System.out.println("5: IsEmpty");
            System.out.println("6: Size");
            System.out.println("7: Quit");
            System.out.print("Enter your option: ");
            option=sc.nextInt();
            switch (option){
                case 1:
                    System.out.print("Enter data to Push:");
                    sc.nextLine();// to clear the input pipe line
                    data=sc.nextLine();
                     queue.add(data);
                    System.out.println(data+" is Pushed");
                    break;
                case 2:
                    data= queue.remove();
                    if(data!=null)
                        System.out.println(data+" is Popped");
                    else
                        System.out.println("Pop operation failed");
                    break;
                case 3:
                    data= queue.getFirst();
                    if(data!=null)
                        System.out.println(data+" is at Front");
                    else
                        System.out.println("Front operation failed");
                    break;
                case 4:
                    data= queue.getLast();
                    if(data!=null)
                        System.out.println(data+" is at Rear");
                    else
                        System.out.println("Rear operation failed");
                    break;
                case 5:
                    if(queue.isEmpty())
                        System.out.println("queue is Empty");
                    else
                        System.out.println("queue is not Empty");
                    break;
                case 6:
                    System.out.println("Size of queue is "+queue.size());
            }
            System.out.println();
        }while (option>=1 && option<=6);
    }
}
