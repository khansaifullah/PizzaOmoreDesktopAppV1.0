package com.PrintUtility;

/**
 * Created by DELL on 2/9/2018.
 */
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import javax.swing.border.Border;

public class OrdersCellRenderer extends JLabel implements ListCellRenderer<Order> {
    private Border border;

   public OrdersCellRenderer()
    {
        // Leave a 10-pixel separator between the flag icon and country name.

        setIconTextGap(10);

        // Swing labels default to being transparent; the container's color
        // shows through. To change a Swing label's background color, you must
        // first make the label opaque (by passing true to setOpaque()). Later,
        // you invoke setBackground(), passing the new color as the argument.

        setOpaque(true);

        // This border is placed around a cell that is selected and has focus.

        border = BorderFactory.createLineBorder(Color.RED, 1);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Order> list,
                                                  Order order,
                                                  int index,
                                                  boolean isSelected,
                                                  boolean cellHasFocus)
    {
        //setUndecorated(true);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
       // setSize(1000,50);
        //setMinimumSize(new Dimension(1000,100));
       // setMinimumSize(new Dimension(1000,100));
        //setPreferedSize(new Dimension(1000,100));
        //setMaximumSize(new Dimension(1000,100));
        setText("Order Id :     "+order.getOrder_id() + " Customer Name:  " + order.getCustomer_name() + " Order Status:  " + "Pending");
        //8setIcon(order.getFlagIcon());

        if (isSelected)

        {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        }
        else
        {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        setFont(list.getFont());

        setEnabled(list.isEnabled());

        if (isSelected && cellHasFocus)
            setBorder(border);
        else
            setBorder(null);

        return this;
    }
}
