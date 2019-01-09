/*

Mathematics functions calculating methods for SIMPLE calculator model.

*/

package calculator.model.functions;

public class MathFunctions 
{

public void oneArgMath(CalcArgument carg)
    {
    switch(carg.calcOp)
        {
         case SQRT:
            {
            double a = carg.bdX1.doubleValue();
            a = Math.sqrt(a);
            carg.bdY = carg.safeConvertDouble(a);
            break;
            }
         default:
            {
            carg.bdY = null;  // mark error if unknown operation
            }
        }
    }
    

public void twoArgMath(CalcArgument carg)
    {
    switch(carg.calcOp)
        {
        case ADD:     { carg.bdY = carg.bdX1.add(carg.bdX2);       break; }
        case SUB:     { carg.bdY = carg.bdX1.subtract(carg.bdX2);  break; }
        case MUL:     { carg.bdY = carg.bdX1.multiply(carg.bdX2);  break; }
        case DIV:     { 
                        // carg.bdY = 
                        // carg.bdX1.divide(carg.bdX2, RoundingMode.HALF_UP);
                        double a = carg.bdX1.doubleValue();
                        double b = carg.bdX2.doubleValue();
                        double c = a / b;
                        carg.bdY = carg.safeConvertDouble(c);
                        //
                                                                   break; }
        case PERCENT: { // BigDecimal bd100 = new BigDecimal("100.0");
                        // carg.bdY = 
                        // carg.bdX1.divide(bd100, RoundingMode.HALF_UP);
                        // carg.bdY = carg.bdY.multiply(carg.bdX2);
                        double a = carg.bdX1.doubleValue();
                        double b = carg.bdX2.doubleValue();
                        double c = a / 100.0 * b;
                        carg.bdY = carg.safeConvertDouble(c);
                        //
                                                                    break; }
        default:
            {
            carg.bdY = null;    // mark error if unknown operation
            }
        }
    }

}