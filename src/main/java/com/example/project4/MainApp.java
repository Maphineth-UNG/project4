package com.example.project4;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to the To-Do List App");
        System.out.println("Available commands: add, list, remove, exit");

        while (true) {
            System.out.print("Enter command: ");
            command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "add":
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    taskManager.addTask(description);
                    break;
                case "list":
                    taskManager.listTasks();
                    break;
                case "remove":
                    System.out.print("Enter task ID to remove: ");
                    int taskId = Integer.parseInt(scanner.nextLine());
                    taskManager.removeTask(taskId);
                    break;
                case "exit":
                    taskManager.saveTasksToFile();
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Unknown command. Try again.");
            }
        }
    }
}
