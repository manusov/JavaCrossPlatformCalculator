/*

Button and operation description class for "=" (Equal) button.

*/

package calculator.controller.simplebuttons;

import calculator.controller.CalcButton;
import calculator.model.core.CalcCore;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;

public class ButtonEqual extends CalcButton
{
private final static String NAME = "=";
private final static String TEXT = "make operation, ENTER key";
private final static int[]  KEYS = { KeyEvent.VK_ENTER };
@Override public String getName() { return NAME; }
@Override public String getText() { return TEXT; }
@Override public int[] getKeys()  { return KEYS; }
@Override public void buttonAction(CalcCore cc) { cc.executeEqual(); }
// button text name customization
@Override public Color getCustomColor() { return EQUAL_CUSTOM_COLOR; }
@Override public Font  getCustomFont()  { return EQUAL_CUSTOM_FONT;  }
}
