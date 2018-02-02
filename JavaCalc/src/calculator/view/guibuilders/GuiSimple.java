// GUI description for SIMPLE calculator.

package calculator.view.guibuilders;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GuiSimple 
{
public Dimension getGuiSize() 
    {
    return new Dimension(355, 340); 
    }

public void setGui( JFrame frame, JPanel[] d, JPanel[] k )
    {
    Container c = frame.getContentPane();
    c.removeAll();
    c.setLayout(new BorderLayout());
    c.add( d[0] , BorderLayout.NORTH  );
    c.add( k[0] , BorderLayout.CENTER );
    frame.setSize(getGuiSize());
    }
}
