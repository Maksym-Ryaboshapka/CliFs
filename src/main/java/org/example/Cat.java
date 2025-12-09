package org.example;

import picocli.CommandLine.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Command(name = "cat", description = "Prints file content")
public class Cat implements Runnable {
  @Parameters(index = "0", paramLabel = "FILE", description = "File to show")
  String filePath;

  public void run() {
    File file = new File(filePath);

    if (!file.exists()) {
      System.out.printf("Error: %s does not exists%n", file.getPath());
      return;
    }

    if (!file.isFile()) {
      System.out.printf("Error: %s is not a file%n", file.getPath());
      return;
    }

    try (FileInputStream fis = new FileInputStream(filePath)) {
      int byteRead;
      while ((byteRead = fis.read()) != -1) {
        System.out.print((char) byteRead);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
