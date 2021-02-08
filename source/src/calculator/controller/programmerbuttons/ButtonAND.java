/*

Button and operation description class for "AND" button.

*/

package calculator.controller.programmerbuttons;

import calculator.controller.CalcButton;
import calculator.model.core.CalcCore;
import calculator.model.functions.CalcArgument.CalcOperations;
import java.awt.event.KeyEvent;

public class ButtonAND extends CalcButton
{
private final static String NAME = "AND";
private final static String TEXT = "Logical AND, N key";
private final static int[]  KEYS = { KeyEvent.VK_N };
@Override public String getName() { return NAME; }
@Override public String getText() { return TEXT; }
@Override public int[] getKeys()  { return KEYS; }
@Override public void buttonAction( CalcCore cc )
    { cc.opTwoOperands( CalcOperations.AND ); }
}
