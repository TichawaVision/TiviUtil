package de.tichawa.util;

import javafx.event.*;
import javafx.scene.control.*;

public class CustomCheckMenuItem extends CustomMenuItem
{
  private final Object label;
  private final CheckBox content;

  public CustomCheckMenuItem(Object label)
  {
    this.label = label;
    this.content = new CheckBox();
    this.setContent(content);
    this.setHideOnClick(false);
    this.textProperty().bindBidirectional(content.textProperty());
    this.setText(label.toString());
  }

  public void setSelected(boolean selected)
  {
    content.setSelected(selected);
  }

  public boolean isSelected()
  {
    return content.isSelected();
  }
  
  public void passOnAction(EventHandler<ActionEvent> handler)
  {
    content.setOnAction(handler);
  }
}
