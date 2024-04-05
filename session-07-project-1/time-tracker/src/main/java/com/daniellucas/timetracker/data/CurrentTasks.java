package com.daniellucas.timetracker.data;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.daniellucas.timetracker.Logger;

public class CurrentTasks {
  private Map<String, Task> currentTasks = new HashMap<>();

  public CurrentTasks() {
  }

  public CurrentTasks(Map<String, Task> currentTasks) {
    this.currentTasks = currentTasks;
  }

  public void startTask(Task task) {
    if (currentTasks.putIfAbsent(task.getName(), task) != null) {
      Logger.log("Task already exists, skipping");
    }
  }

  public void completeTask(String taskName) {
    Task existingTask = currentTasks.get(taskName);

    if(existingTask == null) {
      Logger.log("No tasks found");
    } else {
      existingTask.setEndTime(LocalDateTime.now());
      existingTask.setStatus(TaskStatus.COMPLETE);
    }
  }

  public Map<String, Duration> getTaskReport() {
    return this.currentTasks
      .values()
      .stream()
      .filter(task -> task.getEndTime() != null)
      .collect(Collectors.toMap(Task::getName, Task::getDuration));
  }

  public Map<String, Duration> getCategoryReport() {
    Map<String, Duration> categoryReport = new HashMap<>();

    this.currentTasks
      .values()
      .stream()
      .filter(task -> task.getEndTime() != null)
      .forEach(task -> {
        String category = task.getCategory().getName();
        Duration categoryTotalDuration = categoryReport.getOrDefault(category, Duration.ZERO);
        categoryReport.put(category, categoryTotalDuration.plus(task.getDuration()));
      });

    return categoryReport;
  }

  public Map<String, Task> getCurrentTasks() {
    return currentTasks;
  }

  public void setCurrentTasks(Map<String, Task> currentTasks) {
    this.currentTasks = currentTasks;
  }

  public static CurrentTasks fromCsvLines(Stream<String> lines) {
    Map<String, Task> taskMap = lines
      .map(line -> line.split(","))
      .filter(tokenArray -> tokenArray.length == 5)
      .map(tokenArray -> new Task(
        tokenArray[0],
        new Category(tokenArray[1]),
        tokenArray[2] == null || "null".equals(tokenArray[2]) || tokenArray[2].isBlank() ? null : LocalDateTime.parse(tokenArray[2]),
        tokenArray[3] == null || "null".equals(tokenArray[3]) || tokenArray[3].isBlank() ? null : LocalDateTime.parse(tokenArray[3]),
        TaskStatus.valueOf(tokenArray[4])
      ))
      .collect(Collectors.toMap(Task::getName, Function.identity()));

    return new CurrentTasks(taskMap);
  }

  public List<String> toCsvLines() {
    return this.currentTasks
      .values()
      .stream()
      .map(Task::getCsvFormat)
      .toList();
  }

  @Override
  public String toString() {
    return "CurrentTasks{" +
           "currentTasks=" + this.currentTasks + 
           '}';
  }
}
