package de.tichawa.util;

import java.io.*;

public class AppendingObjectOutputStream extends ObjectOutputStream
{

  public AppendingObjectOutputStream(OutputStream out) throws IOException
  {
    super(out);
  }

  @Override
  protected void writeStreamHeader() throws IOException
  {
    // do not write a header, but reset
    reset();
  }

}
