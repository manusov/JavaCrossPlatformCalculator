// Radio button description class for "Octal" radio button.

package calculator.controller.programmerradio;

import calculator.controller.CalcRadio;
import calculator.model.core.CalcCore;
import calculator.model.functions.CalcArgument.AllRadios;
import java.awt.event.KeyEvent;

public class RadioOctal extends CalcRadio 
{
private final static String NAME = "Octal";
private final static String TEXT = "Octal input mode, ALT-F3";
private final static int[]  KEYS = { KeyEvent.VK_F3 };
@Override public String getName() { return NAME; }
@Override public String getText() { return TEXT; }
@Override public int[] getKeys()  { return KEYS; }
@Override public boolean getDefaultState() { return false; }
@Override public void radioAction(CalcCore cc) { cc.setOption(AllRadios.R3); }
}
