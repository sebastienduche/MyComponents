package com.mycomponents;

import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Titre : MyComponents
 * Description : Votre description
 * Copyright : Copyright (c) 2005
 * Soci&eacute;t&eacute; : Seb Informatique
 *
 * @author S&eacute;bastien Duch&eacute;
 * @version 0.6
 * @since 13/04/22
 */

public final class JModifyTextArea extends JTextArea implements IModifiable {

  private static final long serialVersionUID = 7858711227949516336L;

  private boolean modified;
  private boolean active;
  private boolean listenerEnable;

  public JModifyTextArea() {
    modified = false;
    active = true;
    listenerEnable = true;
    addKeyListener(new KeyAdapter() {

      @Override
      public void keyTyped(KeyEvent arg0) {
        if (active && listenerEnable) {
          doAfterModifying();
          modified = true;
        }
      }
    });
  }

  private void doAfterModifying() {

  }

  @Override
  public void reset() {
    setText("");
    setModified(false);
  }

  @Override
  public boolean isModified() {
    return modified;
  }

  @Override
  public void setModified(boolean modified) {
    this.modified = modified;
  }

  @Override
  public void setActive(boolean active) {
    this.active = active;
  }

  @Override
  public void setListenerEnable(boolean listenerEnable) {
    this.listenerEnable = listenerEnable;
  }
}
