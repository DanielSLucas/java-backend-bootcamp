package com.daniellucas.timetracker.util;


import com.daniellucas.timetracker.Logger;
import com.daniellucas.timetracker.data.Category;

public class ArgUtil {
  public static Args parseArgs(String[] args) {
    if (!areValid(args)) {
      throw new RuntimeException("Invalid arguments");
    }

    Args argObj = new Args();

    Commands command = getCommand(args);

    argObj.setCommand(command);

    if (Commands.TASK_START.equals(command) || Commands.TASK_STOP.equals(command)){
      argObj.setTaskName(args[1]);
      argObj.setCategoryName(args.length == 3 ? args[2] : Category.NONE);
    }
    
    return argObj;
  }

  private static boolean areValid(String[] args) {
    if (args.length < 2) {
      Logger.log("Error! Not enough arguments!");
      return false;
    }
    return true;
  }

  private static Commands getCommand(String[] args) {
    String cmdString = args[0];
    return switch (cmdString) {
      case "start" -> Commands.TASK_START;
      case "stop" -> Commands.TASK_STOP;
      case "report" -> {
        if ("task".equals(args[1])) yield Commands.REPORT_TASKS;
        if ("category".equals(args[1])) yield Commands.REPORT_CATEGORIES;
        yield null;
      }
      default -> throw new RuntimeException("Invalid input arguments");
    };
  }
}
