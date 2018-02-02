// Button and operation description class for "PI" button.

package calculator.controller.scientificbuttons;

import calculator.controller.CalcButton;
import calculator.model.core.CalcCore;
import calculator.model.functions.CalcArgument.CalcOperations;
import java.awt.Color;
import java.awt.Font;

public class ButtonPI extends CalcButton 
{
private final static String NAME = "<html>&#960";
private final static String TEXT = "pi number";
private final static int[]  KEYS = null;
@Override public String getName() { return NAME; }
@Override public String getText() { return TEXT; }
@Override public int[] getKeys()  { return KEYS; }
@Override public void buttonAction(CalcCore cc) 
    { cc.opOneOperand(CalcOperations.PI); }
// button text name customization
@Override public Color getCustomColor() { return FUNCTION_CUSTOM_COLOR; }
@Override public Font  getCustomFont()  { return MATH_CUSTOM_FONT;      }
}
