package com.mycomponents;

import javax.swing.JComboBox;
import java.awt.event.ItemEvent;

/**
 * <p>Titre : MyComponents</p>
 * <p>Description : Votre description</p>
 * <p>Copyright : Copyright (c) 2005</p>
 * <p>Soci&eacute;t&eacute; : Seb Informatique</p>
 *
 * @author S&eacute;bastien Duch&eacute;
 * @version 0.8
 * @since 13/04/22
 */

public final class JModifyComboBox<T> extends JComboBox<T> implements IModifiable {

  private static final long serialVersionUID = 833606680694326736L;

  private boolean modified;
  private boolean active;
  private boolean listenerEnable;

  public JModifyComboBox() {
    modified = false;
    active = true;
    listenerEnable = true;
    addItemListener(itemEvent -> {
      if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
        if (active && listenerEnable) {
          if (!modified) {
            doAfterModifying();
            modified = true;
          }
        }
      }
    });
  }

  private void doAfterModifying() {

  }

  @Override
  public void reset() {
    if (getItemCount() > 0) {
      setSelectedIndex(0);
    }
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
