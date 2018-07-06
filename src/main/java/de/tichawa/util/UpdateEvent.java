package de.tichawa.util;

import javafx.event.*;

public class UpdateEvent extends Event
{
  public static final EventType<UpdateEvent> ANY = new EventType<>(Event.ANY);
  public static final EventType<UpdateEvent> UPDATE = new EventType<>(UpdateEvent.ANY);
  
  public UpdateEvent(EventType<? extends UpdateEvent> eventType)
  {
    super(eventType);
  }
}
