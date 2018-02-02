// Mathematics functions calculating methods for SCIENTIFIC calculator model.
// Factorial calculated as big decimal, but numbers lost possible,
// TODO: convert all operations to Universal Big Decimal Core (UBDC).

package calculator.model.functions;

import calculator.model.functions.CalcArgument.AngleRadio;
import static calculator.model.functions.FactorialUtil.factorial;

public class MathFunctionsScientific extends MathFunctions
{

@Override public void oneArgMath(CalcArgument carg)
    {
    double a = carg.bdX1.doubleValue();
    double b = 0.0;
    boolean skipConversion = false;
    
    if ( carg.isArgumentAngle() )
        {
        if (carg.angleRadio == AngleRadio.DEGREES ) 
            { a = carg.degreesToRadians(a); }
        if (carg.angleRadio == AngleRadio.GRADS )   
            { a = carg.gradsToRadians(a); }
        }
    
    switch(carg.calcOp)
        {
        case NF:       { carg.bdY = factorial(carg.bdX1); 
                         skipConversion = true;  
                                                             break; }
        case SIN:      { b = Math.sin(a);                    break; }
        case COS:      { b = Math.cos(a);                    break; }
        case TG:       { b = Math.tan(a);                    break; }
        case CTG:      { b = Math.cos(a) / Math.sin(a);      break; }
        case SEC:      { b = 1.0 / Math.cos(a);              break; }
        case COSEC:    { b = 1.0 / Math.sin(a);              break; }
        case ARCSIN:   { b = Math.asin(a);                   break; }
        case ARCCOS:   { b = Math.acos(a);                   break; }
        case ARCTG:    { b = Math.atan(a);                   break; }
        case ARCCTG:   { b = Math.PI / 2.0 - Math.atan(a);   break; }
        case ARCSEC:   { b = Math.acos(1/a);                 break; }
        case ARCCOSEC: { b = Math.asin(1/a);                 break; }
        case SH:       { b = Math.sinh(a);                   break; }
        case CH:       { b = Math.cosh(a);                   break; }
        case TH:       { b = Math.tanh(a);                   break; }
        case CTH:      { b = 1.0 / Math.tanh(a);             break; }
        case SECH:     { b = 1.0 / Math.cosh(a);             break; }
        case CSH:      { b = 1.0 / Math.sinh(a);             break; }
        case ARSH:     { b = Math.log
                            ( a + Math.sqrt( a * a + 1 ) );
                                                             break; }
        case ARCH:     { b = Math.log
                            ( a + Math.sqrt( a * a - 1 ) );
                                                             break; }
        case ARTH:     { b = 0.5 * Math.log
                            ( ( 1 + a ) / ( 1 - a ) );
                                                             break; }
        case ARCTH:    { b = 0.5 * Math.log
                            ( ( a + 1 ) / ( a - 1 ) );
                                                             break; }
        case ARSCH:    { b = Math.log
                            ( ( 1 + Math.sqrt( 1 - a * a ) ) / a );
                                                             break; }
        case ARCSCH:   {
                       if ( a == 0.0 )
                        {
                        b = Double.NaN;   
                        }
                       else if ( a < 0.0 )
                        {
                        b = Math.log
                            ( ( 1 - Math.sqrt( 1 + a * a ) ) / a );
                        }
                       else
                        {
                        b = Math.log
                           ( ( 1 + Math.sqrt( 1 + a * a ) ) / a );
                        }
                       break;
                       }
        case EXP:      { b = Math.exp(a);                    break; }
        case P10X:     { b = Math.pow(10.0, a);              break; }
        case LN:       { b = Math.log(a);                    break; }
        case LG:       { b = Math.log10(a);                  break; }
        case PX2:      { b = a * a;                          break; }
        case PI:       { b = Math.PI;                        break; }
        case EE:       { b = Math.E;                         break; }
        case D1X:      { 
                         // BigDecimal bd1 = new BigDecimal(1.0);
                         // carg.bdY = 
                         // bd1.divide(carg.bdX1, RoundingMode.HALF_UP );
                         // skipConversion = true;
                         b = 1.0 / carg.bdX1.doubleValue();
                         //
                                                             break; }
        default:       { super.oneArgMath(carg); 
                         skipConversion = true;  
                                                             break; }
        }
    
    if ( ! skipConversion )
        {
        if ( carg.isResultAngle() )
            {
            if (carg.angleRadio == AngleRadio.DEGREES ) 
                { b = carg.radiansToDegrees(b); }
            if (carg.angleRadio == AngleRadio.GRADS )   
                { b = carg.radiansToGrads(b); }
            }
        carg.bdY = carg.safeConvertDouble(b);
        }
    
    }


@Override public void twoArgMath(CalcArgument carg)
    {
    switch(carg.calcOp)
        {
        case MOD:   { carg.bdY = carg.bdX1.remainder(carg.bdX2);    break; }
        case PXY:   { double a = carg.bdX1.doubleValue();
                      double b = carg.bdX2.doubleValue();
                      double c = Math.pow(a, b);
                      carg.bdY = carg.safeConvertDouble(c);         break; }
        default:    { super.twoArgMath(carg);                       break; }
        }
    }


}
