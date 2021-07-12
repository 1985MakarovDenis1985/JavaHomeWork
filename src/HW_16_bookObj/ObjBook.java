package HW_16_bookObj;

public class ObjBook {
    int isbn;
    String title;
    String author;
    String yearOfPublishing = "Unfortunately unknown";
    String language;
    boolean bestSeller;


    public ObjBook(int isbn, String title, String author, String yearOfPublishing, String language, boolean bestSeller) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
        this.language = language;
        this.bestSeller = bestSeller;
    }

    public ObjBook(int isbn, String title, String author, String language, boolean bestSeller) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.language = language;
        this.bestSeller = bestSeller;
    }
    public ObjBook(int isbn, String title, String author, String language) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.language = language;
    }


    public int getIsbn() {
        return isbn;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getYearOfPublishing() {
        return yearOfPublishing;
    }
    public String getLanguage() {
        return language;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
    public void setLanguage(String language) {
        this.language = language;
    }

    public void display(){
        System.out.println("Description: " + " ISBN: " + isbn + " | Title: " + title +
                " | Author: " + author + " | Year of publishing: " + yearOfPublishing + " | Language: " + language +
                " | Type: " + ((bestSeller) ? "Best Seller!!!" : "Just book"));
    }


    public static void main(String[] args) {
        ObjBook[] books = new ObjBook[3];

        books[0] = new ObjBook((int) 1392949929385L, "Lord of The Rings", "Dj.R.R. Tolkien", "1948", "English" ,true);
        books[1] = new ObjBook((int) 8492875489088L, "Silmarilion", "Dj.R.R. Tolkien", "English" );
        books[2] = new ObjBook((int) 7299384028475L, "Witcher", "Andrzej Sapkowski", "1986", "Polish", true);

        books[0].display();
        books[1].display();
        books[2].display();
    }
}
