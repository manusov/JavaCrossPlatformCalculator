/*

Helper method for factorial calculation.

*/

package calculator.model.functions;

import java.math.BigDecimal;

public class FactorialUtil 
{

public static BigDecimal factorial( BigDecimal bdx )
    {
    int x;
    BigDecimal bdy;
    try { x = bdx.intValueExact();  }   // conversion with check errors
    catch ( Exception e ) { x = -1; }   // mark error if float or negative
    if ( x < 0 )
        {
        bdy = null;
        }
    else
        {
        bdy = BigDecimal.ONE;
        for( int i=2; i<=x; i++ )
            {
            bdy = bdy.multiply( new BigDecimal( i ) );
            }
        }
    return bdy;    
    }
}
