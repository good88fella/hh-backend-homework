package com.example.hh.dao;

import com.example.hh.entity.Resume;
import com.example.hh.model.ResumeInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResumeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public ResumeDAO() {
    }

    public List<ResumeInfo> listResumeInfo() {
        String sql = "Select new " + ResumeInfo.class.getName()
                + "(e.title,e.create_date)"
                + " from " + Resume.class.getName() + " e";
        Session session = this.sessionFactory.getCurrentSession();
        Query<ResumeInfo> query = session.createQuery(sql, ResumeInfo.class);
        return query.getResultList();
    }
}
