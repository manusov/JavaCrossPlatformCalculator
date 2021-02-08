/*

GUI description for PROGRAMMER calculator.

*/

package calculator.view.guibuilders;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class GuiProgrammer extends GuiSimple
{
@Override public Dimension getGuiSize() 
    { 
    return new Dimension( 362, 420 ); 
    }

@Override public void setGui( JFrame frame, JPanel[] d, JPanel[] k )
    {
    Container c = frame.getContentPane();
    c.removeAll();
    SpringLayout s = new SpringLayout();
    c.setLayout( s );
    // Indicator 1, hexadecimal (EAST-EAST, 75 to 81 replaced 4 times)
    s.putConstraint( SpringLayout.NORTH, d[0],   1, SpringLayout.NORTH, c );
    s.putConstraint( SpringLayout.WEST , d[0],   1, SpringLayout.WEST , c );
    s.putConstraint( SpringLayout.EAST , d[0], -81, SpringLayout.EAST , c );
    c.add( d[0] );
    // Indicator 2, decimal
    s.putConstraint( SpringLayout.NORTH, d[1],  -1, SpringLayout.SOUTH, d[0] );
    s.putConstraint( SpringLayout.WEST , d[1],   1, SpringLayout.WEST , c );
    s.putConstraint( SpringLayout.EAST , d[1], -81, SpringLayout.EAST , c );
    c.add( d[1] );
    // Indicator 3, octal
    s.putConstraint( SpringLayout.NORTH, d[2],  -1, SpringLayout.SOUTH, d[1] );
    s.putConstraint( SpringLayout.WEST , d[2],   1, SpringLayout.WEST , c );
    s.putConstraint( SpringLayout.EAST , d[2], -81, SpringLayout.EAST , c );
    c.add( d[2] );
    // Indicator 4, binary
    s.putConstraint( SpringLayout.NORTH, d[3],  -1, SpringLayout.SOUTH, d[2] );
    s.putConstraint( SpringLayout.WEST , d[3],   1, SpringLayout.WEST , c );
    s.putConstraint( SpringLayout.EAST , d[3], -81, SpringLayout.EAST , c );
    c.add( d[3] );
    // Keyboard
    s.putConstraint( SpringLayout.NORTH, k[0],   1, SpringLayout.SOUTH, d[3] );
    s.putConstraint( SpringLayout.WEST , k[0],   0, SpringLayout.WEST , c );
    s.putConstraint( SpringLayout.EAST , k[0],   0, SpringLayout.EAST , c );
    s.putConstraint( SpringLayout.SOUTH, k[0],   0, SpringLayout.SOUTH, c );
    c.add( k[0] );
    // Toggler 1, hex input mode
    s.putConstraint( SpringLayout.NORTH, k[1],  -1, SpringLayout.NORTH, d[0] );
    s.putConstraint( SpringLayout.WEST , k[1],  -4, SpringLayout.EAST , d[0] );
    c.add( k[1] );
    // Toggler 2, decimal input mode
    s.putConstraint( SpringLayout.NORTH, k[2],  -1, SpringLayout.NORTH, d[1] );
    s.putConstraint( SpringLayout.WEST , k[2],  -4, SpringLayout.EAST , d[1] );
    c.add( k[2] );
    // Toggler 3, octal input mode
    s.putConstraint( SpringLayout.NORTH, k[3],  -1, SpringLayout.NORTH, d[2] );
    s.putConstraint( SpringLayout.WEST , k[3],  -4, SpringLayout.EAST , d[2] );
    c.add( k[3] );
    // Toggler 4, binary input mode
    s.putConstraint( SpringLayout.NORTH, k[4],  -1, SpringLayout.NORTH, d[3] );
    s.putConstraint( SpringLayout.WEST , k[4],  -4, SpringLayout.EAST , d[3] );
    c.add( k[4] );
    frame.setSize( getGuiSize() );
    }
}
