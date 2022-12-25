package com.mycomponents.tablecomponents;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Component;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * <p>Titre : Cave &agrave; vin</p>
 * <p>Description : Votre description</p>
 * <p>Copyright : Copyright (c) 2020</p>
 * <p>Soci&eacute;t&eacute; : Seb Informatique</p>
 *
 * @author S&eacute;bastien Duch&eacute;
 * @version 0.2
 * @since 14/12/20
 */
public class DateCellRenderer extends DefaultTableCellRenderer {

  private final DateTimeFormatter formatter;

  public DateCellRenderer(DateTimeFormatter formatter) {
    this.formatter = formatter;
  }

  @Override
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    if (value instanceof LocalDate) {
      setText(((LocalDate) value).format(formatter));
    }
    return this;
  }
}
