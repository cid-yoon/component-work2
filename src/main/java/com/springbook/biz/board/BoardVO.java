package com.springbook.biz.board;

import java.sql.Date;

public class BoardVO {
    private int seq;
    private String title;
    private String writer;
    private String content;
    private Date regDate;
    private int cnt;

    public int getCnt() {
        return cnt;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Date getRegDate() {
        return regDate;
    }

    public int getSeq() {
        return seq;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {

        return "BoardVO [seq=" + seq + ", title = " + title + ", writer = " + writer
                +", content = " + content + ", regDate= " + regDate
                +" + cnt =" + cnt +"]";
    }
}
