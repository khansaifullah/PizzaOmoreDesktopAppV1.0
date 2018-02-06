package com.PrintUtility;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DELL on 2/6/2018.
 */
class MyCellRenderer extends DefaultListCellRenderer {
    //final static ImageIcon longIcon = new ImageIcon("long.gif");
    //final static ImageIcon shortIcon = new ImageIcon("short.gif");

    /* This is the only method defined by ListCellRenderer.  We just
     * reconfigure the Jlabel each time we're called.
     */
    public Component getListCellRendererComponent(
            JList list,
            Object value,   // value to display
            int index,      // cell index
            boolean iss,    // is the cell selected
            boolean chf)    // the list and the cell have the focus
    {
        /* The DefaultListCellRenderer class will take care of
         * the JLabels text property, it's foreground and background
         * colors, and so on.
         */
        super.getListCellRendererComponent(list, value, index, iss, chf);

        /* We additionally set the JLabels icon property here.
         */
       // String s = value.toString();
        //setIcon((s.length > 10) ? longIcon : shortIcon);

        return this;
    }
}
