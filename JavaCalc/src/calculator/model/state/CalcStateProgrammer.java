// Data MODEL for PROGRAMMER calculator,

package calculator.model.state;

import calculator.model.functions.CalcArgument.RadixRadio;

public class CalcStateProgrammer extends CalcState
{
public final String[] CLEAR_MULTI_RADIX = { "0h", "0", "0o", "0b" };
private String[] multiRadix;
private RadixRadio currentRadix = RadixRadio.HEX;

public CalcStateProgrammer()
    {
    int n = CLEAR_MULTI_RADIX.length;
    multiRadix = new String[n];
    System.arraycopy(CLEAR_MULTI_RADIX, 0, multiRadix, 0, n);
    }


@Override public String[] getResultStrings()
    { 
    return multiRadix; 
    }

@Override public void setResultStrings(String[] rs) 
    {
    multiRadix = rs;
    }

@Override public RadixRadio getCurrentRadix() { return currentRadix; }
    
@Override public void setRadioEvent(int clicked)
    {
    RadixRadio[] detector = { RadixRadio.HEX, 
                              RadixRadio.DECIMAL,
                              RadixRadio.OCTAL,
                              RadixRadio.BINARY };
    int n = detector.length;
    for (int i=0; i<n; i++ )
        {
        if ( clicked == detector[i].ordinal() )
            {
            currentRadix = detector[i];
            }
        }
    }
}
