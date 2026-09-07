package com.timetable.serviceimpl;

import com.timetable.dao.Userdao;
import com.timetable.daoimpl.Iserdaoimplement;
import com.timetable.model.Userinterface;
import com.timetable.service.Userservice;

public class Userserviceimpl implements Userservice {

    private Userdao userDAO = new Iserdaoimplement();

    @Override
    public Userinterface login(String username, String password) {

        return userDAO.login(username, password);
    }
}
