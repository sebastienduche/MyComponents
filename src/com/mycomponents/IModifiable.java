package com.mycomponents;

public interface IModifiable {

  void reset();

  boolean isModified();

  void setModified(boolean modified);

  void setActive(boolean active);

  void setListenerEnable(boolean listenerEnable);
}
