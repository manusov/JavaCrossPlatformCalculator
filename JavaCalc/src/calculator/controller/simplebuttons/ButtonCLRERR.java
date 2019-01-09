/*

Button and operation description class for "CE" (Clear error input) button.

*/

package calculator.controller.simplebuttons;

import calculator.controller.CalcButton;
import calculator.model.core.CalcCore;
import java.awt.event.KeyEvent;

public class ButtonCLRERR extends CalcButton 
{
private final static String NAME = "CE";
private final static String TEXT = "clear error last input, BACKSPACE key";
private final static int[]  KEYS = { KeyEvent.VK_BACK_SPACE };
@Override public String getName() { return NAME; }
@Override public String getText() { return TEXT; }
@Override public int[] getKeys()  { return KEYS; }
@Override public void buttonAction(CalcCore cc) { cc.clearCalc(); }
}
