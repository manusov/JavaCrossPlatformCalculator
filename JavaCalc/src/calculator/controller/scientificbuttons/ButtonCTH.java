// Button and operation description class for "CTH" button.

package calculator.controller.scientificbuttons;

import calculator.controller.CalcButton;
import calculator.model.core.CalcCore;
import calculator.model.functions.CalcArgument.CalcOperations;
import java.awt.Color;
import java.awt.Font;

public class ButtonCTH extends CalcButton 
{
private final static String NAME = "cth";
private final static String TEXT = "Hyperbolic cotangent";
private final static int[]  KEYS = null;
@Override public String getName() { return NAME; }
@Override public String getText() { return TEXT; }
@Override public int[] getKeys()  { return KEYS; }
@Override public void buttonAction(CalcCore cc) 
    { cc.opOneOperand(CalcOperations.CTH); }
// button text name customization
@Override public Color getCustomColor() { return FUNCTION_CUSTOM_COLOR; }
@Override public Font  getCustomFont()  { return MATH_CUSTOM_FONT;      }
}
