/*

Action listener and events routing class for calculator buttons clicks.
This class for handling calculator buttons press and 
select appropriate handler in the Button<name> classes.

*/

package calculator.controller;

import calculator.model.core.CalcCore;
import calculator.view.display.CalcDisplay;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcAction implements ActionListener
{
private final CalcButton[][] buttonsHandlers;
private final CalcCore calculatorCore;
private final CalcDisplay[] displayIndicators;

// This class for handling calculator buttons press and 
// select appropriate handler in the Button<name> classes.

public CalcAction
        ( CalcButton[][] list, 
          CalcCore cc, 
          CalcDisplay[] cd )
    {
    buttonsHandlers = list;   // CONTROLLER, classes, associated with buttons
    calculatorCore = cc;      // MODEL, for modifications by controller
    displayIndicators = cd;   // VIEW, for update visualized value(s)
    }
    
@Override public void actionPerformed(ActionEvent event)
    {
    String command = event.getActionCommand();
    int selector;
    if ( ( command != null ) && ( command.length() >= 2 ) )
        {
        try {
            selector = Integer.decode(command);
            }
        catch (Exception e)
            {
            selector = -1;
            }
        if ( (selector >= 0) & (selector <= 100) )
            {
            int x = selector % 10;
            int y = selector / 10;
            
            if ( ( x < buttonsHandlers[0].length ) & 
                 ( y < buttonsHandlers.length    ) )
                {
                buttonsHandlers[y][x].buttonAction(calculatorCore);
                for(int i=0; i<displayIndicators.length; i++)
                    {
                    displayIndicators[i].updateDisplay(calculatorCore, i);
                    }
                }
            }
        }
    }
}
