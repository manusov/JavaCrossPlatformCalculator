/*

GUI panel and it components for SCIENTIFIC calculator keyboard.

*/

package calculator.controller;

import calculator.controller.simplebuttons.*;
import calculator.controller.scientificbuttons.*;
import calculator.controller.scientificradio.*;

public class CalcKeyboardScientific extends CalcKeyboard
{

@Override public CalcButton[][] getButtonsList()
    {
    CalcButton[][] list = new CalcButton[][]
        {
            { new ButtonCLR()       ,  // row 1
              new ButtonCLRERR()    ,
              new ButtonPlusMinus() ,
              new ButtonSQRT()      ,
              new ButtonPercent()   ,
              new ButtonMOD()       ,
            } ,  
            { new ButtonSIN()       ,  // row 2
              new ButtonCOS()       ,
              new ButtonTG()        ,
              new ButtonCTG()       ,
              new ButtonSEC()       ,
              new ButtonCOSEC()     ,
            } ,
            { new ButtonARCSIN()    ,  // row 3
              new ButtonARCCOS()    ,
              new ButtonARCTG()     ,
              new ButtonARCCTG()    ,
              new ButtonARCSEC()    ,  
              new ButtonARCCOSEC()  ,
            } ,
            { new ButtonSH()        ,  // row 4
              new ButtonCH()        ,
              new ButtonTH()        ,
              new ButtonCTH()       ,
              new ButtonSECH()      ,
              new ButtonCSH()       ,
            } ,
            { new ButtonARSH()      ,  // row 5
              new ButtonARCH()      ,
              new ButtonARTH()      ,
              new ButtonARCTH()     ,
              new ButtonARSCH()     ,
              new ButtonARCSCH()    ,
            } ,
            { new ButtonEXP()       ,  // row 6
              new Button10X()       ,
              new ButtonLN()        ,
              new ButtonLG()        ,
              new ButtonX2()        ,
              new ButtonXY()        ,
            } ,
            { new Button7()         ,  // row 7
              new Button8()         ,
              new Button9()         ,
              new ButtonPlus()      ,
              new ButtonMC()        ,
              new ButtonPI()        ,
            } ,
            { new Button4()         ,  // row 8
              new Button5()         ,
              new Button6()         ,
              new ButtonMinus()     ,
              new ButtonMR()        ,
              new ButtonEE()        ,
            } ,
            { new Button1()         ,  // row 9
              new Button2()         ,
              new Button3()         ,
              new ButtonMultiply()  ,
              new ButtonMplus()     ,
              new Button1X()        ,
            } ,
            { new Button0()         ,  // row 10
              new ButtonPoint()     ,
              new ButtonEqual()     ,
              new ButtonDivide()    ,
              new ButtonMminus()    ,
              new ButtonNF()       ,
            }
        };
    return list;
    }

@Override public CalcRadio[] getRadioList()
    {
    CalcRadio[] list = new CalcRadio[]
        {
        new RadioDegrees() ,
        new RadioRadians() ,
        new RadioGrads()   ,
        };
    return list;
    }

}


/*


// OLD VARIANT 10 X 6

@Override public CalcButton[][] getList()
    {
    CalcButton[][] list = new CalcButton[][]
        {
            { new ButtonCLR()       ,  // row 1
              new ButtonCLRERR()    ,
              new ButtonPlusMinus() ,
              new ButtonSQRT()      ,
              new ButtonPercent()   ,
              new ButtonEXP()       ,
              new ButtonSIN()       ,
              new ButtonARCSIN()    ,
              new ButtonSH()        ,
              new ButtonARSH()      ,
            } ,  
            { new ButtonPI()        ,  // row 2
              new ButtonEE()        ,
              new ButtonNF()        ,
              new ButtonX2()        ,
              new ButtonMOD()       ,
              new Button10X()       ,
              new ButtonCOS()       ,
              new ButtonARCCOS()    ,
              new ButtonCH()        ,
              new ButtonARCH()      ,
            } ,
            { new Button7()         ,  // row 3
              new Button8()         ,
              new Button9()         ,
              new ButtonPlus()      ,
              new ButtonMC()        ,  
              new ButtonLN()        ,
              new ButtonTG()        ,
              new ButtonARCTG()     ,
              new ButtonTH()        ,
              new ButtonARTH()      ,
            } ,
            { new Button4()         ,  // row 4
              new Button5()         ,
              new Button6()         ,
              new ButtonMinus()     ,
              new ButtonMR()        ,
              new ButtonLG()        ,
              new ButtonCTG()       ,
              new ButtonARCCTG()    ,
              new ButtonCTH()       ,
              new ButtonARCTH()     ,
            } ,
            { new Button1()         ,  // row 5
              new Button2()         ,
              new Button3()         ,
              new ButtonMultiply()  ,
              new ButtonMplus()     ,
              new ButtonXY()        ,
              new ButtonSEC()       ,
              new ButtonARCSEC()    ,
              new ButtonSECH()      ,
              new ButtonARSCH()     ,
            } ,
            { new Button0()         ,  // row 6
              new ButtonPoint()     ,
              new ButtonEqual()     ,
              new ButtonDivide()    ,
              new ButtonMminus()    ,
              new ButtonRND()       ,
              new ButtonCOSEC()     ,
              new ButtonARCCOSEC()  ,
              new ButtonCSH()       ,
              new ButtonARCSCH()    ,
            }
        };
    return list;
    }


*/