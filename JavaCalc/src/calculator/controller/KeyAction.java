// Action handler for map PC keyboard keys to calculator keyboard buttons.

package calculator.controller;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;

public class KeyAction extends AbstractAction
{
@Override public void actionPerformed(ActionEvent event) 
    {
    Object b = event.getSource();
    if ( b instanceof JButton )
        {
        ((JButton)(b)).doClick();
        }
    }    
}
