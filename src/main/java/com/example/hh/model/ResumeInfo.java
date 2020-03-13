package com.example.hh.model;

import com.example.hh.entity.User;

import java.time.LocalDate;

public class ResumeInfo {

    private String title;
    private User user;
    private LocalDate createDate;

    public ResumeInfo(String title, LocalDate createDate) {
        this.title = title;
        this.createDate = createDate;
    }

    public ResumeInfo() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
}
