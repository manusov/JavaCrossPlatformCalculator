/*

Java Simple Calculator. 
(C)IC Book Labs.
(C)2018 Manusov I.V.

Main class with application entry point.

SECOND SAMPLE USES FRAME AND PANELS SIMPLE FABRICS.
FROM 10-12-2017 USE MODEL-VIEW-CONTROLLER (MVC) PATTERN.

REQUIRED BUGS FIXES AND ADDITIONS:
1)  COMMENT CODE.
2)  KEYBOARD EVENTS.
3)  FOR PRECISION, GET NUMBERS WHEN RECALL, NOT STRING (OR BAD VISUAL ?)
4)  NON-SIGNED ZEROES.
5)  ADD OPTIONS PANEL, EXAMPLE CONTROLLER1, CONTROLLER2.
6)  SOME LOGIC MUST BE MOVED FROM CONTROLLER TO MODEL.
7)  DECIMAL SEPARATOR '.' BETTER AS PARAMETER, NOT FIXED CHAR(S).
8)  OR SET LOCALE FOR USE "." ONLY, THIS MEANS REMOVE "," ADDITIONS.
9)  REPLACE STRINGS TO STRING BUFFERS IF MANY MODIFICATIONS.
10) FOREGROUND COLOR FOR DISABLED BUTTON (INDICATOR).

FIRST STEPS (ONE WEEK):

1)+ v0.04.
   Buttons for 3 modes: simple, scientific, programmer. HTML text strings,
   include HTML strings for special cases,
   bug when KeyboardFabric ignores font, CLR must be RED and BIG.

2)+ v0.05.
   Multi-indicator display for programmer mode (hex, decimal, octal, binary),
   viewPanels, ctrlPanels at root level, as JPanel[], 
   make arrays of components instead single components:
   change to CalcDisplay[] displays,
   change to CalcKeyboard[] keyboards.

3)+ v0.06.
   Togglers in the programmer display: select input mode.

4)+ v0.07.
   Togglers in the scientific display: select radians/degrees ...

5)+ v0.08.
   Root menu with calculator 3 modes select: simple, scientific, programmer,
   or tabs panel.
   5.1) DELETE UNUSED FILES-CLASSES.
   5.2) DELETE UNUSED CODE BLOCKS, LOCKED BY COMMENTS.

6)+ v0.09.
   About, picture and site link window.

7) v0.10 - v0.20,
   Math operations in the data model, 
   select result string centering for different modes (make this in view),
   add "h" , "o" , "b" for hex, octal, binary,
   update model state = f(togglers) in the existed controller,
   when buttons pressed,
   no separate events for radio buttons?
   VERIFICATION, COMMENTS, CLEAR OLD LOCKED CODE.
   FACTORIAL BUG. SEE FLOATING ARGUMENT AND RESULT.
   FACTORIAL OVERFLOW BUG.
   REMOVE UNUSED OPERANDS AT oneArgMath(), twoArgMath().

   BUG WITH "+" AND "-" AT FLOATING POINT CORRECTOR
   FLOATING POINT CORRECTOR FOR NEGATIVE NUMBERS.

   FIRST, MAKE FACTORIAL BY BIG DECIMAL (1 day).
   FACTORIAL ARGUMENT-DEPENDENT BUGS.

   REFACTOR WITH BIG INTEGER, BIG DECIMAL INSTEAD COMPLEX CORRECTORS (1 day).

   TODO:
   Use BigDecimal to prevent precision loss.
   Convert all operations to Universal Big Decimal Core (UBDC),
   yet converted factorial only.

   TODO ( ! ) 
   Better, refactor current calculator code, 
   remove LONG, DOUBLE, TOBITS(yet),
   after separate debug session.
   Rewrite 13 classes at calculator.model.* package.
   Integrate to CPUID v0.53 ?
   Integrate to Graphs Drawings ?


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

public static void main(String[] args) 
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
            for (int j=0; j<displays[i].length; j++)    
                {
                displays[i][j].updateDisplay(cores[i], j);
                }
        }

    // Start GUI
    JFrame.setDefaultLookAndFeelDecorated(true);
    JDialog.setDefaultLookAndFeelDecorated(true);
    rootMenu = new RootMenu( About.getShortName() , displays , controls );
    rootMenu.startApplication();
    }
}
