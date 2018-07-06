package de.tichawa.util;

import java.util.*;
import javafx.beans.property.*;

public class MechaRow extends CSVRow
{

  private static final String[] LIGHT_SOURCES =
  {
    "0D0C", "1D0C", "2D0C", "2D1C", "0D1C"
  };

  public MechaRow(String name, String key, String code, int[] artNos, String[] amounts)
  {
    addProperty("Bezeichnung", new SimpleStringProperty(name), 12);
    addProperty("FERIX-Schlüssel", new SimpleStringProperty(key), 19);
    addProperty("Code", new SimpleStringProperty(code), 3);
    for(int i = 0; i < artNos.length;)
    {
      i++;
      addProperty("NL" + (i * 260), new ArtNoProperty(artNos[i - 1]), 4);
    }
    for(int i = 0; i < amounts.length; i++)
    {
      addProperty(LIGHT_SOURCES[i], new SimpleStringProperty(amounts[i]), 2.35);
    }
  }

  @Override
  public MechaRow getNewInstance(String line)
  {
    String[] data = line.split(SEPARATOR);
    try
    {
      int[] nls = new int[data.length - 3 - LIGHT_SOURCES.length];
      for(int i = 0; i < nls.length; i++)
      {
        nls[i] = data[i + 3].length() > 0 ? Integer.parseInt(data[i + 3]) : 0;
      }
      String[] amounts = new String[LIGHT_SOURCES.length];
      for(int i = nls.length + 3; i < data.length; i++)
      {
        amounts[i - nls.length - 3] = data[i];
      }
      return new MechaRow(data[0],
              data[1],
              data[2],
              nls,
              amounts);
    }
    catch(IndexOutOfBoundsException | NumberFormatException ex)
    {
      return null;
    }
  }

  public static MechaRow getSample(int nls, int lights)
  {
    String[] lightArray = new String[lights];
    Arrays.fill(lightArray, "");
    return new MechaRow("", "", "", new int[nls], lightArray);
  }
}
