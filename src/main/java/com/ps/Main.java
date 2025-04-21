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

        while (programRunning) {
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Hello! Welcome to the library please choose one of the options below!");
            System.out.println("Hello! enter 1 to Show Available books");
            System.out.println("Please enter 2 to Show Checked Out Books");
            System.out.println("Please enter 3 to exit the Library");
            System.out.print("Please enter your choice: ");

            int input = scanner.nextInt();
            scanner.nextLine();


            switch (input) {
                case 1:
                    System.out.println("There are the available books!");
                    for (Book b : books) {
                        if (!b.isCheckedOut()) {
                            System.out.println("ID: " + b.getId() + ", ISBN: " + b.getIsbn() + ", Title: " + b.getTitle());
                        }
                    }

                    boolean stayBookMenu = true;

                    while (stayBookMenu) {
                        System.out.println("\nPlease enter the book id you would like to check out or enter 0 ");
                        System.out.println("to go back to the home screen");
                        System.out.print("Please enter id or 0: ");
                        int checkOutID = scanner.nextInt();
                        scanner.nextLine();

                        // mistake: doesn't check out from here, i can put this into if statement
                        if (checkOutID == 0) {
                            stayBookMenu = false;
                        }

                        if (checkOutID > 0 && checkOutID <= books.length) {
                            // if false
                            if (!books[checkOutID - 1].isCheckedOut()) { //20th book but at 19th index
                                System.out.print("Enter your name: ");
                                String name = scanner.nextLine();
                                books[checkOutID - 1].checkOut(name);
                                System.out.println("Book checked out!\n");
                            } else {
                                System.out.println("Book is already checked in!\n");
                            }
                        } else {
                            System.out.println("invalid book id\n");
                        }

                        System.out.println("Would you like to check  out another book? Enter as so: ");
                        System.out.println("1. Check out another book");
                        System.out.println("2. Return to the home screen\n");
                        System.out.print("Enter your choice: ");
                        int nextChoice = scanner.nextInt();


                        switch (nextChoice) {
                            case 1:
                                // Show ID prompt again, but not full list (for cleanness)
                                stayBookMenu = true;
                                break;
                            case 2:
                                System.out.println("Returning to the home screen \n");
                                stayBookMenu = false;
                                break;
                            default:
                                System.out.println("Invalid choice, returning to main menu\n");
                                stayBookMenu = false;
                                break;
                        }
                    }
                    break;

                case 2: //showing checked out books
                    System.out.println("Checked Out Books:");
                    for (Book b : books) {
                        if (b.isCheckedOut()) {
                            System.out.println("ID: " + b.getId() + ", ISBN: "
                                    + b.getIsbn() + ", Title: " + b.getTitle() + ", Checked Out To: " + b.getCheckedOutTo());
                        }
                    }
                    System.out.println("Please enter 'C' to check in a book ");
                    System.out.println("Please enter 'X' to go back to home screen");
                    System.out.print("Please enter your choice: ");


                    String inputCheckIn = scanner.nextLine().trim().toUpperCase();
                    switch (inputCheckIn) {
                        case "C":
                            boolean stayCheckIn = true;

                            while (stayCheckIn) {
                                System.out.print("Please enter book id: ");
                                int checkInID = scanner.nextInt();
                                scanner.nextLine();


                                if (checkInID == 0 && checkInID <= books.length) {
                                    System.out.println("Returning to the home screen \n");
                                    stayCheckIn = false;
                                    break;
                                }

                                if (checkInID > 0 && checkInID <= books.length) {
                                    Book checkInBook = books[checkInID - 1];
                                    if (checkInBook.isCheckedOut()) {
                                        checkInBook.checkIn();
                                        System.out.println("Book has been checked in!\n");
                                    } else {
                                        System.out.println("That book is already checked in\n");
                                    }
                                    System.out.print("Enter 'C' to check in another book or 'X' to return to main menu: ");

                                    String anotherInputCheck = scanner.next().toUpperCase();

                                    if (anotherInputCheck.equals("C")) {
                                        stayCheckIn = true;
                                    } else {
                                        stayCheckIn = false;
                                        System.out.println("Returning to main menu\n");
                                    }
                                }
                            }
                            break;
                        case "X":
                            System.out.println("Returning to main menu ");
                            break;
                        default:
                            System.out.println("invalid input going back to home screen");
                            break;
                    }
                    break;

                case 3:
                    programRunning = false;
                    System.out.println("Thank you for visiting the library please come again soon!");
                    break;
            }
        }
    }
}
