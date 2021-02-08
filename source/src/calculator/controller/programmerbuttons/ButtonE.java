/*

Button and operation description class for "E" hex digit button.

*/

package calculator.controller.programmerbuttons;

import calculator.controller.CalcButton;
import calculator.model.core.CalcCore;
import java.awt.event.KeyEvent;

public class ButtonE extends CalcButton
{
private final static String NAME = "E";
private final static String TEXT = "hex digit";
private final static int[]  KEYS = { KeyEvent.VK_E };
@Override public String getName() { return NAME; }
@Override public String getText() { return TEXT; }
@Override public int[] getKeys()  { return KEYS; }
@Override public void buttonAction( CalcCore cc ) { cc.inputDigit( 0xE ); }    
}
