// Button and operation description class for "0" button.

package calculator.controller.simplebuttons;

import calculator.controller.CalcButton;
import calculator.model.core.CalcCore;
import java.awt.event.KeyEvent;

public class Button0 extends CalcButton
{
private final static String NAME = "0";
private final static String TEXT = "digit";
private final static int[]  KEYS = { KeyEvent.VK_0 , KeyEvent.VK_NUMPAD0 };
@Override public String getName() { return NAME; }
@Override public String getText() { return TEXT; }
@Override public int[] getKeys()  { return KEYS; }
@Override public void buttonAction(CalcCore cc) { cc.inputDigit(0); }
}
