// Button and operation description class for "3" button.

package calculator.controller.simplebuttons;

import calculator.controller.CalcButton;
import calculator.model.core.CalcCore;
import java.awt.event.KeyEvent;

public class Button3 extends CalcButton
{
private final static String NAME = "3";
private final static String TEXT = "digit";
private final static int[]  KEYS = { KeyEvent.VK_3 , KeyEvent.VK_NUMPAD3 };
@Override public String getName() { return NAME; }
@Override public String getText() { return TEXT; }
@Override public int[] getKeys()  { return KEYS; }
@Override public void buttonAction(CalcCore cc) { cc.inputDigit(3); }
}
