package com.timetable.main;

import java.util.List;
import java.util.Scanner;

import com.timetable.model.Timetable;
import com.timetable.model.Userinterface;
import com.timetable.service.Timetableservice;
import com.timetable.service.Userservice;
import com.timetable.serviceimpl.Timetableserviceimpl;
import com.timetable.serviceimpl.Userserviceimpl;

public class Maintabletest2{

    private static Scanner scanner = new Scanner(System.in);

    private static Userservice userService = new Userserviceimpl();

    private static Timetableservice timetableService =
            new Timetableserviceimpl();


    public static void main(String[] args) {

        while (true) {

            System.out.println();
            System.out.println("======================================");
            System.out.println("   TIMETABLE MANAGEMENT SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    login();
                    break;

                case 2:
                    System.out.println("Thank you!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }


    // STEP 21
    private static void login() {

        System.out.println();
        System.out.println("========== LOGIN ==========");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        Userinterface user = userService.login(username, password);

        if (user != null) {

            System.out.println();
            System.out.println("Login successful!");
            System.out.println("Welcome " + user.getUsername());

            adminMenu();

        } else {

            System.out.println("Invalid username or password!");
        }
    }


    // STEP 21 - ADMIN MENU
    private static void adminMenu() {

        while (true) {

            System.out.println();
            System.out.println("========== ADMIN MENU ==========");
            System.out.println("1. Add Timetable");
            System.out.println("2. View Timetable");
            System.out.println("3. Update Timetable");
            System.out.println("4. Delete Timetable");
            System.out.println("5. Search Timetable");
            System.out.println("6. Logout");

            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    addTimetable();
                    break;

                case 2:
                    viewTimetable();
                    break;

                case 3:
                    updateTimetable();
                    break;

                case 4:
                    deleteTimetable();
                    break;

                case 5:
                    searchTimetable();
                    break;

                case 6:
                    System.out.println("Logged out successfully!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }


    // STEP 22
    private static void addTimetable() {

        System.out.println();
        System.out.println("========== ADD TIMETABLE ==========");

        System.out.print("Enter Class ID: ");
        int classId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Day: ");
        String day = scanner.nextLine();

        System.out.print("Enter Period: ");
        int period = scanner.nextInt();

        System.out.print("Enter Subject ID: ");
        int subjectId = scanner.nextInt();

        System.out.print("Enter Teacher ID: ");
        int teacherId = scanner.nextInt();

        System.out.print("Enter Room ID: ");
        int roomId = scanner.nextInt();

        scanner.nextLine();

        Timetable timetable = new Timetable(
                classId,
                day,
                period,
                subjectId,
                teacherId,
                roomId
        );

        boolean result = timetableService.addTimetable(timetable);

        if (result) {
            System.out.println("Timetable added successfully!");
        } else {
            System.out.println("Failed to add timetable!");
        }
    }


    // STEP 23
    private static void viewTimetable() {

        System.out.println();
        System.out.println("========== ALL TIMETABLES ==========");

        List<Timetable> list =
                timetableService.getAllTimetables();

        if (list.isEmpty()) {

            System.out.println("No timetable records found.");

        } else {

            for (Timetable timetable : list) {
                System.out.println(timetable);
            }
        }
    }


    // STEP 24
    private static void updateTimetable() {

        System.out.println();
        System.out.println("========== UPDATE TIMETABLE ==========");

        System.out.print("Enter Timetable ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Timetable existing =
                timetableService.getTimetableById(id);

        if (existing == null) {

            System.out.println("Timetable not found!");
            return;
        }

        System.out.println("Current details:");
        System.out.println(existing);

        System.out.print("Enter new Class ID: ");
        int classId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter new Day: ");
        String day = scanner.nextLine();

        System.out.print("Enter new Period: ");
        int period = scanner.nextInt();

        System.out.print("Enter new Subject ID: ");
        int subjectId = scanner.nextInt();

        System.out.print("Enter new Teacher ID: ");
        int teacherId = scanner.nextInt();

        System.out.print("Enter new Room ID: ");
        int roomId = scanner.nextInt();

        scanner.nextLine();

        Timetable timetable = new Timetable(
                id,
                classId,
                day,
                period,
                subjectId,
                teacherId,
                roomId
        );

        boolean result =
                timetableService.updateTimetable(timetable);

        if (result) {
            System.out.println("Timetable updated successfully!");
        } else {
            System.out.println("Failed to update timetable!");
        }
    }


    // STEP 25
    private static void deleteTimetable() {

        System.out.println();
        System.out.println("========== DELETE TIMETABLE ==========");

        System.out.print("Enter Timetable ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Timetable timetable =
                timetableService.getTimetableById(id);

        if (timetable == null) {

            System.out.println("Timetable not found!");
            return;
        }

        System.out.println("Record to delete:");
        System.out.println(timetable);

        System.out.print("Are you sure? (yes/no): ");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("yes")) {

            boolean result =
                    timetableService.deleteTimetable(id);

            if (result) {
                System.out.println(
                        "Timetable deleted successfully!");
            } else {
                System.out.println(
                        "Failed to delete timetable!");
            }

        } else {

            System.out.println("Delete cancelled.");
        }
    }


    // STEP 26
    private static void searchTimetable() {

        System.out.println();
        System.out.println("========== SEARCH TIMETABLE ==========");

        System.out.print("Enter day: ");
        String day = scanner.nextLine();

        List<Timetable> list =
                timetableService.searchTimetable(day);

        if (list.isEmpty()) {

            System.out.println(
                    "No timetable found for " + day);

        } else {

            System.out.println(
                    "Timetable for " + day + ":");

            for (Timetable timetable : list) {
                System.out.println(timetable);
            }
        }
    }
}