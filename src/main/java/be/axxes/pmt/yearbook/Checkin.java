package be.axxes.pmt.yearbook;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Checkin {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String user;
    @Column
    private String content;
    @Column
    private Integer year;
    @Column
    private Integer quarter;

    public Checkin() {
    }

    public Checkin(String user, String content, int quarter, int year) {
        this.user = user;
        this.content = content;
        this.quarter = quarter;
        this.year = year;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getQuarter() {
        return quarter;
    }

    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Checkin {" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", year='" + year + '\'' +
                ", content='" + content + '\'' +
                ", quarter=" + quarter +
                '}';
    }

}