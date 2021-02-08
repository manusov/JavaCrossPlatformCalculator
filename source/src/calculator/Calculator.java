/*

Java Simple/Scientific/Programmer Calculator. 
(C)2021 IC Book Labs.
(C)2021 Manusov I.V.
This project can be prepared as part of Benchmarks Integrator.
----------------------------------------------------------------
Main class with application entry point.

*/

package calculator;

import calculator.view.about.About;
import calculator.controller.KeyboardFabric;
import calculator.model.core.CalcCore;
import calculator.model.core.CoreFabric;
import calculator.view.display.CalcDisplay;
import calculator.view.display.DisplayFabric;
import calculator.view.rootmenu.RootMenu;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Calculator
{
    
public enum CALCS { SIMPLE , SCIENTIFIC , PROGRAMMER };
private static final CALCS[] CALC_LIST = 
    { CALCS.SIMPLE , CALCS.SCIENTIFIC , CALCS.PROGRAMMER };

private static CalcCore[] cores;
private static CalcDisplay[][] displays;
private static JPanel[][] controls;
private static RootMenu rootMenu;

public static void main( String[] args ) 
    {
    int n = CALC_LIST.length;
    cores = new CalcCore[n];
    displays = new CalcDisplay[n][];
    controls = new JPanel[n][];
    
    // cycle for all modes: simple, scientific, programmer
    for(int i=0; i<n; i++)
        {
        // Initializing MVC.MODEL
        cores[i] = CoreFabric.getCalculatorCore
            ( CALC_LIST[i] );
        // Initializing MVC.VIEW
        displays[i] = DisplayFabric.getCalculatorDisplays
            ( CALC_LIST[i] );
        // Initializing MVC.CONTROLLER
        controls[i] = KeyboardFabric.getCalculatorKeyboards
            ( CALC_LIST[i], cores[i], displays[i] );
        // Synchronize MODEL and VIEW
            for ( int j=0; j<displays[i].length; j++ )    
                {
                displays[i][j].updateDisplay( cores[i], j );
                }
        }

    // Start GUI
    JFrame.setDefaultLookAndFeelDecorated( true );
    JDialog.setDefaultLookAndFeelDecorated( true );
    rootMenu = new RootMenu( About.getShortName() , displays , controls );
    rootMenu.startApplication();
    }
}
