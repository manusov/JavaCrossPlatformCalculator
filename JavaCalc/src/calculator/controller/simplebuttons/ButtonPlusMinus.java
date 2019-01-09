/*

Button and operation description class for "+/-" (Change sign) button.

*/

package calculator.controller.simplebuttons;

import calculator.controller.CalcButton;
import calculator.model.core.CalcCore;
import java.awt.event.KeyEvent;

public class ButtonPlusMinus extends CalcButton
{
private final static String NAME = "+/-";
private final static String TEXT = "change sign, S key";
private final static int[]  KEYS = { KeyEvent.VK_S };
@Override public String getName() { return NAME; }
@Override public String getText() { return TEXT; }
@Override public int[] getKeys()  { return KEYS; }
@Override public void buttonAction(CalcCore cc) { cc.changeSign(); }
}
