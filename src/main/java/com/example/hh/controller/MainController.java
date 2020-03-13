package com.example.hh.controller;

import com.example.hh.dao.ResumeDAO;
import com.example.hh.dao.UserDAO;
import com.example.hh.dao.VacancyDAO;
import com.example.hh.entity.User;
import com.example.hh.model.ResumeInfo;
import com.example.hh.model.VacancyInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private ResumeDAO resumeDAO;

    @Autowired
    private VacancyDAO vacancyDAO;

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "/api/resume", method = RequestMethod.GET)
    public String showResume(Model model) {
        List<ResumeInfo> list = resumeDAO.listResumeInfo();

        model.addAttribute("resumeInfo", list);

        return "/api/resume";
    }

    @RequestMapping(value = "/api/vacancy", method = RequestMethod.GET)
    public String showVacancy(Model model) {
        List<VacancyInfo> list = vacancyDAO.listVacancyInfo();

        model.addAttribute("resumeInfo", list);

        return "/api/vacancy";
    }

    @RequestMapping(value = "/api/user", method = RequestMethod.POST)
    public String createUser(@RequestBody Map<String, String> body) {
        User user = new User(body.get("name"), body.get("type"));
        userDAO.save(user);
        return "redirect:/";
    }
}
