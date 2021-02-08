/*

GUI panel and it components for PROGRAMMER calculator keyboard.

*/

package calculator.controller;

import calculator.controller.simplebuttons.*;
import calculator.controller.programmerbuttons.*;
import calculator.controller.programmerradio.*;

public class CalcKeyboardProgrammer extends CalcKeyboard
{

@Override public CalcButton[][] getButtonsList()
    {
    CalcButton[][] list = new CalcButton[][]
        {
            { new ButtonCLR()       ,  // row 1
              new ButtonCLRERR()    ,
              new ButtonPlusMinus() ,
              new ButtonSHL()       ,
              new ButtonSHR()       ,  
            } ,
            { new ButtonD()         ,  // row 2
              new ButtonE()         ,
              new ButtonF()         ,
              new ButtonAND()       ,
              new ButtonOR()        ,
            } ,
            { new ButtonA()         ,  // row 3
              new ButtonB()         ,
              new ButtonC()         ,
              new ButtonXOR()       ,
              new ButtonNOT()       ,
            } ,
            { new Button7()         ,  // row 4
              new Button8()         ,
              new Button9()         ,
              new ButtonPlus()      ,
              new ButtonMC()        ,  
            } ,
            { new Button4()         ,  // row 5
              new Button5()         ,
              new Button6()         ,
              new ButtonMinus()     ,
              new ButtonMR()        , 
            } ,
            { new Button1()         ,  // row 6
              new Button2()         ,
              new Button3()         ,
              new ButtonMultiply()  ,
              new ButtonMplus()     ,  
            } ,
            { new Button0()         ,  // row 7
              new ButtonPoint()     ,
              new ButtonEqual()     ,
              new ButtonDivide()    ,
              new ButtonMminus()    , 
            }
        };
    return list;
    }

@Override public CalcRadio[] getRadioList()
    {
    CalcRadio[] list = new CalcRadio[]
        {
        new RadioHex()     ,
        new RadioDecimal() ,
        new RadioOctal()   ,
        new RadioBinary()  ,
        };
    return list;
    }
}
