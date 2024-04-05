package com.daniellucas.timetracker;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Map;

import com.daniellucas.timetracker.data.Category;
import com.daniellucas.timetracker.data.CurrentTasks;
import com.daniellucas.timetracker.data.Task;
import com.daniellucas.timetracker.util.ArgUtil;
import com.daniellucas.timetracker.util.Args;
import com.daniellucas.timetracker.util.FileUtil;

public class TimeTracker {
    public static void main(String[] args) throws URISyntaxException, IOException {
        Args arguments = ArgUtil.parseArgs(args);

        FileUtil fileUtil = new FileUtil();

        CurrentTasks currentTasks = CurrentTasks.fromCsvLines(fileUtil.getLines());

        switch (arguments.getCommand()) {
            case TASK_START -> {
                Task task = new Task(
                    arguments.getTaskName(), 
                    new Category(arguments.getCategoryName())
                );

                currentTasks.startTask(task);
            }
            case TASK_STOP -> currentTasks.completeTask(arguments.getTaskName());
            case REPORT_TASKS -> {
                Map<String, Duration> taskReport = currentTasks.getTaskReport();
                for (Map.Entry<String, Duration> entry: taskReport.entrySet()) {
                    System.out.print("Task: " + entry.getKey());
                    System.out.println("\tDuration in minutes: " + entry.getValue().toMinutes());
                }
            }
            case REPORT_CATEGORIES -> {
                Map<String, Duration> categoryReport = currentTasks.getCategoryReport();
                for (Map.Entry<String, Duration> entry: categoryReport.entrySet()) {
                    System.out.print("Category: " + entry.getKey());
                    System.out.println("\tDuration in minutes: " + entry.getValue().toMinutes());
                }
            }
        };

        fileUtil.saveToFile(currentTasks.toCsvLines());
    }
}