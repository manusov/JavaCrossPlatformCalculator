// Action handler for root menu: calculator mode select.

package calculator.view.rootmenu;

import calculator.view.guibuilders.GuiSimple;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

public class HandlerMode implements ActionListener 
{

private final JFrame frame;
private final JRadioButtonMenuItem simple, scientific, programmer;
private final GuiSimple guiSimple, guiScientific, guiProgrammer;
private final JPanel[][] displays, controls;
    
HandlerMode( JFrame x1 , JPanel[][] x2 , JPanel[][] x3 ,
             JRadioButtonMenuItem y1 , 
             JRadioButtonMenuItem y2 , 
             JRadioButtonMenuItem y3 ,
             GuiSimple z1            ,
             GuiSimple z2            ,
             GuiSimple z3            )
    {
    frame = x1;
    displays = x2;
    controls = x3;
    simple = y1;
    scientific = y2;
    programmer = y3;
    guiSimple = z1;
    guiScientific = z2;
    guiProgrammer = z3;
    }
    
@Override public void actionPerformed(ActionEvent e)
    {
    Object x = e.getSource();
    if ( x instanceof JRadioButtonMenuItem )
        {
        if ( simple.isSelected() )      
            { guiSimple.setGui( frame, displays[0], controls[0] ); }
        if ( scientific.isSelected() )  
            { guiScientific.setGui( frame, displays[1], controls[1] ); }
        if ( programmer.isSelected() )  
            { guiProgrammer.setGui( frame, displays[2], controls[2] ); }
        }
    frame.revalidate();
    }
}
