package com.example.hh.dao;

import com.example.hh.entity.Vacancy;
import com.example.hh.model.VacancyInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VacancyDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public VacancyDAO() {
    }

    public List<VacancyInfo> listVacancyInfo() {
        String sql = "Select new " + VacancyInfo.class.getName()
                + "(e.title,e.create_date)"
                + " from " + Vacancy.class.getName() + " e";
        Session session = this.sessionFactory.getCurrentSession();
        Query<VacancyInfo> query = session.createQuery(sql, VacancyInfo.class);
        return query.getResultList();
    }
}
