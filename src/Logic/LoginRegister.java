package Logic;

import Model.Player;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginRegister {
    
    private ArrayList<Player> playerList;
    private int IndexCurrPlayer = -1;
    
    public LoginRegister(){
        playerList = new ArrayList<>();
        Player player1 = new Player();
        player1.setUsername("evan");
        player1.setPassword("1234");
        
        playerList.add(player1);
        
        Player player2 = new Player();
        player2.setUsername("citra");
        player2.setPassword("1234");
        
        playerList.add(player2);
    }
    
    public void Menu(){
        Scanner scan = new Scanner(System.in);
        Player currPlayer = null;
       
        
        while (true) {
            System.out.println("Menu");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("0. Exit");
            System.out.println("Choose");
            int choose = scan.nextInt();
            
            switch(choose){
                case 1 -> currPlayer = Login();
                case 2 -> currPlayer = Register();
                case 0 -> System.exit(0);
            }
            
            if(currPlayer != null){
                Game game = new Game();
                currPlayer = game.Start(currPlayer);
                playerList.set(IndexCurrPlayer, currPlayer);
            }
        }
    }
    
    private Player Login(){
        String tryAgain = "";
        
        while (!tryAgain.equalsIgnoreCase("N")) {
            Scanner s = new Scanner(System.in);
            System.out.println("Please Login");
            System.out.println("Username :");
            String uname = s.next();
            System.out.println("Password : ");
            String pwd = s.next();
            
            for(Player p: playerList){
                if(p.getUsername().equalsIgnoreCase(uname) && p.getPassword().equalsIgnoreCase(pwd)){
                    this.IndexCurrPlayer = playerList.indexOf(p);
                    return p;
                }
            }
            
            System.out.println("Userame or Password don't match ! ");
            System.out.println("Try Again (Y/N) ? ");
            tryAgain = s.next();
        }
        
        return null;
    }
    
    private Player Register(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please Register");
        System.out.println("Username :");
        String uname = s.next();
        System.out.println("Password : ");
        String pwd = s.next();
        
        Player newPlayer = new Player();
        newPlayer.setUsername(uname);
        newPlayer.setPassword(pwd);
        playerList.add(newPlayer);
        this.IndexCurrPlayer = playerList.size()-1;
        return newPlayer;
    }
}
