/*

Fabric for calculator display panel.

*/

package calculator.view.display;

import calculator.Calculator.CALCS;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;

public class DisplayFabric 
{

public static CalcDisplay[] getCalculatorDisplays(CALCS type)
    {
    CalcDisplay[] displayPanels;
    Dimension dim;
    Font font;
    
    switch (type)
        {
        case SCIENTIFIC:
            {
            displayPanels = new CalcDisplay[1];
            displayPanels[0] = new CalcDisplayScientific();
            dim = new Dimension(350, 45);
            font = new Font("Verdana", Font.PLAIN, 16);
            break; 
            }
        case PROGRAMMER:
            {
            displayPanels = new CalcDisplay[4];
            for(int i=0; i<displayPanels.length; i++)
                {
                displayPanels[i] = new CalcDisplayProgrammer();
                }
            dim = new Dimension(350, 30);
            font = new Font("Verdana", Font.PLAIN, 14);
            break;
            }
        case SIMPLE:
        default:
            {
            displayPanels = new CalcDisplay[1];
            displayPanels[0] = new CalcDisplay();
            dim = new Dimension(350, 50);
            font = new Font("Verdana", Font.PLAIN, 16);
            break;
            }
        }
    
    for (CalcDisplay displayPanel : displayPanels) 
        {
        JButton display = new JButton("Initializing...");
        GridLayout grid = new GridLayout(1, 1);
        display.setEnabled(false);
        display.setPreferredSize(dim);
        display.setFont(font);
        displayPanel.setDisplay(display);
        displayPanel.setLayout(grid);
        displayPanel.add(display);
        }
    
    return displayPanels;
    }
    
}
