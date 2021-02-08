/*

Button and operation description class for "SQRT" (Square root) button.

*/

package calculator.controller.simplebuttons;

import calculator.controller.CalcButton;
import calculator.model.core.CalcCore;
import calculator.model.functions.CalcArgument.CalcOperations;
import java.awt.event.KeyEvent;

public class ButtonSQRT extends CalcButton
{
private final static String NAME = "<html>&#8730";
private final static String TEXT = "square root, Q key";
private final static int[]  KEYS = { KeyEvent.VK_Q };
@Override public String getName() { return NAME; }
@Override public String getText() { return TEXT; }
@Override public int[] getKeys()  { return KEYS; }
@Override public void buttonAction( CalcCore cc ) 
    { cc.opOneOperand( CalcOperations.SQRT ); }
}
