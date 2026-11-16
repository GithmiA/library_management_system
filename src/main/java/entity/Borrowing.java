package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "borrowing")
public class Borrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrowing_id")
    private Integer borrowingId;
    @Column(name = "member_id")
    private String memberId;
    @Column(name = "fullname")
    private String fullName;
    @Column(name = "book_id")
    private String bookId;
    @Column(name = "title")
    private String bookTitle;
    @Column(name = "issuedate")
    private String issueDate;
    @Column(name = "duedate")
    private String dueDate;
    @Column(name = "returndate")
    private String returnDate;
    @Column(name = "status")
    private String status;

    public Borrowing() {
    }

    public Borrowing(String memberId, String fullName, String bookId, String bookTitle, String issueDate, String dueDate, String returnDate, String status) {
        this.memberId = memberId;
        this.fullName = fullName;
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.status = status;
    }


    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
