package com.timetable.service;

import com.timetable.model.Userinterface;

public interface Userservice {

    Userinterface login(String username, String password);
}