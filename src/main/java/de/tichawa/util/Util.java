package de.tichawa.util;

import java.nio.file.*;

public abstract class Util
{

  public static Path getAppData()
  {
    String path;
    String OS = System.getProperty("os.name").toUpperCase();
    if(OS.contains("WIN"))
    {
      path = System.getenv("APPDATA");
    }
    else if(OS.contains("MAC"))
    {
      path = System.getProperty("user.home") + "/Library/";
    }
    else if(OS.contains("NUX"))
    {
      path = System.getProperty("user.home");
    }
    else
    {
      path = System.getProperty("user.dir");
    }

    return Paths.get(path);
  }
}
