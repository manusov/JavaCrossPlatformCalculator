/*

Mathematics functions calculating methods for PROGRAMMER calculator model.

*/

package calculator.model.functions;

public class MathFunctionsProgrammer extends MathFunctions
{

@Override public void oneArgMath( CalcArgument carg )
    {
    long a, b;
    try {
        a = carg.bdX1.longValueExact();
        }
    catch ( Exception e )
        {
        carg.bdY = null;
        return;
        }
    switch( carg.calcOp )
        {
        case NOT:   { b = ~ a; carg.bdY = carg.safeConvertLong( b );   break; }
        default:    { super.oneArgMath( carg );                        break; }
        }
    }


@Override public void twoArgMath( CalcArgument carg )
    {
    long a, b, c;
    boolean skipConversion = false;
    try {
        a = carg.bdX1.longValueExact();
        b = carg.bdX2.longValueExact();
        c = 0;
        }
    catch ( Exception e )
        {
        carg.bdY = null;
        return;
        }
    switch( carg.calcOp )
        {
        case SHL:  { c = a << b;   break; }
        case SHR:  { c = a >>> b;  break; }
        case AND:  { c = a & b;    break; }
        case OR:   { c = a | b;    break; }
        case XOR:  { c = a ^ b;    break; }
        default:   { super.twoArgMath( carg ); skipConversion = true;  break; }
        }
    if ( ! skipConversion )
        {
        carg.bdY = carg.safeConvertLong( c );
        }
    }
}
