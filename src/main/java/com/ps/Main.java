package com.ps;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {


        Book[] books = {
                new Book(1, "9780143127741", "To Kill a Mockingbird"),
                new Book(2, "9780743273565", "The Great Gatsby"),
                new Book(3, "9781501128035", "It Ends With Us"),
                new Book(4, "9780307277671", "The Kite Runner"),
                new Book(5, "9780439139601", "Harry Potter and the Goblet of Fire"),
                new Book(6, "9780061120084", "Brave New World"),
                new Book(7, "9780451524935", "1984"),
                new Book(8, "9780307588371", "Gone Girl"),
                new Book(9, "9780385545969", "The Midnight Library"),
                new Book(10, "9780374533557", "Sapiens"),
                new Book(11, "9780316769488", "The Catcher in the Rye"),
                new Book(12, "9780316015844", "Twilight"),
                new Book(13, "9780812981605", "Educated"),
                new Book(14, "9780143039433", "The Alchemist"),
                new Book(15, "9780525555374", "Where the Crawdads Sing"),
                new Book(16, "9780062316090", "The Subtle Art of Not Giving a Fluff"),
                new Book(17, "9780590353427", "Harry Potter and the Sorcerer's Stone"),
                new Book(18, "9780307346605", "The Book Thief"),
                new Book(19, "9780735211292", "Atomic Habits"),
                new Book(20, "9781982137274", "Verity")
        };


        boolean programRunning = true;

        while(programRunning) {
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Hello! Welcome to the library please choose one of the options below!");
            System.out.println("Hello! enter 1 to Show Available books");
            System.out.println("Please enter 2 to Show Checked Out Books");
            System.out.println("Please enter 3 to exit the Library");

            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    System.out.println("There are the available books!");
                    for (Book b : books) {
                        if (!b.isCheckedOut()) {
                            System.out.println("ID: " + b.getId() + ", ISBN: " + b.getIsbn() + ", Title0: " + b.getTitle());
                        }
                    }

                    boolean stayBookMenu = true;

                    while (stayBookMenu) {
                        System.out.println("Please enter the book id you would like to check out or enter 0 ");
                        System.out.println("to go back to the home screen");
                        int checkOutID = scanner.nextInt();

                        if (checkOutID == 0) {
                            stayBookMenu = false;

                        }

                        if (checkOutID > 0 && checkOutID <= books.length) {
                            if (!books[checkOutID - 1].isCheckedOut()) { //20th book but at 19th index
                                System.out.print("Enter your name: ");
                                String name = scanner.nextLine();
                                books[checkOutID - 1].checkOut(name);
                                System.out.println("Book checked out!");
                            } else {
                                System.out.println("Book is already checked out.");
                            }
                        } else {
                            System.out.println("invalid book id");
                        }
                    }
                    System.out.println("Would you like to check another book? Enter as so: ");
                    System.out.println("1. Check out another book");
                    System.out.println("2. Return to the home screen");
                    System.out.print("Enter your choice: ");
                    int nextChoice = scanner.nextInt();

                    switch (nextChoice) {
                        case 1:
                            // Show ID prompt again, but not full list
                            stayBookMenu = true;
                            break;
                        case 2:
                            System.out.println("Returning to the home screen ");
                            stayBookMenu = false;
                            break;
                        default:
                            System.out.println("Invalid choice, returning to main menu");
                            stayBookMenu = false;
                            break;
                    }
            }
                    break;

                case 2:
                    System.out.println("Please enter 'C' to check in a book ");
                    System.out.println("Please enter 'X' to go back to home screen");

                    break;
                case 3:
                    programRunning = false;
                    break;

            }
        }






        }



    }
}