/*

Button and operation description class for "B" hex digit button.

*/

package calculator.controller.programmerbuttons;

import calculator.controller.CalcButton;
import calculator.model.core.CalcCore;
import java.awt.event.KeyEvent;

public class ButtonB extends CalcButton
{
private final static String NAME = "B";
private final static String TEXT = "hex digit";
private final static int[]  KEYS = { KeyEvent.VK_B };
@Override public String getName() { return NAME; }
@Override public String getText() { return TEXT; }
@Override public int[] getKeys()  { return KEYS; }
@Override public void buttonAction(CalcCore cc) { cc.inputDigit(0xB); }    
}
