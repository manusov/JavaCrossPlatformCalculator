/*

Radio button description class for "Decimal" radio button.

*/

package calculator.controller.programmerradio;

import calculator.controller.CalcRadio;
import calculator.model.core.CalcCore;
import calculator.model.functions.CalcArgument.AllRadios;
import java.awt.event.KeyEvent;

public class RadioDecimal extends CalcRadio 
{
private final static String NAME = "Decimal";
private final static String TEXT = "Decimal input mode, ALT-F2";
private final static int[]  KEYS = { KeyEvent.VK_F2 };
@Override public String getName() { return NAME; }
@Override public String getText() { return TEXT; }
@Override public int[] getKeys()  { return KEYS; }
@Override public boolean getDefaultState() { return false; }
@Override public void radioAction( CalcCore cc ) 
    { cc.setOption( AllRadios.R2 );}
}
