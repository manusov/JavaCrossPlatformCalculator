// Radio button description class for "Grads" radio button.

package calculator.controller.scientificradio;

import calculator.controller.CalcRadio;
import calculator.model.core.CalcCore;
import calculator.model.functions.CalcArgument.AllRadios;
import java.awt.event.KeyEvent;

public class RadioGrads extends CalcRadio
{
private final static String NAME = "Grads";
private final static String TEXT = "Grads mode, ALT-G. " +
                                   "Actual for functions arguments and" + 
                                   " arc functions results";
private final static int[]  KEYS = { KeyEvent.VK_G };
@Override public String getName() { return NAME; }
@Override public String getText() { return TEXT; }
@Override public int[] getKeys()  { return KEYS; }
@Override public boolean getDefaultState() { return true; }
@Override public void radioAction(CalcCore cc) { cc.setOption(AllRadios.R3); }
}
