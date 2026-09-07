package com.timetable.main;

import java.sql.Connection;

import com.timetable.util.Dbmatching;

public class Maintable{

    public static void main(String[] args) {

        try {
            Connection connection = Dbmatching.getConnection();

            if (connection != null) {
                System.out.println("Database connected successfully!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}