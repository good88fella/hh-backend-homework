package com.example.hh.model;

import com.example.hh.entity.Company;

import java.time.LocalDate;

public class VacancyInfo {

    private String title;
    private Company company;
    private LocalDate createDate;

    public VacancyInfo(String title, LocalDate createDate) {
        this.title = title;
        this.createDate = createDate;
    }

    public VacancyInfo() {
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

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
}
