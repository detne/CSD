package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ComicBook {
    private String title;
    private String author;
    private Date releaseDate;
    private int volume;
    private int pages;

    public ComicBook(String title, String author, Date releaseDate, int volume, int pages) {
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.volume = volume;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return title + "|" + author + "|" + sdf.format(releaseDate) + "|" + volume + "|" + pages;
    }


}
