/*

Button and operation description class for "OR" button.

*/

package calculator.controller.programmerbuttons;

import calculator.controller.CalcButton;
import calculator.model.core.CalcCore;
import calculator.model.functions.CalcArgument.CalcOperations;
import java.awt.event.KeyEvent;

public class ButtonOR extends CalcButton
{
private final static String NAME = "OR";
private final static String TEXT = "Logical OR, O key";
private final static int[]  KEYS = { KeyEvent.VK_O };
@Override public String getName() { return NAME; }
@Override public String getText() { return TEXT; }
@Override public int[] getKeys()  { return KEYS; }
@Override public void buttonAction(CalcCore cc) 
    { cc.opTwoOperands(CalcOperations.OR); }
}
