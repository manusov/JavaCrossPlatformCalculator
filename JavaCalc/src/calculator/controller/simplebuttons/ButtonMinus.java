/*

Button and operation description class for "-" (Minus) button.

*/

package calculator.controller.simplebuttons;

import calculator.controller.CalcButton;
import calculator.model.core.CalcCore;
import calculator.model.functions.CalcArgument.CalcOperations;
import java.awt.event.KeyEvent;

public class ButtonMinus extends CalcButton
{
private final static String NAME = "-";
private final static String TEXT = "subtract";
private final static int[]  KEYS = { KeyEvent.VK_SUBTRACT };
@Override public String getName() { return NAME; }
@Override public String getText() { return TEXT; }
@Override public int[] getKeys()  { return KEYS; }
@Override public void buttonAction(CalcCore cc)
    { cc.opTwoOperands(CalcOperations.SUB); }
}
