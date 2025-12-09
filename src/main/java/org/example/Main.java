package org.example;

import picocli.CommandLine;
import picocli.CommandLine.*;

@Command(name = "clifs", subcommands = {Ls.class, Cat.class})
public class Main implements Runnable {
  @Override
  public void run() {
    System.out.println("Use a subcommand");
  }

  public static void main(String[] args) {
    new CommandLine(new Main()).execute(args);
  }
}
