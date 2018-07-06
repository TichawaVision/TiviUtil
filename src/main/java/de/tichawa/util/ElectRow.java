package de.tichawa.util;

import javafx.beans.property.*;

public class ElectRow extends CSVRow
{

  public ElectRow(String key, int artNo, String colorCode, String factor, int[] nl)
  {
    addProperty("FERIX-Schlüssel", new SimpleStringProperty(key), 20);
    addProperty("Artikelnr.", new ArtNoProperty(artNo), 6.5);
    addProperty("Farbcode", new SimpleStringProperty(colorCode), 6.5);
    addProperty("Faktor", new SimpleStringProperty(factor), 4.5);
    for(int i = 0; i < nl.length;)
    {
      i++;
      addProperty("NL" + (i * 260), new SimpleIntegerProperty(nl[i - 1]), 5.35);
    }
  }

  @Override
  public ElectRow getNewInstance(String line)
  {
    String[] data = line.split(SEPARATOR);
    try
    {
      int[] nls = new int[data.length - 4];
      for(int i = 4; i < data.length; i++)
      {
        nls[i - 4] = data[i].length() > 0 ? Integer.parseInt(data[i]) : 0;
      }
      return new ElectRow(data[0],
              Integer.parseInt(data[1]),
              data[2],
              data[3].length() > 0 ? data[3] : "1",
              nls);
    }
    catch(IndexOutOfBoundsException | NumberFormatException ex)
    {
      return null;
    }
  }

  public static ElectRow getSample(int nls)
  {
    return new ElectRow("", 0, "", "", new int[nls]);
  }
}
