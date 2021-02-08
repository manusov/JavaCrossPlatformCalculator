/*

Button and operation description class for "%" (Percent) button.

*/

package calculator.controller.simplebuttons;

import calculator.controller.CalcButton;
import calculator.model.core.CalcCore;
import calculator.model.functions.CalcArgument.CalcOperations;
import java.awt.event.KeyEvent;

public class ButtonPercent extends CalcButton 
{
private final static String NAME = "%";
private final static String TEXT = "percents, N key";
private final static int[]  KEYS = { KeyEvent.VK_N };
@Override public String getName() { return NAME; }
@Override public String getText() { return TEXT; }
@Override public int[] getKeys()  { return KEYS; }
@Override public void buttonAction( CalcCore cc )
    { cc.opTwoOperands( CalcOperations.PERCENT ); }
}
