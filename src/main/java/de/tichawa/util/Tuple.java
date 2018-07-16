package de.tichawa.util;

import java.util.*;
import java.util.stream.*;

public class Tuple<U, V>
{

  private U u;
  private V v;

  public Tuple(U u, V v)
  {
    this.u = u;
    this.v = v;
  }

  public U getU()
  {
    return u;
  }

  public Tuple<U, V> setU(U u)
  {
    this.u = u;
    return this;
  }

  public V getV()
  {
    return v;
  }

  public Tuple<U, V> setV(V v)
  {
    this.v = v;
    return this;
  }

  @Override
  public int hashCode()
  {
    int hash = 7;
    hash = 13 * hash + Objects.hashCode(this.u);
    hash = 13 * hash + Objects.hashCode(this.v);
    return hash;
  }

  @Override
  public boolean equals(Object obj)
  {
    if(this == obj)
    {
      return true;
    }
    if(obj == null)
    {
      return false;
    }
    if(getClass() != obj.getClass())
    {
      return false;
    }
    final Tuple<?, ?> other = (Tuple<?, ?>) obj;
    if(!Objects.equals(this.u, other.u))
    {
      return false;
    }
    return Objects.equals(this.v, other.v);
  }
}
