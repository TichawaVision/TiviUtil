package de.tichawa.util;

import java.util.stream.*;
import javafx.beans.property.*;

public class PriceRow extends CSVRow
{

  public PriceRow(int artNo, String key, double price, double time, double power, double weight, double photo)
  {
    addProperty("Artikelnr.", new ArtNoProperty(artNo), 7.5);
    addProperty("FERIX-Schlüssel", new SimpleStringProperty(key), 25);
    addProperty("Preis (EUR)", new SimpleDoubleProperty(price), 7.5);
    addProperty("Arbeitszeit (h)", new SimpleDoubleProperty(time), 7.5);
    addProperty("Strom (A)", new SimpleDoubleProperty(power), 7.5);
    addProperty("Gewicht (kg)", new SimpleDoubleProperty(weight), 7.5);
    addProperty("Photowert", new SimpleDoubleProperty(photo), 7.5);
  }

  @Override
  public PriceRow getNewInstance(String line)
  {
    String[] data = line.split(SEPARATOR);
    try
    {
      return new PriceRow(Integer.parseInt(data[0]),
            data[1],
            data[2].length() > 0 ? Double.parseDouble(data[2]) : Double.NaN,
            data[3].length() > 0 ? Double.parseDouble(data[3]) : Double.NaN,
            data.length > 4 ? Double.parseDouble(data[4]) : Double.NaN,
            data.length > 5 ? Double.parseDouble(data[5]) : Double.NaN,
            data.length > 6 ? Double.parseDouble(data[6]) : 0);
    }
    catch(IndexOutOfBoundsException | NumberFormatException ex)
    {
      return null;
    }
  }
  
  public static PriceRow getSample()
  {
    return new PriceRow(0, "", 0, 0, 0, 0, 0);
  }

  @Override
  public String toString()
  {
    return getProperties().stream().map(p -> p.getValue().toString()).collect(Collectors.joining(SEPARATOR));
  }
}
