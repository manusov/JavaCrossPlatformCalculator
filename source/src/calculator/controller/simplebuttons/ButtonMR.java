/*

Button and operation description class for "M" (Memory recall) button.

*/

package calculator.controller.simplebuttons;

import calculator.controller.CalcButton;
import calculator.model.core.CalcCore;
import java.awt.event.KeyEvent;

public class ButtonMR extends CalcButton
{
private final static String NAME = "MR";
private final static String TEXT = "memory recall, Y key";
private final static int[]  KEYS = { KeyEvent.VK_Y };
@Override public String getName() { return NAME; }
@Override public String getText() { return TEXT; }
@Override public int[] getKeys()  { return KEYS; }
@Override public void buttonAction( CalcCore cc ) { cc.memoryRecall(); }
}
