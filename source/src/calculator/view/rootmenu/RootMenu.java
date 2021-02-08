/*

Application frame with root menu,
supports calculator mode changing: simple, scientific, programmer.

*/

package calculator.view.rootmenu;

import calculator.view.guibuilders.GuiProgrammer;
import calculator.view.guibuilders.GuiScientific;
import calculator.view.guibuilders.GuiSimple;
import static javax.swing.Action.NAME;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

public class RootMenu extends JFrame
{
private final JMenuBar menuBar;
private final JRadioButtonMenuItem simple, scientific, programmer;
private final GuiSimple guiSimple, guiScientific, guiProgrammer;
private final JPanel[][] displays, controls;

public RootMenu( String name, JPanel[][] x1 , JPanel[][] x2 )
    {
    super( name );
    displays = x1;
    controls = x2;
    guiSimple = new GuiSimple();
    guiScientific = new GuiScientific();
    guiProgrammer = new GuiProgrammer();
    menuBar = new JMenuBar();
    // File menu
    JMenu file = new JMenu( "File" );
    HandlerExit handlerExit = new HandlerExit();
    handlerExit.putValue( NAME, "Exit" );
    JMenuItem exit = new JMenuItem( handlerExit );
    file.add( exit );
    menuBar.add( file );
    // Mode menu
    JMenu mode = new JMenu( "Mode" );
    ButtonGroup bg = new ButtonGroup();
    simple = new JRadioButtonMenuItem( "Simple", true );
    scientific = new JRadioButtonMenuItem( "Scientific" );
    programmer = new JRadioButtonMenuItem( "Programmer" );
    bg.add( simple );
    bg.add( scientific );
    bg.add( programmer );
    HandlerMode handlerMode = new HandlerMode
        ( this, displays, controls,
          simple, scientific, programmer,
          guiSimple, guiScientific, guiProgrammer );
    simple.addActionListener( handlerMode );
    scientific.addActionListener( handlerMode );
    programmer.addActionListener( handlerMode );
    mode.add( simple );
    mode.add( scientific );
    mode.add( programmer );
    menuBar.add( mode );
    // Help menu
    JMenu help = new JMenu( "Help" );
    HandlerAbout handlerAbout = new HandlerAbout( this );
    handlerAbout.putValue( NAME, "About" );
    JMenuItem about = new JMenuItem( handlerAbout );
    help.add( about );
    menuBar.add( help );
    }

public void startApplication()
    {
    setJMenuBar( menuBar );
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    guiSimple.setGui( this, displays[0], controls[0] );  // default is SIMPLE
    setLocationRelativeTo( null );
    setResizable( false );
    setVisible( true );
    }
}
