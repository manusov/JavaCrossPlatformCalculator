// Action handler for root menu: info about application.

package calculator.view.rootmenu;

import calculator.view.about.About;
import calculator.view.about.BuildAbout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class HandlerAbout extends AbstractAction
{
private final JFrame parentFrame;    
    
HandlerAbout(JFrame x1)
    {
    parentFrame = x1;
    }
    
@Override public void actionPerformed(ActionEvent e) 
    {
    BuildAbout about = new BuildAbout();
    final JDialog dialog = about.createDialog( null );
    dialog.setLocationRelativeTo( parentFrame );
    dialog.setVisible(true);    

    }  
}
