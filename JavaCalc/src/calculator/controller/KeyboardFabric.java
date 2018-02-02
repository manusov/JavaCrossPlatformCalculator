// Fabric for calculator keyboard panel.

package calculator.controller;

import calculator.Calculator.CALCS;
import calculator.model.core.CalcCore;
import calculator.view.display.CalcDisplay;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ButtonGroup;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.KeyStroke;

public class KeyboardFabric 
{

// builds CONTROLLER, uses as input parameters:
// DisplayState = MODEL, CalculatorDisplay = VIEW.
    
public static JPanel[] getCalculatorKeyboards
        ( CALCS type, CalcCore cc, CalcDisplay[] cd )
    {
    JPanel[] calculatorPanels;
    CalcKeyboard keyboardPanel;
    Font font;
    
    switch(type)
        {
        case SCIENTIFIC:
            {
            keyboardPanel = new CalcKeyboardScientific();
            font = new Font("Verdana", Font.PLAIN, 12);
            break;
            }
        case PROGRAMMER:
            {
            keyboardPanel = new CalcKeyboardProgrammer();
            font = new Font("Verdana", Font.PLAIN, 14);
            break;
            }
        case SIMPLE:
        default:
            {
            keyboardPanel = new CalcKeyboard();
            font = new Font("Verdana", Font.PLAIN, 15);
            break; 
            }
        }
    
    // build panels: radio buttons
    
    int n = 1;
    int m = 0;
    
    CalcRadio[] radioList = keyboardPanel.getRadioList();
    ActionListener radioListener = new RadioAction(radioList, cc, cd);
    
    if ( radioList != null )
        {
        m = radioList.length;
        }
    calculatorPanels = new JPanel[n+m];
    ButtonGroup radioGroup = new ButtonGroup();
    for(int i=0; i<m; i++)
        {
        JRadioButton radio = new JRadioButton( radioList[i].getName() );
        CalcDisplayMarker marker = new CalcDisplayMarker();
        radio.setSelected( radioList[i].getDefaultState() );
        radioGroup.add(radio);
        int[] mnemonics = radioList[i].getKeys();
        if ( mnemonics != null )
            {
            for(int j=0; j<mnemonics.length; j++)
                {
                radio.setMnemonic( mnemonics[j] );
                }
            }
        radio.setToolTipText( radioList[i].getText() );
        radio.addActionListener(radioListener);
        String stringId = "" + i;
        radio.setActionCommand(stringId);
        marker.add(radio);
        calculatorPanels[i+1] = marker;
        }
    
    // build panel: main keyboard
    
    CalcButton[][] buttonsList = keyboardPanel.getButtonsList();
    ActionListener buttonsListener = new CalcAction(buttonsList, cc, cd);
    
    int nx = buttonsList[0].length;
    int ny = buttonsList.length;
    
    GridLayout gridLayout = new GridLayout(ny, nx);
    keyboardPanel.setLayout(gridLayout);
    JButton[][] buttons = new JButton[ny][nx];
    
    for(int i=0; i<ny; i++)
        {
        for (int j=0; j<nx; j++)
            {
            // identifier string for button, executed at this iteration
            String stringId = "" + i + j;
            // create button, set name for button visual
            buttons[i][j] = new JButton( buttonsList[i][j].getName() );
            // set tooltip, visualized when mouse cursor located at button
            buttons[i][j].setToolTipText ( buttonsList[i][j].getText() );
            // set default or custom for button name string
            Font customFont = buttonsList[i][j].getCustomFont();
            if ( customFont != null ) 
                { buttons[i][j].setFont(customFont); }
            else
                { buttons[i][j].setFont(font); }
            // set custom color for button name string
            Color customColor = buttonsList[i][j].getCustomColor();
            if ( customColor != null )
                { buttons[i][j].setForeground(customColor); }
            // set identifier, used by handler 
            buttons[i][j].setActionCommand(stringId);
            // setup handler for this button
            buttons[i][j].addActionListener(buttonsListener);
            // setup keyboard key(s) for this button
            AbstractAction action = new KeyAction();  // class for handling
            InputMap inputMap =
                 buttons[i][j].getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
            ActionMap actionMap = buttons[i][j].getActionMap();
            // get array of keystrokes from button description
            int[] keys = buttonsList[i][j].getKeys();
            if ( keys != null )
                {
                for ( int k=0; k<keys.length; k++ )
                    {
                    // add key description to button input map, by stringId
                    inputMap.put( KeyStroke.getKeyStroke
                        ( keys[k], 0, true ) , stringId );
                    }
                // add handler class to action map by stringId
                actionMap.put( stringId, action );
                }
            // add button to panel
            keyboardPanel.add(buttons[i][j]);
            }
        }

    calculatorPanels[0] = keyboardPanel;
    return calculatorPanels;
    }

}
