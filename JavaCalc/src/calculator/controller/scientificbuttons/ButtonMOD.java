/*

Button and operation description class for "MOD" button.

*/

package calculator.controller.scientificbuttons;

import calculator.controller.CalcButton;
import calculator.model.core.CalcCore;
import calculator.model.functions.CalcArgument.CalcOperations;

public class ButtonMOD extends CalcButton 
{
private final static String NAME = "MOD";
private final static String TEXT = "Remainder of the integer division";
private final static int[]  KEYS = null;
@Override public String getName() { return NAME; }
@Override public String getText() { return TEXT; }
@Override public int[] getKeys()  { return KEYS; }
@Override public void buttonAction(CalcCore cc)
    { cc.opTwoOperands(CalcOperations.MOD); }
}
