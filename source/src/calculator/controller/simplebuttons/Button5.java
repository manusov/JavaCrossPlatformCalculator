/*

Button and operation description class for "5" button.

*/

package calculator.controller.simplebuttons;

import calculator.controller.CalcButton;
import calculator.model.core.CalcCore;
import java.awt.event.KeyEvent;

public class Button5 extends CalcButton
{
private final static String NAME = "5";
private final static String TEXT = "digit";
private final static int[]  KEYS = { KeyEvent.VK_5 , KeyEvent.VK_NUMPAD5 };
@Override public String getName() { return NAME; }
@Override public String getText() { return TEXT; }
@Override public int[] getKeys()  { return KEYS; }
@Override public void buttonAction( CalcCore cc ) { cc.inputDigit( 5 ); }
}
