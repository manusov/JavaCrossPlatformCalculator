// Fabric for calculator core.

package calculator.model.core;

import calculator.Calculator.CALCS;

public class CoreFabric 
{

public static CalcCore getCalculatorCore(CALCS type)
    {
    CalcCore calculatorCore;
    switch(type)
        {
        case SCIENTIFIC:
            { calculatorCore = new CalcCoreScientific(); break; }
        case PROGRAMMER:
            { calculatorCore = new CalcCoreProgrammer(); break; }
        case SIMPLE:
        default:
            { calculatorCore = new CalcCore(); break; }
        }
    return calculatorCore;
    }    
}
