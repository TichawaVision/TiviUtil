package de.tichawa.util;

import javafx.collections.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class HLessTableView<T> extends TableView<T>
{

  public HLessTableView(ObservableList<T> c)
  {
    super(c);
  }
  
  @Override
  public void resize(double width, double height)
  {
    super.resize(width, height);
    Pane header = (Pane) lookup("TableHeaderRow");
    header.setMinHeight(0);
    header.setPrefHeight(0);
    header.setMaxHeight(0);
    header.setVisible(false);
  }
}
