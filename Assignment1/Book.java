/*
Author : Joseph Babilu Karippai
Book.java ~ Assignment 01
*/

// author -string
// title - string
// date - int (year)
// read medium - ennum 
// genre - string
// rating - ennum
// No SCANNER


// Enum for BookMedium
enum BookMedium {
    PhysicalBook, EBook, AudioBook;
}
enum BookGenre {
    Fiction, NonFiction;
}
enum BookRating {
    Rating1, Rating2, Rating3, Rating4, Rating5;
}


class Book {
    // Private fields
    private String title;
    private String author;
    private int publishedDate;
    private int readDate;
    private BookMedium readMedium;
    private BookGenre genre;
    private BookRating rating;

    // Constructors
    public Book(String title, String author, BookGenre genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public Book(String title, String author, BookGenre genre, int publishedDate) {
        this(title, author, genre);
        this.publishedDate = publishedDate;
    }

    // constructors added  takes published date, read date, read medium, and rating
    public Book(String title, String author, BookGenre genre, int publishedDate, int readDate,
                BookMedium readMedium, BookRating rating) {
        this(title, author, genre, publishedDate);
        this.readDate = readDate;
        this.readMedium = readMedium;
        this.rating = rating;
    }

    // Getters
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getPublishedDate() {
        return publishedDate;
    }
    public int getReadDate() {
        return readDate;
    }
    public BookMedium getMedium() {
        return readMedium;
    }
    public BookGenre getGenre() {
        return genre;
    }
    public BookRating getRating() {
        return rating;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setPublishedDate(int publishedDate) {
        this.publishedDate = publishedDate;
    }
    public void setReadDate(int readDate) {
        this.readDate = readDate;
    }
    public void setMedium(BookMedium readMedium) {
        this.readMedium = readMedium;
    }
    public void setGenre(BookGenre genre) {
        this.genre = genre;
    }
    public void setRating(BookRating rating) {
        this.rating = rating;
    }

    
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(title).append(" by ").append(author);

        if (publishedDate != 0) {
            result.append(" (").append(publishedDate).append(")");
        }
        if (readDate != 0 && readMedium != null && rating != null) {
            result.append(" - read in ").append(readDate).append(", rated ").append(rating.toString().substring(6)).append("/5");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Book b1 = new Book("Children of Time", "Adrian Tchaikovsky", BookGenre.Fiction);
        System.out.println(b1);
        Book b2 = new Book("The Fifth Season", "N. K. Jemesin", BookGenre.Fiction, 2015);
        System.out.println(b2);
        Book b3 = new Book("Perdido Street Station", "China Mieville",
                BookGenre.Fiction, 2000, 2020, BookMedium.EBook, BookRating.Rating5);
        System.out.println(b3);

        // Accessing getters
        System.out.println(b1.getTitle());
        System.out.println(b1.getAuthor());
        System.out.println(b1.getGenre());
        System.out.println(b2.getPublishedDate());
        System.out.println(b3.getReadDate());
        System.out.println(b3.getMedium());
        System.out.println(b3.getRating());
    }
}
