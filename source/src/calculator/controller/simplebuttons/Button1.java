/*

Button and operation description class for "1" button.

*/

package calculator.controller.simplebuttons;

import calculator.controller.CalcButton;
import calculator.model.core.CalcCore;
import java.awt.event.KeyEvent;

public class Button1 extends CalcButton
{
private final static String NAME = "1";
private final static String TEXT = "digit";
private final static int[]  KEYS = { KeyEvent.VK_1 , KeyEvent.VK_NUMPAD1 };
@Override public String getName() { return NAME; }
@Override public String getText() { return TEXT; }
@Override public int[] getKeys()  { return KEYS; }
@Override public void buttonAction( CalcCore cc ) { cc.inputDigit( 1 ); }
}
