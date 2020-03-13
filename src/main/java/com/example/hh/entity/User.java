package com.example.hh.entity;



import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="user_id", nullable = false)
    private int id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "user_type", length = 10, nullable = false)
    private String userType;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_date", nullable = false)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="update_date", nullable = false)
    private Date updateDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Resume> resumes;

    public User() {
    }

    public User(String name, String userType) {
        this.name = name;
        this.userType = userType;
    }

    public User(String name, String userType, Date createDate, Date updateDate) {
        this.name = name;
        this.userType = userType;
        this.createDate = createDate;
        this.updateDate = updateDate;
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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Set<Resume> getResumes() {
        return resumes;
    }

    public void setResumes(Set<Resume> resumes) {
        this.resumes = resumes;
    }
}

