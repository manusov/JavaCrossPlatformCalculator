/*

Operations set for PROGRAMMER calculator model.

*/

package calculator.model.core;

import static calculator.model.core.FloatPrintUtil.printCorrectedBigDecimal;
import calculator.model.functions.CalcArgument.RadixRadio;
import calculator.model.functions.MathFunctionsProgrammer;
import calculator.model.state.CalcStateProgrammer;
import java.math.BigDecimal;
import java.util.Locale;

public class CalcCoreProgrammer extends CalcCore
{

private final static int CHARS_LIMIT_HEX     = 17;
private final static int CHARS_LIMIT_DECIMAL = 21;
private final static int CHARS_LIMIT_OCTAL   = 21;
private final static int CHARS_LIMIT_BINARY  = 50;
    
CalcCoreProgrammer()
    {
    cs = new CalcStateProgrammer();
    mf = new MathFunctionsProgrammer();
    }

@Override public void inputDigit( int num )
    {
    if ( cs.getResultShow() )
        {
        String[] clearResult = ( (CalcStateProgrammer)cs ).CLEAR_MULTI_RADIX;
        int n = clearResult.length;
        String[] rs = new String[n];
        System.arraycopy( clearResult, 0, rs, 0, n );
        cs.setResultStrings( rs );
        }
    cs.setResultShow(false);
    
    RadixRadio rr = cs.getCurrentRadix();
    String[] rs = cs.getResultStrings();
    if ( ( rr == null ) | ( rs == null ) ) return;
    String s;
    switch(rr)
        {
        
        case HEX:
            {
            s = rs[0];
            if ( (num>=0) && (num<=15) && (s!=null) && (s.length()>1) )
                {
                s = s.replaceAll( "h", "" );
                if ( s.equals("0")) { s = ""; }
                s = s + String.format( "%X", num );
                if ( s.length() < CHARS_LIMIT_HEX ) { rs[0] = s + "h"; }
                try { 
                    long value = Long.parseLong(s, 16); 
                    rs[1] = Long.toString(value);
                    rs[2] = Long.toOctalString(value);
                    rs[3] = Long.toBinaryString(value);
                    }
                catch ( NumberFormatException e ) { }
                }
            break;
            }
            
        case DECIMAL:
            {
            s = rs[1];
            if ( (num>=0) && (num<=9) && (s!=null) && (s.length()>0) )
                {
                if ( s.equals( "0" )) { s = ""; }
                s = s + String.format( "%d", num );
                if ( s.length() <= CHARS_LIMIT_DECIMAL ) { rs[1] = s; }
                try { 
                    rs[0] = rs[2] = rs[3] = "?";
                    long value = Long.parseLong( s, 10 ); 
                    rs[0] = Long.toHexString( value ).toUpperCase();
                    rs[2] = Long.toOctalString( value );
                    rs[3] = Long.toBinaryString( value );
                    }
                catch ( NumberFormatException e ) { }
                }
            break;
            }
            
        case OCTAL:
            {
            s = rs[2];
            if ( (num>=0) && (num<=7) && (s!=null) && (s.length()>1) )
                {
                s = s.replaceAll( "o", "" );
                if ( s.equals( "0" )) { s = ""; }
                s = s + String.format( "%o", num );
                if ( s.length() < CHARS_LIMIT_OCTAL ) { rs[2] = s + "o"; }
                try { 
                    rs[0] = rs[1] = rs[3] = "?";
                    long value = Long.parseLong( s, 8 ); 
                    rs[0] = Long.toHexString( value ).toUpperCase();
                    rs[1] = Long.toString( value );
                    rs[3] = Long.toBinaryString( value );
                    }
                catch ( NumberFormatException e ) { }
                }
            break;
            }
            
        case BINARY:
            {
            s = rs[3];
            if ( (num>=0) && (num<=1) && (s!=null) && (s.length()>1) )
                {
                s = s.replaceAll( "b", "" );
                s = s + Integer.toBinaryString( num );
                if ( s.length() < CHARS_LIMIT_BINARY ) { rs[3] = s + "b"; }
                try { 
                    rs[0] = rs[1] = rs[2] = "?";
                    long value = Long.parseLong( s, 2 ); 
                    rs[0] = Long.toHexString( value ).toUpperCase();
                    rs[1] = Long.toString( value );
                    rs[2] = Long.toOctalString( value );
                    }
                catch ( NumberFormatException e ) { }
                }
            break;
            }
        }
    }


@Override public void inputPoint()
    {
    RadixRadio rr = cs.getCurrentRadix();
    String[] rs = cs.getResultStrings();
    if ( ( rr == null ) | ( rs == null ) ) return;
    switch( rr )
        {
        case DECIMAL:
            {
            if ( cs.getResultShow() )
                {
                rs[1] = "0";
                }
            cs.setResultShow( false );
            String s = rs[1];
            int n = s.length();
            boolean b = s.contains( "." ) || s.contains( "," );
            if ( ( n < CHARS_LIMIT_DECIMAL ) && ( !b ) )
                {
                s = s + ".";
                rs[1] = s;
                rs[0] = rs[2] = rs[3] = "?";
                }
            }
        }
    }


@Override public void acceptFirstOperand()
    {
    String[] rs = cs.getResultStrings();
    String s = rs[1];
    BigDecimal bd = null;
    try  {
         bd = new BigDecimal( s );
         }
    catch ( Exception e )
         {
         cs.setErrorFlag( true );
         }
    cs.setFirstBD(bd);
    }


@Override public void acceptSecondOperand()
    {
    String[] rs = cs.getResultStrings();
    String s = rs[1];
    BigDecimal bd = null;
    try  {
         bd = new BigDecimal( s );
         }
    catch ( Exception e )
         {
         cs.setErrorFlag( true );
         }
    cs.setSecondBD( bd );
    }


@Override public void printResult()
    {
    String s0, s1, s2, s3;
    s0 = s1 = s2 = s3 = "ERROR";
    boolean b = cs.getErrorFlag();
    if ( !b )
        {
        boolean result = cs.getResultShow();
        BigDecimal bd = cs.getResultBD();
        if ( bd != null )
            {
            long n = bd.longValue();
            s0 = String.format( Locale.US, "%016Xh", n );  // hex
            s1 = printCorrectedBigDecimal( bd, result );   // decimal
            s2 = String.format( Locale.US, "%oo", n );     // octal
            s3 = Long.toBinaryString(n) + "b";             // binary
            }
        }
    String[] rs = new String[4];
    rs[0] = s0;
    rs[1] = s1;
    rs[2] = s2;
    rs[3] = s3;
    cs.setResultStrings( rs );    
    }


@Override public void changeSign()
    {
    RadixRadio rr = cs.getCurrentRadix();
    String[] rs = cs.getResultStrings();
    if ( ( rr == null ) | ( rs == null ) ) return;
    switch(rr)
        {
        case DECIMAL:
            {
            String s = rs[1];
            int n = s.length();
            if ( ( n > 0 ) && ( n < CHARS_LIMIT_DECIMAL ) )
                {
                char c = s.charAt(0);
                if ( ( n > 1 ) || ( c != '0' ) )
                    {
                    switch(c)
                        {
                        case '+':
                            {
                            s = s.replace( c, '-' );
                            break;
                            }
                        case '-':
                            {
                            s = s.replace( c, '+' );
                            break;
                            }
                        default:
                            {
                            s = "-" + s;
                            break;
                            }
                        }
                    rs[1] = s;
                    }
                }
            }
        }
    }


@Override public void clearCalc()
    {
    super.clearCalc();
    String[] clearResult = ( (CalcStateProgrammer)cs ).CLEAR_MULTI_RADIX;
    int n = clearResult.length;
    String[] rs = new String[n];
    System.arraycopy( clearResult, 0, rs, 0, n );
    cs.setResultStrings( rs );
    }

@Override public void clearError()
    {
    super.clearError();
    String[] clearResult = ( (CalcStateProgrammer)cs ).CLEAR_MULTI_RADIX;
    int n = clearResult.length;
    String[] rs = new String[n];
    System.arraycopy( clearResult, 0, rs, 0, n );
    cs.setResultStrings( rs );
    }
}
