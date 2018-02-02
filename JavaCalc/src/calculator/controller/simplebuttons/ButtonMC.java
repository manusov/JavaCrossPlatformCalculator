// Button and operation description class for "MC" (Memory clear) button.

package calculator.controller.simplebuttons;

import calculator.controller.CalcButton;
import calculator.model.core.CalcCore;
import java.awt.event.KeyEvent;

public class ButtonMC extends CalcButton
{
private final static String NAME = "MC";
private final static String TEXT = "memory clear, Z key";
private final static int[]  KEYS = { KeyEvent.VK_Z };
@Override public String getName() { return NAME; }
@Override public String getText() { return TEXT; }
@Override public int[] getKeys()  { return KEYS; }
@Override public void buttonAction(CalcCore cc) { cc.memoryClear(); }
}
