package com.mycomponents;

import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;

/**MyComponentsCave &agrave; vin
 * Description : Votre description
 * Copyright : Copyright (c) 2005
 * Soci&eacute;t&eacute; : Seb Informatique
 *
 * @author S&eacute;bastien Duch&eacute;
 * @version 0.9
 * @since 13/04/22
 */
public final class JModifyTextField extends JTextField implements IModifiable {

  private static final long serialVersionUID = 7663077125632345441L;

  private boolean modified;
  private boolean active;
  private boolean listenerEnable;

  public JModifyTextField() {
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
  public String getText() {
    return Objects.requireNonNull(super.getText()).strip();
  }

  @Override
  public void setListenerEnable(boolean listenerEnable) {
    this.listenerEnable = listenerEnable;
  }
}
