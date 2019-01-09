/*

GUI panel and it components for PROGRAMMER calculator display.

*/

package calculator.view.display;

import calculator.model.core.CalcCore;
import javax.swing.SwingConstants;

public class CalcDisplayProgrammer extends CalcDisplay
{

@Override public void updateDisplay(CalcCore cc, int selector)
    {
    String[] rs = cc.getIndicator();
    String s = rs[selector];
    display.setHorizontalAlignment(SwingConstants.RIGHT);
    display.setText(s);
    }

}
