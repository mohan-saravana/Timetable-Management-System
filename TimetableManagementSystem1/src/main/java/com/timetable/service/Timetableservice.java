package com.timetable.service;

import java.util.List;
import com.timetable.model.Timetable;

public interface Timetableservice {

    boolean addTimetable(Timetable timetable);

    boolean updateTimetable(Timetable timetable);

    boolean deleteTimetable(int id);

    Timetable getTimetableById(int id);

    List<Timetable> getAllTimetables();

    List<Timetable> searchTimetable(String day);
}