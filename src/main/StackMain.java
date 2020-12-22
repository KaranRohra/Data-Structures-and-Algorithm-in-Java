package main;


import data_structures.array.Stack;
import data_structures.linked_list.Stack;

import java.util.Scanner;

public class StackMain {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        //data_structures.array.Stack this not needed you can directly import the package

        //Comment this line to use stack using linked list don't forget to comment import statement
        Stack<String> stack=new data_structures.array.Stack<>();

        //Comment this line to use stack using array don't forget to comment import statement
        Stack<String> stack=new data_structures.linked_list.Stack<>();

        String data;
        int option;
        do{
            System.out.println("1: Push");
            System.out.println("2: Pop");
            System.out.println("3: Peek");
            System.out.println("4: IsFull");
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
                    if(stack.push(data))
                        System.out.println(data+" is Pushed");
                    else
                        System.out.println("Push operation failed");
                    break;
                case 2:
                    data= stack.pop();
                    if(data!=null)
                        System.out.println(data+" is Popped");
                    else
                        System.out.println("Pop operation failed");
                    break;
                case 3:
                    data= stack.peek();
                    if(data!=null)
                        System.out.println(data+" is at Peek");
                    else
                        System.out.println("Peek operation failed");
                    break;
//                case 4:
//                    if(stack.isFull())// this function is only in stack using array
//                        System.out.println("Stack is Full");
//                    else
//                        System.out.println("Stack is not Full");
//                    break;
                case 5:
                    if(stack.isEmpty())
                        System.out.println("Stack is Empty");
                    else
                        System.out.println("Stack is not Empty");
                    break;
                case 6:
                    System.out.println("Size of stack is "+stack.size());
            }
            System.out.println();
        }while (option>=1 && option<=6);
    }
}
