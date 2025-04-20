package com.ps;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String[] books = new String [20];
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Hello! Welcome to the libary please choose one of the options below!");
        System.out.println("Hello! Welcome to the libary please choose one of the options below!");
        System.out.println("Please enter 2 to Show Checked Out Books");
        System.out.println("Please enter 3 to exit the Libary");

        int input = scanner.nextInt();
        while (input != 3){
            switch(input){
                case 1:

                    break;
                case 2:
                    System.out.println("Please enter 'C' to check in a book ");
                    System.out.println("Please enter 'X' to go back to home screen");




                    break;
                case 3:


                    break;











            }






        }



    }
}