package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @Column(name = "book_id")
    private String bookId;
    @Column(name = "title")
    private String bookTitle;
    @Column(name = "author")
    private String bookAuthor;
    @Column(name = "category")
    private String bookCategory;
    @Column(name = "publish_year")
    private Integer bookPublishYear;
    @Column(name = "quantity")
    private Integer bookQuantity;

    public Book() {

    }

    public Book(String bookId, String bookTitle, String bookAuthor, String bookCategory, Integer bookPublishYear, Integer bookQuantity) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookCategory = bookCategory;
        this.bookPublishYear = bookPublishYear;
        this.bookQuantity = bookQuantity;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public Integer getBookPublishYear() {
        return bookPublishYear;
    }

    public void setBookPublishYear(Integer bookPublishYear) {
        this.bookPublishYear = bookPublishYear;
    }

    public Integer getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(Integer bookQuantity) {
        this.bookQuantity = bookQuantity;
    }
}
