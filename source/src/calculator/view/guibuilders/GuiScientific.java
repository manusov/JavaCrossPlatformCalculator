/*

GUI description for SCIENTIFIC calculator.

*/

package calculator.view.guibuilders;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class GuiScientific extends GuiSimple
{
@Override public Dimension getGuiSize() 
    {
    return new Dimension( 594, 450 ); 
    }

@Override public void 
    setGui( JFrame frame, JPanel[] d, JPanel[] k )
    {
    Container c = frame.getContentPane();
    c.removeAll();
    SpringLayout s = new SpringLayout();
    c.setLayout( s );
    // Indicator
    s.putConstraint( SpringLayout.NORTH, d[0],   1, SpringLayout.NORTH, c );
    s.putConstraint( SpringLayout.WEST , d[0],   1, SpringLayout.WEST , c );
    s.putConstraint( SpringLayout.EAST , d[0],  -1, SpringLayout.EAST , c );
    c.add( d[0] );
    // Toggler 1, degrees argument mode
    s.putConstraint( SpringLayout.NORTH, k[1],   1, SpringLayout.SOUTH, d[0] );
    s.putConstraint( SpringLayout.WEST , k[1],  10, SpringLayout.WEST , c    );
    c.add( k[1] );
    // Toggler 2, radians argument mode
    s.putConstraint( SpringLayout.NORTH, k[2],   1, SpringLayout.SOUTH, d[0] );
    s.putConstraint( SpringLayout.WEST , k[2],   0, SpringLayout.EAST , k[1] );
    c.add( k[2] );
    // Toggler 3, grads argument mode
    s.putConstraint( SpringLayout.NORTH, k[3],   1, SpringLayout.SOUTH, d[0] );
    s.putConstraint( SpringLayout.WEST , k[3],   0, SpringLayout.EAST , k[2] );
    c.add( k[3] );
    // Keyboard
    s.putConstraint( SpringLayout.NORTH, k[0],   1, SpringLayout.SOUTH, k[3] );
    s.putConstraint( SpringLayout.WEST , k[0],   0, SpringLayout.WEST , c );
    s.putConstraint( SpringLayout.EAST , k[0],   0, SpringLayout.EAST , c );
    s.putConstraint( SpringLayout.SOUTH, k[0],   0, SpringLayout.SOUTH, c );
    c.add( k[0] );
    frame.setSize( getGuiSize() );
    }    
}
