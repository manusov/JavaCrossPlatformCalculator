// Mathematics operation argument full representation, used for
// separate calculator control and fundamental operations support.

package calculator.model.functions;

import java.math.BigDecimal;

public class CalcArgument 
{

public enum CalcModes  // decimal point visual mode
    { POINT, NO_POINT, AUTO_POINT };

public enum CalcOperations  // operations list
    { 
    // Simple
    NONE, ADD, SUB, MUL, DIV, PERCENT, SQRT,
    // Scientific
    MOD,
    SIN, COS, TG, CTG, SEC, COSEC,
    ARCSIN, ARCCOS, ARCTG, ARCCTG, ARCSEC, ARCCOSEC,
    SH, CH, TH, CTH, SECH, CSH,
    ARSH, ARCH, ARTH, ARCTH, ARSCH, ARCSCH,
    EXP, P10X, LN, LG, PX2, PXY,
    PI, EE, D1X, NF,
    // Programmer
    SHL, SHR, AND, OR, XOR, NOT
    };

public enum AngleRadio { DEGREES, RADIANS, GRADS };
public enum RadixRadio { HEX, DECIMAL, OCTAL, BINARY };
public enum AllRadios  { R1, R2, R3, R4 };

// two arguments bdX1, bdX2 and result bdY
public BigDecimal bdX1, bdX2, bdY;

public CalcOperations calcOp;
public AngleRadio angleRadio;
public RadixRadio radixRadio;

public CalcArgument
        ( BigDecimal x1, BigDecimal x2,
          CalcOperations co, AngleRadio ar, RadixRadio rr )
    {
    bdX1 = x1;
    bdX2 = x2;
    bdY = null;
    calcOp = co;
    angleRadio = ar;
    radixRadio = rr;
    }

public boolean isOperationFloatOnly()
    {
    if ( (calcOp.compareTo(CalcOperations.SQRT)) == 0 ) return true;
    if ( (calcOp.compareTo(CalcOperations.SIN)) < 0   ) return false;
    return (calcOp.compareTo(CalcOperations.D1X)) <= 0;
    }

public boolean isOperationIntegerOnly()
    {
    if ( (calcOp.compareTo(CalcOperations.SHL)) < 0   ) return false;
    return (calcOp.compareTo(CalcOperations.NOT)) <= 0;
    }

public boolean isArgumentAngle()
    {
    return (  ((calcOp.compareTo(CalcOperations.SIN))>=0)   & 
              ((calcOp.compareTo(CalcOperations.COSEC))<=0) ) |
           (  ((calcOp.compareTo(CalcOperations.SH))>=0)    & 
              ((calcOp.compareTo(CalcOperations.CSH))<=0)   );
    }

public boolean isResultAngle()
    {
    return (  ((calcOp.compareTo(CalcOperations.ARCSIN))>=0)   & 
              ((calcOp.compareTo(CalcOperations.ARCCOSEC))<=0) ) |
           (  ((calcOp.compareTo(CalcOperations.ARSH))>=0)     & 
              ((calcOp.compareTo(CalcOperations.ARCSCH))<=0)   );
    }

public double degreesToRadians(double x)
    {
    return x * ( Math.PI / 180.0 );
    }

public double gradsToRadians(double x)
    {
    return x * ( Math.PI / 200.0 );
    }

public double radiansToDegrees(double x)
    {
    return x * ( 180.0 / Math.PI );
    }

public double radiansToGrads(double x)
    {
    return x * ( 200.0 / Math.PI );
    }

public BigDecimal safeConvertDouble(double x)
    {
    BigDecimal y;
    try {
        y = BigDecimal.valueOf(x);
        }
    catch (Exception e)
        {
        y = null;
        }
    return y;
    }

public BigDecimal safeConvertLong(long x)
    {
    BigDecimal y = BigDecimal.valueOf(x);
    return y;
    }

}
