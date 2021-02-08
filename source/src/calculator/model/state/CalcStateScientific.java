/*

Data MODEL for SCIENTIFIC calculator,

*/

package calculator.model.state;

import calculator.model.functions.CalcArgument.AngleRadio;

public class CalcStateScientific extends CalcState
{

private AngleRadio currentAngle = AngleRadio.DEGREES;

@Override public AngleRadio getCurrentAngle() 
    {
    return currentAngle; 
    }
    
@Override public void setRadioEvent( int clicked )
    {
    AngleRadio[] detector = { AngleRadio.DEGREES, 
                              AngleRadio.RADIANS,
                              AngleRadio.GRADS };
    int n = detector.length;
    for ( int i=0; i<n; i++ )
        {
        if ( clicked == detector[i].ordinal() )
            {
            currentAngle = detector[i];
            }
        }
    }
}
