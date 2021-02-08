/*

Data MODEL for SIMPLE calculator,
This MODEL used and modified by CONTROLLER,
but with incapsulation, via CalcCore, not directly,
This MODEL visualized by VIEW,
but with incapsulation, via CalcCore, not directly.

*/

package calculator.model.state;

import calculator.model.functions.CalcArgument.AngleRadio;
import calculator.model.functions.CalcArgument.CalcModes;
import calculator.model.functions.CalcArgument.CalcOperations;
import calculator.model.functions.CalcArgument.RadixRadio;
import java.math.BigDecimal;

public class CalcState 
{
// data definitions
public enum LastKeyTypes    // type of last input key, for multi-operations support
    { UNKNOWN , OPERATION , EQUAL };

// data fields
private CalcModes mode = CalcModes.AUTO_POINT;
private CalcOperations operation = CalcOperations.NONE;
private LastKeyTypes lastKeyType = LastKeyTypes.UNKNOWN;
// error flag and result show mode,
// when result show: no extra right zeroes after "." and
// new input clear previous value
private boolean errorFlag = false;
private boolean resultShow = false;
// this for current operand
private String[] resultString = { "0" };
// first, second operands save at single and two-operand operations
// BD means BigDecimal type
private BigDecimal firstBD = null;
private BigDecimal secondBD = null;
// result of operation
private BigDecimal resultBD = null;
// this for calculator memory
private BigDecimal memoryBD = null;

// access methods for calculator options
public CalcModes getMode()                   { return mode;         }
public void setMode( CalcModes m )           { mode = m;            }
public CalcOperations getOperation()         { return operation;    }
public void setOperation( CalcOperations o ) { operation = o;       }
public LastKeyTypes getLastKeyType()         { return lastKeyType;  }
public void setLastKeyType( LastKeyTypes t ) { lastKeyType = t;     }
// access methods for mode and error flags
public boolean getErrorFlag()                { return errorFlag;    }
public void setErrorFlag( boolean b )        { errorFlag = b;       }
public boolean getResultShow()               { return resultShow;   }
public void setResultShow( boolean b )       { resultShow = b;      }
// access methods for result string
public String[] getResultStrings()           { return resultString; }
public void setResultStrings( String[] rs )  { resultString = rs;   }
// access methods for big decimal arguments and results
public BigDecimal getFirstBD()               { return firstBD;      }
public void setFirstBD( BigDecimal x )       { firstBD = x;         }
public BigDecimal getSecondBD()              { return secondBD;     }
public void setSecondBD( BigDecimal x )      { secondBD = x;        }
public BigDecimal getResultBD()              { return resultBD;     }
public void setResultBD( BigDecimal x )      { resultBD = x;        }
public BigDecimal getMemoryBD()              { return memoryBD;     }
public void setMemoryBD( BigDecimal x )      { memoryBD = x;        }
// this 3 access methods for childs optional functionality
public void setRadioEvent( int clicked )     {  }
public AngleRadio getCurrentAngle()          { return null; }
public RadixRadio getCurrentRadix()          { return null; }
}
