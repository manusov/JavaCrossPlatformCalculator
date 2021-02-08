/*

Action listener and events routing class for calculator radio buttons clicks.
This class for handling calculator buttons press and 
select appropriate handler in the Button<name> classes.

*/

package calculator.controller;

import calculator.model.core.CalcCore;
import calculator.view.display.CalcDisplay;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioAction implements ActionListener
{
private final CalcRadio[] radioHandlers;
private final CalcCore calculatorCore;
private final CalcDisplay[] displayIndicators;


public RadioAction
        ( CalcRadio[] list, 
          CalcCore cc, 
          CalcDisplay[] cd )
    {
    radioHandlers = list;     // CONTROLLER, classes, associated with buttons
    calculatorCore = cc;      // MODEL, for modifications by controller
    displayIndicators = cd;   // VIEW, for update visualized value(s)
    }

@Override public void actionPerformed( ActionEvent event )
    {
    String command = event.getActionCommand();
    int selector;
    if ( ( command != null ) && ( command.length() >= 1 ) )
        {
        try {
            selector = Integer.decode( command );
            }
        catch ( NumberFormatException e )
            {
            selector = -1;
            }
        if ( ( selector >= 0 ) & ( selector < radioHandlers.length ) )
            {
            radioHandlers[selector].radioAction( calculatorCore );
            for( int i=0; i<displayIndicators.length; i++ )
                {
                displayIndicators[i].updateDisplay( calculatorCore, i );
                }
            }
        }
    }    
}
