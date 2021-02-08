/*

Button and operation description class for "*" (Multiply) button.

*/

package calculator.controller.simplebuttons;

import calculator.controller.CalcButton;
import calculator.model.core.CalcCore;
import calculator.model.functions.CalcArgument.CalcOperations;
import java.awt.event.KeyEvent;

public class ButtonMultiply extends CalcButton
{
private final static String NAME = "*";
private final static String TEXT = "multiply";
private final static int[]  KEYS = { KeyEvent.VK_MULTIPLY };
@Override public String getName() { return NAME; }
@Override public String getText() { return TEXT; }
@Override public int[] getKeys()  { return KEYS; }
@Override public void buttonAction( CalcCore cc )
    { cc.opTwoOperands( CalcOperations.MUL ); }
}
