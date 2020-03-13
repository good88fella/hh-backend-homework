package com.example.hh.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="vacancy")
public class Vacancy {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "vacancy_id", nullable = false)
    private int id;

    @Column(name = "title", length = 150, nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @Column(name = "salary")
    private int salary;

    @Column(name = "description", length = 1000, nullable = false)
    private String description;

    @Column(name = "contacts", length = 200, nullable = false)
    private String contacts;

    @Column(name="create_date")
    private LocalDate createDate;

    @Column(name="update_date")
    private LocalDate updateDate;

    public Vacancy() {
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
