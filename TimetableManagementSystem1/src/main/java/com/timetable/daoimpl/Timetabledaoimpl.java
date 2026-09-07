package com.timetable.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.timetable.dao.Timetabledao;
import com.timetable.model.Timetable;
import com.timetable.util.Dbmatching;

public class Timetabledaoimpl implements Timetabledao {

    // INSERT
    @Override
    public boolean insertTimetable(Timetable timetable) {

        String sql = "INSERT INTO timetable "
                + "(class_id, day, period, subject_id, teacher_id, room_id) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = Dbmatching.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, timetable.getClassId());
            ps.setString(2, timetable.getDay());
            ps.setInt(3, timetable.getPeriod());
            ps.setInt(4, timetable.getSubjectId());
            ps.setInt(5, timetable.getTeacherId());
            ps.setInt(6, timetable.getRoomId());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    // UPDATE
    @Override
    public boolean updateTimetable(Timetable timetable) {

        String sql = "UPDATE timetable SET "
                + "class_id=?, day=?, period=?, subject_id=?, "
                + "teacher_id=?, room_id=? "
                + "WHERE id=?";

        try (Connection con = Dbmatching.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, timetable.getClassId());
            ps.setString(2, timetable.getDay());
            ps.setInt(3, timetable.getPeriod());
            ps.setInt(4, timetable.getSubjectId());
            ps.setInt(5, timetable.getTeacherId());
            ps.setInt(6, timetable.getRoomId());
            ps.setInt(7, timetable.getId());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    // DELETE
    @Override
    public boolean deleteTimetable(int id) {

        String sql = "DELETE FROM timetable WHERE id=?";

        try (Connection con = Dbmatching.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    // SELECT BY ID
    @Override
    public Timetable getTimetableById(int id) {

        String sql = "SELECT * FROM timetable WHERE id=?";

        try (Connection con = Dbmatching.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Timetable(
                        rs.getInt("id"),
                        rs.getInt("class_id"),
                        rs.getString("day"),
                        rs.getInt("period"),
                        rs.getInt("subject_id"),
                        rs.getInt("teacher_id"),
                        rs.getInt("room_id")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    // SELECT ALL
    @Override
    public List<Timetable> getAllTimetables() {

        List<Timetable> list = new ArrayList<>();

        String sql = "SELECT * FROM timetable ORDER BY id";

        try (Connection con = Dbmatching.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Timetable timetable = new Timetable(
                        rs.getInt("id"),
                        rs.getInt("class_id"),
                        rs.getString("day"),
                        rs.getInt("period"),
                        rs.getInt("subject_id"),
                        rs.getInt("teacher_id"),
                        rs.getInt("room_id")
                );

                list.add(timetable);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


    // SEARCH BY DAY
    @Override
    public List<Timetable> searchTimetable(String day) {

        List<Timetable> list = new ArrayList<>();

        String sql = "SELECT * FROM timetable WHERE day=? ORDER BY period";

        try (Connection con = Dbmatching.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, day);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Timetable timetable = new Timetable(
                        rs.getInt("id"),
                        rs.getInt("class_id"),
                        rs.getString("day"),
                        rs.getInt("period"),
                        rs.getInt("subject_id"),
                        rs.getInt("teacher_id"),
                        rs.getInt("room_id")
                );

                list.add(timetable);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}