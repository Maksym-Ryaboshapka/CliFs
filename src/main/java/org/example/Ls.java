package org.example;

import java.io.File;

import picocli.CommandLine.*;

@Command(name = "ls", description = "List directory content")
public class Ls implements Runnable {
  @Parameters(index = "0", paramLabel = "DIR", description = "Directory to list")
  String dirPath;

  @Override
  public void run() {
    File dir = new File(dirPath);

    if (!dir.exists()) {
      System.out.printf("Error: %s does not exists%n", dir.getPath());
      return;
    }

    if (!dir.isDirectory()) {
      System.out.printf("Error: %s is not a directory%n", dir.getPath());
      return;
    }

    if (dir.exists() && dir.isDirectory()) {
      File[] files = dir.listFiles();
      if (files != null) {
        for (File file : files) {
          System.out.println(file.getName());
        }
      }
    }
  }
}
