package de.tichawa.util;

import java.util.*;
import javafx.collections.*;

public class ObservableLinkedList<T> extends ModifiableObservableListBase<T>
{
  private final List<T> impl;

  public ObservableLinkedList()
  {
    this.impl = new LinkedList<>();
  }
  
  @Override
  public T get(int index)
  {
    return impl.get(index);
  }

  @Override
  public int size()
  {
    return impl.size();
  }

  @Override
  protected void doAdd(int index, T element)
  {
    impl.add(index, element);
  }

  @Override
  protected T doRemove(int index)
  {
    return impl.remove(index);
  }

  @Override
  protected T doSet(int index, T element)
  {
    return impl.set(index, element);
  }
}
