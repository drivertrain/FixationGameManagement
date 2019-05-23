package fixgamemanagement;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;


/**
 *
 * @author Chase Uphaus --- Fixation Gaming
 */
public class MainMenu extends javax.swing.JFrame 
{

    Inventory games;
    Game current;
    ImageIcon logo;
    int width = 150, height = 150;
    FTPClient session;
    boolean admin;
    static boolean loggedIn;
    public MainMenu()
    {
        initComponents();
        session = new FTPClient();
        admin = false;
        loggedIn = false;
        login();
        games = new Inventory();
        logo = new ImageIcon(MainMenu.class.getResource("resources/logo.png"));
        Image image = logo.getImage(); // transform it 
        Image newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        logo = new ImageIcon(newimg);
        iconLabel.setIcon(logo);
        setIconImage(image);
        newGameBtn.setVisible(admin);
        menuBar.setVisible(admin);
            
    }
    
    public void login()
    {
        try
        {
            new loginWindow(this, true).setVisible(true);
            if (loginWindow.cred[0].compareTo("") == 0)
                dispose();
            OutputStream out = new FileOutputStream(new File("inventory.dat"));
            session.connect("25.79.110.177", 21);
            session.setKeepAlive(true);
            loggedIn = session.login(loginWindow.cred[0], loginWindow.cred[1]);
            if (!(loggedIn))
            {
                JOptionPane.showMessageDialog(null, "Invalid Username/PW");
                session.disconnect();                
                login();
            }
            session.enterLocalPassiveMode();
            session.setFileType(FTP.ASCII_FILE_TYPE);
            //The following two lines must be uncommented if running on a windows machine.
            //Process p = Runtime.getRuntime().exec("cmd /c start runas /user:domain/administrator /savecred:cmdrun.txt  netsh advfirewall firewall add rule name=”FTP Service” action=allow service=ftpsvc protocol=TCP dir=" + Inventory.class.getCanonicalName());
            //p = Runtime.getRuntime().exec("cmd /c start runas /user:domain/administrator /savecred:cmdrun.txt  netsh advfirewall set global StatefulFTP disable");
            session.retrieveFile("inventory.dat", out);
            out.flush();
            out.close();
            if (loginWindow.cred[0].equals("fixClient")) admin = true;
        }
        catch (Exception e){System.out.println("Login ERROR");}
    }//End login
    
    public void logout()
    {
        try
        {
            if (!session.isAvailable())
            {
                session.connect("25.79.110.177", 21);
                session.login("Guest", "fix9909");
                session.logout();
                session.disconnect();
            }
        }
        catch(Exception e){System.out.println("Logout ERROR");}
    }
    
    public void uploadData()
    {
      
        try
        {   
            if (!session.isAvailable())
            {
                session.connect("25.79.110.177", 21);
                session.login(loginWindow.cred[0], loginWindow.cred[1]);
                session.enterLocalPassiveMode();
                session.setFileType(FTP.ASCII_FILE_TYPE);
            }
            File dataFile = new File("inventory.dat");
            InputStream is = new FileInputStream(dataFile);
            OutputStream outputStream = session.storeFileStream("inventory.dat");
            byte[] bytesIn = new byte[4096];
            int read = 0;
            
            while ((read = is.read(bytesIn)) != -1)
            {
                outputStream.write(bytesIn, 0, read);
            }
            is.close();
            outputStream.close();
            
        }
        catch (IOException e){e.printStackTrace();}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        newGameBtn = new javax.swing.JButton();
        viewSrchBtn = new javax.swing.JButton();
        iconLabel = new javax.swing.JLabel();
        exitBtn = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileBtn = new javax.swing.JMenu();
        saveBtn = new javax.swing.JMenuItem();
        removeGame = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fixation Game Management");
        setName("mainMenuScreen"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosed(java.awt.event.WindowEvent evt)
            {
                saveInv(evt);
            }
        });

        newGameBtn.setText("Add a Game");
        newGameBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                newGameBtnActionPerformed(evt);
            }
        });

        viewSrchBtn.setText("View/Search Games");
        viewSrchBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                viewSrchBtnActionPerformed(evt);
            }
        });

        exitBtn.setText("Exit");
        exitBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                exitBtnActionPerformed(evt);
            }
        });

        fileBtn.setText("File");

        saveBtn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                saveBtnActionPerformed(evt);
            }
        });
        fileBtn.add(saveBtn);

        removeGame.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        removeGame.setText("Delete a Game");
        removeGame.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                removeGameActionPerformed(evt);
            }
        });
        fileBtn.add(removeGame);

        menuBar.add(fileBtn);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(exitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newGameBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewSrchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(iconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(211, 211, 211))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(newGameBtn)
                        .addGap(9, 9, 9)
                        .addComponent(viewSrchBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(iconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(exitBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newGameBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_newGameBtnActionPerformed
    {//GEN-HEADEREND:event_newGameBtnActionPerformed
        current = newGame.newG;
        JDialog newG = new newGame(this, true);
        newG.setVisible(true);
        if (newGame.newG == null)
            System.out.println("An invalid title was entered");
        else
            games.add(newGame.newG);
        
    }//GEN-LAST:event_newGameBtnActionPerformed

    private void viewSrchBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_viewSrchBtnActionPerformed
    {//GEN-HEADEREND:event_viewSrchBtnActionPerformed
        try
        {
            //JFrame view = new viewGames(games);
            JDialog view = new iconViewGames(this, true, games);
            view.setVisible(true);
        }//End try
        catch (Exception e) {e.printStackTrace(); JOptionPane.showMessageDialog(null, "Error Accessing Games Data...");}
    }//GEN-LAST:event_viewSrchBtnActionPerformed

    private void saveInv(java.awt.event.WindowEvent evt)//GEN-FIRST:event_saveInv
    {//GEN-HEADEREND:event_saveInv
    }//GEN-LAST:event_saveInv

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_saveBtnActionPerformed
    {//GEN-HEADEREND:event_saveBtnActionPerformed
        games.storeGames();
    }//GEN-LAST:event_saveBtnActionPerformed

    private void removeGameActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_removeGameActionPerformed
    {//GEN-HEADEREND:event_removeGameActionPerformed
        JDialog deleteGame = new gameDeleteMenu(this, true, games);
        deleteGame.setVisible(true);
        
    }//GEN-LAST:event_removeGameActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_exitBtnActionPerformed
    {//GEN-HEADEREND:event_exitBtnActionPerformed
        if (admin == true)
        {
            games.storeGames();
            uploadData();                        
        }
        logout();
        dispose();
    }//GEN-LAST:event_exitBtnActionPerformed


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitBtn;
    private javax.swing.JMenu fileBtn;
    private javax.swing.JLabel iconLabel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton newGameBtn;
    private javax.swing.JMenuItem removeGame;
    private javax.swing.JMenuItem saveBtn;
    private javax.swing.JButton viewSrchBtn;
    // End of variables declaration//GEN-END:variables
}
