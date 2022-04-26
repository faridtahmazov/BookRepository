package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Book implements Serializable {

    @Id
    private Integer id;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "page")
    private Integer page;

    @Column(name = "topic")
    private String topic;

    @Column(name = "author")
    private String author;

    @Temporal(TemporalType.DATE)
    private Date publisherDate;

    public Book(){}

    public Book(Integer id, String bookName, Integer page, String topic, String author, Date publisherDate){
        super();
        this.id = id;
        this.bookName = bookName;
        this.page = page;
        this.topic = topic;
        this.author = author;
        this.publisherDate = publisherDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublisherDate(){
        return publisherDate;
    }

    public void setPublisherDate(Date publisherDate){
        this.publisherDate = publisherDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", page=" + page +
                ", topic='" + topic + '\'' +
                ", author='" + author + '\'' +
                ", publisherDate=" + publisherDate +
                '}';
    }
}
