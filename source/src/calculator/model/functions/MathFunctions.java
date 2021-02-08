/*

Mathematics functions calculating methods for SIMPLE calculator model.

*/

package calculator.model.functions;

public class MathFunctions 
{

public void oneArgMath( CalcArgument carg )
    {
    if ( carg.bdX1 == null )
        {
        carg.bdY = null;
        return;
        }
        
    switch( carg.calcOp )
        {
         case SQRT:
            {
            double a = carg.bdX1.doubleValue();
            a = Math.sqrt( a );
            carg.bdY = carg.safeConvertDouble( a );
            break;
            }
         default:
            {
            carg.bdY = null;  // mark error if unknown operation
            }
        }
    }
    

public void twoArgMath( CalcArgument carg )
    {
    if ( ( carg.bdX1 == null ) || ( carg.bdX2 == null ) )
        {
        carg.bdY = null;
        return;
        }
        
    switch( carg.calcOp )
        {
        case ADD:     { carg.bdY = carg.bdX1.add( carg.bdX2 );       break; }
        case SUB:     { carg.bdY = carg.bdX1.subtract( carg.bdX2 );  break; }
        case MUL:     { carg.bdY = carg.bdX1.multiply( carg.bdX2 );  break; }
        case DIV:     { double a = carg.bdX1.doubleValue();
                        double b = carg.bdX2.doubleValue();
                        double c = a / b;
                        carg.bdY = carg.safeConvertDouble( c );
                                                                     break; }
        case PERCENT: { double a = carg.bdX1.doubleValue();
                        double b = carg.bdX2.doubleValue();
                        double c = a / 100.0 * b;
                        carg.bdY = carg.safeConvertDouble( c );
                                                                     break; }
        default:
            {
            carg.bdY = null;    // mark error if unknown operation
            break;
            }
        }
    }
}