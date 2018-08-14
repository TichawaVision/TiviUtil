/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tichawa.util;

import java.util.function.*;
import javafx.scene.control.*;

/**
 *
 * @author florian
 */
public class DynamicTableResizer
{

  public static Consumer<TableColumn<?, ?>> scaleTo(double newVal)
  {
    return column -> column.setPrefWidth((column.getMinWidth() / column.getTableView().getColumns().stream().mapToDouble(TableColumn::getMinWidth).sum()) * newVal);
  }
}
