/*

GUI panel and it components for SIMPLE calculator keyboard.

*/

package calculator.controller;

import calculator.controller.simplebuttons.*;
import javax.swing.JPanel;

public class CalcKeyboard extends JPanel
{

public CalcButton[][] getButtonsList()
    {
    CalcButton[][] list = new CalcButton[][]
        {
            { new ButtonCLR()       ,  // row 1
              new ButtonCLRERR()    ,
              new ButtonPlusMinus() ,
              new ButtonSQRT()      ,
              new ButtonPercent()   ,  
            } ,
            { new Button7()         ,  // row 2
              new Button8()         ,
              new Button9()         ,
              new ButtonPlus()      ,
              new ButtonMC()        ,  
            } ,
            { new Button4()         ,  // row 3
              new Button5()         ,
              new Button6()         ,
              new ButtonMinus()     ,
              new ButtonMR()        , 
            } ,
            { new Button1()         ,  // row 4
              new Button2()         ,
              new Button3()         ,
              new ButtonMultiply()  ,
              new ButtonMplus()     ,  
            } ,
            { new Button0()         ,  // row 5
              new ButtonPoint()     ,
              new ButtonEqual()     ,
              new ButtonDivide()    ,
              new ButtonMminus()    , 
            }
        };
    return list;
    }

public CalcRadio[] getRadioList()
    {
    return null;
    }

}
