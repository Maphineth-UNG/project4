package com.example.project4;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;
    private static final String FILE_NAME = "tasks.json";

    public TaskManager() {
        tasks = loadTasksFromFile();
    }

    public void addTask(String description) {
        int id = tasks.size() > 0 ? tasks.get(tasks.size() - 1).getId() + 1 : 1;
        Task task = new Task(id, description);
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("To-Do List:");
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    public void removeTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
        System.out.println("Task with ID " + id + " removed.");
    }

    public void saveTasksToFile() {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            Gson gson = new Gson();
            gson.toJson(tasks, writer);
        } catch (IOException e) {
            System.err.println("Error saving tasks: " + e.getMessage());
        }
    }

    private List<Task> loadTasksFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (FileReader reader = new FileReader(file)) {
            Gson gson = new Gson();
            Type taskListType = new TypeToken<List<Task>>() {}.getType();
            return gson.fromJson(reader, taskListType);
        } catch (IOException e) {
            System.err.println("Error loading tasks: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
