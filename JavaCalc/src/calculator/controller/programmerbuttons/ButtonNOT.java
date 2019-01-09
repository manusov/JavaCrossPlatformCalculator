/*

Button and operation description class for "NOT" button.

*/

package calculator.controller.programmerbuttons;

import calculator.controller.CalcButton;
import calculator.model.core.CalcCore;
import calculator.model.functions.CalcArgument.CalcOperations;
import java.awt.event.KeyEvent;

public class ButtonNOT extends CalcButton
{
private final static String NAME = "NOT";
private final static String TEXT = "Logical NOT, T key";
private final static int[]  KEYS = { KeyEvent.VK_T };
@Override public String getName() { return NAME; }
@Override public String getText() { return TEXT; }
@Override public int[] getKeys()  { return KEYS; }
@Override public void buttonAction(CalcCore cc)
    { cc.opOneOperand(CalcOperations.NOT); }
}
