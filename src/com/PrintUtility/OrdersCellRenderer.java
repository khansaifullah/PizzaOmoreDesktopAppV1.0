package com.PrintUtility;

/**
 * Created by DELL on 2/9/2018.
 */
import java.awt.*;

import javax.swing.*;

import javax.swing.border.Border;

public class OrdersCellRenderer extends JLabel implements ListCellRenderer<Order> {
    private Border border;

   public OrdersCellRenderer()
    {

        //setHorizontalAlignment(SwingConstants.LEFT);
        //setMinimumSize(new Dimension(1000, 100));

        // Leave a 10-pixel separator between the flag icon and country name.
        //setIconTextGap(10);
       // setFont(new Font("Sans Serif", Font.PLAIN, 15));

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


        setText("Order id:"+order.getOrder_id()+"                           " +
                "    "+order.getCustomer_name()+"                               " +
                "  "+ order.getOrder_price());
        //setForeground(Color.blue);
        //setText("Order Id :     "+order.getOrder_id() + " Customer Name:  " + order.getCustomer_name() + " Order Status:  " + "Pending");
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
