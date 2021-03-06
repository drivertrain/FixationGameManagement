package fixgamemanagement;

import fixgamemanagement.utils.gameCellRenderer;
import java.awt.Frame;
import java.util.Vector;

/**
 *
 * @author Chase Uphaus --- Fixation Gaming
 */
public class iconViewGames extends javax.swing.JDialog
{

    Inventory games;
    Frame parentWindow;
    public iconViewGames(java.awt.Frame parent, boolean modal, Inventory games)
    {
        super(parent, modal);
        initComponents();
        Vector v = new Vector();
        v.addAll(games.getUnderlyingStructure());
        iconView.setListData(v);
        iconView.setCellRenderer(new gameCellRenderer());
        this.games = games;
        this.parentWindow = parent;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        scrollPane = new javax.swing.JScrollPane();
        iconView = new javax.swing.JList<>();
        srchButon = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter()
        {
            public void componentResized(java.awt.event.ComponentEvent evt)
            {
                formComponentResized(evt);
            }
        });

        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        iconView.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        iconView.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        iconView.setVisibleRowCount(4);
        iconView.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                iconViewMouseClicked(evt);
            }
        });
        iconView.addComponentListener(new java.awt.event.ComponentAdapter()
        {
            public void componentResized(java.awt.event.ComponentEvent evt)
            {
                iconViewComponentResized(evt);
            }
        });
        scrollPane.setViewportView(iconView);

        srchButon.setText("Search Games");
        srchButon.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                srchButonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(srchButon, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(scrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(srchButon)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iconViewMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_iconViewMouseClicked
    {//GEN-HEADEREND:event_iconViewMouseClicked
        if (evt.getClickCount() == 2)
        {
            new inspectGame(parentWindow, true, games.get(iconView.getSelectedIndex())).setVisible(true);
            
        }
    }//GEN-LAST:event_iconViewMouseClicked

    private void srchButonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_srchButonActionPerformed
    {//GEN-HEADEREND:event_srchButonActionPerformed
        new viewGames(games).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_srchButonActionPerformed

    private void iconViewComponentResized(java.awt.event.ComponentEvent evt)//GEN-FIRST:event_iconViewComponentResized
    {//GEN-HEADEREND:event_iconViewComponentResized
        
    }//GEN-LAST:event_iconViewComponentResized

    private void formComponentResized(java.awt.event.ComponentEvent evt)//GEN-FIRST:event_formComponentResized
    {//GEN-HEADEREND:event_formComponentResized
        int height = scrollPane.getHeight();
        int sizePerRow = 96;
        int amtRows = height/sizePerRow;
        if (!(iconView.getVisibleRowCount() == amtRows))
        {
            iconView.setVisibleRowCount(amtRows);
        }
    }//GEN-LAST:event_formComponentResized

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> iconView;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JButton srchButon;
    // End of variables declaration//GEN-END:variables
}
