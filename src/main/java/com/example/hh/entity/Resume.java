package com.example.hh.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="resume")
public class Resume {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="resume_id", nullable = false)
    private int id;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @Column(name = "experience", length = 1000, nullable = false)
    private String experience;

    @Column(name = "contacts", length = 200, nullable = false)
    private String contacts;

    @Column(name="create_date")
    private LocalDate createDate;

    @Column(name="update_date")
    private LocalDate updateDate;

    public Resume() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }
}
