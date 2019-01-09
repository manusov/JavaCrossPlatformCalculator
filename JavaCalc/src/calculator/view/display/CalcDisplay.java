/*

GUI panel and it components for SIMPLE calculator display.
This is also parent class for SCIENTIFIC and PROGRAMMER calc. displays.

*/

package calculator.view.display;

import calculator.model.core.CalcCore;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CalcDisplay extends JPanel
{
JButton display;

public JButton getDisplay()
    {
    return display; 
    }

public void setDisplay(JButton b) 
    {
    display = b;    
    }

public void updateDisplay(CalcCore cc, int selector)
    {
    String[] rs = cc.getIndicator();
    String s = rs[0];
    display.setText(s);
    }
}
