/*

Button and operation description class for "+" (Plus) button.

*/

package calculator.controller.simplebuttons;

import calculator.controller.CalcButton;
import calculator.model.core.CalcCore;
import calculator.model.functions.CalcArgument.CalcOperations;
import java.awt.event.KeyEvent;

public class ButtonPlus extends CalcButton
{
private final static String NAME = "+";
private final static String TEXT = "add";
private final static int[]  KEYS = { KeyEvent.VK_ADD , KeyEvent.VK_EQUALS };
@Override public String getName() { return NAME; }
@Override public String getText() { return TEXT; }
@Override public int[] getKeys()  { return KEYS; }
@Override public void buttonAction( CalcCore cc ) 
    { cc.opTwoOperands( CalcOperations.ADD ); }
}
