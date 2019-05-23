
package fixgamemanagement.utils;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import fixgamemanagement.Game;

/**
 *
 * @author Chase J Uphaus --- Fixation Gaming
 */
public class gameCellRenderer extends DefaultListCellRenderer
{
   
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) 
    {
        
         
        Game current = (Game) value;
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        label.setIcon(current.getLogo());
        label.setText("");
        return label;
    }
}