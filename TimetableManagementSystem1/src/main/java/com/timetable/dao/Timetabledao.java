package com.timetable.dao;

import java.util.List;
import com.timetable.model.Timetable;

public interface Timetabledao {

    boolean insertTimetable(Timetable timetable);

    boolean updateTimetable(Timetable timetable);

    boolean deleteTimetable(int id);

    Timetable getTimetableById(int id);

    List<Timetable> getAllTimetables();

    List<Timetable> searchTimetable(String day);
}