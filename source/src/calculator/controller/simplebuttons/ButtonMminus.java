/*

Button and operation description class for "M-" (Memory minus) button.

*/

package calculator.controller.simplebuttons;

import calculator.controller.CalcButton;
import calculator.model.core.CalcCore;
import java.awt.event.KeyEvent;

public class ButtonMminus extends CalcButton
{
private final static String NAME = "M-";
private final static String TEXT = "subtract from memory, M key";
private final static int[]  KEYS = { KeyEvent.VK_M };
@Override public String getName() { return NAME; }
@Override public String getText() { return TEXT; }
@Override public int[] getKeys()  { return KEYS; }
@Override public void buttonAction( CalcCore cc ) { cc.memoryMinus(); }
}
