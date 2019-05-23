package fixgamemanagement;
//Author: Chase Uphaus --- Fixation Gaming
import java.util.*;
import javax.swing.JFrame;



public class FixGameManagement
{
    
    public static void main(String[] args)
    {
        JFrame menu = new MainMenu();
        menu.setVisible(true);
        if (MainMenu.loggedIn == false)
            menu.dispose();
        
    }//End main
    
}//
