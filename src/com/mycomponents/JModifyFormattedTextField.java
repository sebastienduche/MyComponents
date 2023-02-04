package com.mycomponents;

import javax.swing.JFormattedTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.Format;
import java.text.ParseException;

/**
 * Titre : MyComponents
 * Description : Votre description
 * Copyright : Copyright (c) 2005
 * Soci&eacute;t&eacute; : Seb Informatique
 *
 * @author S&eacute;bastien Duch&eacute;
 * @version 0.8
 * @since 04/02/23
 */

public final class JModifyFormattedTextField extends JFormattedTextField implements IModifiable {

  private static final long serialVersionUID = -7364848812779720027L;

  private boolean modified;
  private boolean active;
  private boolean listenerEnable;
  private boolean allowsEmptyValues;

  public JModifyFormattedTextField(Format format) {
    this(format, false);
  }

  public JModifyFormattedTextField(Format format, boolean allowsEmptyValues) {
    super(format);
    this.allowsEmptyValues = allowsEmptyValues;
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

  protected void doAfterModifying() {

  }

  @Override
  public void reset() {
    setText("");
    setModified(false);
  }

  @Override
  public void commitEdit() throws ParseException {
    if (allowsEmptyValues && (getText() == null || getText().isBlank())) {
      setValue(null);
    } else {
      super.commitEdit();
    }
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

  public boolean isAllowsEmptyValues() {
    return allowsEmptyValues;
  }

  public void setAllowsEmptyValues(boolean allowsEmptyValues) {
    this.allowsEmptyValues = allowsEmptyValues;
  }
}
