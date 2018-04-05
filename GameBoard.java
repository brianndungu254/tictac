import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
/**
 * name:brian ndungu.
 * course:CS30/CS40S
 * Teacher:Mr.Hardman
 * lab#1, Program#1
 * LAST DATE MODIFIED:
 * 
 */
public class GameBoard extends World
{
    
    private boolean playerOneTurn = true;
    private boolean messageShown = false; 
    
    private String playerOneName;
    private String playerTwoName;
    
    private String[][] board = new String [3][3];
    
    /**
     * GameBoard is the constructor for objects of class GameBoard
     * 
     * @param There are no parameters
     * @return an object of type GameBoard
     */
    public GameBoard()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        
        drawLines();
        
        for( int r = 0; r < board.length; r++ )
        {
            for( int c = 0; c < board[r].length; c++ )
            {
                board[r][c] = "";
            }
        }
    }
    
    /**
     * drawLines draws the 3x3 grid that we can place the markers for the game tictac
     * 
     * @param There are no parameters
     * @return a marker of type
     */
    private void drawLines()
    {
         getBackground().setColor( Color.CYAN );
         
         for( int i = 200; i < getWidth(); i += 200 )
        {
             getBackground().drawLine(i, 0, i, getHeight() );
             getBackground().drawLine(0, i, getWidth(), i);
        }
    }
    
    public void started()
    {
        JOptionPane.showInputDialog( null, "Please enter your name:", "Player one Name", JOptionPane.WARNING_MESSAGE );
        JOptionPane.showInputDialog( null, "Please enter your name:", "Player two Name", JOptionPane.WARNING_MESSAGE );
    }
   
    /**
     * act is the act cycle of game tictac
     * 
     * @param There are no parameters
     * @return Nothing to return
     */
    public void act()
    {
        displayBoard();
        Greenfoot.delay(10);
        
        if( checkPlayerOneWin() == true )
        {
            
        }
        else if( checkPlayerTwoWin() == true )
        {
            
        }
        else if(  checkBoardFilled() == true )
        {
            
        }
        
        checkMouseClick();
    }
    
    private void showTurn()
    {
        if( playerOneTurn == true )
        {
            JOptionPane.showMessageDialog( null, "player one's turn" );
        }
        else if( playerTwoTurn == false )
        {
            JOptionPane.showMessageDialog( null, "player two's turn" );
        }
    }
    
    /**
     * checkMouseClick checks if the player has clicked the X and O in the game tictac
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void checkMouseClick()
    {
        MouseInfo mouse;
        int rowNum;
        int columnNum;
        if( Greenfoot.mouseClicked(this) )
        {
            mouse = Greenfoot.getMouseInfo();
            columnNum = mouse.getX() / ( getWidth() / 3 );
            rowNum = mouse.getY() / ( getHeight() / 3 );
            
            if( board[rowNum][columnNum] == "" )
            {
                if( playerOneTurn = true )
                {
                    board[rowNum][columnNum] = "X";
                    playerOneTurn = false;
                    messageShown = false;
                }
                else
                {
                    board[rowNum][columnNum] = "O";
                    playerOneTurn = true;
                    messageShown = false;
                }
            }
        }
    }
    
    /**
     * 
     */
    private void displayBoard()
    {
        GreenfootImage toDisplay;
        
          for( int r = 0; r < board.length; r++ )
        {
            for( int c = 0; c < board[r].length; c++ )
            {
                toDisplay = new GreenfootImage( board[r][c], 100, Color.RED, new Color(0, 0, 0, 0) );
                getBackground().drawImage( toDisplay, c * getWidth()/3 + (getWidth()/3 - toDisplay.getWidth())/2, r * getHeight()/3 + (getHeight()/3 - toDisplay.getHeight())/2 );
            }
        }
    }
    
    /**
     * 
     */
    private boolean checkPlayerOneWin()
    {
        boolean playerOneWin = false;
        
        if( board[0][0] == "X" && board[0][1] == "X" && board[0][2] == "X")
        {
            playerOneWin = true;
        }
        else if( board[1][0] == "X" && board[1][1] == "X" && board[1][2] == "X")
        {
            playerOneWin = true;
        }
        else if( board[2][0] == "X" && board[2][1] == "X" && board[2][2] == "X")
        {
             playerOneWin = true;
        }
        else if( board[1][0] == "X" && board[2][0] == "X" && board[2][0] == "X")
        {
            playerOneWin = true;
        }
        else if( board[1][0] == "X" && board[2][0] == "X" && board[2][0] == "X")
        {
            playerOneWin = true;
        }
        else if( board[0][2] == "X" && board[1][2] == "X" && board[2][2] == "X")
        {
             playerOneWin = true;
        }
        else if( board[0][0] == "X" && board[1][1] == "X" && board[2][0] == "X")
        {
             playerOneWin = true;
        }
        else if( board[0][2] == "X" && board[1][1] == "X" && board[2][0] == "X")
        {
             playerOneWin = true;
        }
        return playerOneWin;
    }
    
    /**
     * 
     */
    private boolean checkPlayerTwoWin()
    {
        boolean playerTwoWin = false;
     
         if( board[0][0] == "O" && board[0][1] == "O" && board[0][2] == "O")
        {
            playerTwoWin = true;
        }
        else if( board[1][0] == "O" && board[1][1] == "O" && board[1][2] == "O")
        {
            playerTwoWin = true;
        }
        else if( board[2][0] == "O" && board[2][1] == "O" && board[2][2] == "O")
        {
             playerTwoWin = true;
        }
        else if( board[0][0] == "O" && board[1][0] == "O" && board[2][0] == "O")
        {
            playerTwoWin = true;
        }
        else if( board[0][1] == "O" && board[1][1] == "O" && board[2][1] == "O")
        {
            playerTwoWin = true;
        }
        else if( board[0][2] == "O" && board[1][2] == "O" && board[2][2] == "O")
        {
             playerTwoWin = true;
        }
        else if( board[0][0] == "O" && board[1][1] == "O" && board[2][0] == "O")
        {
             playerTwoWin = true;
        }
        else if( board[0][2] == "O" && board[1][1] == "O" && board[2][0] == "O")
        {
             playerTwoWin = true;
        }
        
        return playerTwoWin;
    }
    
    private boolean checkBoardFilled()
    {
         boolean boardFilled = false;
        
         if(  messageShown = false )
         {
                if( boardFilled = true )
               {
                  JOptionPane.showMessageDialog( null, "its a DRAW" );
                  Greenfoot.stop();
               }
         }
         
        return boardFilled;
    }
}
    
    

