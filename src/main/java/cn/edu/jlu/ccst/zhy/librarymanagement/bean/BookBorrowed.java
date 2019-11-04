package cn.edu.jlu.ccst.zhy.librarymanagement.bean;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.DurationFormatUtils;

import java.util.Date;

public class BookBorrowed {
    long userid;
    String username;
    long bookid;
    String isbn;
    String name;
    String author;
    String publisher;
    String cover_path;
    String describe;
    Date borrowtime;
    String state;

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getBookid() {
        return bookid;
    }

    public void setBookid(long bookid) {
        this.bookid = bookid;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCover_path() {
        return cover_path;
    }

    public void setCover_path(String cover_path) {
        this.cover_path = cover_path;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Date getBorrowtime() {
        return borrowtime;
    }

    public void setBorrowtime(Date borrowtime) {
        this.borrowtime = borrowtime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "BookBorrowed{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", bookid=" + bookid +
                ", isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", cover_path='" + cover_path + '\'' +
                ", describe='" + describe + '\'' +
                ", borrowtime=" + borrowtime +
                ", state='" + state + '\'' +
                '}';
    }

    public String getLeftTime(){
        Date now=new Date();
        int available=15;
        String left;
        try{
            left="还剩"
                    + DurationFormatUtils.formatPeriod(now.getTime(), DateUtils
                    .addDays(borrowtime, available).getTime(), "d'天'HH'小时'mm'分钟'ss'秒'");
        }catch (Exception e){
            left="超期"
                    + DurationFormatUtils.formatPeriod(DateUtils
                    .addDays(borrowtime, available).getTime(),now.getTime(), "d'天'HH'小时'mm'分钟'ss'秒'");
        }
        return left;
    }
    public boolean isOutOfTime(){
        Date now=new Date();
        int available=15;
        try{
            DurationFormatUtils.formatPeriod(now.getTime(), DateUtils
                    .addDays(borrowtime, available).getTime(),"d");
        }catch (Exception e){
            return false;
        }
        return true;
    }

}
