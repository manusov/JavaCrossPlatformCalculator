/*

Radio button description class for "Binary" radio button.

*/

package calculator.controller.programmerradio;

import calculator.controller.CalcRadio;
import calculator.model.core.CalcCore;
import calculator.model.functions.CalcArgument.AllRadios;
import java.awt.event.KeyEvent;

public class RadioBinary extends CalcRadio 
{
private final static String NAME = "Binary";
private final static String TEXT = "Binary input mode, ALT-F4";
private final static int[]  KEYS = { KeyEvent.VK_F4 };
@Override public String getName() { return NAME; }
@Override public String getText() { return TEXT; }
@Override public int[] getKeys()  { return KEYS; }
@Override public boolean getDefaultState() { return false; }
@Override public void radioAction(CalcCore cc) { cc.setOption(AllRadios.R4); }
}
