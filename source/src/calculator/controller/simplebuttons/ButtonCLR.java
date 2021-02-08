/*

Button and operation description class for "C" (Clear) button.

*/

package calculator.controller.simplebuttons;

import calculator.controller.CalcButton;
import calculator.model.core.CalcCore;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;

public class ButtonCLR extends CalcButton
{
private final static String NAME = "CLR";
private final static String TEXT = "clear result, ESC key";
private final static int[]  KEYS = { KeyEvent.VK_ESCAPE };
@Override public String getName() { return NAME; }
@Override public String getText() { return TEXT; }
@Override public int[] getKeys()  { return KEYS; }
@Override public void buttonAction( CalcCore cc ) { cc.clearCalc(); }
// button text name customization
@Override public Color getCustomColor() { return CLR_CUSTOM_COLOR; }
@Override public Font  getCustomFont()  { return CLR_CUSTOM_FONT;  }
}
