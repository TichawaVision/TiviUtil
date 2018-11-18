package de.tichawa.util;

import java.util.*;
import java.util.stream.Collectors;
import javafx.beans.property.*;

public abstract class CSVRow
{

  public static final String SEPARATOR = "\t";
  private static boolean CHANGED = false;
  private final List<Property> properties;
  private final List<String> propNames;
  private final List<Double> propWidth;

  public CSVRow()
  {
    this.properties = new LinkedList<>();
    this.propNames = new LinkedList<>();
    this.propWidth = new LinkedList<>();
  }
  
  public List<Property> getProperties()
  {
    return properties;
  }
  
  public List<String> getPropNames()
  {
    return propNames;
  }
  
  public abstract CSVRow getNewInstance(String line);
  
  @SuppressWarnings("unchecked")
  protected final <T extends Property> T addProperty(String name, T property, double width)
  {
    propNames.add(name);
    propWidth.add(width);
    property.addListener((observable, oldVal, newVal) -> setChanged(true));
    properties.add(property);
    return property;
  }
  
  @SuppressWarnings("unchecked")
  public <T> Property<T> getProperty(String name)
  {
    if(propNames.indexOf(name) > -1)
    {
      return properties.get(propNames.indexOf(name));
    }
    return null;
  }
  
  public Double getPropWidth(String name)
  {
    if(propNames.indexOf(name) > -1)
    {
      return propWidth.get(propNames.indexOf(name));
    }
    return null;
  }

  public static void setChanged(boolean changed)
  {
    CHANGED = changed;
  }

  public static boolean hasChanged()
  {
    return CHANGED;
  }
  
  @Override
  public String toString()
  {
    return properties.stream()
            .map(Property::getValue)
            .map(Object::toString)
            .collect(Collectors.joining("\t"));
  }
}
