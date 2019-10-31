package cn.edu.jlu.ccst.zhy.librarymanagement.bean;

import java.util.Date;

public class BorrowLog {
    int userid;
    long bookid;
    String type;
    int num;
    Date datetime;
    String state;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public long getBookid() {
        return bookid;
    }

    public void setBookid(long bookid) {
        this.bookid = bookid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "BorrowLog{" +
                "userid=" + userid +
                ", bookid=" + bookid +
                ", type='" + type + '\'' +
                ", num=" + num +
                ", datetime=" + datetime +
                '}';
    }
}
