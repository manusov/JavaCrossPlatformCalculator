// Button and operation description class for "9" button.

package calculator.controller.simplebuttons;

import calculator.controller.CalcButton;
import calculator.model.core.CalcCore;
import java.awt.event.KeyEvent;

public class Button9 extends CalcButton
{
private final static String NAME = "9";
private final static String TEXT = "digit";
private final static int[]  KEYS = { KeyEvent.VK_9 , KeyEvent.VK_NUMPAD9 };
@Override public String getName() { return NAME; }
@Override public String getText() { return TEXT; }
@Override public int[] getKeys()  { return KEYS; }
@Override public void buttonAction(CalcCore cc) { cc.inputDigit(9); }
}
