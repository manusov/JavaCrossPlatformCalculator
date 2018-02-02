// Radio button description class for "Degrees" radio button.

package calculator.controller.scientificradio;

import calculator.controller.CalcRadio;
import calculator.model.core.CalcCore;
import calculator.model.functions.CalcArgument.AllRadios;
import java.awt.event.KeyEvent;

public class RadioDegrees extends CalcRadio
{
private final static String NAME = "Degrees";
private final static String TEXT = "Degrees mode, ALT-D. " +
                                   "Actual for functions arguments and" + 
                                   " arc functions results";
private final static int[]  KEYS = { KeyEvent.VK_D };
@Override public String getName() { return NAME; }
@Override public String getText() { return TEXT; }
@Override public int[] getKeys()  { return KEYS; }
@Override public boolean getDefaultState() { return true; }
@Override public void radioAction(CalcCore cc) { cc.setOption(AllRadios.R1); }
}
