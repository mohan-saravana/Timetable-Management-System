package com.timetable.dao;

import com.timetable.model.Userinterface;

public interface Userdao {

    Userinterface login(String username, String password);
}