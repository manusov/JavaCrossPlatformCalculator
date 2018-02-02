// Operations set for SIMPLE calculator model,
// this operations set can be used by some different controllers, 
// depend on calculator keyboard type.

package calculator.model.core;

import static calculator.model.core.FloatPrintUtil.printCorrectedBigDecimal;
import calculator.model.functions.CalcArgument;
import calculator.model.functions.CalcArgument.AllRadios;
import calculator.model.functions.CalcArgument.AngleRadio;
import calculator.model.functions.CalcArgument.CalcModes;
import calculator.model.functions.CalcArgument.CalcOperations;
import calculator.model.functions.CalcArgument.RadixRadio;
import calculator.model.functions.MathFunctions;
import calculator.model.state.CalcState;
import calculator.model.state.CalcState.LastKeyTypes;
import java.math.BigDecimal;

public class CalcCore 
{
CalcState cs;
MathFunctions mf;

// constants

private final static int CHARS_LIMIT = 30;

// constructor with data model initialization

CalcCore()
    {
    cs = new CalcState();
    mf = new MathFunctions();
    }

// operations with model, associated with calculator keyboard events

// input digit [0-9]
// num = digit as integer
public void inputDigit(int num)
    {
    String[] rs = new String[1];
    String s = "0";
    rs[0] = s;
    if ( cs.getResultShow() )  // clear if now visualized previous result
        {
        cs.setResultStrings(rs);
        }
    cs.setResultShow(false);
    rs = cs.getResultStrings();
    s = rs[0];
    int n = s.length();
    if ( ( n == 1 ) && ( s.charAt(0) == '0' ) )
        {  // this input to just-cleared indicator
        s = "" + num;
        rs[0] = s;
        cs.setResultStrings(rs);
        }
    else if ( n < CHARS_LIMIT )
        {  // this input for input continue
        s = s + num;
        rs[0] = s;
        cs.setResultStrings(rs);
        }
    }

// input decimal point
public void inputPoint()
    {
    String[] rs = new String[1];
    String s = "0";
    rs[0] = s;
    if ( cs.getResultShow() )
        {
        cs.setResultStrings(rs);
        }
    cs.setResultShow(false);
    rs = cs.getResultStrings();
    s = rs[0];
    int n = s.length();
    boolean b = s.contains(".") || s.contains(",");
    if ( ( n < CHARS_LIMIT ) && (!b) )
        {
        s = s + ".";
        rs[0] = s;
        cs.setResultStrings(rs);
        }
    }

// convert string after input to big decimal number
public void acceptFirstOperand()
    {
    String[] rs = cs.getResultStrings();
    String s = rs[0];
    BigDecimal bd = null;
    try  {
         bd = new BigDecimal(s);
         }
    catch (Exception e)
         {
         cs.setErrorFlag(true);
         }
    cs.setFirstBD(bd);
    }

// convert string after input to big decimal number
public void acceptSecondOperand()
    {
    String[] rs = cs.getResultStrings();
    String s = rs[0];
    BigDecimal bd = null;
    try  {
         bd = new BigDecimal(s);
         }
    catch (Exception e)
         {
         cs.setErrorFlag(true);
         }
    cs.setSecondBD(bd);
    }

// shifts first (previous) input into back position
// prepare for second input
public void shiftFirstOperand()
    {
    acceptFirstOperand();
    cs.setResultBD(BigDecimal.ZERO);
    cs.setResultShow(true);    
    }

// shifts second (previous) input into back position
// prepare for make operation
public void shiftSecondOperand()
    {
    acceptSecondOperand();
    cs.setResultBD(BigDecimal.ZERO);
    cs.setResultShow(true);    
    }

// build string in the model for print value
public void printResult()
    {
    String s = "ERROR";
    boolean b = cs.getErrorFlag();
    if (!b)
        {
        boolean result = cs.getResultShow();
        s = printCorrectedBigDecimal( cs.getResultBD(), result );
        }
    String[] rs = new String[1];
    rs[0] = s;
    cs.setResultStrings(rs);    
    }

// clear calculator state, support functionality of "C" button
public void clearCalc()
    {
    cs.setMode(CalcModes.AUTO_POINT);
    cs.setOperation(CalcOperations.NONE);
    cs.setLastKeyType(LastKeyTypes.UNKNOWN);
    cs.setErrorFlag(false);
    cs.setResultShow(false);
    
    cs.setResultBD(BigDecimal.ZERO);
    cs.setFirstBD(BigDecimal.ZERO);
    cs.setSecondBD(BigDecimal.ZERO);
    cs.setMemoryBD(BigDecimal.ZERO);
    
    String[] rs = new String[1];
    rs[0] = "0";
    cs.setResultStrings(rs);
    }

// clear last error input, support functionality of "CE" button
public void clearError()
    {
    cs.setErrorFlag(false);
    cs.setResultBD(BigDecimal.ZERO);
    String[] rs = new String[1];
    rs[0] = "0";
    cs.setResultStrings(rs);
    }

private void twiceOps()
    {
    if ( cs.getLastKeyType() == LastKeyTypes.OPERATION )
        {
        executeEqual();
        shiftFirstOperand();
        }
    else
        {
        cs.setLastKeyType(LastKeyTypes.OPERATION);
        shiftFirstOperand();
        shiftSecondOperand();
        }
    }

// operation for two operands, y=f(x1, x2), for example y=x1+x2;
public void opTwoOperands(CalcOperations co)
    {
    twiceOps();
    cs.setOperation(co);
    }

// operation for single operand, y=f(x), for example y=sqrt(x)
public void opOneOperand(CalcOperations co)
    {
    // get one operand
    acceptFirstOperand();
    // prepare arguments
    AngleRadio ar = cs.getCurrentAngle();
    RadixRadio rr = cs.getCurrentRadix();
    BigDecimal x = cs.getFirstBD();
    // build argument class and call
    CalcArgument carg = new CalcArgument( x, null, co, ar, rr );
    mf.oneArgMath(carg);
    // interpreting results, print indication string
    cs.setResultBD(carg.bdY);
    cs.setResultShow(true);
    printResult();
    }

// change sign +/-
public void changeSign()
    {
    String[] rs = cs.getResultStrings();
    String s = rs[0];
    int n = s.length();
    if ( ( n > 0 ) && ( n < CHARS_LIMIT ) )
        {
        char c = s.charAt(0);
        if ( ( n > 1 ) || ( c != '0' ) )
            {
            switch(c)
                {
                case '+':
                    {
                    s = s.replace(c, '-');
                    break;
                    }
                case '-':
                    {
                    s = s.replace(c, '+');
                    break;
                    }
                default:
                    {
                    s = "-" + s;
                    break;
                    }
                }
            rs[0] = s;
            cs.setResultStrings(rs);
            }
        }
    }

// operation memory clear
public void memoryClear()
    {
    cs.setMemoryBD(BigDecimal.ZERO);
    }

// operation memory recall
public void memoryRecall()
    {
    cs.setResultBD( cs.getMemoryBD() );
    printResult();    
    cs.setResultShow(true);
    }

// operation add to memory
public void memoryPlus()
    {
    shiftFirstOperand();
    cs.setMemoryBD( cs.getMemoryBD().add( cs.getFirstBD() ) );
    }

// operation add to memory
public void memoryMinus()
    {
    shiftFirstOperand();
    cs.setMemoryBD( cs.getMemoryBD().subtract(cs.getFirstBD() ) );
    }

// operation for equal ("=") key, execute pre-selected operation
public void executeEqual()
    {
    cs.setLastKeyType(LastKeyTypes.EQUAL);    
    
    if ( cs.getResultShow() ) 
        {
        acceptFirstOperand(); 
        }
    else
        { 
        acceptSecondOperand(); 
        }

    // prepare arguments    
    CalcOperations co = cs.getOperation();
    AngleRadio ar = cs.getCurrentAngle();
    RadixRadio rr = cs.getCurrentRadix();
    BigDecimal x1 = cs.getFirstBD();
    BigDecimal x2 = cs.getSecondBD();
    // build argument class and call
    CalcArgument carg = new CalcArgument( x1, x2, co, ar, rr );
    mf.twoArgMath(carg);
    // interpreting results and print indicator
    cs.setResultBD(carg.bdY);
    cs.setResultShow(true);
    printResult();    
    }

// get text string for visual indicator
public String[] getIndicator()
    {
    return cs.getResultStrings();
    }

// set state by radio button event
public void setOption(AllRadios ar)
    {
    int clicked = ar.ordinal();
    cs.setRadioEvent(clicked);
    }

}
