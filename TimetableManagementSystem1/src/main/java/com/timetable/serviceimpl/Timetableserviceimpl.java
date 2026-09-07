package com.timetable.serviceimpl;

import java.util.List;

import com.timetable.dao.Timetabledao;
import com.timetable.daoimpl.Timetabledaoimpl;
import com.timetable.model.Timetable;
import com.timetable.service.Timetableservice;

public class Timetableserviceimpl implements Timetableservice {

    private Timetabledao timetableDAO;

    public Timetableserviceimpl() {
        timetableDAO = new Timetabledaoimpl();
    }


    @Override
    public boolean addTimetable(Timetable timetable) {
        return timetableDAO.insertTimetable(timetable);
    }


    @Override
    public boolean updateTimetable(Timetable timetable) {
        return timetableDAO.updateTimetable(timetable);
    }


    @Override
    public boolean deleteTimetable(int id) {
        return timetableDAO.deleteTimetable(id);
    }


    @Override
    public Timetable getTimetableById(int id) {
        return timetableDAO.getTimetableById(id);
    }


    @Override
    public List<Timetable> getAllTimetables() {
        return timetableDAO.getAllTimetables();
    }


    @Override
    public List<Timetable> searchTimetable(String day) {
        return timetableDAO.searchTimetable(day);
    }
}