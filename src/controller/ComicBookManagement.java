

package controller;

import model.ComicBook;
import model.ComicBookList;
import view.ComicListView;

import java.util.Scanner;

public class ComicBookManagement {
    public static void main(String[] args) {
        ComicBookList comicBookList = new ComicBookList();
        ComicListView view = new ComicListView();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        comicBookList.readFromFile("comics_input.txt");

        while (running) {
            view.displayMenu();
            System.out.print("Choose an option: ");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    ComicBook newComic = view.getComicBookDetails();
                    if (newComic != null) {
                        comicBookList.addComicBook(newComic);
                        System.out.println("Comic added successfully.");
                    }
                    break;
                case 2:
                    view.displayComicBooks(comicBookList);
                    break;
                case 3:
                    comicBookList.sortByPages();
                    view.displayComicBooks(comicBookList);
                    break;
                case 4:
                    System.out.println(" 1. Title or 2. Author?");
                    int searchOption = Integer.parseInt(scanner.nextLine());
                    if (searchOption == 1) {
                        String title = view.getSearchQuery("title");
                        ComicBook foundByTitle = comicBookList.searchByTitle(title);
                        System.out.println(foundByTitle != null ? foundByTitle : "Comic not found.");
                    } else {
                        String author = view.getSearchQuery("author");
                        ComicBook foundByAuthor = comicBookList.searchByAuthor(author);
                        System.out.println(foundByAuthor != null ? foundByAuthor : "Comic not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter the number: ");
                    int years = Integer.parseInt(scanner.nextLine());
                    comicBookList.deleteOldComics(years);
                    System.out.println("Deleted comics older than " + years + " years.");
                    break;

                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}





