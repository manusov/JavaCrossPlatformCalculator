// Operations set for SCIENTIFIC calculator model,

package calculator.model.core;

import calculator.model.functions.MathFunctionsScientific;
import calculator.model.state.CalcStateScientific;

public class CalcCoreScientific extends CalcCore
{
CalcCoreScientific()
    {
    cs = new CalcStateScientific();
    mf = new MathFunctionsScientific();
    }

}
