/*

GUI panel and it components for select input radix mode,
used by PROGRAMMER calculator mode.

*/

package calculator.controller;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class CalcDisplayMarker extends JPanel
{
JRadioButton marker;

public JRadioButton getMarker()
    {
    return marker; 
    }

public void setMarker(JRadioButton r) 
    {
    marker = r;    
    }

public boolean getFlag()
    {
    return marker.isSelected();
    }

}
