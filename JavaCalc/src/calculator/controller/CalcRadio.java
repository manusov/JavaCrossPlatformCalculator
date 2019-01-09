/*

Parent class for radio buttons description classes.

*/

package calculator.controller;

import calculator.model.core.CalcCore;

public abstract class CalcRadio 
{
public abstract String getName();  // get string for radio button name
public abstract String getText();  // get string for tooltips output
public abstract int[] getKeys();   // get keyboard combination for press this
public abstract boolean getDefaultState();  // get default state: selected/no
public abstract void radioAction(CalcCore cc);  // operation when click radio
}
