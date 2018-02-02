// Button and operation description class for "SHL" button.

package calculator.controller.programmerbuttons;

import calculator.controller.CalcButton;
import calculator.model.core.CalcCore;
import calculator.model.functions.CalcArgument.CalcOperations;
import java.awt.event.KeyEvent;

public class ButtonSHL extends CalcButton
{
private final static String NAME = "SHL";
private final static String TEXT = "Shift logical left, L key";
private final static int[]  KEYS = { KeyEvent.VK_L };
@Override public String getName() { return NAME; }
@Override public String getText() { return TEXT; }
@Override public int[] getKeys()  { return KEYS; }
@Override public void buttonAction(CalcCore cc) 
    { cc.opTwoOperands(CalcOperations.SHL); }
}
