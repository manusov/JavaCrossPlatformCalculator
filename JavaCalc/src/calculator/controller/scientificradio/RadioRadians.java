// Radio button description class for "Radians" radio button.

package calculator.controller.scientificradio;

import calculator.controller.CalcRadio;
import calculator.model.core.CalcCore;
import calculator.model.functions.CalcArgument.AllRadios;
import java.awt.event.KeyEvent;

public class RadioRadians extends CalcRadio
{
private final static String NAME = "Radians";
private final static String TEXT = "Radians mode, ALT-R. " +
                                   "Actual for functions arguments and" + 
                                   " arc functions results";
private final static int[]  KEYS = { KeyEvent.VK_R };
@Override public String getName() { return NAME; }
@Override public String getText() { return TEXT; }
@Override public int[] getKeys()  { return KEYS; }
@Override public boolean getDefaultState() { return true; }
@Override public void radioAction(CalcCore cc) { cc.setOption(AllRadios.R2);}
}
