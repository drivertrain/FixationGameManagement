package fixgamemanagement;

import java.awt.Frame;
import javax.swing.JDialog;

/**
 *
 * @author Chase Uphaus --- Fixation Gaming
 */
public class inspectGame extends javax.swing.JDialog
{

    /**
     * Creates new form inspectGame
     */
    Frame parentWindow;
    Game current;
    public inspectGame(java.awt.Frame parent, boolean modal, Game current)
    {
        super(parent, modal);
        initComponents();
        this.current = current;
        this.parentWindow = parent;
        if (!(loginWindow.cred[0].equals("fixClient"))) editGameBtn.setVisible(false);
        gameName.setText(current.getName());
        if (current.isMultiplayer())
        {
            multValue.setText("Yes");
            multiAmt.setText(current.getPlayers() + " Players");
        }
        else
            multValue.setText("No");
        
        copiesVal.setText("" + current.getCopies());
        if (current.getFree())
            freeVal.setText("Yes");
        else
            freeVal.setText("No");
        //Add Genres
        for (int i = 0;i < current.getGenres().size(); i++)
            genresDisp.add(current.getGenres().get(i));
        //Add Stations
        for (int i = 0; i < current.getStations().size(); i++)
            stationsDisp.add(current.getStations().get(i));  
        if (current.getLogo() != null)
            imageLabel.setIcon(current.getLogo());
    }//End inspectGame()

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        gameName = new javax.swing.JLabel();
        genresTag = new javax.swing.JLabel();
        genresDisp = new java.awt.List();
        stationsTag = new javax.swing.JLabel();
        stationsDisp = new java.awt.List();
        multiTag = new javax.swing.JLabel();
        multValue = new javax.swing.JLabel();
        multiAmt = new javax.swing.JLabel();
        copysTag = new javax.swing.JLabel();
        copiesVal = new javax.swing.JLabel();
        freeTag = new javax.swing.JLabel();
        freeVal = new javax.swing.JLabel();
        editGameBtn = new javax.swing.JButton();
        imageLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        gameName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        gameName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        genresTag.setText("Genres:");

        stationsTag.setText("Stations:");

        multiTag.setText("Multiplayer:");

        copysTag.setText("Number of Copies:");

        freeTag.setText("Free:");

        editGameBtn.setText("Edit Game");
        editGameBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                editGameBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(genresTag)
                            .addComponent(genresDisp, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stationsTag)
                            .addComponent(stationsDisp, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(gameName, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(multiTag)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(multValue, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(multiAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(copysTag)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(copiesVal, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(freeTag)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(freeVal, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(editGameBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gameName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(genresTag)
                            .addComponent(stationsTag)))
                    .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(genresDisp, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(stationsDisp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(multiAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(multiTag)
                                .addComponent(multValue, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(copysTag)
                            .addComponent(copiesVal, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(freeTag)
                            .addComponent(freeVal, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editGameBtn)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editGameBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_editGameBtnActionPerformed
    {//GEN-HEADEREND:event_editGameBtnActionPerformed
        JDialog editGame = new editGame(parentWindow, true, current);
        editGame.setVisible(true);
    }//GEN-LAST:event_editGameBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel copiesVal;
    private javax.swing.JLabel copysTag;
    private javax.swing.JButton editGameBtn;
    private javax.swing.JLabel freeTag;
    private javax.swing.JLabel freeVal;
    private javax.swing.JLabel gameName;
    private java.awt.List genresDisp;
    private javax.swing.JLabel genresTag;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel multValue;
    private javax.swing.JLabel multiAmt;
    private javax.swing.JLabel multiTag;
    private java.awt.List stationsDisp;
    private javax.swing.JLabel stationsTag;
    // End of variables declaration//GEN-END:variables
}
