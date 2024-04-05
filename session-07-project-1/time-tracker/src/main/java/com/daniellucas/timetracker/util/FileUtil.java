package com.daniellucas.timetracker.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class FileUtil {
  public static final String PATH = "task-info.csv";

  public Stream<String> getLines() throws URISyntaxException, IOException {
    Path path = Paths.get(PATH);
    
    if(Files.notExists(path)) {
      Files.createFile(path);
    }

    return  Files.lines(path);
  }

  public void saveToFile(List<String> lines) throws IOException {
    Path path = Paths.get(PATH);
    
    if(Files.notExists(path)) {
      Files.createFile(path);
    }    

    Files.write(path, lines);
  }
}
