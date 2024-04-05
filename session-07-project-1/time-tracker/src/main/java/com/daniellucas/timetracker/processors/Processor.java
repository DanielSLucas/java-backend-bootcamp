package com.daniellucas.timetracker.processors;

import com.daniellucas.timetracker.data.Task;

public interface Processor {
  public void process(Task task);
}
