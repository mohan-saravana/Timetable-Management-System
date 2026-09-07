package com.timetable.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.timetable.dao.Userdao;
import com.timetable.model.Userinterface;
import com.timetable.util.Dbmatching;

public class Iserdaoimplement implements Userdao {

    @Override
    public Userinterface login(String username, String password) {

        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection connection = Dbmatching.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    Userinterface scan= new Userinterface();

                    scan.setId(rs.getInt("id"));
                    scan.setUsername(rs.getString("username"));
                    scan.setPassword(rs.getString("password"));
                    scan.setRole(rs.getString("role"));

                    return scan;

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
