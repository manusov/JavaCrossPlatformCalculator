// Action handler for root menu: application exit.

package calculator.view.rootmenu;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class HandlerExit extends AbstractAction 
{
@Override public void actionPerformed(ActionEvent e) 
    {
    System.exit(0); 
    }  
}
