// Button and operation description class for "." (Decimal point) button.

package calculator.controller.simplebuttons;

import calculator.controller.CalcButton;
import calculator.model.core.CalcCore;
import java.awt.event.KeyEvent;

public class ButtonPoint extends CalcButton
{
private final static String NAME = ".";
private final static String TEXT = "decimal point";
private final static int[]  KEYS = { KeyEvent.VK_DECIMAL };
@Override public String getName() { return NAME; }
@Override public String getText() { return TEXT; }
@Override public int[] getKeys()  { return KEYS; }
@Override public void buttonAction(CalcCore cc) { cc.inputPoint(); }
}
