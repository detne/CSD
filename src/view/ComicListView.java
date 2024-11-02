package view;

import model.ComicBook;
import model.ComicBookList;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ComicListView {
    private Scanner scanner;

    public ComicListView() {
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("1. Add a new comic book");
        System.out.println("2. Display all comic books");
        System.out.println("3. Display sorted comic books by number of pages");
        System.out.println("4. Search comic books");
        System.out.println("5. Delete old comic books");
        System.out.println("0. Exit");
    }

    public ComicBook getComicBookDetails() {
        try {
            System.out.print("Enter title: ");
            String title = scanner.nextLine();

            System.out.print("Enter author: ");
            String author = scanner.nextLine();

            System.out.print("Enter release date (dd/MM/yyyy): ");
            String dateStr = scanner.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date releaseDate = sdf.parse(dateStr);

            System.out.print("Enter volume: ");
            int volume = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter number of pages: ");
            int pages = Integer.parseInt(scanner.nextLine());

            return new ComicBook(title, author, releaseDate, volume, pages);
        } catch (Exception e) {
            System.out.println("Invalid input, please try again.");
            return null;
        }
    }

    public void displayComicBooks(ComicBookList comicBookList) {
        for (ComicBook comic : comicBookList.getComicBooks()) {
            System.out.println(comic);
        }
    }

    public String getSearchQuery(String type) {
        System.out.print("Enter " + type + ": ");
        return scanner.nextLine();
    }
}
