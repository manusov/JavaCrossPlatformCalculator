// Button and operation description class for "/" (Divide) button.

package calculator.controller.simplebuttons;

import calculator.controller.CalcButton;
import calculator.model.core.CalcCore;
import calculator.model.functions.CalcArgument.CalcOperations;
import java.awt.event.KeyEvent;

public class ButtonDivide extends CalcButton
{
private final static String NAME = "<html>&#247";
private final static String TEXT = "divide";
private final static int[]  KEYS = { KeyEvent.VK_DIVIDE };
@Override public String getName() { return NAME; }
@Override public String getText() { return TEXT; }
@Override public int[] getKeys()  { return KEYS; }
@Override public void buttonAction(CalcCore cc)
    { cc.opTwoOperands(CalcOperations.DIV); }
}
