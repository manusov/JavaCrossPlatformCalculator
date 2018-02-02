// Parent class for buttons and operations description classes.

package calculator.controller;

import calculator.model.core.CalcCore;
import java.awt.Color;
import java.awt.Font;

public abstract class CalcButton
{
// constants

protected final static int CHARS_LIMIT = 30;

protected final static Color CLR_CUSTOM_COLOR      = Color.RED;
protected final static Color EQUAL_CUSTOM_COLOR    = new Color(1, 145, 1);
protected final static Color FUNCTION_CUSTOM_COLOR = new Color(5, 5, 190);

protected final static Font  CLR_CUSTOM_FONT = 
        new Font("Verdana", Font.PLAIN, 15);
protected final static Font  EQUAL_CUSTOM_FONT = 
        new Font("Verdana", Font.BOLD, 28);
protected final static Font  MATH_CUSTOM_FONT = 
        new Font("Times New Roman", Font.ITALIC, 14);

// public abstract methods
public abstract String getName();  // get string for button name
public abstract String getText();  // get string for tooltips output
public abstract int[] getKeys();   // get keyboard keys for press this button

// public optional supported methods
public Color getCustomColor() { return null; }  // get custom color for button
public Font getCustomFont()   { return null; }  // get custom font for button

// public abstract method: operation when press buttons
public abstract void buttonAction(CalcCore cc);
}

