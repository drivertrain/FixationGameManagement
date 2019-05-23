package fixgamemanagement;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.imageio.*;

/**
 *
 * @author Chase Uphaus --- Fixation
 */
public class Game implements Comparable
{
    private String name, filename;
    private int numCopies, amtPlayers;
    private ArrayList<String> stations, genre;
    private boolean multiplayer, free;
    ImageIcon gameLogo;
    
    
    public Game()
    {
        
    }
    
    public Game(String n, int c, boolean m)
    {
        this.name = n;
        this.numCopies = c;
        this.multiplayer = m;
    }//End game
    public void loadImg() {gameLogo = new ImageIcon(Game.class.getResource("resources/" + name + ".jpg"));}
    public void setName(String n){this.name = n;}
    public void setCopies(int c){this.numCopies = c;}
    public void setMulti(boolean b){this.multiplayer = b;}
    public void setStations(ArrayList<String> s){this.stations = s;}
    public void setGenre(ArrayList<String> g){this.genre = g;}
    public void setPremium(boolean f){this.free = f;}
    public void setPlayers(int p){this.amtPlayers = p;}
    public ArrayList<String> getGenres() {return genre;}
    public ArrayList<String> getStations() {return stations;}
    public String getName() {return name;}
    public boolean isMultiplayer() {return multiplayer;}
    public int getPlayers() {return amtPlayers;}
    public int getCopies() {return numCopies;}
    public boolean getFree() {return free;}
    public boolean equals(Game comp)
    {
       return (this.numCopies == comp.getCopies() &&
               this.name.equals(comp.getName()) &&
               this.amtPlayers == comp.getPlayers() &&
               this.stations.containsAll(comp.getStations()) &&
               this.genre.containsAll(comp.getGenres()) &&
               this.multiplayer == comp.isMultiplayer() &&
               this.free == comp.getFree());
            
    }

    @Override
    public int compareTo(Object o)
    {
        return this.toString().compareTo(o.toString());
    }
    @Override
    public String toString()
    {
        return this.name;
    }
    public void setIcon(ImageIcon logo)
    {
        this.gameLogo = logo;
        saveImage();

    }
    public ImageIcon getLogo() {return this.gameLogo;}
    public String getFilename() {return this.filename;}
    private void saveImage()
    {
        try
        {
            BufferedImage bi = new BufferedImage(
            gameLogo.getIconWidth(),
            gameLogo.getIconHeight(),
            BufferedImage.TYPE_INT_RGB);
            Graphics g = bi.createGraphics();
            // paint the Icon to the BufferedImage.
            gameLogo.paintIcon(null, g, 0,0);
            g.dispose();
            File imageFile = new File("src/fixgamemanagement/resources/" + name + ".jpg");
            ImageIO.write(bi, "jpg", imageFile);
        }
        catch(Exception e){e.printStackTrace();}
    }
}//End class game
