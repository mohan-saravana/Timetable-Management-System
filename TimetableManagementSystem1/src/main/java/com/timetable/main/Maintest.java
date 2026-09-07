package com.timetable.main;

import java.util.Scanner;

import com.timetable.model.Userinterface;
import com.timetable.service.Userservice;
import com.timetable.serviceimpl.Userserviceimpl;

public class Maintest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        Userservice userService = new Userserviceimpl();

        Userinterface user = userService.login(username, password);

        if (user != null) {
            System.out.println("\nLogin successful!");
            System.out.println("Welcome " + user.getUsername());
            System.out.println("Role: " + user.getRole());
        } else {
            System.out.println("\nInvalid username and password");
        }

        sc.close();
    }
}