// Button and operation description class for "7" button.

package calculator.controller.simplebuttons;

import calculator.controller.CalcButton;
import calculator.model.core.CalcCore;
import java.awt.event.KeyEvent;

public class Button7 extends CalcButton 
{
private final static String NAME = "7";
private final static String TEXT = "digit";
private final static int[]  KEYS = { KeyEvent.VK_7 , KeyEvent.VK_NUMPAD7 };
@Override public String getName() { return NAME; }
@Override public String getText() { return TEXT; }
@Override public int[] getKeys()  { return KEYS; }
@Override public void buttonAction(CalcCore cc) { cc.inputDigit(7); }
}
