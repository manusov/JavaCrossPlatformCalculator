// Button and operation description class for "SHR" button.

package calculator.controller.programmerbuttons;

import calculator.controller.CalcButton;
import calculator.model.core.CalcCore;
import calculator.model.functions.CalcArgument.CalcOperations;
import java.awt.event.KeyEvent;

public class ButtonSHR extends CalcButton
{
private final static String NAME = "SHR";
private final static String TEXT = "Shift logical right, R key";
private final static int[]  KEYS = { KeyEvent.VK_R };
@Override public String getName() { return NAME; }
@Override public String getText() { return TEXT; }
@Override public int[] getKeys()  { return KEYS; }
@Override public void buttonAction(CalcCore cc)
    { cc.opTwoOperands(CalcOperations.SHR); }
}
