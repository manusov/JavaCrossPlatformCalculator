/*

Radio button description class for "Hex" radio button.

*/

package calculator.controller.programmerradio;

import calculator.controller.CalcRadio;
import calculator.model.core.CalcCore;
import calculator.model.functions.CalcArgument.AllRadios;
import java.awt.event.KeyEvent;

public class RadioHex extends CalcRadio 
{
private final static String NAME = "Hex";
private final static String TEXT = "Hexadecimal input mode, ALT-F1";
private final static int[]  KEYS = { KeyEvent.VK_F1 };
@Override public String getName() { return NAME; }
@Override public String getText() { return TEXT; }
@Override public int[] getKeys()  { return KEYS; }
@Override public boolean getDefaultState() { return true; }
@Override public void radioAction(CalcCore cc) { cc.setOption(AllRadios.R1); }
}
