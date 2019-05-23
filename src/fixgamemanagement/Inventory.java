package fixgamemanagement;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import org.apache.commons.net.ftp.FTP;
import static org.apache.commons.net.ftp.FTP.ASCII_FILE_TYPE;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;

/**
 *
 * @author superspeed
 */
public class Inventory
{
    ArrayList<Game> games;
    
    
    public Inventory() 
    {
        games = new ArrayList<>();
        loadGames();
        
    }//End default constructor
    //Make sure the game is not already in the database before adding
    
    public void add(Game g)
    {
        if (!(games.contains(g)))
        {
            games.add(g);
            sort();
        }
        else
            System.out.println("The game is already in the database...");
    }//End add
    public int size() {return games.size();}
    public ArrayList<Game> genreSearch(String searchKey)
    {
        Game current;
        ArrayList<Game> searchResult = new ArrayList<>();
        for (int i = 0; i < games.size(); i++)
        {
            current = games.get(i);
            for (int j = 0; j < current.getGenres().size(); j++)
            {
                if (current.getGenres().get(j).equals(searchKey))
                {
                    searchResult.add(current);
                    break;
                }//End if
            }//End inner for
        }//End outer for
        
        return searchResult;
    }//End  genreSearch
    public ArrayList<Game> nameSearch(String searchKey)
    {
        ArrayList<Game> searchResult = new ArrayList<>();
        for (int i = 0; i < games.size(); i++)
        {
            if (games.get(i).getName().toUpperCase().contains(searchKey.toUpperCase())) searchResult.add(games.get(i));
        }//End for
        return searchResult;
    }    
    public Game get(int index){return games.get(index);}
    public Game getGame(String name) throws Exception
    {
        for (int i = 0; i < games.size(); i++)
        {
            if (games.get(i).getName().equals(name)) return games.get(i);
        }
        JOptionPane.showMessageDialog(null, "ERROR: No game selected...");
        throw new Exception("Unknown Error Occured"); 
    }//End getGame();
    public void storeGames()
    {
        try
        {
            java.io.File save = new java.io.File("inventory.dat");
            PrintWriter output = new PrintWriter(save);
            //Loop for every game
            for (int i = 0; i < games.size(); i++)
            {
                output.print(games.get(i).getName() + ";");
                output.print(games.get(i).getFree() + ";");
                output.print(games.get(i).isMultiplayer() + ";");
                //Stations Loop
                for (int j = 0; j < games.get(i).getStations().size(); j++)
                {
                    if (j == (games.get(i).getStations().size() - 1))
                        output.print(games.get(i).getStations().get(j));
                    else
                        output.print(games.get(i).getStations().get(j) + ",");
                }
                output.print(";");
                //Genres Loop
                for (int j = 0; j < games.get(i).getGenres().size(); j++)
                {
                    if (j == (games.get(i).getGenres().size() - 1))
                        output.print(games.get(i).getGenres().get(j)); 
                    else
                        output.print(games.get(i).getGenres().get(j) + ",");   
                }
                if (games.get(i).isMultiplayer())
                    output.println(";" + games.get(i).getPlayers());
                else
                    output.println("");
            }
            output.flush();
            output.close();
        }
        catch (Exception e){e.printStackTrace(); JOptionPane.showMessageDialog(null, "Error Backing Up Inventory");}        
    }//End store games
    
    private void loadGames()
    {
        try
        {
            java.io.File saveFile = new java.io.File("inventory.dat");
            Scanner input = new Scanner(saveFile);
            String[] container, genresArr, stationsArr;
            String currentLine;
            
            while (input.hasNext())
            {
                Game current = new Game();
                currentLine = input.nextLine();
                container = currentLine.split(";");
                //Singleplayer case
               
                current.setName(container[0]);
                current.setPremium(Boolean.parseBoolean(container[1]));
                current.setMulti(Boolean.parseBoolean(container[2]));
                if (current.isMultiplayer())
                    current.setPlayers(Integer.parseInt(container[5]));
                stationsArr = container[3].split(",");
                genresArr = container[4].split(",");
                current.setStations(new ArrayList<String>(Arrays.asList(stationsArr)));
                current.setGenre(new ArrayList<String>(Arrays.asList(genresArr)));
                current.setCopies(current.getStations().size());
                try{current.loadImg();}
                catch (Exception E){System.out.println("Error reading image for game: " + current.getName());}
                games.add(current);
            }//End while
            
            input.close();
            sort();
        }//End try
        catch (Exception e) {e.printStackTrace(); System.out.println("Error reading data...");}
    }//End loadGames()
    
    public boolean contains(Game in)
    {
        return games.contains(in);
    }
    //Returns null if by somehow the value is not found
    public Game singleSearch(String searchKey)
    {
        for (int i = 0; i < games.size(); i++)
        {
            if (games.get(i).getName().compareTo(searchKey) == 0)
                return games.get(i);
        }
        return null;
    }
    public boolean remove(Game g)
    {
        return games.remove(g);
    }
    
    public String[] toArray()
    {
        String[] arr = new String[games.size()];
        for (int i = 0; i < games.size(); i++)
        {
            arr[i] = games.get(i).getName();
        }
        return arr;
    }
    public Game indexSearch(int i)
    {
        return games.get(i);
    }
    
    private void sort()
    {
        Collections.sort(games);
    }
    
    public ArrayList<Game> getUnderlyingStructure(){return games;}
    
    
    

}//End class inventory
