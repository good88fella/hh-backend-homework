package com.example.hh.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="company")
public class Company {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "company_id", nullable = false)
    private int id;

    @Column(name = "name", length = 150, nullable = false)
    private String name;

    @Column(name="create_date")
    private LocalDate createDate;

    @Column(name="update_date")
    private LocalDate updateDate;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private Set<Vacancy> vacancies;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private Set<User> users;

    public Company() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<Vacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(Set<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
