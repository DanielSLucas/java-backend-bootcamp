package com.daniellucas.timetracker.data;

import java.time.Duration;
import java.time.LocalDateTime;

public class Task {
  private String name;
  private Category category;
  private LocalDateTime startTime;
  private LocalDateTime endTime;
  private TaskStatus status;

  public Task() {
  }

  public Task(String name, Category category) {
    this.name = name;
    this.category = category;
    this.startTime = LocalDateTime.now();
    this.status = TaskStatus.IN_PROGRESS;
  }

  public Task(String name, Category category, LocalDateTime startTime, LocalDateTime endTime, TaskStatus status) {
    this.name = name;
    this.category = category;
    this.startTime = startTime;
    this.endTime = endTime;
    this.status = status;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public LocalDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
  }

  public LocalDateTime getEndTime() {
    return endTime;
  }

  public void setEndTime(LocalDateTime endTime) {
    this.endTime = endTime;
  }

  public TaskStatus getStatus() {
    return status;
  }

  public void setStatus(TaskStatus status) {
    this.status = status;
  }

  public String getCsvFormat() {
    return this.name + ',' +
      this.category + ',' +
      this.startTime + ',' +
      this.endTime + ',' +
      this.status;
  }

  public Duration getDuration() {
    if (this.getEndTime() == null) {
      return null;
    }

    return Duration.between(this.getStartTime(), this.getEndTime());
  }

  @Override
  public String toString() {
    return "Task{" +
      "name='" + this.name + '\'' +
      ", category='" + this.category + '\'' +
      ", startTime=" + this.startTime +
      ", endTime=" + this.endTime +
      ", status=" + this.status +
      '}';
  }

}

