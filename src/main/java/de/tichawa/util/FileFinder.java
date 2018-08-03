package de.tichawa.util;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.*;

public class FileFinder implements FileVisitor<Path>
{

  private final Path target;
  private Optional<Path> match;

  public FileFinder(Path target)
  {
    this.target = target;
    this.match = Optional.empty();
  }

  @Override
  public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException
  {
    return FileVisitResult.CONTINUE;
  }

  @Override
  public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException
  {
    if(Files.isReadable(dir))
    {
      return FileVisitResult.CONTINUE;
    }
    return FileVisitResult.SKIP_SUBTREE;
  }

  @Override
  public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
  {
    if(file.endsWith(target))
    {
      match = Optional.of(file);
      return FileVisitResult.TERMINATE;
    }
    return FileVisitResult.CONTINUE;
  }

  @Override
  public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException
  {
    return FileVisitResult.CONTINUE;
  }

  public Optional<Path> getMatch()
  {
    return match;
  }
}
