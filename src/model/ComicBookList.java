package model;

import java.io.BufferedReader;
import java.lang.String;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ComicBookList {
    private List<ComicBook> comicBooks = new ArrayList<>();

    public ComicBookList() {
        comicBooks = new ArrayList<>();
    }
    public void readFromFile(String fileName){
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 5) {
                    try {
                        String title = parts[0];
                        String author = parts[1];
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Date releaseDate = sdf.parse(parts[2]);
                        int volume = Integer.parseInt(parts[3]);
                        int pages = Integer.parseInt(parts[4]);
                        comicBooks.add(new ComicBook(title, author, releaseDate, volume, pages));
                    } catch (Exception e) {
                        System.out.println("Error ");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addComicBook(ComicBook comic) {
        comicBooks.add(comic);
    }

    public List<ComicBook> getComicBooks() {
        return comicBooks;
    }

    public void sortByPages() {
        Collections.sort(comicBooks, Comparator.comparingInt(ComicBook::getPages));
    }


    public ComicBook searchByTitle(String title) {
        for (ComicBook comic : comicBooks) {
            if (comic.getTitle().equalsIgnoreCase(title)) {
                return comic;
            }
        }
        return null;
    }

    public ComicBook searchByAuthor(String author) {
        for (ComicBook comic : comicBooks) {
            if (comic.getAuthor().equalsIgnoreCase(author)) {
                return comic;
            }
        }
        return null;
    }

    public void deleteOldComics(int years) {
        Calendar currentCalendar = Calendar.getInstance();
        int currentYear = currentCalendar.get(Calendar.YEAR);
        comicBooks.removeIf(comic -> (currentYear - comic.getReleaseDate().getYear()) >= years);
    }

}






